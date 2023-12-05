package com.teamone.bookmanagementsystem.controllers;/*
 * Copyright(C)2022
 * Mock_project
 * Record of change:
 * DATE       Version     AUTHOR     Description
 * 8/8/2022    1.0         ADMIN    First Implement
 */

import javax.servlet.*;
import javax.servlet.http.*;

import com.teamone.bookmanagementsystem.dao.BookDao;
import com.teamone.bookmanagementsystem.dao.CategoryDao;
import com.teamone.bookmanagementsystem.dao.impl.BookDaoImpl;
import com.teamone.bookmanagementsystem.dao.impl.CategoryDaoImpl;
import com.teamone.bookmanagementsystem.models.Book;
import com.teamone.bookmanagementsystem.models.Category;

import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ViewBooksController", value = "/books")
public class ViewBooksController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	BookDao bookDao = new BookDaoImpl();
    	CategoryDao categoryDao = new CategoryDaoImpl();
    	try {
			List<Book> bookNew = bookDao.selectNewBook();
			List<Book> bookRandom = bookDao.selectRandom();
			List<Category> listCategories = categoryDao.getAll();
			request.setAttribute("bookNew", bookNew);
			request.setAttribute("bookRandom", bookRandom);
			request.setAttribute("categoryList", listCategories);
			request.getRequestDispatcher("/view/home.jsp").forward(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
