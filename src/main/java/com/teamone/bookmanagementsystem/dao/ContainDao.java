package com.teamone.bookmanagementsystem.dao;

import java.sql.SQLException;
import java.util.List;

import com.teamone.bookmanagementsystem.models.Book;
import com.teamone.bookmanagementsystem.models.Bookcase;
import com.teamone.bookmanagementsystem.models.User;

/*
 * Copyright(C)2022
 * Mock_project
 * Record of change:
 * DATE       Version     AUTHOR     Description
 * 8/8/2022    1.0         ADMIN    First Implement
 */

public interface ContainDao {
	boolean addBookIntoBookcase(int bookcaseId, String bookId) throws SQLException;
	boolean deleteBookFromBookcase(int userId, String bookId) throws SQLException;
	List<Book> selectListBook (int userId) throws SQLException;
	boolean isBookExist (int bookcaseId, String bookId) throws SQLException;
}
