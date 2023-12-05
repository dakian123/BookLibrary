package com.teamone.bookmanagementsystem.controllers;/*
 * Copyright(C)2022
 * Mock_project
 * Record of change:
 * DATE       Version     AUTHOR     Description
 * 8/8/2022    1.0         ADMIN    First Implement
 */

import com.teamone.bookmanagementsystem.dao.ContainDao;
import com.teamone.bookmanagementsystem.dao.impl.ContainDaoImpl;
import com.teamone.bookmanagementsystem.models.Book;
import com.teamone.bookmanagementsystem.models.Bookcase;
import com.teamone.bookmanagementsystem.models.Contain;
import com.teamone.bookmanagementsystem.models.User;
import com.teamone.bookmanagementsystem.utils.AppUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "DeleteBookcaseController", value = "/bookcase/delete")
public class DeleteBookcaseController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        try {
            int userId = Integer.parseInt(request.getParameter("userId"));
            String bookid = request.getParameter("bookId");
            User user = AppUtil.getLoginedUser(request.getSession(false));
            ContainDao containDao = new ContainDaoImpl();
            containDao.deleteBookFromBookcase(user.getBookCase().getBookcaseId(),bookid);
            request.setAttribute("bookcase", user.getBookCase());
            List<Book> books = containDao.selectListBook(user.getId());
            request.setAttribute("books", books);
          response.sendRedirect(request.getContextPath()+"/bookcase");
        } catch (Exception ex) {
            Logger.getLogger(DeleteBookcaseController.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
}
