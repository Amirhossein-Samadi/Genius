package org.example;

public class FollowedArtists {

    private String artistName;
    private String userName;

    public FollowedArtists(String userName, String artistName)
    {
        this.userName = userName;
        this.artistName = artistName;
    }

    public String getArtistName() {return artistName;}

    public String getUserName() {return userName;}
}
