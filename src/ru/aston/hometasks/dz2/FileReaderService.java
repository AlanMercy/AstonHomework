package ru.aston.hometasks.dz2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileReaderService {

    private static final String STUDENT_PREFIX = "Student:";
    private static final String BOOK_PREFIX = "Book:";
    private static final String BOOK_FIELDS_DELIMITER = "\\|";
    private static final int EXPECTED_BOOK_FIELDS_COUNT = 4;
    private static final int TITLE_INDEX = 0;
    private static final int AUTHOR_INDEX = 1;
    private static final int PAGES_INDEX = 2;
    private static final int YEAR_INDEX = 3;

    public List<Student> loadStudentsFromFile(Path filePath) {
        List<Student> students = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(filePath);
            String currentStudentName = null;
            List<Book> currentBooks = new ArrayList<>();

            for (String line : lines) {
                if (line.startsWith(STUDENT_PREFIX)) {
                    if (currentStudentName != null && !currentBooks.isEmpty()) {
                        // Создаём студента с иммутабельным списком книг
                        students.add(new Student(currentStudentName, List.copyOf(currentBooks)));
                        currentBooks.clear();
                    }
                    currentStudentName = extractStudentName(line);
                } else if (line.startsWith(BOOK_PREFIX)) {
                    Book book = parseBook(line);
                    if (book != null) {
                        currentBooks.add(book);
                    }
                }
            }

            if (currentStudentName != null && !currentBooks.isEmpty()) {
                students.add(new Student(currentStudentName, List.copyOf(currentBooks)));
            }

        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
            e.printStackTrace();
        }

        return Collections.unmodifiableList(students);
    }

    private String extractStudentName(String line) {
        return line.substring(STUDENT_PREFIX.length()).trim();
    }

    private Book parseBook(String line) {
        String bookData = line.substring(BOOK_PREFIX.length()).trim();
        String[] parts = bookData.split(BOOK_FIELDS_DELIMITER);

        if (parts.length != EXPECTED_BOOK_FIELDS_COUNT) {
            return null;
        }

        try {
            String title = parts[TITLE_INDEX].trim();
            String author = parts[AUTHOR_INDEX].trim();
            int pages = Integer.parseInt(parts[PAGES_INDEX].trim());
            int year = Integer.parseInt(parts[YEAR_INDEX].trim());

            return new Book(title, author, pages, year);
        } catch (NumberFormatException e) {
            System.err.println("Ошибка парсинга чисел в строке: " + line);
            return null;
        }
    }
}