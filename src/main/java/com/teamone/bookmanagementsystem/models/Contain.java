package com.teamone.bookmanagementsystem.models;/*
 * Copyright(C)2022
 * Mock_project
 * Record of change:
 * DATE       Version     AUTHOR     Description
 * 8/8/2022    1.0         ADMIN    First Implement
 */

import java.sql.Date;

public class Contain {
    private Bookcase bookcase;
    private Book book;
    private Date createDate;

    public Contain(){
    }

    public Contain(Bookcase bookcase, Book book, Date createDate) {
        this.bookcase = bookcase;
        this.book = book;
        this.createDate = createDate;
    }

    public Bookcase getBookcase() {
        return bookcase;
    }

    public void setBookcase(Bookcase bookcase) {
        this.bookcase = bookcase;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Contain{" +
                "bookcase=" + bookcase +
                ", book=" + book +
                ", createDate=" + createDate +
                '}';
    }
}
