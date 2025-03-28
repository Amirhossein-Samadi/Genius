package org.example;

import java.util.ArrayList;
import java.util.List;

public class Album {

    private String title;
    private String artist;
    private String releaseDate;

    private List<Song> trackList = new ArrayList<>();

    public Album(String title, String artist, String releaseDate) {
        this.title = title;
        this.artist = artist;
        this.releaseDate = releaseDate;
    }

    public String albumGetTitle() {return title;}

    public String albumGetArtist() {return artist;}

    public String albumGetReleaseDate() {return releaseDate;}

    public List<Song> albumGetTrackList() {return trackList;}

    public void addSong(Song song) {trackList.add(song);}

}
