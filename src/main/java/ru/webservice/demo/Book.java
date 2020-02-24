package ru.webservice.demo;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class Book {

    private int isbn;
    private String title;
    private String author;
    private int pageNumber;

    public Book(String title, String author, int pageNumber) {
        super();
        this.title = title;
        this.author = author;
        this.pageNumber = pageNumber;
    }

    public String toString() {
        return "[" + new Date() + "] - ISBN: " + isbn + " - Title: " + title + " - Author: " + author
                + " - Page number: " + pageNumber;
    }

}