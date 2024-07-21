package com.practic.libary_project;

import java.io.Serial;
import java.io.Serializable;

public class Book implements Serializable {

    @Serial
    private static final long serialVersionUID = 2L;

    private final String bookTitle;

    private final String author;

    private final int year;

    private final String isbn;

    private boolean isRented;


    public Book(String bookTitle, String author, int year, String isbn) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.year = year;
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        String rent;
        if (isRented){
            rent = "Книга в аренде";
        }else {
            rent = "Книга доступна";
        }
        return "\n" + bookTitle + "\n" + author +
                "\n" + year + " г.\nisbn - " + isbn +
                "\n" + rent;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }
}

