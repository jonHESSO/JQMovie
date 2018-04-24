package com.jqmovie.jqmovie.Directors;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
import com.jqmovie.jqmovie.Movies.Movies;
import com.jqmovie.jqmovie.R;
import com.jqmovie.jqmovie.Settings.Settings;

import java.util.Arrays;
import java.util.List;

public class DirectorEdit extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    Button button;

    AlertDialog.Builder alertdialogbuilder;

    String[] AlertDialogItems = new String[]{
            "Titanic",
            "Catch me if you can",
            "Saving private Ryan",
            "Interstellar",
    };

    List<String> ItemsIntoList;

    boolean[] Selectedtruefalse = new boolean[]{
            false,
            false,
            false,
            false,
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_director_edit);

        //ajout des fonctionalités à la navigation bar
        NavigationView navigationView = (NavigationView) findViewById(R.id.menu_director_edit);
        navigationView.setNavigationItemSelectedListener(this);



    }

    //actions des boutons de la navigation bar
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_actor:
                Intent intent1 = new Intent(DirectorEdit.this, Actors.class);
                startActivity(intent1);
                return true;

            case R.id.item_director:
                Intent intent2 = new Intent(DirectorEdit.this, Directors.class);
                startActivity(intent2);
                return true;

            case R.id.item_movie:
                Intent intent3 = new Intent(DirectorEdit.this, Movies.class);
                startActivity(intent3);
                return true;

            case R.id.item_about:
                Intent intent4 = new Intent(DirectorEdit.this, About.class);
                startActivity(intent4);
                return true;

            case R.id.item_settings:
                Intent intent5 = new Intent(DirectorEdit.this, Settings.class);
                startActivity(intent5);
                return true;

            default:
                return false;
        }
    }
}
