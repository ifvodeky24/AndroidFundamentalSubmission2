package com.idw.project.moviecataloguesub2.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.idw.project.moviecataloguesub2.model.Movie;
import com.idw.project.moviecataloguesub2.R;

public class DetailMovieActivity extends AppCompatActivity {

    public static final String TAG = "movie";

    ImageView iv_poster_movie;
    TextView tv_judul_movie, tv_tanggal_rilis_movie, tv_deskripsi_movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("Detail Movie");
        setContentView(R.layout.activity_detail_movie);

        iv_poster_movie = findViewById(R.id.iv_poster_movie);
        tv_judul_movie = findViewById(R.id.tv_judul_movie);
        tv_tanggal_rilis_movie = findViewById(R.id.tv_tanggal_rilis_movie);
        tv_deskripsi_movie = findViewById(R.id.tv_deskripsi_movie);

        Movie movie = getIntent().getExtras().getParcelable(TAG);

        iv_poster_movie.setImageResource(movie.getPoster());
        tv_judul_movie.setText(movie.getJudul());
        tv_tanggal_rilis_movie.setText(movie.getTanggalRilis());
        tv_deskripsi_movie.setText(movie.getDeskripsi());
    }
}
