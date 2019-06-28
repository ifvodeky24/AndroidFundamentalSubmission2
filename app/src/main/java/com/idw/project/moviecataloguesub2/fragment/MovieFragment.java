package com.idw.project.moviecataloguesub2.fragment;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.idw.project.moviecataloguesub2.adapter.MovieAdapter;
import com.idw.project.moviecataloguesub2.model.Movie;
import com.idw.project.moviecataloguesub2.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {
    public static final String ARG_STATUS = "status";
    private ShimmerFrameLayout mShimmerViewContainer;

    private  String[] dataJudulMovie;
    private String[] dataDeskripsiMovie;
    private  String[] dataTanggalRilisMovie;
    private TypedArray dataPosterMovie;
    private MovieAdapter movieAdapter;


    private RecyclerView rvMovie;
    private ArrayList<Movie> movies ;

    //membuat fungsi menambahkan fragment di activity
    public static MovieFragment newInstance(String status){
        Bundle args = new Bundle();
        args.putString(ARG_STATUS, status);

        MovieFragment fragment = new MovieFragment();
        fragment.setArguments(args);
        return fragment;
    }


    public MovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movie, container, false);

        mShimmerViewContainer = view.findViewById(R.id.shimmer_view_container);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvMovie = getView().findViewById(R.id.rv_movie);
        rvMovie.setHasFixedSize(true);
        rvMovie.setLayoutManager(new LinearLayoutManager(getActivity()));
        prepare();
        addItem();
        rvMovie.setAdapter(movieAdapter);

    }

    private void  prepare(){
        dataJudulMovie = getResources().getStringArray(R.array.data_judul_movie);
        dataDeskripsiMovie = getResources().getStringArray(R.array.data_deskripsi_movie);
        dataTanggalRilisMovie = getResources().getStringArray(R.array.data_tanggal_rilis_movie);
        dataPosterMovie = getResources().obtainTypedArray(R.array.data_poster_movie);

    }

    public void addItem(){
        movies = new ArrayList<>();
        for (int i = 0;i <dataJudulMovie.length; i++){
            Movie movie = new Movie();
            movie.setJudul(dataJudulMovie[i]);
            movie.setDeskripsi(dataDeskripsiMovie[i]);
            movie.setTanggalRilis(dataTanggalRilisMovie[i]);
            movie.setPoster(dataPosterMovie.getResourceId(i, -1));
            movies.add(movie);

            mShimmerViewContainer.stopShimmerAnimation();
            mShimmerViewContainer.setVisibility(View.GONE);
        }

        movieAdapter = new MovieAdapter(movies, getActivity());

    }

    @Override
    public void onResume() {
        super.onResume();
        mShimmerViewContainer.startShimmerAnimation();
    }

    @Override
    public void onPause() {
        super.onPause();
        mShimmerViewContainer.stopShimmerAnimation();

    }
}
