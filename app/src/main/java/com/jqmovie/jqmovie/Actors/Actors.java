package com.jqmovie.jqmovie.Actors;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.widget.GridView;

import com.jqmovie.jqmovie.About.About;
import com.jqmovie.jqmovie.Directors.Directors;
import com.jqmovie.jqmovie.Movies.Movies;
import com.jqmovie.jqmovie.R;
import com.jqmovie.jqmovie.Settings.Settings;

public class Actors extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    GridView gridview;

    public static String[] actorList = {
            "Burns",
            "Burstyn",
            "Caine",
            "Chastain",
            "Matt Damon",
            "Leonardo DiCarpaccio",
            "Tom Hanks",
            "Hathaway",
            "Irwin",
            "McConaughey",
            "Kate Winslet"
    };
    public static int[] actorImages = {
            R.mipmap.burns,
            R.mipmap.burstyn,
            R.mipmap.caine,
            R.mipmap.chastain,
            R.mipmap.damon,
            R.mipmap.dicaprio,
            R.mipmap.hanks,
            R.mipmap.hathaway,
            R.mipmap.irwin,
            R.mipmap.mcconaughey,
            R.mipmap.winslet,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actors);

        //création du gridLayout
        gridview = (GridView) findViewById(R.id.actorgrid);
        gridview.setAdapter(new ActorAdapter(this, actorList, actorImages));


        //ajout des fonctionalités à la navigation bar
        NavigationView navigationView = (NavigationView) findViewById(R.id.menu_actor);
        navigationView.setNavigationItemSelectedListener(this);
    }


    //action des boutons
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_actor:
                Intent intent1 = new Intent(Actors.this, Actors.class);
                startActivity(intent1);
                return true;

            case R.id.item_director:
                Intent intent2 = new Intent(Actors.this, Directors.class);
                startActivity(intent2);
                return true;

            case R.id.item_movie:
                Intent intent3 = new Intent(Actors.this, Movies.class);
                startActivity(intent3);
                return true;

            case R.id.item_about:
                Intent intent4 = new Intent(Actors.this, About.class);
                startActivity(intent4);
                return true;

            case R.id.item_settings:
                Intent intent5 = new Intent(Actors.this, Settings.class);
                startActivity(intent5);
                return true;

            case R.id.item_add:
                Intent intent6 = new Intent(Actors.this, ActorEdit.class);
                startActivity(intent6);
                return true;

            default:
                return false;
        }
    }

}
