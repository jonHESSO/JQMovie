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

import com.jqmovie.jqmovie.About.About;
import com.jqmovie.jqmovie.Actors.Actors;
import com.jqmovie.jqmovie.Movies.Movies;
import com.jqmovie.jqmovie.R;
import com.jqmovie.jqmovie.Settings.Settings;
import com.jqmovie.jqmovie.db.AppDatabase;
import com.jqmovie.jqmovie.db.Entities.Director;
import com.jqmovie.jqmovie.db.Entities.Movie;

import java.util.List;

public class DirectorDetails extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    Director director;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_director_details);

        context = this;

        //ajout des fonctionalité à la navigation bar
        NavigationView navigationView = (NavigationView) findViewById(R.id.menu_director_details);
        navigationView.setNavigationItemSelectedListener(this);

        Intent intent = getIntent() ;
        director = AppDatabase.getAppDatabase(this).directorDAO().getDirector(intent.getIntExtra("directorid", 0)) ;

        ImageView image = findViewById(R.id.directorPicture) ;
        image.setImageResource(director.getPicture());

        TextView name = findViewById(R.id.name) ;
        name.setText(director.getFirstname() + " " + director.getLastname());

        TextView birthdate = findViewById(R.id.yearValue) ;
        birthdate.setText(director.getBirthdate());

        TextView biography = findViewById(R.id.biographyValue) ;
        biography.setText(director.getBiography());

        final Button btnMovie = findViewById(R.id.moviesButton);
        btnMovie.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                List<Movie> movies= AppDatabase.getAppDatabase(DirectorDetails.this).movieDAO().getMovieFromDirector(director.getDirectorid()) ;
                if(movies.isEmpty()){
                    Toast.makeText(DirectorDetails.this, R.string.nothing, Toast.LENGTH_LONG).show();
                }
                else{

                    Intent intentMovie = new Intent(DirectorDetails.this, Movies.class);
                    intentMovie.putExtra("directorid", director.getDirectorid());
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
                intent6.putExtra("directorid", director.getDirectorid()) ;
                startActivity(intent6);
                return true;

            case R.id.item_delete:
                AppDatabase.getAppDatabase(getParent()).directorDAO().delete(director);
                Intent intent7 = new Intent(DirectorDetails.this, Directors.class);
                intent7.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent7);
                return true;

            default:
                return false;
        }
    }
}
