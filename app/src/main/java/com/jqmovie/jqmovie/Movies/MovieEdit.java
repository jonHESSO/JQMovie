package com.jqmovie.jqmovie.Movies;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.jqmovie.jqmovie.About.About;
import com.jqmovie.jqmovie.Actors.ActorEdit;
import com.jqmovie.jqmovie.Actors.Actors;
import com.jqmovie.jqmovie.Directors.Directors;
import com.jqmovie.jqmovie.R;
import com.jqmovie.jqmovie.Settings.Settings;
import com.jqmovie.jqmovie.db.Entities.Actor;
import com.jqmovie.jqmovie.db.Entities.Director;
import com.jqmovie.jqmovie.db.Entities.Movie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MovieEdit extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    //class to edit and add a movie
    Button buttonDirector;
    Button buttonActor;

    AlertDialog.Builder alertdialogbuilderDirector;
    AlertDialog.Builder alertdialogbuilderActor;

    Movie movie ;

    Boolean create = true ;

    String actorid = "" ;
    String directorid = "";

    String movieid = "";

    DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_edit);

        //added features to bar navigation
        NavigationView navigationView = (NavigationView) findViewById(R.id.menu_movie_edit);
        navigationView.setNavigationItemSelectedListener(this);

        final TextView titleView = findViewById(R.id.edit_name_movie);
        final TextView genreView = findViewById(R.id.edit_genre_movie);
        final TextView yearView = findViewById(R.id.edit_year_movie);
        final TextView synopsisView = findViewById(R.id.edit_synopsis_movie);

        Intent intent = getIntent() ;

        movie = new Movie();
        //edit a movie
        if(intent.getExtras() != null && intent.getExtras().containsKey("movieid")) {
            movieid = intent.getStringExtra("movieid");
            create = false;
            mDatabase.child("Movies").child(movieid).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    movie = dataSnapshot.getValue(Movie.class);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
            titleView.setText(movie.getTitle());
            genreView.setText(movie.getGenre());
            yearView.setText(movie.getYear());
            synopsisView.setText(movie.getSynopsis());
            actorid = movie.getActorid();
            directorid = movie.getDirectorid();
        }


        buttonDirector = (Button)findViewById(R.id.btn_adddirector_movie);
        buttonActor = (Button)findViewById(R.id.btn_addactors_movie);

        Button buttonSubmit= (Button)findViewById(R.id.btn_submit_movie);


        //Button action director
        buttonDirector.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Added a DialogAlert to choose a film director
                alertdialogbuilderDirector = new AlertDialog.Builder(MovieEdit.this);

                final List<Director> directors =  new ArrayList<>();
                mDatabase.child("Directors").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot childata :dataSnapshot.getChildren())
                        {
                            Director director = childata.getValue(Director.class);
                            director.setDirectorid(childata.getKey());
                            directors.add(director);
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
                String[] directornames = new String[directors.size()];
                int i = 0;
                for (Director di:directors) {
                    directornames[i] = di.getFirstname()+" "+di.getLastname();
                    i++;
                }


                alertdialogbuilderDirector.setSingleChoiceItems(directornames, -1, new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        directorid = directors.get(i).getDirectorid();
                    }
                });


                alertdialogbuilderDirector.setCancelable(false);

                alertdialogbuilderDirector.setTitle("Select Director Here");

                alertdialogbuilderDirector.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MovieEdit.this, "Director : "+directorid, Toast.LENGTH_SHORT).show();
                    }
                });


                AlertDialog dialog = alertdialogbuilderDirector.create();

                dialog.show();
            }
        });
        //Button action actor
        buttonActor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Added a DialogAlert to choose an actor
                alertdialogbuilderActor = new AlertDialog.Builder(MovieEdit.this);

                final List<Actor> actors =  new ArrayList<>();
                mDatabase.child("Actors").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot childata :dataSnapshot.getChildren())
                        {
                            Actor actor = childata.getValue(Actor.class);
                            actor.setActorId(childata.getKey());
                            actors.add(actor);
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

                String[] actornames = new String[actors.size()];
                int i = 0;
                for (Actor ac:actors) {
                    actornames[i] = ac.getFirstname()+" "+ac.getLastname();
                    i++;
                }


                alertdialogbuilderActor.setSingleChoiceItems(actornames, -1, new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        actorid = actors.get(i).getActorId();
                    }
                });

                alertdialogbuilderActor.setCancelable(false);

                alertdialogbuilderActor.setTitle("Select Actors Here");

                alertdialogbuilderActor.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MovieEdit.this, "Actor : "+actorid, Toast.LENGTH_SHORT).show();
                    }
                });


                AlertDialog dialog = alertdialogbuilderActor.create();

                dialog.show();
            }
        });
        //Button action submit
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if no actor or director has been chosen
                if(actorid=="-1" || directorid=="-1"){
                    Toast.makeText(MovieEdit.this, "Please select actor and director", Toast.LENGTH_SHORT).show();
                    return;
                }
                //get the movie's info
                movie.setActorid(actorid);
                movie.setDirectorid(directorid);
                movie.setTitle(titleView.getText().toString());
                movie.setGenre(genreView.getText().toString());
                movie.setYear(yearView.getText().toString());
                movie.setSynopsis(synopsisView.getText().toString());
                //edit the movie
                if(create==false)
                {
                    mDatabase.child("Movies").child(movieid).setValue(movie);
                }
                //add the actor
                else{
                    movie.setPicture("movies");
                    DatabaseReference childref = mDatabase.child("Movies").push();
                    childref.setValue(movie);

                }
                Intent intent = new Intent(view.getContext(), Movies.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    //bar navigation button actions
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_actor:
                Intent intent1 = new Intent(MovieEdit.this, Actors.class);
                startActivity(intent1);
                return true;

            case R.id.item_director:
                Intent intent2 = new Intent(MovieEdit.this, Directors.class);
                startActivity(intent2);
                return true;

            case R.id.item_movie:
                Intent intent3 = new Intent(MovieEdit.this, Movies.class);
                startActivity(intent3);
                return true;

            case R.id.item_about:
                Intent intent4 = new Intent(MovieEdit.this, About.class);
                startActivity(intent4);
                return true;

            case R.id.item_settings:
                Intent intent5 = new Intent(MovieEdit.this, Settings.class);
                startActivity(intent5);
                return true;

            default:
                return false;
        }
    }
}
