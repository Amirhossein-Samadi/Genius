package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Comment {

    private String message;
    private String author;
    private String date;
    private String songTitle;

    public Comment(String message, String author, String date, String songTitle) {
        this.message = message;
        this.author = author;
        this.date = date;
        this.songTitle = songTitle;
    }

    public String getMessage() {return message;}
    public String getAuthor() {return author;}
    public String getDate() {return date;}
    public String getSongTitle() {return songTitle;}

}
