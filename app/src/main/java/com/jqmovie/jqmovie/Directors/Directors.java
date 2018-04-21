package com.jqmovie.jqmovie.Directors;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.GridView;

import com.jqmovie.jqmovie.About.About;
import com.jqmovie.jqmovie.Actors.Actors;
import com.jqmovie.jqmovie.Movies.Movies;
import com.jqmovie.jqmovie.R;
import com.jqmovie.jqmovie.Settings.Settings;

public class Directors extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener{

    GridView gridview;

    public static String[] directorList = {
            "James Cameron",
            "Steven Spielberg",
            "Chritopher Nolan",

    };
    public static int[] directorImages = {
            R.mipmap.cameron,
            R.mipmap.spielberg,
            R.mipmap.nolan,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directors);

        //création du gridlayout
        gridview = (GridView) findViewById(R.id.directorgrid);
        gridview.setAdapter(new DirectorAdapter(this, directorList, directorImages));

        //ajout des fonctionalité à la navigation bar
        NavigationView navigationView = (NavigationView) findViewById(R.id.menu_director);
        navigationView.setNavigationItemSelectedListener(this);
    }

    //actions des boutons de la navigation bar
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_actor:
                Intent intent1 = new Intent(Directors.this, Actors.class);
                startActivity(intent1);
                return true;

            case R.id.item_director:
                Intent intent2 = new Intent(Directors.this, Directors.class);
                startActivity(intent2);
                return true;

            case R.id.item_movie:
                Intent intent3 = new Intent(Directors.this, Movies.class);
                startActivity(intent3);
                return true;

            case R.id.item_about:
                Intent intent4 = new Intent(Directors.this, About.class);
                startActivity(intent4);
                return true;

            case R.id.item_settings:
                Intent intent5 = new Intent(Directors.this, Settings.class);
                startActivity(intent5);
                return true;

            case R.id.item_add:
                Intent intent6 = new Intent(Directors.this, DirectorEdit.class);
                startActivity(intent6);
                return true;

            default:
                return false;
        }
    }
}
