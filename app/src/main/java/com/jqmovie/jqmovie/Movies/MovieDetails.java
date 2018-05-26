package com.jqmovie.jqmovie.Movies;

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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jqmovie.jqmovie.About.About;
import com.jqmovie.jqmovie.Actors.ActorDetails;
import com.jqmovie.jqmovie.Actors.Actors;
import com.jqmovie.jqmovie.Directors.DirectorDetails;
import com.jqmovie.jqmovie.Directors.Directors;
import com.jqmovie.jqmovie.R;
import com.jqmovie.jqmovie.Settings.Settings;

import com.jqmovie.jqmovie.db.Entities.Movie;

public class MovieDetails extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    //class to display the details of a movie
    Movie movie;
    String movieid;
    DatabaseReference mDatabase;

    ImageView image ;
    TextView name;
    TextView year ;
    TextView genre ;
    TextView synopsis ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        //added features to bar navigation
        NavigationView navigationView = (NavigationView) findViewById(R.id.menu_movie_details);
        navigationView.setNavigationItemSelectedListener(this);

        image = findViewById(R.id.moviePicture) ;
        name = findViewById(R.id.name) ;
        year = findViewById(R.id.yearValue) ;
        genre = findViewById(R.id.genreValue) ;
        synopsis = findViewById(R.id.synopsisValue) ;

        mDatabase = FirebaseDatabase.getInstance().getReference();

        //fill in the actor's fields by accessing the database
        Intent intent = getIntent() ;
        movieid = intent.getStringExtra("movieid");
        mDatabase.child("Movies").child(intent.getStringExtra("movieid")).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()) {
                    movie = dataSnapshot.getValue(Movie.class);
                    String picturename = movie.getPicture();
                    int ressourceId = getResources().getIdentifier(picturename, "drawable", getPackageName());
                    image.setImageResource(ressourceId);
                    name.setText(movie.getName());
                    year.setText(movie.getYear());
                    genre.setText(movie.getGenre());
                    synopsis.setText(movie.getSynopsis());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });





        //button action to display the movie's director
        final Button btnDirector = findViewById(R.id.moviesButton);
        btnDirector.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intentDirector = new Intent(MovieDetails.this, DirectorDetails.class);
                intentDirector.putExtra("directorid", movie.getDirector());
                startActivity(intentDirector);
            }
        });
        //button action to display the movie's actor
        final Button btnActor = findViewById(R.id.actorButton);
        btnActor.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intentActor = new Intent(MovieDetails.this, ActorDetails.class);
                intentActor.putExtra("actorid", movie.getActor());
                startActivity(intentActor);
            }
        });

    }

    //bar navigation button actions
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_actor:
                Intent intent1 = new Intent(MovieDetails.this, Actors.class);
                startActivity(intent1);
                return true;

            case R.id.item_director:
                Intent intent2 = new Intent(MovieDetails.this, Directors.class);
                startActivity(intent2);
                return true;

            case R.id.item_movie:
                Intent intent3 = new Intent(MovieDetails.this, Movies.class);
                startActivity(intent3);
                return true;

            case R.id.item_about:
                Intent intent4 = new Intent(MovieDetails.this, About.class);
                startActivity(intent4);
                return true;

            case R.id.item_settings:
                Intent intent5 = new Intent(MovieDetails.this, Settings.class);
                startActivity(intent5);
                return true;

            case R.id.item_edit:
                Intent intent6 = new Intent(MovieDetails.this, MovieEdit.class);
                intent6.putExtra("movieid", movieid);
                startActivity(intent6);
                return true;

            case R.id.item_delete:
                mDatabase.child("Movies").child(movieid).removeValue();
                Intent intent7 = new Intent(MovieDetails.this, Movies.class);
                intent7.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent7);
                MovieDetails.this.finish();
                return true;

            default:
                return false;
        }
    }
    //this method allows to update this class before it is in foreground
    @Override
    protected void onResume() {

        super.onResume();
        /*
        Actor actor = AppDatabase.getAppDatabase(MovieDetails.this).actorDAO().getActor(movie.getActor());
        if(actor==null){MovieDetails.this.finish();}
        */
    }
}
