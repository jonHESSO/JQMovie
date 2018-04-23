package com.jqmovie.jqmovie.Actors;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.jqmovie.jqmovie.About.About;
import com.jqmovie.jqmovie.Directors.Directors;
import com.jqmovie.jqmovie.Movies.Movies;
import com.jqmovie.jqmovie.R;
import com.jqmovie.jqmovie.Settings.Settings;
import com.jqmovie.jqmovie.db.AppDatabase;
import com.jqmovie.jqmovie.db.Entities.Actor;

public class ActorDetails extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actor_details);

        //ajout des fonctionalité à la navigation bar
        NavigationView navigationView = (NavigationView) findViewById(R.id.menu_actor_details);
        navigationView.setNavigationItemSelectedListener(this);

        Intent intent = getIntent() ;
        Actor actor = AppDatabase.getAppDatabase(this).actorDAO().getActor(intent.getIntExtra("actorid", 0)) ;

        ImageView image = findViewById(R.id.actorPicture) ;
        image.setImageResource(actor.getPicture());

        TextView name = findViewById(R.id.actorName) ;
        name.setText(actor.getFirstname() + " " + actor.getLastname());

        TextView birthdate = findViewById(R.id.yearValue) ;
        birthdate.setText(actor.getBirthdate());

        TextView biography = findViewById(R.id.biographyValue) ;
        biography.setText(actor.getBiography());


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
                startActivity(intent6);
                return true;

            case R.id.item_delete:
                return true;

            default:
                return false;
        }
    }
}
