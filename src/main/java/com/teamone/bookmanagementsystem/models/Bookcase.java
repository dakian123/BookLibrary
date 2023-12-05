package com.teamone.bookmanagementsystem.models;/*
 * Copyright(C)2022
 * Mock_project
 * Record of change:
 * DATE       Version     AUTHOR     Description
 * 8/8/2022    1.0         ADMIN    First Implement
 */

public class Bookcase {
    private int bookcaseId;
    private String bookcaseName;
    private Integer totalBook;
    private User user;

    public Bookcase() {
    }

    public Bookcase(int bookcaseId, String bookcaseName, Integer totalBook, User user) {
        this.bookcaseId = bookcaseId;
        this.bookcaseName = bookcaseName;
        this.totalBook = totalBook;
        this.user = user;
    }

    public int getBookcaseId() {
        return bookcaseId;
    }

    public void setBookcaseId(int bookcaseId) {
        this.bookcaseId = bookcaseId;
    }

    public String getBookcaseName() {
        return bookcaseName;
    }

    public void setBookcaseName(String bookcaseName) {
        this.bookcaseName = bookcaseName;
    }

    public Integer getTotalBook() {
        return totalBook;
    }

    public void setTotalBook(Integer totalBook) {
        this.totalBook = totalBook;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Bookcase{" +
                "bookcaseId=" + bookcaseId +
                ", bookcaseName='" + bookcaseName + '\'' +
                ", totalBook=" + totalBook +
                ", user=" + user +
                '}';
    }
}
