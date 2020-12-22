package com.okellosoftwarez.popularmovies.ui.notifications;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.gson.Gson;
import com.okellosoftwarez.popularmovies.ui.model.detail;
import com.okellosoftwarez.popularmovies.ui.model.results;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotificationsViewModel extends ViewModel {
    private static final String TAG = "NotificationVmodel";
    String moviesKey = "27dada59165b58ea926aae10fb0ea263";
    private MutableLiveData<List<results>> movie_list;
    private MutableLiveData<detail> detailMutableLiveData;

    public LiveData<List<results>> getMovie_list(){
        if (detailMutableLiveData == null || movie_list == null){
            detailMutableLiveData = new MutableLiveData<detail>();
            movie_list = new MutableLiveData<List<results>>();
            loadMovies();

        }

        return movie_list;
    }

    private void loadMovies() {

//        Call<List<results>> call = MovieRetrofitClient.getInstance().getMovieInterface().getMovies();
//
//        call.enqueue(new Callback<List<results>>() {
//            @Override
//            public void onResponse(Call<List<results>> call, Response<List<results>> response) {
//
//                if (response.isSuccessful()){
//                    Log.d(TAG, "onResponse: U can read...");
//                    Log.i(TAG, "onResponse: Correct");
//                }
//
//                if (!response.isSuccessful()){
//                    Log.d(TAG, "onResponse: Impossible");
//                    Log.i(TAG, "onResponse: Incorrect");
//                }
////                for (:
////                     ) {
////
////                }
////                movie_list.setValue(response.body());
//
////                for (Movie eachMovie:
////                     ) {
////
////                }
////                String movieResponse = response.toString();
////                Gson gson = new Gson();
////                detail detailInfo = gson.fromJson(movieResponse, detail.class);
////                try {
////
////                    JSONObject jsonObject = new JSONObject(response.body().toString());
////                    JSONObject getSth = jsonObject.getJSONObject("results");
////                    int nlop = getSth.length();
//////                    Object level = getSth.get("2");
////                    Object title = getSth.get("title");
////                    Log.d(TAG, "onResponse: "+ title);
////                }
////                catch (JSONException je){
////                    Log.e(TAG, "onResponse: ", je);
////                }
//            }
//
//            @Override
//            public void onFailure(Call<List<results>> call, Throwable t) {
////                Toast.makeText(, "", Toast.LENGTH_SHORT).show();
//            }
//        });
        Call<detail> detailCall = MovieRetrofitClient.getInstance().getMovieInterface().getMoviesPerPage();

        detailCall.enqueue(new Callback<detail>() {
            @Override
            public void onResponse(Call<detail> call, Response<detail> response) {
                if (response != null && response.isSuccessful()){
                    Log.d(TAG, "onResponse: Success...:" + response.body().getResultsList().size());
                    Log.d(TAG, "onResponse: Okello...: " + new Gson().toJson(response.body().getResultsList()));

                    movie_list.setValue(response.body().getResultsList());
                }
                else {
                    Log.d(TAG, "onResponse: not Success");
                }
            }

            @Override
            public void onFailure(Call<detail> call, Throwable t) {
                Log.d(TAG, "onFailure: Totally Failure...");
            }
        });
    }
}