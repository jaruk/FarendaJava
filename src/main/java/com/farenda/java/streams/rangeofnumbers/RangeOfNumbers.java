package com.farenda.java.streams.rangeofnumbers;

import com.farenda.java.util.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toMap;

/**
 * Created by jarek on 2017-03-17.
 */
public class RangeOfNumbers {


    public static void main(String[] args) {
        printBreakWithTitle("range 1");
        streamRange(1,100);
        printBreakWithTitle("range 2");
        inclusiveRange(1,100);
        printBreakWithTitle("range 3");
        iterateStream(1,1, 100);
    }

    static List<Integer> streamRange(int from, int limit) {
        return IntStream.range(from, from+limit)
                .boxed()
                .collect(Collectors.toList());
    }

    static List<Integer> inclusiveRange(int from, int limit) {
        return IntStream.rangeClosed(from, from+limit)
                .boxed()
                .collect(Collectors.toList());
    }

    static List<Integer> iterateStream(int from, int step, int limit) {
        return IntStream.iterate(from, i -> i+step) // next int
                .limit(limit/step) // only numbers in range
                .boxed()
                .collect(Collectors.toList());
    }

    public static void printBreakWithTitle(String title) {
        System.out.println("\n\n-------------------------------------------------------------------------------");
        System.out.println("------------------------" + title);

    }
}
