package com.farenda.solved;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JavaSolved {

    public static void main(String[] args) throws IOException {
        String filename = createTempFile();
        printContent(filename);
    }

    // Creates a temporary file that will be deleted on JVM exit.
    private static String createTempFile() throws IOException {
        // Since Java 1.7 Files and Path API simplify operations on files
        Path path = Files.createTempFile("sample-file", ".txt");
        File file = path.toFile();
        // writing sample data
        Files.write(path, "Temporary content...".getBytes(StandardCharsets.UTF_8));
        // This tells JVM to delete the file on JVM exit.
        // Useful for temporary files in tests.
        file.deleteOnExit();
        return file.getAbsolutePath();
    }

    private static void printContent(String filename) throws IOException {
        System.out.println("Reading from: " + filename);
        // In Java 8 you can use forEach() method instead of iterating collection.
        // Moreover static methods can be passed as an arguments.
        Files.readAllLines(Paths.get(filename)).forEach(System.out::println);
    }
}