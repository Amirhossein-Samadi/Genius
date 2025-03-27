package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Comment {

    private String comment;
    private String author;
    private String date;
    private String songTitle;

    public Comment(String comment, String author, String date, String songTitle) {
        this.comment = comment;
        this.author = author;
        this.date = date;
        this.songTitle = songTitle;
    }

    public String getComment() {return comment;}
    public String getAuthor() {return author;}
    public String getDate() {return date;}
    public String getSongTitle() {return songTitle;}

}
