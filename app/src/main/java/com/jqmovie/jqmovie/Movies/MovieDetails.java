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

import com.jqmovie.jqmovie.About.About;
import com.jqmovie.jqmovie.Actors.ActorDetails;
import com.jqmovie.jqmovie.Actors.Actors;
import com.jqmovie.jqmovie.Directors.DirectorDetails;
import com.jqmovie.jqmovie.Directors.Directors;
import com.jqmovie.jqmovie.R;
import com.jqmovie.jqmovie.Settings.Settings;
import com.jqmovie.jqmovie.db.AppDatabase;
import com.jqmovie.jqmovie.db.Entities.Movie;

public class MovieDetails extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        //ajout des fonctionalité à la navigation bar
        NavigationView navigationView = (NavigationView) findViewById(R.id.menu_movie_details);
        navigationView.setNavigationItemSelectedListener(this);

        Intent intent = getIntent() ;
        final Movie movie = AppDatabase.getAppDatabase(this).movieDAO().getMovie(intent.getIntExtra("movieid", 0)) ;

        ImageView image = findViewById(R.id.moviePicture) ;
        image.setImageResource(movie.getPicture());

        TextView name = findViewById(R.id.name) ;
        name.setText(movie.getTitle());

        TextView year = findViewById(R.id.yearValue) ;
        year.setText(movie.getYear());

        TextView genre = findViewById(R.id.genreValue) ;
        genre.setText(movie.getGenre());

        TextView synopsis = findViewById(R.id.synopsisValue) ;
        synopsis.setText(movie.getSynopsis());

        final Button btnDirector = findViewById(R.id.moviesButton);
        btnDirector.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intentDirector = new Intent(MovieDetails.this, DirectorDetails.class);
                intentDirector.putExtra("directorid", movie.getDirectorid());
                startActivity(intentDirector);
            }
        });

        final Button btnActor = findViewById(R.id.actorButton);
        btnActor.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intentActor = new Intent(MovieDetails.this, ActorDetails.class);
                intentActor.putExtra("actorid", movie.getActorid());
                startActivity(intentActor);
            }
        });

    }

    //actions des boutons de la navigation bar
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
                startActivity(intent6);
                return true;

            case R.id.item_delete:
                return true;

            default:
                return false;
        }
    }
}
