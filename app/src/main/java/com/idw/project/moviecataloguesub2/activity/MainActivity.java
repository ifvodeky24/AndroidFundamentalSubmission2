package com.idw.project.moviecataloguesub2.activity;

import android.content.Intent;
import android.provider.Settings;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.idw.project.moviecataloguesub2.adapter.DaftarMovieTvshowViewPagerAdapter;
import com.idw.project.moviecataloguesub2.fragment.MovieFragment;
import com.idw.project.moviecataloguesub2.fragment.TvshowFragment;
import com.idw.project.moviecataloguesub2.R;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("Movie Catalogue");
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar_daftar_movie_tvshow);
        setSupportActionBar(toolbar);

        viewPager = findViewById(R.id.viewpager_daftar_movie_tvshow);
        tabLayout = findViewById(R.id.tabs_daftar_movie_tvshow);

        setUpViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setUpViewPager(ViewPager viewPager) {
        DaftarMovieTvshowViewPagerAdapter adapter = new DaftarMovieTvshowViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(MovieFragment.newInstance("Movie"), "Movie");
        adapter.addFragment(TvshowFragment.newInstance("Tvshow"), "Tvshow");
        viewPager.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_change_settings){
            Intent intent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
