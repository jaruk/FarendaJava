package com.farenda.solved;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Java8WriteFile {
    public static void main(String[] args) throws IOException {
        String file = "languages.txt";
        System.out.println("Writing to file: " + file);
        // Files.newBufferedWriter() uses UTF-8 encoding by default
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(file))) {
            writer.write("Java\n");
            writer.write("Python\n");
            writer.write("Clojure\n");
            writer.write("Scala\n");
            writer.write("JavaScript\n");
        } // the file will be automatically closed
    }
}