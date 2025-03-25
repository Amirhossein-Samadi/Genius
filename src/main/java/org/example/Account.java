package org.example;

public abstract class Account {

    private String name;
    private int age;
    private String email;
    private String username;
    private String password;
    private int role;

    // implementing Account constructor.
    public Account(String name, int age, String email, String username, String password, int role) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
