package com.teamone.bookmanagementsystem.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.teamone.bookmanagementsystem.dao.ContainDao;
import com.teamone.bookmanagementsystem.models.Book;
import com.teamone.bookmanagementsystem.models.Category;

/*
 * Copyright(C)2022
 * Mock_project
 * Record of change:
 * DATE       Version     AUTHOR     Description
 * 8/8/2022    1.0         ADMIN    First Implement
 */

public class ContainDaoImpl implements ContainDao{

	@Override
	public boolean addBookIntoBookcase(int bookcaseId, String bookId) throws SQLException {
		int check = 0;
		try(Connection con = DBContext.getConnection()){
			PreparedStatement preparedStatement = con.prepareStatement("\r\n"
					+ "INSERT INTO Contain VALUES \r\n"
					+ "(? , ?,  ?)");
			preparedStatement.setInt(1, bookcaseId);
			preparedStatement.setString(2, bookId);
			preparedStatement.setDate(3, java.sql.Date.valueOf(java.time.LocalDate.now()));
			check = preparedStatement.executeUpdate();
        }catch (Exception e){
            System.out.println("Add book into bookcase fail!");
            e.printStackTrace();
        }
        return check > 0;
	}

	@Override
	public boolean deleteBookFromBookcase(int userId, String bookId) throws SQLException {
		int check = 0;
		try(Connection con = DBContext.getConnection()){
			PreparedStatement preparedStatement = con.prepareStatement("DELETE FROM Contain\r\n"
					+ "WHERE BookcaseId = ? and BookId = ?");
			preparedStatement.setInt(1, userId);
			preparedStatement.setString(2, bookId);
			check = preparedStatement.executeUpdate();
        }catch (Exception e){
            System.out.println("Delete book from bookcase fail!");
            e.printStackTrace();
        }
        return check > 0;
	}
	

	public List<Book> selectListBook (int userId) throws SQLException{
		List<Book> listBooks = new ArrayList<Book>();
		try (Connection connection = DBContext.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(
					"SELECT Book.*,CategoryName FROM Book INNER JOIN Category ON Book.CategoryId = Category.CategoryId \r\n"
					+ "WHERE BookId IN (SELECT BookId FROM Contain WHERE BookcaseId = ?)");
			statement.setInt(1, userId);
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
	
	@Override
	public boolean isBookExist(int bookcaseId, String bookId) throws SQLException {
		try(Connection connection = DBContext.getConnection()){
			PreparedStatement statement = connection.prepareStatement("SELECT BookId FROM Contain WHERE BookcaseId = ? and BookId = ?");
			statement.setInt(1, bookcaseId);
			statement.setString(2, bookId);
			ResultSet rs = statement.executeQuery();
			if(rs.next()) {
				return true;
			}				
			else {
				return false;
			}							
		}catch (SQLException e) {
			// TODO: handle exception
			return false;
		}
		
	}


}
