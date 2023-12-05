/*
 * Copyright(C)2022
 * Mock_project
 * Record of change:
 * DATE       Version     AUTHOR     Description
 * 8/9/2022    1.0         ADMIN    First Implement
 */
package com.teamone.bookmanagementsystem.filters;
import com.teamone.bookmanagementsystem.models.User;
import com.teamone.bookmanagementsystem.utils.AppUtil;
import com.teamone.bookmanagementsystem.wrappers.UserRoleRequestWrapper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "SecurityFilter", value = "/*")
public class SecurityFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String servletPath = req.getServletPath();
        if(servletPath.contains("/login") || servletPath.contains("/register")){
            chain.doFilter(request, response);
            return;
        }
        HttpServletRequest wrapperRequest = req;
        User loginUser = AppUtil.getLoginedUser(req.getSession());
        if(loginUser != null){
            String username = loginUser.getUsername();
            String role = loginUser.getRole().getAuthority();
            wrapperRequest = new UserRoleRequestWrapper(username, role, req);
        }
        if (AppUtil.isSecurityPage(req)) {
            if (loginUser == null) {
                String requestUri = req.getRequestURI();
                int redirectId = AppUtil.storeRedirectAfterLoginUrl(req.getSession(), requestUri);
                res.sendRedirect(wrapperRequest.getContextPath() + "/login?redirectId=" + redirectId);
                return;
            }
            boolean hasPermission = AppUtil.hasPermission(wrapperRequest);
            if (!hasPermission) {
                request.getRequestDispatcher("/view/accessDenied.jsp").forward(request, response);
                return;
            }
        }
        chain.doFilter(request, response);

    }
}
