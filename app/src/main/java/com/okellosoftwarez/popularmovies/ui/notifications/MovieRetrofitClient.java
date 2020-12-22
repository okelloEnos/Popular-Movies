package com.okellosoftwarez.popularmovies.ui.notifications;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//Singleton of retrofit

public class MovieRetrofitClient {
    private static MovieRetrofitClient instance = null;
    private MovieInterface movieInterface;

    private MovieRetrofitClient(){
//        Okhttp client

        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        okHttpClientBuilder.addInterceptor(loggingInterceptor);

        Retrofit movieRetrofit = new Retrofit.Builder().baseUrl(MovieInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).client(okHttpClientBuilder.build())
                .build();

        movieInterface = movieRetrofit.create(MovieInterface.class);
    }

    public static synchronized MovieRetrofitClient getInstance(){
        if (instance == null){
            instance = new MovieRetrofitClient();
        }

        return instance;
    }

    public MovieInterface getMovieInterface(){
        return movieInterface;
    }
}
