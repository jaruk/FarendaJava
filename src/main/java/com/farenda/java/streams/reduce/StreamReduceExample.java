package com.farenda.java.streams.reduce;


import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;

public class StreamReduceExample {

    public static void main(String[] args) {
        printBreakWithTitle("reduce1");
        reduce1();
        printBreakWithTitle("reduce2");
        reduce2();
        printBreakWithTitle("reduce3");
        reduce3();
        printBreakWithTitle("reduce4");
        reduce4();
        printBreakWithTitle("reduce5");
        reduce5();
    }

    private static void reduce5() {
        BinaryOperator<Integer> COMBINER = (a, b) -> {
            System.out.printf("combining(%s, %s)%n", a, b);
            return Integer.sum(a, b);
        };
        List<Integer> numbers = asList(1, 2, 3, 4, 5);
        int sum = numbers.parallelStream()
                // init, accumulator, combiner
                .reduce(0, Integer::sum, COMBINER);
        System.out.println("Sum: " + sum);
    }

    private static void reduce4() {
        BinaryOperator<Integer> COMBINER = (a, b) -> {
            System.out.printf("combining(%s, %s)%n", a, b);
            return Integer.sum(a, b);
        };
        List<Integer> numbers = asList(1, 2, 3, 4, 5);
        int sum = numbers.stream()
                // init, accumulator, combiner
                .reduce(0, Integer::sum, COMBINER);
        System.out.println("Sum: " + sum);
    }

    private static void reduce3() {
        // empty list == empty stream!
        List<Integer> numbers = emptyList();
        Optional<Integer> result = numbers.stream()
                .reduce(Integer::sum);
        int sum = result.orElse(0);
        System.out.println("Sum: " + sum);
    }

    private static void reduce2() {
        List<Integer> numbers = asList(1, 2, 3, 4, 5);
        Optional<Integer> result = numbers.stream()
                .reduce(Integer::sum);
        int sum = result.orElse(0);
        System.out.println("Sum: " + sum);
    }

    private static void reduce1() {
        List<Integer> numbers = asList(1, 2, 3, 4, 5);
        int sum = numbers.stream().reduce(0, (a, b) -> {
            System.out.printf("summing(%s, %s)%n", a, b);
            return Integer.sum(a, b);
        });
        System.out.println("Sum: " + sum);
    }

    public static void printBreakWithTitle(String title) {
        System.out.println("\n\n-------------------------------------------------------------------------------");
        System.out.println("------------------------" + title);

    }
}
