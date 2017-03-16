package com.farenda.java.streams.countfrequency;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.function.UnaryOperator.identity;


/**
 * Created by jarek on 2017-03-16.
 */
public class CountFrequency {

    private static List<Integer> randomNumbers(int n, int bound) {
        Random rand = new Random();
        return IntStream
                .generate(() -> rand.nextInt(bound))
                .limit(n)
                .boxed()
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> grades = randomNumbers(1000, 10);

        Map<Integer, Integer> frequencies = grades.stream()
                .collect(Collectors.toMap(identity(), v -> 1, Integer::sum));
        System.out.println("Frequencies:\n" + frequencies);
    }
}
