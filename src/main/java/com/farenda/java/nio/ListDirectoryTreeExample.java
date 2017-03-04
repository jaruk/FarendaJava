package com.farenda.java.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static java.lang.System.out;

public class ListDirectoryTreeExample {

    public static void main(String[] args) throws IOException {
        String dirName = ".";
        int searchDepth = 2;

        Path path = Paths.get(dirName);
        out.printf("Content of %s with depth %d:%n",
                dirName, searchDepth);

        // Use try-clause to close the stream immediately:
        try (Stream<Path> paths = Files.walk(path, searchDepth)) {
            paths.forEachOrdered(out::println);
        }
    }
}