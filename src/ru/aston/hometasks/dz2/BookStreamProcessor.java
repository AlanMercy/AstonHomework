package ru.aston.hometasks.dz2;

import java.util.List;

public class BookStreamProcessor {

    public static void processAndPrint(List<Student> students) {
        students.stream().peek(System.out::println)
                .map(Student::getBooks)
                .flatMap(List::stream)
                .sorted()
                .distinct()
                .filter(book -> book.getYear() > 2000)
                .limit(3)
                .map(Book::getYear)
                .findFirst()
                .ifPresentOrElse(
                        year -> System.out.println("\nНайденная книга выпущена в: " + year),
                        () -> System.out.println("\nКнига, выпущенная после 2000 года, не найдена")
                );
    }
}