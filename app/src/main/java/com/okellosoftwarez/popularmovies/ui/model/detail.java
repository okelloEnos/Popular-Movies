package com.okellosoftwarez.popularmovies.ui.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class detail {
   private int page;
   @SerializedName("results")
    private ArrayList<results> resultsList;
    private int total_pages;
    private int total_results;
//    private ArraySet<results> arraySet;

//    public detail(int page, com.okellosoftwarez.movies.ui.model.results results, int total_pages, int total_results) {
//        this.page = page;
//        this.results = results;
//        this.total_pages = total_pages;
//        this.total_results = total_results;
//    }

    public detail(int page, ArrayList<results> resultsList, int total_pages, int total_results) {
        this.page = page;
        this.resultsList = resultsList;
        this.total_pages = total_pages;
        this.total_results = total_results;
    }

    public ArrayList<results> getResultsList() {
        return resultsList;
    }

    public int getPage() {
        return page;
    }

//    public com.okellosoftwarez.movies.ui.model.results getResults() {
//        return results;
//    }

    public int getTotal_pages() {
        return total_pages;
    }

    public int getTotal_results() {
        return total_results;
    }

//    public ArraySet<results> getArraySet() {
//        return arraySet;
//    }
}
