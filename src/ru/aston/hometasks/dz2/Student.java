package ru.aston.hometasks.dz2;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Student {
    private final String name;
    private final List<Book> books;

    public Student(String name, List<Book> books) {
        this.name = name;
        this.books = books == null || books.isEmpty()
                ? Collections.emptyList()
                : List.copyOf(books);
    }

    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        return "Student{" + "name='" + name + '\'' + ", books=" + books + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(books, student.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, books);
    }
}
