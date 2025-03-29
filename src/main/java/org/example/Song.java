package org.example;

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

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
    private String artists;

    private List<Comment> comments;

    public Song(String title, String album, String artists, String lyrics, String genre, String releaseDate) {
        this.title = title;
        this.album = album;
        this.artists = artists;
        this.lyrics = lyrics;
        this.genre = genre;
        this.releaseDate = releaseDate;
    }

    public String getTitle() {return title;}

    public String getAlbum() {return album;}

    public String getLyrics() {return lyrics;}

    public String getGenre() {return genre;}

    public String getReleaseDate() {return releaseDate;}

    public String getViewsNumber() {return viewsNumber + "";};

    public String getArtists() {return artists;}

    // public List<String> songGetComments() {return comments;}

    public void countViews() {viewsNumber++;};

    public void setComments(Comment comment) {comments.add(comment);}

}
