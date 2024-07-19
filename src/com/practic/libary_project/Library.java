package com.practic.libary_project;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private final List<Book> booksList = new ArrayList<>();

    public void addBook(Book book){
        booksList.add(book);
        System.out.println("Книга " + book.getBookTitle() + " была добавлена");
    }

    public void removeBook(String isbn){
        for(Book book : booksList){
            if (book.getIsbn().equals(isbn)){
                booksList.remove(book);
                System.out.println("Книга " + book.getBookTitle() + " была удалена");
            }else {
                System.out.println("Такой книги нет в библиотеке");
            }
        }
    }


}
