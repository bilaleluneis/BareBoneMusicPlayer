package com.bilaleluneis.musicplayer.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import com.bilaleluneis.musicplayer.model.Song;

import java.util.List;

/**
 * @uthor Bilal El Uneis (bilaleluneis@gmail.com)
 * @since Jan 14 2015
 * Simple Music Player Service to play a song, even when app is set as background process
 * Credit goes to Sue Smith for the awesome tutorial on creating Music Player for Android
 * (http://code.tutsplus.com/tutorials/create-a-music-player-on-android-song-playback--mobile-22778)
 */

public class MusicPlayerService extends Service implements MediaPlayer.OnPreparedListener,
        MediaPlayer.OnErrorListener,
        MediaPlayer.OnCompletionListener {

    private MediaPlayer musicPlayer;
    private List<Song>  musicList;

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

    public MediaPlayer getMusicPlayer() {
        return musicPlayer;
    }

    public void setMusicPlayer(MediaPlayer musicPlayer) {
        this.musicPlayer = musicPlayer;
    }

    public List<Song> getMusicList() {
        return musicList;
    }

    public void setMusicList(List<Song> musicList) {
        this.musicList = musicList;
    }
}
