package com.farenda.solved;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Java8ReadAllLines {

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("Run with a file as a parameter");
        } else {
            System.out.println("Reading from: " + args[0] + " using Java 8");
            // By default readAllLines() uses UTF-8 to load text
            for (String line : Files.readAllLines(Paths.get(args[0]))) {
                System.out.println(line);
            }
        }
    }
}