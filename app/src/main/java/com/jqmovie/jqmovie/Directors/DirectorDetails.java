package com.jqmovie.jqmovie.Directors;

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
import com.jqmovie.jqmovie.Actors.Actors;
import com.jqmovie.jqmovie.Movies.Movies;
import com.jqmovie.jqmovie.R;
import com.jqmovie.jqmovie.Settings.Settings;
import com.jqmovie.jqmovie.db.Entities.Director;
import com.jqmovie.jqmovie.db.Entities.Movie;

import java.util.ArrayList;
import java.util.List;

public class DirectorDetails extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    //class to display the details of a director
    Director director;
    String directorId ;
    Context context;
    DatabaseReference mDatabase;
    List<Movie> movies ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_director_details);

        context = this;

        //added features to bar navigation
        NavigationView navigationView = (NavigationView) findViewById(R.id.menu_director_details);
        navigationView.setNavigationItemSelectedListener(this);

        //fill in the director's fields by accessing the database
        Intent intent = getIntent() ;
        mDatabase = FirebaseDatabase.getInstance().getReference();
        directorId = intent.getStringExtra("directorid");
        director = new Director() ;
        mDatabase.child("Directors").child(directorId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()) {
                    director = dataSnapshot.getValue(Director.class);
                    setContent();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }

    private void setContent()
    {
        ImageView image = findViewById(R.id.directorPicture) ;

        String picturename = director.getPicture();
        int ressourceId = context.getResources().getIdentifier(picturename, "drawable", context.getPackageName());

        image.setImageResource(ressourceId);

        TextView name = findViewById(R.id.name) ;
        name.setText(director.getFirstname() + " " + director.getLastname());

        TextView birthdate = findViewById(R.id.yearValue) ;
        birthdate.setText(director.getBirthdate());

        TextView biography = findViewById(R.id.biographyValue) ;
        biography.setText(director.getBiography());

        movies = new ArrayList<>();
        mDatabase.child("Movies").addValueEventListener( new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot childDataSnapshot : dataSnapshot.getChildren()) {
                    Movie movie ;
                    movie = childDataSnapshot.getValue(Movie.class);
                    movie.setMovieid(childDataSnapshot.getKey());
                    if(movie.getDirector().equals(directorId)) {
                        movies.add(movie);
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        //button action to display the director's movies
        final Button btnMovie = findViewById(R.id.moviesButton);
        btnMovie.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //if the actor are not movie
                if(movies.isEmpty()){
                    Toast.makeText(DirectorDetails.this, R.string.nothing, Toast.LENGTH_LONG).show();
                }
                else{

                    Intent intentMovie = new Intent(DirectorDetails.this, Movies.class);
                    intentMovie.putExtra("directorid", directorId);
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
                Intent intent1 = new Intent(DirectorDetails.this, Actors.class);
                startActivity(intent1);
                return true;

            case R.id.item_director:
                Intent intent2 = new Intent(DirectorDetails.this, Directors.class);
                startActivity(intent2);
                return true;

            case R.id.item_movie:
                Intent intent3 = new Intent(DirectorDetails.this, Movies.class);
                startActivity(intent3);
                return true;

            case R.id.item_about:
                Intent intent4 = new Intent(DirectorDetails.this, About.class);
                startActivity(intent4);
                return true;

            case R.id.item_settings:
                Intent intent5 = new Intent(DirectorDetails.this, Settings.class);
                startActivity(intent5);
                return true;

            case R.id.item_edit:
                Intent intent6 = new Intent(DirectorDetails.this, DirectorEdit.class);
                intent6.putExtra("directorid", directorId) ;
                startActivity(intent6);
                return true;

            case R.id.item_delete:
                mDatabase.child("Directors").child(directorId).removeValue();
                /*
                final List<Movie> movies = new ArrayList<>();
                mDatabase.child("Movies").orderByChild("directorId").equalTo(directorId).addValueEventListener( new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot childDataSnapshot : dataSnapshot.getChildren()) {
                            Movie movie ;
                            movie = childDataSnapshot.getValue(Movie.class);
                            movie.setMovieid(childDataSnapshot.getKey());
                            movies.add(movie);
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
                if(!(movies.isEmpty())){
                    for (Movie m : movies) {
                        mDatabase.child("Movies").child(m.getMovieid()).removeValue();
                    }

                }
                */
                Intent intent7 = new Intent(DirectorDetails.this, Directors.class);
                intent7.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent7);
                DirectorDetails.this.finish();
                return true;

            default:
                return false;
        }
    }
}
