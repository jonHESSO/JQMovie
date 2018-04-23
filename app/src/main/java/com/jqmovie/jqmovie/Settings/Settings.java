package com.jqmovie.jqmovie.Settings;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.jqmovie.jqmovie.About.About;
import com.jqmovie.jqmovie.Actors.Actors;
import com.jqmovie.jqmovie.BuildConfig;
import com.jqmovie.jqmovie.Directors.Directors;
import com.jqmovie.jqmovie.Movies.Movies;
import com.jqmovie.jqmovie.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Settings extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        //ajout des fonctionalité à la navigation bar
        NavigationView navigationView = (NavigationView) findViewById(R.id.menu_settings);
        navigationView.setNavigationItemSelectedListener(this);

        // creer spinner
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);

        // remplir le spinner
        List<String> categories = new ArrayList<String>();
        categories.add(getString(R.string.english));
        categories.add(getString(R.string.french));
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
    }

    //Séléction d'une langue
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();

        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    //action des boutons
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_actor:
                Intent intent1 = new Intent(Settings.this, Actors.class);
                startActivity(intent1);
                return true;

            case R.id.item_director:
                Intent intent2 = new Intent(Settings.this, Directors.class);
                startActivity(intent2);
                return true;

            case R.id.item_movie:
                Intent intent3 = new Intent(Settings.this, Movies.class);
                startActivity(intent3);
                return true;

            case R.id.item_about:
                Intent intent4 = new Intent(Settings.this, About.class);
                startActivity(intent4);
                return true;

            case R.id.item_settings:
                Intent intent5 = new Intent(Settings.this, Settings.class);
                startActivity(intent5);
                return true;

            default:
                return false;
        }
    }
}
