package com.teamone.bookmanagementsystem.filters;/*
 * Copyright(C)2022
 * Mock_project
 * Record of change:
 * DATE       Version     AUTHOR     Description
 * 8/12/2022    1.0         ADMIN    First Implement
 */

import com.teamone.bookmanagementsystem.models.User;
import com.teamone.bookmanagementsystem.utils.AppUtil;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "PreventAccessJSPFilter")
public class PreventAccessJSPFilter implements Filter {
    public void init(FilterConfig config) {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        String uriPath = request.getRequestURI();
        String servletPath = request.getServletPath();
        /*if uri contain .jsp that user access directly to jsp page, return home*/
        if(uriPath.contains(".jsp")){
            response.sendRedirect("books");
            return;
        }
        User loginUser = AppUtil.getLoginedUser(request.getSession());
        /*if servletPath contains login and user already login, return home*/
        if(loginUser != null){
            if(servletPath.equals("/login") || servletPath.equals("/register")){
                response.sendRedirect("books");
                return;
            }
        }
        chain.doFilter(request, response);
    }
}
