package com.idw.project.moviecataloguesub2.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.idw.project.moviecataloguesub2.model.Tvshow;
import com.idw.project.moviecataloguesub2.R;

public class DetailTvshowActivity extends AppCompatActivity {

    public static final String TAG = "tvshow";

    ImageView iv_poster_tvshow;
    TextView tv_judul_tvshow, tv_tanggal_rilis_tvshow, tv_deskripsi_tvshow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("Detail Tv Show");
        setContentView(R.layout.activity_detail_tvshow);

        iv_poster_tvshow = findViewById(R.id.iv_poster_tvshow);
        tv_judul_tvshow = findViewById(R.id.tv_judul_tvshow);
        tv_tanggal_rilis_tvshow = findViewById(R.id.tv_tanggal_rilis_tvshow);
        tv_deskripsi_tvshow = findViewById(R.id.tv_deskripsi_tvshow);

        Tvshow tvshow = getIntent().getExtras().getParcelable(TAG);

        iv_poster_tvshow.setImageResource(tvshow.getPoster());
        tv_judul_tvshow.setText(tvshow.getJudul());
        tv_tanggal_rilis_tvshow.setText(tvshow.getTanggalRilis());
        tv_deskripsi_tvshow.setText(tvshow.getDeskripsi());
    }
}
