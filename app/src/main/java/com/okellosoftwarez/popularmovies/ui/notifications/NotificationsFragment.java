package com.okellosoftwarez.popularmovies.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.okellosoftwarez.popularmovies.R;
import com.okellosoftwarez.popularmovies.ui.model.results;

import java.util.List;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;
    private RecyclerView movieRecyclerView;
    private MovieAdapter movieAdapter;
    private List<com.okellosoftwarez.popularmovies.ui.model.results> results;
    private RecyclerView.LayoutManager movieLayoutManager;

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
//        movieAdapter = new MovieAdapter(getActivity(), null);
//        movieRecyclerView.setAdapter(movieAdapter);

        notificationsViewModel.getMovie_list().observe(getViewLifecycleOwner(), new Observer<List<results>>() {
            @Override
            public void onChanged(List<results> results) {
                movieAdapter = new MovieAdapter(getActivity(), results);
                movieRecyclerView.setAdapter(movieAdapter);
            }
        });
//        notificationsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }
}
