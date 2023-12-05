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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "ViewDashboardController", value = "/admin-book")
public class ViewDashboardController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            BookDao bookDao = new BookDaoImpl();
            List<Book> listbook = new ArrayList<>();
            listbook = bookDao.selectAllForAdmin();
            request.setAttribute("listbook", listbook);
            request.getRequestDispatcher("/view/viewBook.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(SearchBookController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
