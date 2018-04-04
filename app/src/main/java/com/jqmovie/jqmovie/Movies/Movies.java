package com.jqmovie.jqmovie.Movies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import com.jqmovie.jqmovie.R;

public class Movies extends AppCompatActivity {

    GridView gridview;

    public static String[] movieList = {
            "Titanic",
            "Catch Me If you Can",
            "Saving Private Ryan",
            "Interstellar",

    };
    public static int[] movieImages = {
            R.mipmap.titanic,
            R.mipmap.catchme,
            R.mipmap.ryan,
            R.mipmap.interstellar,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
        gridview = (GridView) findViewById(R.id.moviegrid);
        gridview.setAdapter(new MovieAdapter(this, movieList, movieImages));
    }
}
