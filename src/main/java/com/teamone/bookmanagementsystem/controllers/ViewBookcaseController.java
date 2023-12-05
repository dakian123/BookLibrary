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
import com.teamone.bookmanagementsystem.models.Contain;
import com.teamone.bookmanagementsystem.models.User;
import com.teamone.bookmanagementsystem.utils.AppUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ViewBookcaseController", value = "/bookcase")
public class ViewBookcaseController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ContainDao contain = new ContainDaoImpl();
        try {
            User user = AppUtil.getLoginedUser(request.getSession(false));
            request.setAttribute("bookcase",user.getBookCase());
            List<Book> books = contain.selectListBook(user.getId());
            request.setAttribute("books",books);
            request.getRequestDispatcher("/view/bookcase.jsp").forward(request,response);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
