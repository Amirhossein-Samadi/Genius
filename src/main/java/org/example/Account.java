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

    public String getUsername() {return username;}

    public String getPassword() {return password;}

    public int getAge() {return age;}

    public String getName() {return name;}

    public int getRole() {return role;}

    public String getEmail() {return email;}

    
}
