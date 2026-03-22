package ru.aston.hometasks.dz2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentBookProcessor {

    public static void main(String[] args) {
        Path filePath = Paths.get("students_books.txt");
        List<Student> students = loadStudentsFromFile(filePath);
        students.stream()
                .peek(System.out::println)
                .map(Student::getBooks)
                .flatMap(List::stream)
                .sorted()
                .distinct()
                .filter(book -> book.getYear() > 2000)
                .limit(3)
                .map(Book::getYear)
                .findFirst()
                .ifPresentOrElse(
                        year -> System.out.println("\nНайденная " +
                                "книга выпущена в: " + year),
                        () -> System.out.println("\nКнига, выпущенная " +
                                "после 2000 года, не найдена")
                );
    }

    private static List<Student> loadStudentsFromFile(Path filePath) {
        List<Student> students = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(filePath);
            String currentStudentName = null;
            List<Book> currentBooks = new ArrayList<>();
            for (String line : lines) {
                if (line.startsWith("Student:")) {
                    if (currentStudentName != null && !currentBooks.isEmpty()) {
                        students.add(new Student(currentStudentName, new ArrayList<>(currentBooks)));
                        currentBooks.clear();
                    }
                    currentStudentName = line.substring("Student:".length()).trim();
                } else if (line.startsWith("Book:")) {
                    String bookData = line.substring("Book:".length()).trim();
                    String[] parts = bookData.split("\\|");
                    if (parts.length == 4) {
                        String title = parts[0].trim();
                        String author = parts[1].trim();
                        int pages = Integer.parseInt(parts[2].trim());
                        int year = Integer.parseInt(parts[3].trim());
                        currentBooks.add(new Book(title, author, pages, year));
                    }
                }
            }

            if (currentStudentName != null && !currentBooks.isEmpty()) {
                students.add(new Student(currentStudentName, new ArrayList<>(currentBooks)));
            }

        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
            e.printStackTrace();
        }

        return students;
    }
}