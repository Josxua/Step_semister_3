package main.java.oop_concept2.class_problems;

import java.time.LocalDate;

class LibraryItem {
    String title;

    LibraryItem(String title) {
        this.title = title;
    }

    LocalDate getDueDate() {
        return LocalDate.of(2023, 10, 26);
    }
}

class Book extends LibraryItem {
    Book(String title) {
        super(title);
    }

    @Override
    LocalDate getDueDate() {
        return LocalDate.of(2023, 10, 26).plusDays(14);
    }
}

class DVD extends LibraryItem {
    DVD(String title) {
        super(title);
    }

    @Override
    LocalDate getDueDate() {
        return LocalDate.of(2023, 10, 26).plusDays(7);
    }
}

class Magazine extends LibraryItem {
    Magazine(String title) {
        super(title);
    }

    @Override
    LocalDate getDueDate() {
        return LocalDate.of(2023, 10, 26).plusDays(3);
    }
}

public class LibraryDueDate {
    public static void main(String[] args) {

        LibraryItem[] items = {
                new Book("1984"),
                new DVD("The Matrix"),
                new Magazine("Forbes Issue 500")
        };

        for (LibraryItem item : items) {
            System.out.println(item.title + ": " + item.getDueDate());
        }
    }
}