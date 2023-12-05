package com.teamone.bookmanagementsystem.controllers;/*
 * Copyright(C)2022
 * Mock_project
 * Record of change:
 * DATE       Version     AUTHOR     Description
 * 8/8/2022    1.0         ADMIN    First Implement
 */

import com.teamone.bookmanagementsystem.dao.UserDao;
import com.teamone.bookmanagementsystem.dao.impl.UserDaoImpl;
import com.teamone.bookmanagementsystem.models.Role;
import com.teamone.bookmanagementsystem.models.User;
import com.teamone.bookmanagementsystem.utils.PasswordUtil;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "RegisterController", value = "/register")
public class RegisterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/view/register.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            UserDao userDao = new UserDaoImpl();
            String username = request.getParameter("username").trim();
            String password = request.getParameter("password").trim();
            String repassword = request.getParameter("repassword").trim();
            Role role = new Role(2, "User");

            if (!password.equals(repassword)) {
                String msg = "Password is not match!";
                request.setAttribute("msg", msg);
                request.getRequestDispatcher("/view/register.jsp").forward(request, response);
            } else {
                User user = userDao.getUserByUsername(username);

                if (user == null) {

                    userDao.addUser(username, PasswordUtil.generatePasswordHash(password), role);
                    response.sendRedirect(request.getContextPath() + "/login");
                } else {
                    String msg1 = "Username already exists";
                    request.setAttribute("msg1", msg1);
                    request.getRequestDispatcher("/view/register.jsp").forward(request, response);
                }
                //missing
            }


        } catch (Exception ex) {
            Logger.getLogger(SearchBookController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
