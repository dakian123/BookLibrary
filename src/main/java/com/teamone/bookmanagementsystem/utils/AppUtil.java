package com.teamone.bookmanagementsystem.utils;/*
 * Copyright(C)2022
 * Mock_project
 * Record of change:
 * DATE       Version     AUTHOR     Description
 * 8/9/2022    1.0         ADMIN    First Implement
 */

import com.teamone.bookmanagementsystem.config.SecurityConfig;
import com.teamone.bookmanagementsystem.models.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

public class AppUtil {
    private static int REDIRECT_ID = 0;

    private static final Map<Integer, String> ID_URI_MAP = new HashMap<Integer, String>();
    private static final Map<String, Integer> URI_ID_MAP = new HashMap<String, Integer>();

    private static AppUtil appUtil = null;

    public static AppUtil getInstance(){
        if(appUtil == null){
            appUtil = new AppUtil();
        }
        return appUtil;
    }
    /**
     * Add information of user to session .
     *
     * @param session   session from request It is
     *                  a <code>javax.servlet.http.HttpSession</code> object
     * @param loginUser object
     */
    public static void storeLoginedUser(HttpSession session, User loginUser) {
        // Trên JSP có thể truy cập thông qua ${loginUser}
        session.setAttribute("user", loginUser);
    }

    /**
     * Get information of user from session .
     *
     * @param session session from request It is
     *                a <code>javax.servlet.http.HttpSession</code> object
     * @return AccountBean object
     */
    public static User getLoginedUser(HttpSession session) {
        User loginUser = (User) session.getAttribute("user");
        return loginUser;
    }

    public static int storeRedirectAfterLoginUrl(HttpSession session, String requestUri) {
        Integer id = URI_ID_MAP.get(requestUri);

        if (id == null) {
            id = REDIRECT_ID++;

            URI_ID_MAP.put(requestUri, id);
            ID_URI_MAP.put(id, requestUri);
            return id;
        }

        return id;
    }

    public static String getRedirectAfterLoginUrl(HttpSession session, int redirectId) {
        String url = ID_URI_MAP.get(redirectId);
        if (url != null) {
            return url;
        }
        return null;
    }
    /**
     * Check if request access a page need to login or not.
     *
     * @param request
     * @return
     *
     */
    public static boolean isSecurityPage(HttpServletRequest request) {
        String urlPattern = UrlPatternUtil.getUrlPattern(request);
        Set<String> roles = SecurityConfig.getAllAppRoles();
        return roles.stream().map((role) -> SecurityConfig.getUrlPatternForRole(role)).anyMatch((urlPatterns) -> (urlPatterns != null && urlPatterns.contains(urlPattern)));
    }

    /**
     * Check if request access a page have permission to access page or not
     *
     * @param request
     * @return
     *
     */
    public static boolean hasPermission(HttpServletRequest request){
        String urlPattern = UrlPatternUtil.getUrlPattern(request);
        Set<String> allRoles = SecurityConfig.getAllAppRoles();
        return allRoles.stream().filter((role) -> !(!request.isUserInRole(role))).map((role) -> SecurityConfig.getUrlPatternForRole(role)).anyMatch((urlPatterns) -> (urlPatterns != null && urlPatterns.contains(urlPattern)));
    }

    public static String createBookId(String bookName) {
        List<String> words = Arrays.asList(bookName.split("\\s+"));
        StringBuilder bookId = new StringBuilder();
        words.forEach((word) -> bookId.append(word.toUpperCase().charAt(0)));
        return bookId.toString();
    }
}
