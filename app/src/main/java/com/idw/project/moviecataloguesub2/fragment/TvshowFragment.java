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
import com.idw.project.moviecataloguesub2.adapter.TvshowAdapter;
import com.idw.project.moviecataloguesub2.model.Tvshow;
import com.idw.project.moviecataloguesub2.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TvshowFragment extends Fragment {
    public static final String ARG_STATUS = "status";
    private ShimmerFrameLayout mShimmerViewContainer;

    private  String[] dataJudulTvshow;
    private String[] dataDeskripsiTvshow;
    private  String[] dataTanggalRilisTvshow;
    private TypedArray dataPosterTvshow;
    private TvshowAdapter tvshowAdapter;

    private RecyclerView rvTvshow;
    private ArrayList<Tvshow> tvshows;

    //membuat fungsi menambahkan fragment di activity
    public static TvshowFragment newInstance(String status){
        Bundle args = new Bundle();
        args.putString(ARG_STATUS, status);

        TvshowFragment fragment = new TvshowFragment();
        fragment.setArguments(args);
        return fragment;
    }


    public TvshowFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_tvshow, container, false);

        mShimmerViewContainer = view.findViewById(R.id.shimmer_view_container);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvTvshow = getView().findViewById(R.id.rv_tvshow);
        rvTvshow.setHasFixedSize(true);
        rvTvshow.setLayoutManager(new LinearLayoutManager(getActivity()));
        prepare();
        addItem();
        rvTvshow.setAdapter(tvshowAdapter);

    }

    private void  prepare(){
        dataJudulTvshow = getResources().getStringArray(R.array.data_judul_tvshow);
        dataDeskripsiTvshow = getResources().getStringArray(R.array.data_deskripsi_tvshow);
        dataTanggalRilisTvshow = getResources().getStringArray(R.array.data_tanggal_rilis_tvshow);
        dataPosterTvshow = getResources().obtainTypedArray(R.array.data_poster_tvshow);

    }

    public void addItem(){
        tvshows = new ArrayList<>();
        for (int i = 0;i <dataJudulTvshow.length; i++){
            Tvshow tvshow = new Tvshow();
            tvshow.setJudul(dataJudulTvshow[i]);
            tvshow.setDeskripsi(dataDeskripsiTvshow[i]);
            tvshow.setTanggalRilis(dataTanggalRilisTvshow[i]);
            tvshow.setPoster(dataPosterTvshow.getResourceId(i, -1));
            tvshows.add(tvshow);

            mShimmerViewContainer.stopShimmerAnimation();
            mShimmerViewContainer.setVisibility(View.GONE);
        }

        tvshowAdapter = new TvshowAdapter(tvshows, getActivity());

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
