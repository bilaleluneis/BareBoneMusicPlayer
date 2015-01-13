package com.bilaleluneis.musicplayer.util;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.widget.CursorAdapter;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;
import java.util.List;

/**
 * @author Bilal El Uneis (bilaleluneis@gmail.com)
 * @since jan 10 2015
 * an abstract util class to hold common operations methods
 * needed for a music player
 */
public abstract class MusicPlayerUtils {

    private MusicPlayerUtils(){/* maybe an overkill, but just want to be sure this cant be instantiated*/}


    /**
     *@param context is the activity calling this method, in the activity that would call this method just pass "this"
     *@param layoutId the layout id that would contain the views listOfViewsIdToStoreEachMetaDataTo, ex R.Layout."something"
     *@param ListOfkMetaDataForTrack a list containing the information you want to get about each track (title, album, duration,etc)
     *@param listOfViewsIdToStoreEachMetaDataTo those are the list of views that are contained in layoutId
     *@return ListAdapter containing the list of songs in user's Android Music Library
     */
    public static ListAdapter getMusicLibraryList(Context context, int layoutId, List<String> ListOfkMetaDataForTrack, List<Integer> listOfViewsIdToStoreEachMetaDataTo){
        if((ListOfkMetaDataForTrack == null || ListOfkMetaDataForTrack.isEmpty()))
            return null;
        if(listOfViewsIdToStoreEachMetaDataTo ==null || listOfViewsIdToStoreEachMetaDataTo.isEmpty())
            return null;
        String[] from = listOfViewsIdToStoreEachMetaDataTo.toArray(new String[listOfViewsIdToStoreEachMetaDataTo.size()]);
        int[] to = new int[listOfViewsIdToStoreEachMetaDataTo.size()];
        int trackCounter=0;
        for(Integer ViewIdToHoldMetaDateInfo : listOfViewsIdToStoreEachMetaDataTo) {
            to[trackCounter++] = ViewIdToHoldMetaDateInfo.intValue();
        }
        ContentResolver contentResolver = context.getContentResolver();
        Uri musicLibUri = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        /*thanks to https://github.com/alexdantas/kure-music-player*/
        final String musicsOnly = MediaStore.Audio.Media.IS_MUSIC + "=1";
        Cursor cursor = contentResolver.query(musicLibUri, null, musicsOnly, null, MediaStore.Audio.Media.TITLE);
        return new SimpleCursorAdapter(context,layoutId,cursor,from,to, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
    }
}
