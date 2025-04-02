package org.example;

public class Request {

    private String username;
    private String artistName;
    private String songTitle;
    private String recommendedLyrics;
    private String description;
    private String releaseDate;
    private String status;

    public Request(String username, String artistName, String songTitle, String recommendedLyrics, String description, String releaseDate, int status)
    {
        this.username = username;
        this.artistName = artistName;
        this.songTitle = songTitle;
        this.recommendedLyrics = recommendedLyrics;
        this.description = description;
        this.releaseDate = releaseDate;
        if (status == 1) {this.status = "Accepted";}
        else if (status == 2) {this.status = "Rejected";}
        else {this.status = "Unread";}
    }

    public String getUsername() {return username;}
    public String getArtistName() {return artistName;}
    public String getSongTitle() {return songTitle;}
    public String getRecommendedLyrics() {return recommendedLyrics;}
    public String getDescription() {return description;}
    public String getReleaseDate() {return releaseDate;}
}
