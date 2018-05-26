package com.jqmovie.jqmovie.Directors;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.GridView;

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

import java.util.ArrayList;
import java.util.List;

public class Directors extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener{
    //class to display all the director of the db
    GridView gridview;
    DatabaseReference mDatabase;

    List<Director> directorList = new ArrayList<>();
    DirectorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directors);

        mDatabase = FirebaseDatabase.getInstance().getReference();



        //gridLayout creation
        gridview = (GridView) findViewById(R.id.directorgrid);





        adapter = new DirectorAdapter(this, directorList);
        gridview.setAdapter(adapter);

        mDatabase.child("Directors").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                directorList.clear();
                for(DataSnapshot snapshot : dataSnapshot.getChildren())
                {
                    Director director ;
                    director = (Director)snapshot.getValue(Director.class);
                    director.setDirectorid(snapshot.getKey());
                    directorList.add(director);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



        //added features to bar navigation
        NavigationView navigationView = (NavigationView) findViewById(R.id.menu_director);
        navigationView.setNavigationItemSelectedListener(this);
    }

    //bar navigation button action
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_actor:
                Intent intent1 = new Intent(Directors.this, Actors.class);
                startActivity(intent1);
                return true;

            case R.id.item_director:
                Intent intent2 = new Intent(Directors.this, Directors.class);
                startActivity(intent2);
                return true;

            case R.id.item_movie:
                Intent intent3 = new Intent(Directors.this, Movies.class);
                startActivity(intent3);
                return true;

            case R.id.item_about:
                Intent intent4 = new Intent(Directors.this, About.class);
                startActivity(intent4);
                return true;

            case R.id.item_settings:
                Intent intent5 = new Intent(Directors.this, Settings.class);
                startActivity(intent5);
                return true;

            case R.id.item_add:
                Intent intent6 = new Intent(Directors.this, DirectorEdit.class);
                startActivity(intent6);
                return true;

            default:
                return false;
        }
    }
}
