package org.example;

import java.util.ArrayList;

public class Artist extends Account{

    private ArrayList<Song> songsList = new ArrayList<>();
    private ArrayList<Album> albumsList = new ArrayList<>();

    public Artist(String name, int age, String email, String username, String password, int role) {
        super(name, age, email, username, password, role);
    }

    public ArrayList<Song> getSongsList() {return songsList;};
    public ArrayList<Album> getAlbumsList() {return albumsList;};

}
