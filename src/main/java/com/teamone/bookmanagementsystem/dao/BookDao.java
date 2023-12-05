package com.teamone.bookmanagementsystem.dao;/*
 * Copyright(C)2022
 * Mock_project
 * Record of change:
 * DATE       Version     AUTHOR     Description
 * 8/8/2022    1.0         ADMIN    First Implement
 */

import java.sql.SQLException;
import java.util.List;

import com.teamone.bookmanagementsystem.models.Book;

public interface BookDao {
	List<Book> totalBook() throws SQLException;
	List<Book> selectAll(int page) throws SQLException;
	List<Book> selectNewBook() throws SQLException;
	Book selectBookById(String bookId) throws SQLException;
	List<Book> selectRandom() throws SQLException;
	List<Book> selectByCategory(int page,String categoryId) throws SQLException;
	List<Book> search(int page,String category,String value) throws SQLException;
	List<Book> search1(String textSearch, String value) throws SQLException;
	boolean addBook(Book book) throws SQLException;
	boolean updateBook(Book book) throws SQLException;
	boolean deleteBook(String bookId) throws SQLException;
	String getLastestBookId(String bookId)throws SQLException;
	public List<Book> selectAllForAdmin() throws SQLException;
}
