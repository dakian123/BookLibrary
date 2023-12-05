package com.teamone.bookmanagementsystem.utils;/*
 * Copyright(C)2022
 * Mock_project
 * Record of change:
 * DATE       Version     AUTHOR     Description
 * 8/9/2022    1.0         ADMIN    First Implement
 */

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class UrlPatternUtil {
    private static boolean hasUrlPattern(ServletContext servletContext, String urlPattern) {

        Map<String, ? extends ServletRegistration> map = servletContext.getServletRegistrations();

        return map.keySet().stream().map((servletName) -> map.get(servletName)).map((sr) -> sr.getMappings()).anyMatch((mappings) -> (mappings.contains(urlPattern)));
    }

    // servletPath:
    // ==> /spath
    // ==> /spath/*
    // ==> *.ext
    // ==> /
    public static String getUrlPattern(HttpServletRequest request) {
        ServletContext servletContext = request.getServletContext();
        String servletPath = request.getServletPath();
        String pathInfo = request.getPathInfo();

        StringBuilder urlPattern = new StringBuilder();
        if (pathInfo != null) {
            urlPattern.append(servletPath);
            urlPattern.append("/*");
            return urlPattern.toString();
        }
        urlPattern.append(servletPath);

        boolean has = hasUrlPattern(servletContext, String.valueOf(urlPattern));
        if (has) {
            return urlPattern.toString();
        }
        int i = servletPath.lastIndexOf('.');
        if (i != -1) {
            String ext = servletPath.substring(i + 1);
            urlPattern.append("*.");
            urlPattern.append(ext);
            has = hasUrlPattern(servletContext, String.valueOf(urlPattern));

            if (has) {
                return urlPattern.toString();
            }
        }
        return "/";
    }
}
