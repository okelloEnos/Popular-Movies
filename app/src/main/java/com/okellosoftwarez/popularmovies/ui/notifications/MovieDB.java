package com.okellosoftwarez.popularmovies.ui.notifications;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.okellosoftwarez.popularmovies.ui.model.Movie;
import com.okellosoftwarez.popularmovies.ui.model.results;

@Database(entities = {results.class}, version = 1, exportSchema = false)
public abstract class MovieDB extends RoomDatabase {
    public abstract MovieDAO movieDAO();

}
