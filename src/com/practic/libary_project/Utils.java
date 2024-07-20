package com.practic.libary_project;

import java.util.Scanner;

public class Utils {


    public static Book createBook() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите названеи книги: ");
        String bookTitle = scanner.nextLine();

        System.out.print("Введите автора книги: ");
        String author = scanner.nextLine();

        System.out.print("Введите год книги: ");
        int year = scanner.nextInt();

        Scanner scanner2 = new Scanner(System.in);

        System.out.print("Введите код книги: ");
        String isbn = scanner2.nextLine();

        System.out.println();

        return new Book(bookTitle, author, year, isbn);
    }
}
