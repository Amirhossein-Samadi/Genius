package org.example;

import static org.example.LoadingSongs.songsList;

public class SearchSong {

    public static Song searchSong(String searchText)
    {
        for (Song song : songsList)
        {
            if (song.getTitle().equals(searchText)) { return song; }
        }
        return null;
    }
}
