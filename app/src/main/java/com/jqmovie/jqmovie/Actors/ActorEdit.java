package com.jqmovie.jqmovie.Actors;

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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jqmovie.jqmovie.About.About;
import com.jqmovie.jqmovie.Directors.Directors;
import com.jqmovie.jqmovie.Movies.Movies;
import com.jqmovie.jqmovie.R;
import com.jqmovie.jqmovie.Settings.Settings;
import com.jqmovie.jqmovie.db.Entities.Actor;

import java.util.Arrays;
import java.util.List;

public class ActorEdit extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    //class to edit and add an actor
    Actor actor ;
    Boolean create = true ;
    String actorId;

    DatabaseReference mDatabase ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actor_edit);

        //added features to bar navigation
        NavigationView navigationView = (NavigationView) findViewById(R.id.menu_actor_edit);
        navigationView.setNavigationItemSelectedListener(this);

        final TextView firstnameView = findViewById(R.id.edit_firstname_actor) ;
        final TextView lastnameView = findViewById(R.id.edit_lastname_actor) ;
        final TextView birthdateView = findViewById(R.id.edit_birthdate_actor) ;
        final TextView biographyView = findViewById(R.id.edit_biography_actor) ;

        Intent intent = getIntent() ;

        mDatabase = FirebaseDatabase.getInstance().getReference();

        //edit an actor
        actor = new Actor();
        if(intent.getExtras() != null && intent.getExtras().containsKey("actorid"))
        {
            actorId = intent.getStringExtra("actorid");
            create = false ;
            mDatabase.child("Actors").child(actorId).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    actor = dataSnapshot.getValue(Actor.class);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
            firstnameView.setText(actor.getFirstname());
            lastnameView.setText(actor.getLastname());
            birthdateView.setText(actor.getBirthdate());
            biographyView.setText(actor.getBiography());
        }

    //action button
        Button button = findViewById(R.id.btn_submit_actor) ;
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //get the actor's info
                actor.setFirstname(firstnameView.getText().toString());
                actor.setLastname(lastnameView.getText().toString());
                actor.setBirthdate(birthdateView.getText().toString());
                actor.setBiography(biographyView.getText().toString());
                //edit the actor
                if(create == false) {
                    mDatabase.child("Actors").child(actorId).setValue(actor);
                }
                //add the actor
                else
                {
                    actor.setPicture(R.mipmap.actors);
                    DatabaseReference childref = mDatabase.child("Actors").push();
                    childref.setValue(actor);
            }
                Intent intent = new Intent(view.getContext(), Actors.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        }) ;

    }

    //bar navigation button actions
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_actor:
                Intent intent1 = new Intent(ActorEdit.this, Actors.class);
                startActivity(intent1);
                return true;

            case R.id.item_director:
                Intent intent2 = new Intent(ActorEdit.this, Directors.class);
                startActivity(intent2);
                return true;

            case R.id.item_movie:
                Intent intent3 = new Intent(ActorEdit.this, Movies.class);
                startActivity(intent3);
                return true;

            case R.id.item_about:
                Intent intent4 = new Intent(ActorEdit.this, About.class);
                startActivity(intent4);
                return true;

            case R.id.item_settings:
                Intent intent5 = new Intent(ActorEdit.this, Settings.class);
                startActivity(intent5);
                return true;

            default:
                return false;
        }
    }
}
