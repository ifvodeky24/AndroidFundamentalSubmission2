package com.idw.project.moviecataloguesub2.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.idw.project.moviecataloguesub2.activity.DetailMovieActivity;
import com.idw.project.moviecataloguesub2.model.Movie;
import com.idw.project.moviecataloguesub2.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    ArrayList<Movie> movies;
    private Context context;

    public MovieAdapter(ArrayList<Movie> movies, Context context) {
        this.movies = movies;
        this.context = context;
    }

    public ArrayList<Movie> getListItem(){
        return movies;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from( viewGroup.getContext())
                .inflate(R.layout.movie_item, viewGroup, false);

        return  new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final Movie Item = getListItem().get(i);

        viewHolder.iv_poster_movie.setImageResource(Item.getPoster());
        viewHolder.tv_judul_movie.setText(Item.getJudul());
        viewHolder.tv_deskripsi_movie.setText(Item.getDeskripsi());
        viewHolder.tv_tanggal_rilis_movie.setText(Item.getTanggalRilis());

        viewHolder.cv_movie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, DetailMovieActivity.class);
                i.putExtra(DetailMovieActivity.TAG, Item );
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{

        public CircleImageView iv_poster_movie;
        public TextView tv_judul_movie;
        public TextView tv_deskripsi_movie;
        public TextView tv_tanggal_rilis_movie;
        public CardView cv_movie;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            iv_poster_movie = itemView.findViewById(R.id.iv_poster_movie);
            tv_judul_movie = itemView.findViewById(R.id.tv_judul_movie);
            tv_deskripsi_movie = itemView.findViewById(R.id.tv_deskripsi_movie);
            tv_tanggal_rilis_movie = itemView.findViewById(R.id.tv_tanggal_rilis_movie);
            cv_movie = itemView.findViewById(R.id.cv_movie);
        }
    }
}
