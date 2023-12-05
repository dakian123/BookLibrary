package com.teamone.bookmanagementsystem.controllers;/*
 * Copyright(C)2022
 * Mock_project
 * Record of change:
 * DATE       Version     AUTHOR     Description
 * 8/8/2022    1.0         ADMIN    First Implement
 */

import com.teamone.bookmanagementsystem.dao.BookDao;
import com.teamone.bookmanagementsystem.dao.impl.BookDaoImpl;
import com.teamone.bookmanagementsystem.models.Book;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "ViewBookDetailController", value = "/detail")
public class ViewBookDetailController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookId = request.getParameter("bookId");

        try {
            BookDao bookDao = new BookDaoImpl();
            Book book = bookDao.selectBookById(bookId);
            request.setAttribute("book",book);
            request.getRequestDispatcher("/view/detail.jsp").forward(request,response);
        } catch (Exception ex) {
            Logger.getLogger(ViewBookDetailController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
