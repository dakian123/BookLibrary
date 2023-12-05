package com.teamone.bookmanagementsystem.models;/*
 * Copyright(C)2022
 * Mock_project
 * Record of change:
 * DATE       Version     AUTHOR     Description
 * 8/8/2022    1.0         ADMIN    First Implement
 */

public class User {
    private int id;

    private String username;
    private String password;
    private Role role;
    private Bookcase bookCase;

    public User() {
    }

    public User(String username, String password, Role role){
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User(int id, String username, String password){
        this.id = id;
        this.username = username;
        this.password = password;

    }
    public User(int id, String username, String password, Role role){
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }
    public User(int id, String username, String password, Role role, Bookcase bookCase) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.bookCase = bookCase;
    }

    public User(String username, String password, Role role, Bookcase bookCase) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.bookCase = bookCase;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Bookcase getBookCase() {
        return bookCase;
    }

    public void setBookCase(Bookcase bookCase) {
        this.bookCase = bookCase;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", bookCase=" + bookCase +
                '}';
    }
}
