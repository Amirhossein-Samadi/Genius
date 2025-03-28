package org.example;

import java.util.ArrayList;
import java.util.List;

public class User extends Account{

    private List<Artist> followedArtist = new ArrayList<>();
    private List<Song> followedSong = new ArrayList<>();

    public User(String name, int age, String email, String username, String password, int role) {
        super(name, age, email, username, password, role);
    }

    public List<Artist> getFollowedArtist() {return followedArtist;}

    public List<Song> getFollowedSong() {return followedSong;}

    public void setFollowedArtist(Artist artist) {followedArtist.add(artist);}

    public void setFollowedSong()
    {

        for (Artist artist : followedArtist)
        {
            for (Song song : artist.getSongsList())
            {
                followedSong.add(song);
            }
        }
    }
}
