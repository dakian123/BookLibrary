package com.teamone.bookmanagementsystem.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.teamone.bookmanagementsystem.dao.BookDao;
import com.teamone.bookmanagementsystem.models.Book;
import com.teamone.bookmanagementsystem.models.Category;

/*
 * Copyright(C)2022
 * Mock_project
 * Record of change:
 * DATE       Version     AUTHOR     Description
 * 8/8/2022    1.0         ADMIN    First Implement
 */

public class BookDaoImpl implements BookDao {
	public List<Book> totalBook() throws SQLException {
		List<Book> listBooks = new ArrayList<Book>();
		try (Connection connection = DBContext.getConnection()) {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT a.*,CategoryName FROM (SELECT * ,ROW_NUMBER() OVER (ORDER BY CreateDate DESC) AS e FROM Book) AS a INNER JOIN Category ON a.CategoryId = Category.CategoryId");
			while (rs.next()) {
				String bid = rs.getString(1);
				String btitle = rs.getString(2);
				String auhor = rs.getString(3);
				String brief = rs.getString(4);
				String publisher = rs.getString(5);
				String content = rs.getString(6);
				String image = rs.getString(7);
				Date createdate = rs.getDate(8);
				int cateid = rs.getInt(9);
				String catename = rs.getString(11);
				Category category = new Category(cateid, catename);
				Book book = new Book(bid, btitle, auhor, brief, publisher, content, image, createdate, category);
				listBooks.add(book);
			}

		}
		return listBooks;
	}

	public List<Book> selectAll(int page) throws SQLException {
		List<Book> listBooks = new ArrayList<Book>();
		int pageSize = 8;
		try (Connection connection = DBContext.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(
					"SELECT a.*,CategoryName FROM (SELECT * ,ROW_NUMBER() OVER (ORDER BY CreateDate DESC) AS e FROM Book) AS a INNER JOIN Category ON a.CategoryId = Category.CategoryId WHERE e between ? and ?");
			statement.setInt(1, ((page-1) * pageSize)+1);
			int b = pageSize * page;
			statement.setInt(2, b);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String bid = rs.getString(1);
				String btitle = rs.getString(2);
				String auhor = rs.getString(3);
				String brief = rs.getString(4);
				String publisher = rs.getString(5);
				String content = rs.getString(6);
				String image = rs.getString(7);
				Date createdate = rs.getDate(8);
				int cateid = rs.getInt(9);
				String catename = rs.getString(11);
				Category category = new Category(cateid, catename);
				Book book = new Book(bid, btitle, auhor, brief, publisher, content, image, createdate, category);
				listBooks.add(book);
			}

		}
		return listBooks;
	}
	public List<Book> selectAllForAdmin() throws SQLException {
		List<Book> listBooks = new ArrayList<Book>();
		try (Connection connection = DBContext.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(
					"SELECT a.*,CategoryName FROM (SELECT * ,ROW_NUMBER() OVER (ORDER BY CreateDate DESC) AS e FROM Book) AS a INNER JOIN Category ON a.CategoryId = Category.CategoryId ");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String bid = rs.getString(1);
				String btitle = rs.getString(2);
				String author = rs.getString(3);
				String brief = rs.getString(4);
				String publisher = rs.getString(5);
				String content = rs.getString(6);
				String image = rs.getString(7);
				Date createdate = rs.getDate(8);
				int cateid = rs.getInt(9);
				String catename = rs.getString(11);
				Category category = new Category(cateid, catename);
				Book book = new Book(bid, btitle, author, brief, publisher, content, image, createdate, category);
				listBooks.add(book);
			}

		}
		return listBooks;
	}

	public List<Book> selectNewBook() throws SQLException {
		List<Book> listBooks = new ArrayList<Book>();
		try (Connection connection = DBContext.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(
					"SELECT TOP 4 Book.*,CategoryName FROM Book INNER JOIN Category ON Book.CategoryId = Category.CategoryId ORDER BY CreateDate DESC");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String bid = rs.getString(1);
				String btitle = rs.getString(2);
				String auhor = rs.getString(3);
				String brief = rs.getString(4);
				String publisher = rs.getString(5);
				String content = rs.getString(6);
				String image = rs.getString(7);
				Date createdate = rs.getDate(8);
				int cateid = rs.getInt(9);
				String catename = rs.getString(10);
				Category category = new Category(cateid, catename);
				Book book = new Book(bid, btitle, auhor, brief, publisher, content, image, createdate, category);
				listBooks.add(book);
			}

		}
		return listBooks;
	}

	public Book selectBookById(String bookId) throws SQLException {
		try (Connection connection = DBContext.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(
					"SELECT Book.*,CategoryName FROM Book INNER JOIN Category ON Book.CategoryId = Category.CategoryId WHERE BookId = ?");
			statement.setString(1, bookId);
			ResultSet rs = statement.executeQuery();
			rs.next();
			String bid = rs.getString(1);
			String btitle = rs.getString(2);
			String auhor = rs.getString(3);
			String brief = rs.getString(4);
			String publisher = rs.getString(5);
			String content = rs.getString(6);
			String image = rs.getString(7);
			Date createdate = rs.getDate(8);
			int cateid = rs.getInt(9);
			String catename = rs.getString(10);
			Category category = new Category(cateid, catename);
			Book book = new Book(bid, btitle, auhor, brief, publisher, content, image, createdate, category);
			return book;
		}

	}

	public List<Book> selectRandom() throws SQLException {
		List<Book> listBooks = new ArrayList<Book>();
		try (Connection connection = DBContext.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(
					"SELECT TOP 4 Book.*,CategoryName FROM Book INNER JOIN Category ON Book.CategoryId = Category.CategoryId ORDER BY NEWID()");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String bid = rs.getString(1);
				String btitle = rs.getString(2);
				String auhor = rs.getString(3);
				String brief = rs.getString(4);
				String publisher = rs.getString(5);
				String content = rs.getString(6);
				String image = rs.getString(7);
				Date createdate = rs.getDate(8);
				int cateid = rs.getInt(9);
				String catename = rs.getString(10);
				Category category = new Category(cateid, catename);
				Book book = new Book(bid, btitle, auhor, brief, publisher, content, image, createdate, category);
				listBooks.add(book);
			}

		}
		return listBooks;
	}

	public List<Book> selectByCategory(int page, String categoryId) throws SQLException {
		List<Book> listBooks = new ArrayList<Book>();
		int pageSize = 8;
		try (Connection connection = DBContext.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(
					"SELECT a.*,CategoryName FROM (SELECT * ,ROW_NUMBER() OVER (ORDER BY CreateDate DESC) AS e FROM Book WHERE CategoryId = ? ) AS a INNER JOIN Category ON a.CategoryId = Category.CategoryId WHERE e between ? and ?");
			statement.setString(1, categoryId);
			statement.setInt(2, ((page-1) * pageSize)+1);
			int b = pageSize * page;
			statement.setInt(3, b);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String bid = rs.getString(1);
				String btitle = rs.getString(2);
				String auhor = rs.getString(3);
				String brief = rs.getString(4);
				String publisher = rs.getString(5);
				String content = rs.getString(6);
				String image = rs.getString(7);
				Date createdate = rs.getDate(8);
				int cateid = rs.getInt(9);
				String catename = rs.getString(11);
				Category category = new Category(cateid, catename);
				Book book = new Book(bid, btitle, auhor, brief, publisher, content, image, createdate, category);
				listBooks.add(book);
			}

		}
		return listBooks;
	}

	public List<Book> search(int page, String textSearch, String value) throws SQLException {
		List<Book> listBooks = new ArrayList<Book>();
		int pageSize = 8;
		try (Connection connection = DBContext.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(
					"SELECT a.*,CategoryName FROM (SELECT * ,ROW_NUMBER() OVER (ORDER BY CreateDate DESC) AS e FROM Book "
					+ "WHERE "+ textSearch+" LIKE ?) AS a INNER JOIN Category ON a.CategoryId = Category.CategoryId  WHERE e between ? and ?");
			statement.setString(1, "%" + value + "%");
			statement.setInt(2, ((page - 1) * pageSize)+1);
			int b = pageSize * page;
			System.out.println(b);
			statement.setInt(3, b);
			
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String bid = rs.getString(1);
				String btitle = rs.getString(2);
				String auhor = rs.getString(3);
				String brief = rs.getString(4);
				String publisher = rs.getString(5);
				String content = rs.getString(6);
				String image = rs.getString(7);
				Date createdate = rs.getDate(8);
				int cateid = rs.getInt(9);
				String catename = rs.getString(11);
				Category category = new Category(cateid, catename);
				Book book = new Book(bid, btitle, auhor, brief, publisher, content, image, createdate, category);
				listBooks.add(book);
			}

		}
		return listBooks;
	}

	public List<Book> search1(String textSearch ,String value) throws SQLException {
		List<Book> listBooks = new ArrayList<Book>();
		try (Connection connection = DBContext.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(
					"SELECT a.*,CategoryName FROM (SELECT * ,ROW_NUMBER() OVER (ORDER BY CreateDate DESC) AS e FROM Book "
					+ "WHERE "+ textSearch+" LIKE ?) AS a INNER JOIN Category ON a.CategoryId = Category.CategoryId");
			statement.setString(1, "%" + value + "%");			
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String bid = rs.getString(1);
				String btitle = rs.getString(2);
				String auhor = rs.getString(3);
				String brief = rs.getString(4);
				String publisher = rs.getString(5);
				String content = rs.getString(6);
				String image = rs.getString(7);
				Date createdate = rs.getDate(8);
				int cateid = rs.getInt(9);
				String catename = rs.getString(11);
				Category category = new Category(cateid, catename);
				Book book = new Book(bid, btitle, auhor, brief, publisher, content, image, createdate, category);
				listBooks.add(book);
			}

		}
		return listBooks;
	}

	public boolean addBook(Book book) throws SQLException {
		try (Connection connection = DBContext.getConnection()) {
			PreparedStatement statement = connection.prepareStatement("INSERT INTO Book VALUES(?,?,?, ?, ?,?, ?, ?,?)");
			statement.setString(1, book.getbookId());
			statement.setString(2, book.getbookTitle());
			statement.setString(3, book.getauthor());
			statement.setString(4, book.getBrief());
			statement.setString(5, book.getPublisher());
			statement.setString(6, book.getContent());
			statement.setString(7, book.getImage());
			statement.setDate(8, book.getcreateDate());
			statement.setInt(9, book.getCategory().getcategoryId());
			return statement.executeUpdate() > 0;
		}
	}

	public boolean updateBook(Book book) throws SQLException {
		try (Connection connection = DBContext.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(
					"UPDATE [dbo].[Book] SET [BookTitle] = ?\r\n" + "      ,[Author] = ?\r\n" + "      ,[Brief] = ?\r\n"
							+ "      ,[Publisher] = ?\r\n" + "      ,[Content] = ?\r\n" + "      ,[Image] = ?\r\n"
							+ "      ,[CreateDate] = ?\r\n" + "      ,[CategoryId] = ?\r\n" + " WHERE [BookId] = ?");
			statement.setString(1, book.getbookTitle());
			statement.setString(2, book.getauthor());
			statement.setString(3, book.getBrief());
			statement.setString(4, book.getPublisher());
			statement.setString(5, book.getContent());
			statement.setString(6, book.getImage());
			statement.setDate(7, book.getcreateDate());
			statement.setInt(8, book.getCategory().getcategoryId());
			statement.setString(9, book.getbookId());
			return statement.executeUpdate() > 0;
		}
	}

	public boolean deleteBook(String bookId) throws SQLException {
		try (Connection connection = DBContext.getConnection()) {
			PreparedStatement statement = connection
					.prepareStatement("DELETE FROM [dbo].[Book]\r\n" + "      WHERE BookId = ?");
			statement.setString(1, bookId);
			return statement.executeUpdate() > 0;
		}

	}
	public boolean deleteBookContain(String bookId) throws SQLException {
		try (Connection connection = DBContext.getConnection()) {
			PreparedStatement statement = connection
					.prepareStatement("DELETE FROM [dbo].[Contain]\r\n" + "      WHERE BookId = ?");
			statement.setString(1, bookId);
			return statement.executeUpdate() > 0;
		}
	}
	public boolean checkBookExist(String bookId) throws SQLException {
		try (Connection connection = DBContext.getConnection()) {
			PreparedStatement statement = connection
					.prepareStatement("SELECT * FROM [dbo].[Contain]\r\n" + "      WHERE BookId = ?");
			statement.setString(1, bookId);
			ResultSet rs = statement.executeQuery();
			if(rs.next()){
				return true;
			} else {
				return false;
			}
		}
	}



	@Override
	public String getLastestBookId(String bookId) throws SQLException{
		List<String> listBookId = new ArrayList<>();
		try(Connection connection = DBContext.getConnection()){
			PreparedStatement statement = connection.prepareStatement("SELECT TOP 1 BookId FROM [dbo].[Book] WHERE BookId LIKE ? ORDER BY BookId DESC ");
			statement.setString(1, bookId +"[0-9]%");
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()){
				return resultSet.getString(1);
			}
		}
		return null;
	}

	public static void main(String[] args) throws SQLException {
		BookDaoImpl bookDao = new BookDaoImpl();
		boolean a = bookDao.checkBookExist("ITW02");
		System.out.println(a);
	}
}
