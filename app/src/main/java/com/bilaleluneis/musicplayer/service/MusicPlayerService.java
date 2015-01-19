package com.bilaleluneis.musicplayer.service;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.os.PowerManager;

import com.bilaleluneis.musicplayer.model.Song;

import java.util.List;

/**
 * @author Bilal El Uneis (bilaleluneis@gmail.com)
 * @since Jan 14 2015
 * Simple Music Player Service to play a song, even when app is set as background process
 * Credit goes to Sue Smith for the awesome tutorial on creating Music Player for Android
 * (http://code.tutsplus.com/tutorials/create-a-music-player-on-android-song-playback--mobile-22778)
 */

public class MusicPlayerService extends Service implements MediaPlayer.OnPreparedListener,
        MediaPlayer.OnErrorListener,
        MediaPlayer.OnCompletionListener {

    private static MediaPlayer musicPlayer;
    private List<Song>  musicList;
    private int songId;


    @Override
    public void onCreate() {
        super.onCreate();
        initMusicPlayer();
    }

    @Override
    public void onCompletion(MediaPlayer mp) {

    }

    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
        return false;
    }

    @Override
    public void onPrepared(MediaPlayer mp) {

    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    /**
     * this follows a singleton pattern, to make sure that only
     * one instance of the MediaPlayer object is made available and
     * reused
     * @return existing instance of the music player or creates
     * a new one and return it
     */
    protected MediaPlayer getMusicPlayer() {
        if(musicPlayer == null) {
            musicPlayer= new MediaPlayer();
        }
        return musicPlayer;
    }


    public List<Song> getMusicList() {
        return musicList;
    }

    public void setMusicList(List<Song> musicList) {
        this.musicList = musicList;
    }

    public int getSongId() {
        return songId;
    }

    /**
     * @param songId the id for the song the music player will play
     */
    public void setSongId(int songId) {
        this.songId = songId;
    }

    /**
     * this method will create instance of music player by calling getMusicPlayer()
     * and set the properties and configure the player.
     */
    public void initMusicPlayer(){
        setSongId(0);
        getMusicPlayer().setWakeMode(getApplicationContext(), PowerManager.PARTIAL_WAKE_LOCK);
        getMusicPlayer().setAudioStreamType(AudioManager.STREAM_MUSIC);
        getMusicPlayer().setOnPreparedListener(this);
        getMusicPlayer().setOnCompletionListener(this);
        getMusicPlayer().setOnErrorListener(this);
    }
}
