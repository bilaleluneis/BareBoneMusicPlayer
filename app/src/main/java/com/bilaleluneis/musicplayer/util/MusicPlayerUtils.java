package com.bilaleluneis.musicplayer.util;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.widget.CursorAdapter;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;

/**
 * @author Bilal El Uneis (bilaleluneis@gmail.com)
 * @since jan 10 2015
 * an abstract util class to hold common operations methods
 * needed for a music player
 */
public abstract class MusicPlayerUtils {

    private MusicPlayerUtils(){/* maybe an overkill, but just want to be sure this cant be instantiated*/}

    /**
     *
     * @return ListAdapter containing the list of songs in
     * user's Android Music Library
     */
    public static ListAdapter getMusicLibraryList(Context context){
        String[] from = {MediaStore.MediaColumns.TITLE};
        int[] to = {android.R.id.text1};
        ContentResolver contentResolver = context.getContentResolver();
        Uri musicLibUri = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        /*thanks to https://github.com/alexdantas/kure-music-player*/
        final String musicsOnly = MediaStore.Audio.Media.IS_MUSIC + "=1";
        Cursor cursor = contentResolver.query(musicLibUri, null, musicsOnly, null, MediaStore.Audio.Media.TITLE);
        return new SimpleCursorAdapter(context,android.R.layout.simple_list_item_1,cursor,from,to, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
    }
}
