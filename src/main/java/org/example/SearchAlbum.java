package org.example;

import java.sql.SQLException;

import static org.example.LoadingAlbums.albumsList;

public class SearchAlbum {

    public static Album searchAlbum(String searchText)
    {
        for (Album album : albumsList)
        {
            return album;
        }
        return null;
    }
}
