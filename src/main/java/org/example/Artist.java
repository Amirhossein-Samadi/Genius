package org.example;

import java.util.ArrayList;
import java.util.List;

import static org.example.LoadingArtists.artistsList;

public class Artist extends Account{

    private List<Song> songsList = new ArrayList<>();
    private List<Album> albumsList = new ArrayList<>();

    public Artist(String name, int age, String email, String userName, String password, int role) {
        super(name, age, email, userName, password, role);
    }

    public List<Song> getSongsList() {return songsList;};
    public List<Album> getAlbumsList() {return albumsList;};

    public void addSong(Song song) {songsList.add(song);}

    public void setAlbum(Album album) {albumsList.add(album);}

    public static Artist searchArtists(String username, String password)
    {
        for (Artist artist : artistsList)
        {
            if (artist.getUserName().equals(username) && artist.getPassword().equals(password))
            {
                return artist;
            }
        }

        return null;
    }

}
