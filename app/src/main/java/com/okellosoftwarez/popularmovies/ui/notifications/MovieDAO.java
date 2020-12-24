package com.okellosoftwarez.popularmovies.ui.notifications;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.okellosoftwarez.popularmovies.ui.model.results;

import java.util.List;

@Dao
public interface MovieDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertMovie(List<results> movieList );

    @Query("SELECT * FROM Movies")
   public LiveData<List<results>> retrieveAll();

    @Query("DELETE FROM Movies")
    public void deleteAllMovies();

}
