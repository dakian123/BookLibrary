package com.teamone.bookmanagementsystem.dao.impl;/*
 * Copyright(C)2022
 * Mock_project
 * Record of change:
 * DATE       Version     AUTHOR     Description
 * 8/8/2022    1.0         ADMIN    First Implement
 */

import com.teamone.bookmanagementsystem.dao.RoleDao;
import com.teamone.bookmanagementsystem.dao.UserDao;
import com.teamone.bookmanagementsystem.models.Bookcase;
import com.teamone.bookmanagementsystem.models.Role;
import com.teamone.bookmanagementsystem.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public List<User> getAllUser() throws SQLException {
        List<User> listUser = new ArrayList<User>();
        try (Connection con = DBContext.getConnection()) {
            java.sql.Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM dbo.[User]");
            while (rs.next()) {
                int id = rs.getInt(1);
                String username = rs.getString(2);
                String password = rs.getString(3);
                Role role = new Role(rs.getInt(4), "");

                listUser.add(new User(id, username, password, role));
            }
        }
        return listUser;
    }

    @Override
    public boolean addUser(String username, String password, Role role) throws SQLException {
        int check = 0;
        try (Connection con = DBContext.getConnection()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO dbo.[User] VALUES (?, ?, ?)");
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setInt(3, role.getRoleId());
            check = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Add user fail!");
        }
        return check > 0;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateUser(int id, String username, String password) throws SQLException {
        try (Connection con = DBContext.getConnection()) {
            PreparedStatement ps = con.prepareStatement("UPDATE dbo.[User] SET Username =?, [Password] = ? WHERE Id = 9");
            ps.setInt(1, id);
            ps.setString(2, username);
            ps.setString(3, password);
            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public User getUserByUsername(String username) throws SQLException {
        try (Connection con = DBContext.getConnection()) {
            ResultSet rs = null;
            PreparedStatement ps = con.prepareStatement("SELECT u.Id, u.Username, u.[Password], u.RoleId, r.Authority, b.BookcaseId, b.BookcaseName, b.TotalBook \r\n"
            		+ "FROM [User] u JOIN [Role] r ON u.RoleId = r.RoleId JOIN [Bookcase] b ON u.Id = b.BookcaseId\r\n"
            		+ "WHERE u.Username = ?");
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt(1));
                user.setUsername(rs.getString(2));
                user.setPassword(rs.getString(3));
                Role role = new Role();
                role.setRoleId(rs.getInt(4));
                role.setAuthority(rs.getString(5));
                user.setRole(role);
                Bookcase bookcase = new Bookcase();
                bookcase.setBookcaseId(rs.getInt(6));
                bookcase.setBookcaseName(rs.getString(7));
                bookcase.setTotalBook(rs.getInt(8));
                bookcase.setUser(user);
                user.setBookCase(bookcase);
                return user;
            }
        }
        return null;
    }
}
