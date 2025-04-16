package org.example;

public abstract class Account {

    protected String name;
    protected int age;
    protected String email;
    protected String userName;
    protected String password;
    protected int role;

    // implementing Account constructor.
    public Account(String name, int age, String email, String userName, String password, int role) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    public String getUserName() {return userName;}

    public String getPassword() {return password;}

    public int getAge() {return age;}

    public String getName() {return name;}

    public int getRole() {return role;}

    public String getEmail() {return email;}


}
