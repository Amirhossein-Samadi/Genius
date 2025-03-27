package org.example;

import java.util.ArrayList;

public class User extends Account{

    private ArrayList<Artist> followedArtist;

    public User(String name, int age, String email, String username, String password, int role) {
        super(name, age, email, username, password, role);
    }

    public ArrayList<Artist> getFollowedArtist() {return followedArtist;}
}
