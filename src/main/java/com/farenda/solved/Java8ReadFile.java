package com.farenda.solved;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Java8ReadFile {

    // It's good to move such code to reusable methods
    private static String loadFile(String filename) throws IOException {
        // need to pass file encoding
        return new String(Files.readAllBytes(Paths.get(filename)),
                StandardCharsets.UTF_8);
    }

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("Run with a file as a parameter");
        } else {
            System.out.println("Reading from: " + args[0] + " using Java 8");
            System.out.println(loadFile(args[0]));
        }
    }
}