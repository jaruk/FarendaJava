package com.farenda.java.nio;

import sun.management.FileSystem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Wlasna klasa badajaca mozliwosci klas Paths i Files
 */
public class PathsAndFiles {


    public static void main(String[] args) throws IOException {
        Path path = Paths.get(".");
        breakLine("path");
        print(path);
        breakLine("absolutePathe");
        print(path.toAbsolutePath());
        breakLine("Files.list");
        Stream<Path> stream = Files.list(path);
        stream.forEach(PathsAndFiles::print);
        breakLine("Files.find");
        Stream<Path> files = Files.find(path, Integer.MAX_VALUE, (p, a) -> p.toString().endsWith(".java"));
        files.forEach(PathsAndFiles::print);
        breakLine("Files.walk");
        Stream<Path> all = Files.walk(path);
        all.forEach(PathsAndFiles::print);
        breakLine("Files.readalllines");
        breakLine("Files.readallbytes");
    }

    public static void breakLine(String warning) {
        System.out.println("");
        System.out.println(warning+"-------------------------------------------------------------------------------------------");

    }

    public static void print(Object o) {

        System.out.println(o);
    }
}
