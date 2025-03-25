package org.example;

import java.util.ArrayList;

public class Song {
// title, album, artists, lyric, genre,
//tags, views count, comments, release date.

    private String title;
    private String album;
    private String artists;
    private String lyrics;
    private String genre;
    private String tags;
    private int viewsNumber;
    private ArrayList<String> comments;
    private String releaseDate;

    public Song(String title, String album, String artists, String lyrics, String genre, String releaseDate) {
        this.title = title;
        this.album = album;
        this.artists = artists;
        this.lyrics = lyrics;
        this.genre = genre;
        this.releaseDate = releaseDate;
    }

}
