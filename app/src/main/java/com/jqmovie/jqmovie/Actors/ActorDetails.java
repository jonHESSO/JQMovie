package com.jqmovie.jqmovie.Actors;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jqmovie.jqmovie.About.About;
import com.jqmovie.jqmovie.Directors.Directors;
import com.jqmovie.jqmovie.Movies.Movies;
import com.jqmovie.jqmovie.R;
import com.jqmovie.jqmovie.Settings.Settings;
import com.jqmovie.jqmovie.db.AppDatabase;
import com.jqmovie.jqmovie.db.Entities.Actor;
import com.jqmovie.jqmovie.db.Entities.Movie;

import java.util.ArrayList;
import java.util.List;

public class ActorDetails extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    Actor actor ;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actor_details);

        context = this;

        //ajout des fonctionalité à la navigation bar
        NavigationView navigationView = (NavigationView) findViewById(R.id.menu_actor_details);
        navigationView.setNavigationItemSelectedListener(this);

        Intent intent = getIntent() ;
        actor = AppDatabase.getAppDatabase(this).actorDAO().getActor(intent.getIntExtra("actorid", 0)) ;

        ImageView image = findViewById(R.id.actorPicture) ;
        image.setImageResource(actor.getPicture());

        TextView name = findViewById(R.id.actorName) ;
        name.setText(actor.getFirstname() + " " + actor.getLastname());

        TextView birthdate = findViewById(R.id.yearValue) ;
        birthdate.setText(actor.getBirthdate());

        TextView biography = findViewById(R.id.biographyValue) ;
        biography.setText(actor.getBiography());

        final Button btnMovie = findViewById(R.id.moviesButton);
        btnMovie.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                List<Movie> movies= AppDatabase.getAppDatabase(ActorDetails.this).movieDAO().getMovieFromActor(actor.getActorid()) ;
                if(movies==null){
                    Toast.makeText(ActorDetails.this, "Aucun film", Toast.LENGTH_LONG).show();
                }
                else{

                    Intent intentMovie = new Intent(ActorDetails.this, Movies.class);
                    intentMovie.putExtra("actorid", actor.getActorid());
                    startActivity(intentMovie);
                }

            }
        });
    }



    //actions des boutons de la navigation bar
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_actor:
                Intent intent1 = new Intent(ActorDetails.this, Actors.class);
                startActivity(intent1);
                return true;

            case R.id.item_director:
                Intent intent2 = new Intent(ActorDetails.this, Directors.class);
                startActivity(intent2);
                return true;

            case R.id.item_movie:
                Intent intent3 = new Intent(ActorDetails.this, Movies.class);
                startActivity(intent3);
                return true;

            case R.id.item_about:
                Intent intent4 = new Intent(ActorDetails.this, About.class);
                startActivity(intent4);
                return true;

            case R.id.item_settings:
                Intent intent5 = new Intent(ActorDetails.this, Settings.class);
                startActivity(intent5);
                return true;

            case R.id.item_edit:
                Intent intent6 = new Intent(ActorDetails.this, ActorEdit.class);
                intent6.putExtra("actorid", actor.getActorid()) ;
                startActivity(intent6);
                return true;

            case R.id.item_delete:
                        AppDatabase.getAppDatabase(getParent()).actorDAO().delete(actor);
                        Intent intent7 = new Intent(ActorDetails.this, Actors.class);
                        intent7.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent7);
                        ActorDetails.this.finish();
                return true;

            default:
                return false;
        }
    }
}
