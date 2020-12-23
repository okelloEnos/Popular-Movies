package com.okellosoftwarez.popularmovies.ui.notifications;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.okellosoftwarez.popularmovies.ui.model.results;

import java.util.List;

public class NotificationsViewModel extends ViewModel {
    private static final String TAG = "NotificationVmodel";
    String moviesKey = "27dada59165b58ea926aae10fb0ea263";
    private LiveData<List<results>> movie_list;
    private MovieRepository movieRepository = MovieRepository.getRepositoryInstance();


    public LiveData<List<results>> getMovie_list(){

            movie_list = movieRepository.getMovies();

        return movie_list;
    }
}