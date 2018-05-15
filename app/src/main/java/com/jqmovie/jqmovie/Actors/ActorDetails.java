package com.jqmovie.jqmovie.Actors;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jqmovie.jqmovie.About.About;
import com.jqmovie.jqmovie.Directors.Directors;
import com.jqmovie.jqmovie.Movies.Movies;
import com.jqmovie.jqmovie.R ;
import com.jqmovie.jqmovie.Settings.Settings;
import com.jqmovie.jqmovie.db.Entities.Actor;
import com.jqmovie.jqmovie.db.Entities.Movie;

import java.util.ArrayList;
import java.util.List;

public class ActorDetails extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    //class to display the details of an actor
    Actor actor ;
    String actorId ;
    Context context;
    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actor_details);

        context = this;

        //added features to bar navigation
        NavigationView navigationView = (NavigationView) findViewById(R.id.menu_actor_details);
        navigationView.setNavigationItemSelectedListener(this);

        //fill in the actor's fields by accessing the database
        Intent intent = getIntent() ;
        mDatabase = FirebaseDatabase.getInstance().getReference();
        actorId = intent.getStringExtra("actorid");
        actor = new Actor() ;
        mDatabase.child("Actors").child(actorId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                actor = dataSnapshot.getValue(Actor.class);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        ImageView image = findViewById(R.id.actorPicture) ;
        image.setImageResource(actor.getPicture());

        TextView name = findViewById(R.id.actorName) ;
        name.setText(actor.getFirstname() + " " + actor.getLastname());

        TextView birthdate = findViewById(R.id.yearValue) ;
        birthdate.setText(actor.getBirthdate());

        TextView biography = findViewById(R.id.biographyValue) ;
        biography.setText(actor.getBiography());

        //button action to display the actor's movies
        final Button btnMovie = findViewById(R.id.moviesButton);
        btnMovie.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final List<Movie> movies = new ArrayList<>();
                mDatabase.child("movies").orderByChild("actorId").equalTo(actorId).addValueEventListener( new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot childDataSnapshot : dataSnapshot.getChildren()) {
                            movies.add(childDataSnapshot.getValue(Movie.class));
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
                //if the actor are not movie
                if(movies.isEmpty()){
                    Toast.makeText(ActorDetails.this, R.string.nothing, Toast.LENGTH_LONG).show();
                }
                else{

                    Intent intentMovie = new Intent(ActorDetails.this, Movies.class);
                    intentMovie.putExtra("actorid", actorId);
                    startActivity(intentMovie);
                }

            }
        });
    }



    //bar navigation button actions
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
                intent6.putExtra("actorid", actorId) ;
                startActivity(intent6);
                return true;

            case R.id.item_delete:
                        mDatabase.child("actors").child(""+actorId).removeValue();
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
