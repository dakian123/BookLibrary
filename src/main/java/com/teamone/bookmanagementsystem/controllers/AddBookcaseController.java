package com.teamone.bookmanagementsystem.controllers;/*
														* Copyright(C)2022
														* Mock_project
														* Record of change:
														* DATE       Version     AUTHOR     Description
														* 8/10/2022    1.0         ADMIN    First Implement
														*/

import javax.servlet.*;
import javax.servlet.http.*;


import com.teamone.bookmanagementsystem.dao.ContainDao;
import com.teamone.bookmanagementsystem.dao.impl.ContainDaoImpl;
import com.teamone.bookmanagementsystem.models.Book;
import com.teamone.bookmanagementsystem.models.User;
import com.teamone.bookmanagementsystem.utils.AppUtil;

import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "AddBookcaseController", value = "/bookcaseadd")
public class AddBookcaseController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String targetBookId = request.getParameter("bookId");
		try {
			
			User user = AppUtil.getLoginedUser(request.getSession(false));
			ContainDao containDao = new ContainDaoImpl();
			
			if(!containDao.isBookExist(user.getBookCase().getBookcaseId(), targetBookId)) {	
				containDao.addBookIntoBookcase(user.getBookCase().getBookcaseId(), targetBookId);
				request.setAttribute("bookcase", user.getBookCase());
	            List<Book> books = containDao.selectListBook(user.getId());
				request.setAttribute("books", books);
				response.sendRedirect(request.getContextPath()+"/bookcase");
			}
			else {			
				request.setAttribute("error_text", "This book is already on bookcase");
				request.getRequestDispatcher("/view/detail.jsp").forward(request, response);
			}
			
		} catch (Exception ex) {
			Logger.getLogger(ViewBookDetailController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
