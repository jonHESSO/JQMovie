package com.jqmovie.jqmovie.Actors;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.widget.GridView;
import android.widget.Toast;

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

import java.util.ArrayList;
import java.util.List;

public class Actors extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    //class to display all the actor of the db
    GridView gridview;
    DatabaseReference mDatabase;

    List<Actor> actorList = new ArrayList<>();
    ActorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actors);

        mDatabase = FirebaseDatabase.getInstance().getReference();



        //gridLayout creation
        gridview = (GridView) findViewById(R.id.actorgrid);



        adapter = new ActorAdapter(this, actorList);
        gridview.setAdapter(adapter);

        mDatabase.child("Actors").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.getChildren())
                {
                    Actor actor ;
                    actor = (Actor)snapshot.getValue(Actor.class);
                    actor.setActorId(snapshot.getKey());
                    actorList.add(actor);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        //added features to bar navigation
        NavigationView navigationView = (NavigationView) findViewById(R.id.menu_actor);
        navigationView.setNavigationItemSelectedListener(this);
    }


    //bar navigation button action
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_actor:
                Intent intent1 = new Intent(Actors.this, Actors.class);
                startActivity(intent1);
                return true;

            case R.id.item_director:
                Intent intent2 = new Intent(Actors.this, Directors.class);
                startActivity(intent2);
                return true;

            case R.id.item_movie:
                Intent intent3 = new Intent(Actors.this, Movies.class);
                startActivity(intent3);
                return true;

            case R.id.item_about:
                Intent intent4 = new Intent(Actors.this, About.class);
                startActivity(intent4);
                return true;

            case R.id.item_settings:
                Intent intent5 = new Intent(Actors.this, Settings.class);
                startActivity(intent5);
                return true;

            case R.id.item_add:
                Intent intent6 = new Intent(Actors.this, ActorEdit.class);
                startActivity(intent6);
                return true;

            default:
                return false;
        }
    }

}
