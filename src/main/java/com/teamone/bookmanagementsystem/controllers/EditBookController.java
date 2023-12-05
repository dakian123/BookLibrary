package com.teamone.bookmanagementsystem.controllers;/*
 * Copyright(C)2022
 * Mock_project
 * Record of change:
 * DATE       Version     AUTHOR     Description
 * 8/9/2022    1.0         ADMIN    First Implement
 */

import com.teamone.bookmanagementsystem.dao.BookDao;
import com.teamone.bookmanagementsystem.dao.CategoryDao;
import com.teamone.bookmanagementsystem.dao.impl.BookDaoImpl;
import com.teamone.bookmanagementsystem.dao.impl.CategoryDaoImpl;
import com.teamone.bookmanagementsystem.models.Book;
import com.teamone.bookmanagementsystem.models.Category;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "EditBookController", value = "/admin-book/edit")
public class EditBookController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookId = request.getParameter("bookId");

        try {
            CategoryDao categoryDao = new CategoryDaoImpl();
            List<Category> categoryList = new ArrayList<>();
            categoryList = categoryDao.getAll();
            BookDaoImpl bookDao = new BookDaoImpl();
            Book book = bookDao.selectBookById(bookId);
            request.setAttribute("categoryList", categoryList);
            request.setAttribute("book",book);
            request.getRequestDispatcher("/view/editBook.jsp").forward(request,response);
        } catch (Exception ex) {
            Logger.getLogger(ViewBookDetailController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            BookDao bookDao = new BookDaoImpl();
            CategoryDao categoryDao = new CategoryDaoImpl();
            String bookid = request.getParameter("bookid").trim();
            String title = request.getParameter("title").trim();
            String author = request.getParameter("author").trim();
            String brief = request.getParameter("brief").trim();
            String pulis = request.getParameter("publis").trim();
            String content = request.getParameter("content").trim();
            String date = request.getParameter("creatdate");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate dob1 = LocalDate.parse(date, formatter);
            java.sql.Date dob2 = java.sql.Date.valueOf(dob1);
            int cate = Integer.parseInt(request.getParameter("cate"));
            Category category = new Category();
            category= categoryDao.getById(cate);
            String image = request.getParameter("image").trim();
            Book book = new Book(bookid,title,author,brief,pulis,content,image,dob2,category);
            bookDao.updateBook(book);
            response.sendRedirect(request.getContextPath() + "/admin-book");
        } catch (Exception ex) {
            Logger.getLogger(ViewBookDetailController.class.getName()).log(Level.SEVERE, null, ex);
        }

        }


    }

