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
import com.teamone.bookmanagementsystem.utils.AppUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "CreateBookController", value = "/admin-book/create")
public class CreateBookController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          try{
              CategoryDao categoryDao = new CategoryDaoImpl();
              List<Category> categoryList = categoryDao.getAll();
              request.setAttribute("categoryList",categoryList);
              request.getRequestDispatcher("/view/createBook.jsp").forward(request,response);
          }catch (Exception ex){
              Logger.getLogger(ViewBookDetailController.class.getName()).log(Level.SEVERE, null, ex);
          }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       try{
           CategoryDao categoryDao = new CategoryDaoImpl();
           BookDao bookDao = new BookDaoImpl();
           String title = request.getParameter("title").trim();
           String author = request.getParameter("author").trim();
           String brief = request.getParameter("brief").trim();
           String publisher = request.getParameter("publisher").trim();
           int cate = Integer.parseInt(request.getParameter("category"));
           Category category = categoryDao.getById(cate);
           String content = request.getParameter("content").trim();
           String imgURL = request.getParameter("img").trim();
           Date date = Date.valueOf(request.getParameter("date").trim());
           String bookId = AppUtil.createBookId(title);
           String bookIdInDb = bookDao.getLastestBookId(bookId);
           if(bookIdInDb == null){
               bookId =  String.format("%s%02d", bookId, 1);
           }
           else{
                String indexBookId = bookIdInDb.replaceFirst(bookId, "");
                try{
                    int castIndexBookId = Integer.parseInt(indexBookId);
                    bookId =  String.format("%s%02d", bookId, ++castIndexBookId);
                }
                catch (NumberFormatException e){

                }
           }
           Book book = new Book(bookId,title,author,brief,publisher,content,imgURL,date,category);
           if( bookDao.addBook(book)){
               request.getSession().setAttribute("insert","Insert successfully!");
           }else{
               request.getSession().setAttribute("insert","Insert failed!");
           }
           response.sendRedirect(request.getContextPath()+"/admin-book");
           return;
       }
       catch (Exception ex){
           Logger.getLogger(ViewBookDetailController.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
}
