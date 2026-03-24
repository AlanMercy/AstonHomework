package ru.aston.hometasks.dz2;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Path filePath = Paths.get("students_books.txt");
        List<Student> students = FileReaderService.loadStudentsFromFile(filePath);
        BookStreamProcessor.processAndPrint(students);
    }
}