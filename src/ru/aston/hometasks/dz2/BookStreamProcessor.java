package ru.aston.hometasks.dz2;

import java.util.List;

public class BookStreamProcessor {

    private static final int FILTER_YEAR_THRESHOLD = 2000;
    private static final int LIMIT_BOOKS_COUNT = 3;

    public void processAndPrint(List<Student> students) {
        students.stream().peek(System.out::println)
                .map(Student::getBooks)
                .flatMap(List::stream)
                .sorted()
                .distinct()
                .filter(book -> book.getYear() > FILTER_YEAR_THRESHOLD)
                .limit(LIMIT_BOOKS_COUNT)
                .map(Book::getYear)
                .findFirst()
                .ifPresentOrElse(
                        year -> System.out.println("\nНайденная книга выпущена в: " + year),
                        () -> System.out.println("\nКнига, выпущенная после 2000 года, не найдена")
                );
    }
}