package com.teamone.bookmanagementsystem.controllers;

import com.teamone.bookmanagementsystem.dao.BookDao;
import com.teamone.bookmanagementsystem.dao.impl.BookDaoImpl;
import com.teamone.bookmanagementsystem.models.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "SearchAdminController", value = "/admin-book/searchadmin")
public class SearchAdminController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String search = request.getParameter("search").trim();
            String filter = request.getParameter("filter");
            List<Book> listBooksAll = new ArrayList<>();
            BookDao bookDao = new BookDaoImpl();
            listBooksAll = bookDao.search1(filter, search);
            request.setAttribute("listbook", listBooksAll);
            request.getRequestDispatcher("/view/viewBook.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(SearchAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
