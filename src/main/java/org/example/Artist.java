package org.example;

import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.example.DbConnection.connectGenuisDb;
import static org.example.LoadingArtists.artistsList;

public class Artist extends Account{

    private List<Song> songsList = new ArrayList<>();
    private List<Album> albumsList = new ArrayList<>();
    private List<Request> requests = new ArrayList<>();

    private int status;

    public Artist(String name, int age, String email, String userName, String password, int role) {
        super(name, age, email, userName, password, role);
    }

    public int getStatus() {return status;}

    public void setStatus(int status) {this.status = status;}

    public List<Request> getRequests() {return requests;}

    public void setRequests(Request request) {this.requests.add(request);}

    public List<Song> getSongsList() {return songsList;};

    public List<Album> getAlbumsList() {return albumsList;};

    public void addSong(Song song) {songsList.add(song);}

    public void setAlbum(Album album) {albumsList.add(album);}

    public static Artist searchArtists(String username, String password)
    {
        String sql = "SELECT * FROM ArtistsData WHERE username = ?";

        try (Connection conn = connectGenuisDb();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String storedHashedPassword = rs.getString("password");

                if (BCrypt.checkpw(password, storedHashedPassword)) {
                    for (Artist artist : artistsList)
                    {
                        if (artist.getUserName().equals(username))
                        {
                            return artist;
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

}
