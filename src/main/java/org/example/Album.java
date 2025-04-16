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

    public String getTitle() {return title;}

    public String getArtist() {return artist;}

    public String getReleaseDate() {return releaseDate;}

    public List<Song> getTrackList() {return trackList;}

    public void addSong(Song song) {trackList.add(song);}

}
