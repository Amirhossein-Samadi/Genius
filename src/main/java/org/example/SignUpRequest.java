package org.example;

public class SignUpRequest {

    private String artistName;
    private String status;
    private String date;

    public SignUpRequest(String artistName, int status, String date)
    {
        this.artistName = artistName;
        this.date = date;

        if (status == 1)
        {
            this.status = "Accepted";
        }
        else if (status == 2)
        {
            this.status = "Rejected";
        }
        else {this.status = "Unread";}
    }

    public String getArtistName() {return artistName;}
    public String getStatus() {return status;}
    public String getDate() {return date;}

}
