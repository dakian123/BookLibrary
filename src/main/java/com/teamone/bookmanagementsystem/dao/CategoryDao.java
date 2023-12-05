package com.teamone.bookmanagementsystem.dao;

import java.sql.SQLException;
import java.util.List;

import com.teamone.bookmanagementsystem.models.Category;

/*
 * Copyright(C)2022
 * Mock_project
 * Record of change:
 * DATE       Version     AUTHOR     Description
 * 8/8/2022    1.0         ADMIN    First Implement
 */

public interface CategoryDao {
	List<Category> getAll() throws SQLException;
	Category getById(int targetId) throws SQLException;
}
