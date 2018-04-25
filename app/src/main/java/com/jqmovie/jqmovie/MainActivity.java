package com.jqmovie.jqmovie;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.jqmovie.jqmovie.About.About;
import com.jqmovie.jqmovie.Actors.ActorEdit;
import com.jqmovie.jqmovie.Actors.Actors;
import com.jqmovie.jqmovie.Directors.Directors;
import com.jqmovie.jqmovie.Movies.Movies;
import com.jqmovie.jqmovie.Settings.Settings;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //added features to bar navigation
        NavigationView navigationView = (NavigationView) findViewById(R.id.menu_menu);
        navigationView.setNavigationItemSelectedListener(this);

        // action button actor
        final Button btnActor = findViewById(R.id.button_actor);
        btnActor.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intentActor = new Intent(MainActivity.this, Actors.class);
                startActivity(intentActor);
            }
        });

        //action button movie
        final Button btnMovie = findViewById(R.id.button_movie);
        btnMovie.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intentMovie = new Intent(MainActivity.this, Movies.class);
                startActivity(intentMovie);
            }
        });

        //action button director
        final Button btnDirector = findViewById(R.id.button_director);
        btnDirector.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intentDirector = new Intent(MainActivity.this, Directors.class);
                startActivity(intentDirector);
            }
        });
    }

    //bar navigation button action
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_actor:
                Intent intent1 = new Intent(MainActivity.this, Actors.class);
                startActivity(intent1);
                return true;

            case R.id.item_director:
                Intent intent2 = new Intent(MainActivity.this, Directors.class);
                startActivity(intent2);
                return true;

            case R.id.item_movie:
                Intent intent3 = new Intent(MainActivity.this, Movies.class);
                startActivity(intent3);
                return true;

            case R.id.item_about:
                Intent intent4 = new Intent(MainActivity.this, About.class);
                startActivity(intent4);
                return true;

            case R.id.item_settings:
                Intent intent5 = new Intent(MainActivity.this, Settings.class);
                startActivity(intent5);
                return true;

            default:
                return false;
        }
    }
}
