package com.okellosoftwarez.popularmovies.ui.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Movies")
public class results {
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
//    private String vote_average;
//    private String poster_path;
//    private String release_date;
//    private String overview;
//    private Integer id;
//    private String imageBaseUrl = "https://image.tmdb.org/t/p/original";

    public results(String title, String vote_average, String poster_path, String release_date, String overview, Integer id) {
        this.title = title;
        this.vote_average = vote_average;
        this.poster_path =  poster_path;
        this.release_date = release_date;
        this.overview = overview;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getVote_average() {
        return vote_average;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public String getRelease_date() {
        return release_date;
    }

    public String getOverview() {
        return overview;
    }

    public Integer getId() {
        return id;
    }
}
