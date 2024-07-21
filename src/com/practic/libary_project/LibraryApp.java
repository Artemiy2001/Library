package com.practic.libary_project;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LibraryApp {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Library library = new Library(new ArrayList<>());
        library.loadFromFile();

        Scanner scanner = new Scanner(System.in);
        boolean exitProgram = true;





        while (exitProgram){
            displayMenu();
            while (!scanner.hasNextInt() || scanner.nextInt() > 9){
                System.out.println("Некорректное действие!\n");
                scanner = new Scanner(System.in);
                displayMenu();
            }
            int action = scanner.nextInt();
            exitProgram = handleInputUser(action, library);
            System.out.println();
        }




    }

    public static void displayMenu(){
        System.out.println("""
                1 - Добавить книгу
                2 - Удалить книгу
                3 - Поиск книги по названию
                4 - Поиск книги по автору
                5 - Поиск книги по году
                6 - Взять книгу в прокат
                7 - Вернуть книгу
                8 - Выйти
                """);
        System.out.print("Выберите действие: ");


    }

    public static boolean handleInputUser(int actionUser, Library library) throws IOException {
        switch (actionUser) {
            case 1 -> {
                Book book = Utils.createBook();
                library.addBook(book);
            }
            case 2 -> {
                Scanner code = new Scanner(System.in);
                System.out.print("Введите код удаляемой книги: ");
                library.removeBook(code.nextLine());
            }
            case 3 -> {
                Scanner title = new Scanner(System.in);
                System.out.print("Введите название книги: ");
                library.findBookByTitle(title.nextLine());
            }
            case 4 -> {
                Scanner author = new Scanner(System.in);
                System.out.print("Введите автора книги: ");
                library.findBookByAuthor(author.nextLine());
            }
            case 5 -> {
                Scanner year = new Scanner(System.in);
                System.out.print("Введите год книги: ");
                if (year.hasNextInt()){
                    library.findBookByYear(year.nextInt());
                }else {
                    System.out.println("Некорректный ввод!");
                    return true;
                }

            }
            case 6 -> {
                Scanner isbn = new Scanner(System.in);
                System.out.print("Введите код книги для проката: ");
                library.rentBook(isbn.nextLine());
            }
            case 7 -> {
                Scanner isbn = new Scanner(System.in);
                System.out.print("Введите код книги для возврата: ");
                library.returnBook(isbn.nextLine());
            }
            case 8 -> {
                library.saveToFile();
                return  false;
            }
            case 9 -> {
                System.out.println(library);
            }
        }
        return true;

    }


}
