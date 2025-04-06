package org.example;

public class SignUpRequest {

    private String artistName;
    private int status;
    private String date;

    public SignUpRequest(String artistName, int status, String date)
    {
        this.artistName = artistName;
        this.status = status;
        this.date = date;
    }

    public String getArtistName() {return artistName;}
    public int getStatus() {return status;}
    public String getDate() {return date;}

}
