package org.example;

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

    public String songGetTitle() {return title;}

    public String songGetLyrics() {return lyrics;}

    public String songGetGenre() {return genre;}

    public String songGetReleaseDate() {return releaseDate;}

    public String songGetViewsNumber() {return viewsNumber + "";};

    public ArrayList<String> songGetArtists() {return artists;}

    public ArrayList<String> songGetComments() {return comments;}

    public void countViews() {viewsNumber++;};

}
