package com.teamone.bookmanagementsystem.dao;/*
 * Copyright(C)2022
 * Mock_project
 * Record of change:
 * DATE       Version     AUTHOR     Description
 * 8/8/2022    1.0         ADMIN    First Implement
 */

import com.teamone.bookmanagementsystem.models.Role;
import com.teamone.bookmanagementsystem.models.User;
import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    List<User> getAllUser() throws SQLException;
    boolean addUser(String username, String password, Role role) throws SQLException;
    boolean deleteUser(int id) throws SQLException;
    boolean updateUser(int id, String username, String password) throws SQLException;
    User getUserByUsername(String username) throws SQLException;

}
