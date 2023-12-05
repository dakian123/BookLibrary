package com.teamone.bookmanagementsystem.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.teamone.bookmanagementsystem.dao.CategoryDao;
import com.teamone.bookmanagementsystem.models.Category;

/*
 * Copyright(C)2022
 * Mock_project
 * Record of change:
 * DATE       Version     AUTHOR     Description
 * 8/8/2022    1.0         ADMIN    First Implement
 */

public class CategoryDaoImpl implements CategoryDao{

	@Override
	public List<Category> getAll() throws SQLException {
		List<Category> categoryList = new ArrayList<>();
		try(Connection con = DBContext.getConnection()){
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("SELECT CategoryId, CategoryName FROM Category");
			while(rs.next()) {
				int categoryId = rs.getInt(1);
				String categoryName = rs.getString(2);
				Category category = new Category(categoryId, categoryName);
				categoryList.add(category);
			}
		}catch (Exception e){
            System.out.println("Get all category fail!");
        }
		return categoryList;
	}

	@Override
	public Category getById(int targetId) throws SQLException {
		try(Connection con = DBContext.getConnection()){
			PreparedStatement preparedStatement = 
					con.prepareStatement("SELECT CategoryId, CategoryName FROM Category\r\n"
					+ "Where CategoryId = ?");
			preparedStatement.setInt(1, targetId);
			ResultSet rs = preparedStatement.executeQuery();
			rs.next();
			int categoryId = rs.getInt("CategoryId");
			String categoryName = rs.getString("CategoryName");
			Category category =  new Category(categoryId, categoryName);
			return category;	
		}
	}
}
