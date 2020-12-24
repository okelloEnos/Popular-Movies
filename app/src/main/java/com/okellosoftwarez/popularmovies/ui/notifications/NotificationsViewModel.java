package com.okellosoftwarez.popularmovies.ui.notifications;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.okellosoftwarez.popularmovies.ui.model.results;

import java.util.List;

public class NotificationsViewModel extends ViewModel {
    private static final String TAG = "NotificationVmodel";
    String moviesKey = "27dada59165b58ea926aae10fb0ea263";
    private LiveData<List<results>> movie_list;
    private MovieRepository movieRepository = MovieRepository.getRepositoryInstance();


    public LiveData<List<results>> getMovie_listFromRemoteDB(Context context){

            movie_list = movieRepository.getMoviesFromRemote(context);

        return movie_list;
    }

    public LiveData<List<results>> getMovie_listFromLocalDB(Context context) {

        movie_list = movieRepository.getMoviesFromDB(context);
        return movie_list;
    }
}