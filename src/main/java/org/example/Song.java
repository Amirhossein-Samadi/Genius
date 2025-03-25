package org.example;

import java.util.ArrayList;

public class Song {
// title, album, artists, lyric, genre,
//tags, views count, comments, release date.

    private String title;
    private String album;
    private String lyrics;
    private String genre;
    private String tags;
    private String releaseDate;
    private int viewsNumber;

    private ArrayList<String> artists;
    private ArrayList<String> comments;

    public Song(String title, String album, ArrayList<String> artists, String lyrics, String genre, String releaseDate) {
        this.title = title;
        this.album = album;
        this.artists = artists;
        this.lyrics = lyrics;
        this.genre = genre;
        this.releaseDate = releaseDate;
    }

    public String getTitle() {return title;}

    public String getLyrics() {return lyrics;}

    public String getGenre() {return genre;}

    public String getReleaseDate() {return releaseDate;}

    public String getViewsNumber() {return viewsNumber + "";};

    public ArrayList<String> getArtists() {return artists;}

    public ArrayList<String> getComments() {return comments;}

    public void countViews() {viewsNumber++;};

}
