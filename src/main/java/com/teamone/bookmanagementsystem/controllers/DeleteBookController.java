package com.teamone.bookmanagementsystem.controllers;/*
 * Copyright(C)2022
 * Mock_project
 * Record of change:
 * DATE       Version     AUTHOR     Description
 * 8/8/2022    1.0         ADMIN    First Implement
 */

import com.teamone.bookmanagementsystem.dao.impl.BookDaoImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "DeleteBookController", value = "/admin-book/delete")
public class DeleteBookController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String bookId = request.getParameter("bookId");
            BookDaoImpl bookDao = new BookDaoImpl();
            if(bookDao.checkBookExist(bookId)) {
                bookDao.deleteBookContain(bookId);
                bookDao.deleteBook(bookId);
            } else {
                bookDao.deleteBook(bookId);
            }
            response.sendRedirect(request.getContextPath() + "/admin-book");
        } catch (Exception ex) {
            Logger.getLogger(SearchBookController.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
