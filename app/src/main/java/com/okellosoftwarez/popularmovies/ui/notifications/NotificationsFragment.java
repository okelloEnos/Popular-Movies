package com.okellosoftwarez.popularmovies.ui.notifications;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.okellosoftwarez.popularmovies.R;
import com.okellosoftwarez.popularmovies.ui.model.results;

import java.util.List;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;
    private RecyclerView movieRecyclerView;
    private MovieAdapter movieAdapter;
    private List<com.okellosoftwarez.popularmovies.ui.model.results> results;
    private RecyclerView.LayoutManager movieLayoutManager;
    private String TAG = "NotFrag";
    private MovieDB movieDB;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);
//        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
//        final TextView textView = root.findViewById(R.id.text_notifications);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);

        movieRecyclerView = root.findViewById(R.id.popularMovieRecycler);
        movieRecyclerView.setHasFixedSize(true);

        movieLayoutManager = new LinearLayoutManager(getActivity());
        movieRecyclerView.setLayoutManager(movieLayoutManager);
        movieRecyclerView.setItemAnimator(new DefaultItemAnimator());

        movieDB = Room.databaseBuilder(getActivity(), MovieDB.class, "Movies_db").fallbackToDestructiveMigration().build();

        if (isNetworkConnected(getActivity())){
            notificationsViewModel.getMovie_listFromRemoteDB(getActivity());
            Log.d(TAG, "onCreateView: isNetConnected");
        }
        else {
            Toast.makeText(getActivity(), "No Internet Found Displaying Cached Data...", Toast.LENGTH_SHORT).show();
        }

        notificationsViewModel.getMovie_listFromLocalDB(getActivity()).observe(getViewLifecycleOwner(), new Observer<List<results>>() {
            @Override
            public void onChanged(List<results> results) {
                Log.d(TAG, "onChanged: LocalDB");
                movieAdapter = new MovieAdapter(getActivity(), results);
                movieRecyclerView.setAdapter(movieAdapter);
            }
        });
        return root;
    }

    private boolean isNetworkConnected(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();

        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();

    }
}
