package com.farenda.java.streams.listtomap;

import com.farenda.java.util.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toMap;

/**
 * Created by jarek on 2017-03-15.
 */
public class ListToMap {


    public static void main(String[] args) {
        printBreakWithTitle("list to map 1");
        listToMap1();
        printBreakWithTitle("list to map 2");
        listToMap2();

    }

    private static void listToMap2() {
        List<User> users = asList(new User("Foo"), new User("Bar"));
        Map<String, User> usersByName = users.stream()
                .collect(toMap(User::getName, Function.identity()));
        System.out.println("Mapping: " + usersByName);
    }

    private static void listToMap1() {
        List<User> users = asList(new User("Foo"), new User("Bar"));
        Map<String, User> usersByName = new HashMap<>();
        for (User user : users) {
            usersByName.put(user.getName(), user);
        }
        System.out.println("Mapping: " + usersByName);
    }


    public static void printBreakWithTitle(String title) {
        System.out.println("\n\n-------------------------------------------------------------------------------");
        System.out.println("------------------------" + title);

    }
}
