package com.teamone.bookmanagementsystem.wrappers;
/*
 * Copyright(C)2022
 * Mock_project
 * Record of change:
 * DATE       Version     AUTHOR     Description
 * 8/9/2022    1.0         ADMIN    First Implement
 */

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.security.Principal;

public class UserRoleRequestWrapper extends HttpServletRequestWrapper {

    private final String user;
    private String role = null;
    private final HttpServletRequest realRequest;
    public UserRoleRequestWrapper(String user, String role, HttpServletRequest request) {
        super(request);
        this.user = user;
        this.role = role;
        this.realRequest = request;
    }
    @Override
    public boolean isUserInRole(String role) {
        if (this.role == null) {
            return this.realRequest.isUserInRole(role);
        }
        return this.role.equals(role);
    }

    @Override
    public Principal getUserPrincipal() {
        if (this.user == null) {
            return realRequest.getUserPrincipal();
        }
        // Make an anonymous implementation to just return our user
        return () -> user;
    }

}
