package com.teamone.bookmanagementsystem.dao.impl;/*
 * Copyright(C)2022
 * Mock_project
 * Record of change:
 * DATE       Version     AUTHOR     Description
 * 8/8/2022    1.0         ADMIN    First Implement
 */

import com.teamone.bookmanagementsystem.dao.RoleDao;
import com.teamone.bookmanagementsystem.models.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleDaoImpl implements RoleDao {



    public List<Role> getAllRole() throws SQLException {
        List<Role> listRole = new ArrayList<Role>();
        try(Connection con = DBContext.getConnection()){
            java.sql.Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM dbo.[Role]");
            while(rs.next()) {
                int roleId = rs.getInt(1);
                String authority = rs.getString(2);
                listRole.add(new Role(roleId, authority));
            }
        }
        return listRole;
    }

    public boolean addRole(String authority) throws SQLException {
        int check = 0;
        try(Connection con = DBContext.getConnection()){
            PreparedStatement ps = con.prepareStatement("INSERT INTO dbo.[Role] VALUES(?)");
            ps.setString(1, authority);
            check = ps.executeUpdate();

        }catch (Exception e){
            System.out.println("Add role fail!");
        }

        return check>0;
    }

    public boolean deleteRole(int roleId) throws SQLException {
        try(Connection con = DBContext.getConnection()){
            PreparedStatement ps = con.prepareStatement("DELETE FROM dbo.[Role] WHERE RoleId=?");
            ps.setInt(1, roleId);
            return ps.executeUpdate()>0;
        }
    }

    @Override
    public boolean updateRole(int roleId, String authority) throws SQLException {
        try(Connection con = DBContext.getConnection()){
            PreparedStatement ps = con.prepareStatement("UPDATE dbo.[Role] SET authority = ? WHERE RoleId = ?");
            ps.setInt(1, roleId);
            ps.setString(2, authority);
            return ps.executeUpdate()>0;
        }
    }
}
