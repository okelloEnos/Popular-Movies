package com.okellosoftwarez.popularmovies.ui.notifications;


import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

//import com.okellosoftwarez.popularmovies.kotlinSample;
import com.okellosoftwarez.popularmovies.ui.model.Movie;
import com.okellosoftwarez.popularmovies.ui.model.detail;
import com.okellosoftwarez.popularmovies.ui.model.results;

import org.jetbrains.annotations.Contract;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {
    private MutableLiveData<List<results>> movieList;
    public static final MovieRepository repositoryInstance = new MovieRepository();
    private static final String TAG = "MoviesRepo";

    public static MovieRepository getRepositoryInstance() {
        return repositoryInstance;
    }

    public LiveData<List<results>> getMoviesFromDB(Context context) {
        return DatabaseInstance.getDatabaseInstance(context).movieDAO().retrieveAll();
    }

    public LiveData<List<results>> getMoviesFromRemote(Context context) {
        if (movieList == null) {
            movieList = new MutableLiveData<>();
            loadMovies(context);
        }

        return movieList;
    }

    private void loadMovies(Context context) {
        Call<detail> detailCall = MovieRetrofitClient.getInstance().getMovieInterface().getMoviesPerPage();

        detailCall.enqueue(new Callback<detail>() {
            @Override
            public void onResponse(Call<detail> call, Response<detail> response) {
                if (response != null && response.isSuccessful()) {
                    movieList.setValue(response.body().getResultsList());
                    Log.d(TAG, "onResponse: " + response.body().getResultsList().size());

//                    Worker Thread
                    Thread databaseThread = new Thread() {
                        @Override
                        public void run() {
                            super.run();
                            DatabaseInstance.getDatabaseInstance(context).movieDAO().deleteAllMovies();
//                            kotlinSample.databaseInstance.movieDAO().deleteAllMovies();
                            DatabaseInstance.getDatabaseInstance(context).movieDAO().insertMovie(response.body().getResultsList());
//                            kotlinSample.databaseInstance.movieDAO().insertMovie(response.body().getResultsList());
                            Log.d(TAG, "run: Storing");
//                    movieDAO.insertMovie(response.body().getResultsList()); Saving to database implementation
                        }
                    };
                    databaseThread.start();

                } else {
                    movieList.setValue(null);
                    Log.d(TAG, "onResponse: Something Happened");
                }
            }

            @Override
            public void onFailure(Call<detail> call, Throwable t) {
                Log.d(TAG, "onFailure: Totally Failure...");
            }
        });
    }
}
