package com.teamone.bookmanagementsystem.config;/*
 * Copyright(C)2022
 * Mock_project
 * Record of change:
 * DATE       Version     AUTHOR     Description
 * 8/10/2022    1.0         ADMIN    First Implement
 */

import com.teamone.bookmanagementsystem.listners.GetContextListener;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SecurityConfig {

    public static final String ADMIN_ROLE = "Admin";
    public static final String USER_ROLE = "User";
    private static final Map<String, List<String>> MAP_CONFIG = new HashMap<>();
    static {
        init();
    }

    private static void init() {
        ServletContext context = GetContextListener.servletContext;
        Map<String, ? extends ServletRegistration> registrations = context.getServletRegistrations();
        Supplier<Stream<String>> allPattern = () -> registrations.keySet().stream()
                .map((servletName) -> registrations.get(servletName)).map((sr) -> sr.getMappings())
                .flatMap(col -> col.stream());
        List<String> userPattern = allPattern.get().filter((mapping) -> mapping.contains("bookcase"))
                .collect(Collectors.toList());
        MAP_CONFIG.put(USER_ROLE, userPattern);
        List<String> adminPattern = allPattern.get().filter((mapping) -> mapping.contains("admin")).collect(Collectors.toList());
        MAP_CONFIG.put(ADMIN_ROLE, adminPattern);
    }


    public static Set<String> getAllAppRoles() {
        return MAP_CONFIG.keySet();
    }

    public static List<String> getUrlPatternForRole(String role) {
        return MAP_CONFIG.get(role);
    }

}


