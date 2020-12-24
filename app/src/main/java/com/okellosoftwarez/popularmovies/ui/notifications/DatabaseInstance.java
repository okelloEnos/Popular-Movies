package com.okellosoftwarez.popularmovies.ui.notifications;

import android.content.Context;

import androidx.room.Room;

public class DatabaseInstance {
    public static MovieDB databaseInstance ;

    public static MovieDB getDatabaseInstance(Context context) {
        databaseInstance = Room.databaseBuilder(context, MovieDB.class, "Movies_db").fallbackToDestructiveMigration().build();

        return databaseInstance;
    }

}
