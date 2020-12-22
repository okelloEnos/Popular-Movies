package com.okellosoftwarez.popularmovies.ui.notifications;


import com.okellosoftwarez.popularmovies.ui.model.detail;
import com.okellosoftwarez.popularmovies.ui.model.results;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieInterface {
    String BASE_URL = "https://api.themoviedb.org/3/movie/";

    @GET("popular?api_key=27dada59165b58ea926aae10fb0ea263&language=en-US&page=1")
    Call<List<results>> getMovies();

    @GET("popular?api_key=27dada59165b58ea926aae10fb0ea263&language=en-US&page=1")
    Call<detail> getMoviesPerPage();

}
