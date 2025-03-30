package org.example;

import static org.example.LoadingArtists.artistsList;

public class Search {

    public static Artist searchArtist(String searchText)
    {
        for (Artist artist : artistsList)
        {
            if (artist.getUserName().equals(searchText) || artist.getName().equals(searchText))
            {
                return artist;
            }
        }
        return null;
    }
}
