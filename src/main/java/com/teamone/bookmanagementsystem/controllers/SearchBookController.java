package com.teamone.bookmanagementsystem.controllers;/*
 * Copyright(C)2022
 * Mock_project
 * Record of change:
 * DATE       Version     AUTHOR     Description
 * 8/8/2022    1.0         ADMIN    First Implement
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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "SearchBookController", value = "/search")
public class SearchBookController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String search = request.getParameter("search").trim();
            String filter = request.getParameter("filter");
            String category = request.getParameter("category");
            String page = request.getParameter("page");
            BookDao bookDao = new BookDaoImpl();
            CategoryDao categoryDao = new CategoryDaoImpl();
            List<Book> listBooks = new ArrayList<>();
            List<Book> listBooksAll = new ArrayList<>();
            List<Book> listBooksByCate = new ArrayList<Book>();
            List<Category> categoryList = new ArrayList<>();
            String msg = null;
            int pageNo = 0;
            if(page == null || Integer.parseInt(page) < 1) {
                pageNo = 1;
            }else {
				pageNo = Integer.parseInt(page);
			}
            if (search.equals("")) {
                if(category==null){
                	
                    listBooks = bookDao.selectAll(pageNo);
                    listBooksAll = bookDao.totalBook();
                } else {
                    listBooks = bookDao.selectByCategory(pageNo, category);
                    
                    
                }
            } else {
                listBooks = bookDao.search(pageNo, filter, search);
                listBooksAll = bookDao.search1(filter, search);
                if(listBooks.isEmpty()) {
                    msg = "Book not found, please try again!";
                }
            }
            int totalPage = listBooksAll.size()/8;
            
            if (totalPage % 8 != 0) {
                totalPage++;
            }
            
            listBooksByCate = bookDao.selectByCategory(1, category);
            categoryList = categoryDao.getAll();
            request.setAttribute("filter", filter);
            request.setAttribute("search", search);
            request.setAttribute("category", category);
            request.setAttribute("previousPage", pageNo);
            request.setAttribute("totalPage", totalPage);
            request.setAttribute("listBooks", listBooks);
            request.setAttribute("listBooksByCate", listBooksByCate);
            request.setAttribute("categoryList", categoryList);
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("/view/searchbook.jsp").forward(request, response);


        } catch (Exception ex) {
            Logger.getLogger(SearchBookController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

    }
}
