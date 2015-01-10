package com.bilaleluneis.musicplayer.model;

import java.io.Serializable;

/**
 * @uthor Bilal El Uneis (bilaleluneis@gmail.com)
 * @since Jan 10 2015
 * Song Class to Store information about each song on Android device
 * Credit goes to Sue Smith for the awesome tutorial on creating Music Player for Android
 * (http://code.tutsplus.com/tutorials/create-a-music-player-on-android-project-setup--mobile-22764)
 */

public class Song implements Serializable{

    private long id;
    private String title;
    private String artist;

    public Song(long id, String title, String artist) {
        this.id = id;
        this.title = title;
        this.artist = artist;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
