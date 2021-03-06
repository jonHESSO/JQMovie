package com.jqmovie.jqmovie.Movies;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.Toast;

import com.jqmovie.jqmovie.About.About;
import com.jqmovie.jqmovie.Actors.Actors;
import com.jqmovie.jqmovie.Directors.Directors;
import com.jqmovie.jqmovie.R;
import com.jqmovie.jqmovie.Settings.Settings;
import com.jqmovie.jqmovie.db.AppDatabase;
import com.jqmovie.jqmovie.db.Entities.Movie;

import java.util.List;

public class Movies extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    //class to display all the movie of the db
    GridView gridview;
    Intent intent ;
    List<Movie> movieList ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        intent = getIntent() ;

        //gridLayout creation
        gridview = (GridView) findViewById(R.id.moviegrid);
        AppDatabase db = AppDatabase.getAppDatabase(this) ;

        //whether the window should display an actor's movies
        if(intent.getIntExtra("actorid",0) != 0){
            movieList = AppDatabase.getAppDatabase(this).movieDAO().getMovieFromActor(intent.getIntExtra("actorid",0));
        }
        //whether the window should display an director's movies
        else if(intent.getIntExtra("directorid",0) != 0){
            movieList = AppDatabase.getAppDatabase(this).movieDAO().getMovieFromDirector(intent.getIntExtra("directorid",0));
        }
        //whether the window should display all movies in the db
        else{movieList = db.movieDAO().getAll() ;
        }



        gridview.setAdapter(new MovieAdapter(this, movieList));

        //added features to bar navigation
        NavigationView navigationView = (NavigationView) findViewById(R.id.menu_movie);
        navigationView.setNavigationItemSelectedListener(this);
    }

    //bar navigation button action
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

    //this method allows to update this class before it is in foreground
    @Override
    protected void onResume() {
        super.onResume();

        intent = getIntent() ;

        //whether the window should display an actor's movies
        if(intent.getIntExtra("actorid",0) != 0 /*&& intent.getExtras().containsKey("actorid")*/){
            movieList = AppDatabase.getAppDatabase(this).movieDAO().getMovieFromActor(intent.getIntExtra("actorid",0));
        }
        //whether the window should display an director's movies
        else if(intent.getIntExtra("directorid",0) != 0){
            movieList = AppDatabase.getAppDatabase(this).movieDAO().getMovieFromDirector(intent.getIntExtra("directorid",0));
        }
        //whether the window should display all movies in the db
        else{movieList = AppDatabase.getAppDatabase(Movies.this).movieDAO().getAll() ;
        }

        gridview.setAdapter(new MovieAdapter(this, movieList));
    }
}
