package com.okellosoftwarez.popularmovies.ui.notifications;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.okellosoftwarez.popularmovies.R;
import com.okellosoftwarez.popularmovies.ui.model.results;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    Context mContext;
    List<results> resultsList;
    private String BaseUrlImage = "https://image.tmdb.org/t/p/original";
    private static final String TAG = "NotificationVmodel";

    public MovieAdapter(Context mContext, List<results> resultsList) {
        this.mContext = mContext;
        this.resultsList = resultsList;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View movieView = LayoutInflater.from(mContext).inflate(R.layout.movie_recycler, parent, false);
        return new MovieViewHolder(movieView);
//        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {

        results popularResults = resultsList.get(position);

        Picasso.get().load(BaseUrlImage + popularResults.getPoster_path()).placeholder(R.drawable.ic_notifications_black_24dp).into(holder.movieImage);
        holder.movieName.setText(popularResults.getTitle());
        Log.d(TAG, "onBindViewHolder: " + BaseUrlImage + popularResults.getPoster_path());
    }

    @Override
    public int getItemCount() {
        return resultsList.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder{

        ImageView movieImage;
        TextView movieName;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);

            movieImage = itemView.findViewById(R.id.movieImage);
            movieName = itemView.findViewById(R.id.movieName);
        }
    }
}
