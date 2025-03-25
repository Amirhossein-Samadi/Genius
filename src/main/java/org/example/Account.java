package org.example;

public abstract class Account {

    protected String name;
    protected int age;
    protected String email;
    protected String username;
    protected String password;
    protected int role;

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
