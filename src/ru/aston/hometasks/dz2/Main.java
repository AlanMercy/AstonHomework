package ru.aston.hometasks.dz2;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Path filePath = Paths.get("students_books.txt");

        FileReaderService fileReaderService = new FileReaderService();
        BookStreamProcessor bookStreamProcessor = new BookStreamProcessor();

        List<Student> students = fileReaderService.loadStudentsFromFile(filePath);
        bookStreamProcessor.processAndPrint(students);
    }
}