package com.teamone.bookmanagementsystem.controllers;/*
 * Copyright(C)2022
 * Mock_project
 * Record of change:
 * DATE       Version     AUTHOR     Description
 * 8/8/2022    1.0         ADMIN    First Implement
 */

import com.teamone.bookmanagementsystem.dao.UserDao;
import com.teamone.bookmanagementsystem.dao.impl.UserDaoImpl;
import com.teamone.bookmanagementsystem.models.User;
import com.teamone.bookmanagementsystem.utils.AppUtil;
import com.teamone.bookmanagementsystem.utils.PasswordUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        request.getRequestDispatcher("/view/login.jsp").forward(request, response); //if uri is Login then forward to this page
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            String username = request.getParameter("username").trim(); // get username input from Login form
            String password = request.getParameter("password").trim(); // get password input from Login form
            Map<String, String> messages = new HashMap<>(); //initalize hashmap to hold message
            if(username == null || password == null){
                messages.put("noti", "Invalid data");
            }
            else{
                messages.put("username", username);
                messages.put("password", password);
                HttpSession session = request.getSession();
                UserDao db = new UserDaoImpl();
                User userGetFromDb = db.getUserByUsername(username); //get AccountBean from database

                /*check if userGetFromDb is null then no exist user in database, put message to hashmap*/
                if (userGetFromDb == null) {
                    messages.put("noti", "User isn't exist");
                } else {
                    /*compare pw input from user and pw in db by decryption pw from db*/
                    boolean checkPass = PasswordUtil.validatePassword(password, userGetFromDb.getPassword());
                    if (!checkPass) {
                        messages.put("noti", "Invalid password");
                    } else {
                        String remember = request.getParameter("remember"); //check if user tick remember option
                        /* if user tick remember option then create cookie to store user*/
                        if (remember != null) {
                            Cookie userCookie = new Cookie("username", username);
                            Cookie passCookie = new Cookie("password", password);
                            userCookie.setMaxAge(3600 * 24 * 30);
                            passCookie.setMaxAge(3600 * 24 * 30);
                            response.addCookie(userCookie);
                            response.addCookie(passCookie);
                        }
                        AppUtil.storeLoginedUser(session, userGetFromDb); // set user in session if login success
                        int redirectId = -1;
                        try {
                            redirectId = Integer.parseInt(request.getParameter("redirectId"));
                        } catch (NumberFormatException e) {
                        }
                        session.setAttribute("remember", remember);
                        String requestUri = AppUtil.getRedirectAfterLoginUrl(request.getSession(), redirectId);
                        if (requestUri != null) {
                            response.sendRedirect(request.getContextPath()+ "/" + requestUri);
                            return;
                        } else {
                            response.sendRedirect(request.getContextPath() +"/books");
                            return;
                        }
                    }
                }
            }
            /*set noti in hashmap to request attribute if login fail and forward to login page */
            request.setAttribute("message_forward", messages);
            request.getRequestDispatcher("./view/login.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
