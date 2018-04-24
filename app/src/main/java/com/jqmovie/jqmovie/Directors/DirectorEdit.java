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
import android.widget.TextView;

import com.jqmovie.jqmovie.About.About;
import com.jqmovie.jqmovie.Actors.ActorEdit;
import com.jqmovie.jqmovie.Actors.Actors;
import com.jqmovie.jqmovie.Movies.Movies;
import com.jqmovie.jqmovie.R;
import com.jqmovie.jqmovie.Settings.Settings;
import com.jqmovie.jqmovie.db.AppDatabase;
import com.jqmovie.jqmovie.db.Entities.Director;

import java.util.Arrays;
import java.util.List;

public class DirectorEdit extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    Director director ;
    Boolean create = true ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_director_edit);

        //ajout des fonctionalités à la navigation bar
        NavigationView navigationView = (NavigationView) findViewById(R.id.menu_director_edit);
        navigationView.setNavigationItemSelectedListener(this);

        final TextView firstnameView = findViewById(R.id.edit_firstname_director) ;
        final TextView lastnameView = findViewById(R.id.edit_lastname_director) ;
        final TextView birthdateView = findViewById(R.id.edit_birthdate_director) ;
        final TextView biographyView = findViewById(R.id.edit_biography_director) ;

        Intent intent = getIntent() ;

        director = new Director();
        if(intent.getExtras() != null && intent.getExtras().containsKey("directorid"))
        {
            create = false ;
            director = AppDatabase.getAppDatabase(this).directorDAO().getDirector(intent.getIntExtra("directorid",0));
            firstnameView.setText(director.getFirstname());
            lastnameView.setText(director.getLastname());
            birthdateView.setText(director.getBirthdate());
            biographyView.setText(director.getBiography());
        }


        Button button = findViewById(R.id.btn_submit_director) ;
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                director.setFirstname(firstnameView.getText().toString());
                director.setLastname(lastnameView.getText().toString());
                director.setBirthdate(birthdateView.getText().toString());
                director.setBiography(biographyView.getText().toString());
                if(create == false) {
                    AppDatabase.getAppDatabase(view.getContext()).directorDAO().update(director);
                }
                else
                {
                    director.setPicture(R.mipmap.directors);
                    AppDatabase.getAppDatabase(view.getContext()).directorDAO().insert(director);
                }
                Intent intent = new Intent(view.getContext(), Directors.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        }) ;

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
