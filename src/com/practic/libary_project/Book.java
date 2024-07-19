package com.practic.libary_project;

public class Book {

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
        return "Book{" +
                "bookTitle='" + bookTitle + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", isbn='" + isbn + '\'' +
                ", isRented=" + isRented +
                '}';
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

