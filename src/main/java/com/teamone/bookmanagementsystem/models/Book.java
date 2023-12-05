package com.teamone.bookmanagementsystem.models;/*
 * Copyright(C)2022
 * Mock_project
 * Record of change:
 * DATE       Version     AUTHOR     Description
 * 8/8/2022    1.0         ADMIN    First Implement
 */

import java.sql.Date;

public class Book {
    private String bookId;
    private String bookTitle;
    private String author;
    private String brief;
    private String publisher;
    private String content;
    private String image;
    private Date createDate;
    private Category category;

    public Book() {
    }

    public Book(String bookId, String bookTitle, String author, String brief, String publisher, String content, String image, Date createDate, Category category) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.author = author;
        this.brief = brief;
        this.publisher = publisher;
        this.content = content;
        this.image = image;
        this.createDate = createDate;
        this.category = category;
    }

    public Book(String bookTitle, String author, String brief, String publisher, String content, String image, Date createDate, Category category) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.brief = brief;
        this.publisher = publisher;
        this.content = content;
        this.image = image;
        this.createDate = createDate;
        this.category = category;
    }

    public String getbookId() {
        return bookId;
    }

    public void setbookId(String bookId) {
        this.bookId = bookId;
    }

    public String getbookTitle() {
        return bookTitle;
    }

    public void setbookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getauthor() {
        return author;
    }

    public void setauthor(String author) {
        this.author = author;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getcreateDate() {
        return createDate;
    }

    public void setcreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId='" + bookId + '\'' +
                ", bookTitle='" + bookTitle + '\'' +
                ", author='" + author + '\'' +
                ", brief='" + brief + '\'' +
                ", publisher='" + publisher + '\'' +
                ", content='" + content + '\'' +
                ", image='" + image + '\'' +
                ", createDate=" + createDate +
                ", category=" + category +
                '}';
    }
}
