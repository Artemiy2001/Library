package com.practic.libary_project;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Library implements Serializable {

    Path path = Path.of("resources", "library.out");

    private List<Book> booksList;

    public Library(List<Book> booksList) {
        this.booksList = booksList;
    }

    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "Library{" +
                "booksList=" + booksList +
                '}';
    }

    public void addBook(Book book) throws IOException {
        boolean uniqueFlag = true;
        for(Book books : booksList){
            if (book.getIsbn().equals(books.getIsbn())) {
                uniqueFlag = false;
                break;
            }
        }
        if (uniqueFlag){
            booksList.add(book);
            System.out.println("Книга " + book.getBookTitle() + " была добавлена");
            saveToFile();
        }else {
            System.out.println("Код книги совпадает с существующей книгой");
        }


    }

    public void removeBook(String isbn) throws IOException {
        for(int i = 0; i < booksList.size(); i++){
            if (booksList.get(i).getIsbn().equals(isbn)){
                System.out.println("Книга " + booksList.get(i).getBookTitle() + " была удалена");
                booksList.remove(booksList.get(i));
                saveToFile();
                return;
            }
        }
        System.out.println("Такой книги нет");


    }

    public void findBookByTitle(String title){
        for(Book book : booksList) {
            if (book.getBookTitle().equals(title)) {
                System.out.println("Книга найдена:");
                System.out.println(book);
                return;
            }
        }
        System.out.println("Такой книги нет в библиотеке");
    }

    public void findBookByAuthor(String author){
        int counterBooks = 1;
        for(Book book : booksList) {
            if (book.getAuthor().equals(author)) {
                System.out.println(counterBooks + " - " + book);
                counterBooks++;
            }
        }
        if (counterBooks == 1){
            System.out.println("Книг с таким автором не найдено");
        }
    }

    public void findBookByYear(int year){
        int counterBook = 1;
        for(Book book : booksList) {
            if (book.getYear() == year) {
                System.out.println(counterBook + ". " + book);
                counterBook++;
            }
        }
        if (counterBook == 1){
            System.out.println("Книг с таким годом не найдено");
        }
    }

    public void rentBook(String isbn) throws IOException {
        for(Book book : booksList) {
            if (book.getIsbn().equals(isbn)) {
                if (!book.isRented()){
                    book.setRented(true);
                    System.out.println("Книга " + book.getAuthor() + " была арендована");
                    saveToFile();
                }else {
                    System.out.println("Книга уже арендована");
                }
            } else {
                System.out.println("Такой книги нет в библиотеке");
            }
        }
    }

    public void returnBook(String isbn) throws IOException {
        for(Book book : booksList) {
            if (book.getIsbn().equals(isbn)) {
                book.setRented(false);
                System.out.println("Книга " + book.getAuthor() + " была возвращена");
                saveToFile();
            } else {
                System.out.println("Такой книги нет в библиотеке");
            }
        }
    }

    public void saveToFile() throws IOException {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path.toFile()))) {
            objectOutputStream.writeObject(booksList);
        }
    }

    public void loadFromFile() throws IOException, ClassNotFoundException {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path.toFile()))) {
            Object object = objectInputStream.readObject();
            if (object instanceof List<?>){
                booksList = (List<Book>) object;
            }

        }
    }




}
