package com.okellosoftwarez.popularmovies.ui.notifications;


import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.okellosoftwarez.popularmovies.ui.model.detail;
import com.okellosoftwarez.popularmovies.ui.model.results;

import org.jetbrains.annotations.Contract;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {
    private MutableLiveData<List<results>> movieList;
    public static final MovieRepository repositoryInstance = new MovieRepository();
    private static final String TAG = "MoviesRepo";

    public static MovieRepository getRepositoryInstance(){
        return repositoryInstance;
    }

    public LiveData<List<results>> getMovies(){
        if (movieList == null){
            movieList = new MutableLiveData<>();
            loadMovies();
        }

        return movieList;
    }

    private void loadMovies() {
        Call<detail> detailCall = MovieRetrofitClient.getInstance().getMovieInterface().getMoviesPerPage();

        detailCall.enqueue(new Callback<detail>() {
            @Override
            public void onResponse(Call<detail> call, Response<detail> response) {
                if (response != null && response.isSuccessful()) {
                    movieList.setValue(response.body().getResultsList());
                    Log.d(TAG, "onResponse: "+ response.body().getResultsList().size());
                }
                else {
                    movieList.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<detail> call, Throwable t) {
                Log.d(TAG, "onFailure: Totally Failure...");
            }
        });
    }
}
