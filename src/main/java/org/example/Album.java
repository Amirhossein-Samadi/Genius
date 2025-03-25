package org.example;

import java.util.ArrayList;

public class Album {
    // title, release date, and tracklist.

    private String title;
    private String artist;
    private String releaseDate;

    private ArrayList<String> trackList;

    public Album(String title, String artist, String releaseDate, ArrayList<String> trackList) {
        this.title = title;
        this.artist = artist;
        this.releaseDate = releaseDate;
        this.trackList = trackList;
    }


}
