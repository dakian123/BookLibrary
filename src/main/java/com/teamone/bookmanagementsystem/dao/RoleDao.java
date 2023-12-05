package com.teamone.bookmanagementsystem.dao;/*
 * Copyright(C)2022
 * Mock_project
 * Record of change:
 * DATE       Version     AUTHOR     Description
 * 8/8/2022    1.0         ADMIN    First Implement
 */

import com.teamone.bookmanagementsystem.models.Role;
import java.sql.SQLException;
import java.util.List;

public interface RoleDao {

    List<Role> getAllRole() throws SQLException;
    boolean addRole(String authority) throws SQLException;
    boolean deleteRole(int roleId) throws SQLException;
    boolean updateRole(int roleId, String authority) throws SQLException;
}
