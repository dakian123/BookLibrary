package com.teamone.bookmanagementsystem.listners;/*
 * Copyright(C)2022
 * Mock_project
 * Record of change:
 * DATE       Version     AUTHOR     Description
 * 8/12/2022    1.0         ADMIN    First Implement
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebListener
public class GetContextListener implements ServletContextListener{

    public static ServletContext servletContext;
    public GetContextListener() {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        servletContext = sce.getServletContext();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        servletContext = null;
    }

}
