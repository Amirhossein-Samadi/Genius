package org.example;

import java.util.ArrayList;

public class Album {

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

    public String albumGetTitle() {return title;}

    public String albumGetArtist() {return artist;}

    public String albumGetReleaseDate() {return releaseDate;}

    public ArrayList<String> albumGetTrackList() {return trackList;}

    public void addSong(Song song) {trackList.add(song.songGetTitle());}

}
