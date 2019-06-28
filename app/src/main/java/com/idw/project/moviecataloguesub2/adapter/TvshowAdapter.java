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

import com.idw.project.moviecataloguesub2.activity.DetailTvshowActivity;
import com.idw.project.moviecataloguesub2.model.Tvshow;
import com.idw.project.moviecataloguesub2.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class TvshowAdapter extends RecyclerView.Adapter<TvshowAdapter.ViewHolder> {

    ArrayList<Tvshow> tvshows;
    private Context context;

    public TvshowAdapter(ArrayList<Tvshow> tvshows, Context context) {
        this.tvshows = tvshows;
        this.context = context;
    }

    public ArrayList<Tvshow> getListItem(){
        return tvshows;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from( viewGroup.getContext())
                .inflate(R.layout.tvshow_item, viewGroup, false);

        return  new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final Tvshow Item = getListItem().get(i);

        viewHolder.iv_poster_tvshow.setImageResource(Item.getPoster());
        viewHolder.tv_judul_tvshow.setText(Item.getJudul());
        viewHolder.tv_deskripsi_tvshow.setText(Item.getDeskripsi());
        viewHolder.tv_tanggal_rilis_tvshow.setText(Item.getTanggalRilis());

        viewHolder.cv_tvshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, DetailTvshowActivity.class);
                i.putExtra(DetailTvshowActivity.TAG, Item );
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return tvshows.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{

        public CircleImageView iv_poster_tvshow;
        public TextView tv_judul_tvshow;
        public  TextView tv_deskripsi_tvshow;
        public TextView tv_tanggal_rilis_tvshow;
        public CardView cv_tvshow;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            iv_poster_tvshow = itemView.findViewById(R.id.iv_poster_tvshow);
            tv_judul_tvshow = itemView.findViewById(R.id.tv_judul_tvshow);
            tv_deskripsi_tvshow = itemView.findViewById(R.id.tv_deskripsi_tvshow);
            tv_tanggal_rilis_tvshow = itemView.findViewById(R.id.tv_tanggal_rilis_tvshow);
            cv_tvshow = itemView.findViewById(R.id.cv_tvshow);
        }
    }
}

