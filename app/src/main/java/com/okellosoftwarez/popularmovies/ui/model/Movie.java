package com.okellosoftwarez.popularmovies.ui.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Movies")
public class Movie {

    @ColumnInfo(name = "Title")
    private String title;
    @ColumnInfo(name = "Vote_Average")
    private String vote_average;
    @ColumnInfo(name = "Poster_Path")
    private String poster_path;
    @ColumnInfo(name = "Release_Date")
    private String release_date;
    @ColumnInfo(name = "Overview")
    private String overview;
    @PrimaryKey
    private Integer id;


}
