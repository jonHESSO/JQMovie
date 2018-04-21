package com.jqmovie.jqmovie.Movies;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.GridView;

import com.jqmovie.jqmovie.About.About;
import com.jqmovie.jqmovie.Actors.Actors;
import com.jqmovie.jqmovie.Directors.Directors;
import com.jqmovie.jqmovie.R;
import com.jqmovie.jqmovie.Settings.Settings;

public class Movies extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

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

        //création du gridLayout
        gridview = (GridView) findViewById(R.id.moviegrid);
        gridview.setAdapter(new MovieAdapter(this, movieList, movieImages));

        //ajout des fonctionalités à la navigation bar
        NavigationView navigationView = (NavigationView) findViewById(R.id.menu_movie);
        navigationView.setNavigationItemSelectedListener(this);
    }

    //actions des boutons de la navigation bar
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_actor:
                Intent intent1 = new Intent(Movies.this, Actors.class);
                startActivity(intent1);
                return true;

            case R.id.item_director:
                Intent intent2 = new Intent(Movies.this, Directors.class);
                startActivity(intent2);
                return true;

            case R.id.item_movie:
                Intent intent3 = new Intent(Movies.this, Movies.class);
                startActivity(intent3);
                return true;

            case R.id.item_about:
                Intent intent4 = new Intent(Movies.this, About.class);
                startActivity(intent4);
                return true;

            case R.id.item_settings:
                Intent intent5 = new Intent(Movies.this, Settings.class);
                startActivity(intent5);
                return true;

            case R.id.item_add:
                Intent intent6 = new Intent(Movies.this, MovieEdit.class);
                startActivity(intent6);
                return true;

            default:
                return false;
        }
    }
}
