package org.example;

import java.util.ArrayList;
import java.util.List;

public class Artist extends Account{

//    private String name;
//    private String username;
    private List<Song> songsList = new ArrayList<>();
    private List<Album> albumsList = new ArrayList<>();

    public Artist(String name, int age, String email, String username, String password, int role) {
        super(name, age, email, username, password, role);

//        this.name = name;
//        this.username = username;
    }

    public List<Song> getSongsList() {return songsList;};
    public List<Album> getAlbumsList() {return albumsList;};

    public void addSong(Song song) {songsList.add(song);}

}
