package com.farenda.java.util;

public class User {
    private static long userCounter;
    private final String name;
    private long id;

    public User(String name) {
        this.id = userCounter++;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User(id:" + id + ", name: " + name + ")";
    }
}