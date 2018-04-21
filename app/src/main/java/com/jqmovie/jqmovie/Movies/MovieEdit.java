package com.jqmovie.jqmovie.Movies;

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

import com.jqmovie.jqmovie.About.About;
import com.jqmovie.jqmovie.Actors.ActorEdit;
import com.jqmovie.jqmovie.Actors.Actors;
import com.jqmovie.jqmovie.Directors.Directors;
import com.jqmovie.jqmovie.R;
import com.jqmovie.jqmovie.Settings.Settings;

import java.util.Arrays;
import java.util.List;

public class MovieEdit extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    Button buttonDirector;
    Button buttonActor;

    AlertDialog.Builder alertdialogbuilderDirector;
    AlertDialog.Builder alertdialogbuilderActor;

    String[] AlertDialogItemsDirector = new String[]{
            "Cameron",
            "Spielberg",
            "Nolan",
    };
    String[] AlertDialogItemsActor = new String[]{
            "Burns",
            "Burstyn",
            "Caine",
            "Chastain",
            "Matt Damon",
            "Leoanardo DiCapaccio",
            "Tom Hanks",
            "Hathaway",
            "Irwin",
            "McConaughey",
            "Kate Winslet",
    };

    List<String> ItemsIntoListDirector;
    List<String> ItemsIntoListActor;

    boolean[] SelectedtruefalseDirector = new boolean[]{
            false,
            false,
            false,
    };
    boolean[] SelectedtruefalseActor = new boolean[]{
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_edit);

        //ajout des fonctionalités à la navigation bar
        NavigationView navigationView = (NavigationView) findViewById(R.id.menu_movie_edit);
        navigationView.setNavigationItemSelectedListener(this);



        //Ajout d'une alertDialog pour choisir les acteurs et le directeur du film
        buttonDirector = (Button)findViewById(R.id.btn_adddirector_movie);
        buttonActor = (Button)findViewById(R.id.btn_addactors_movie);

        buttonDirector.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                alertdialogbuilderDirector = new AlertDialog.Builder(MovieEdit.this);

                ItemsIntoListDirector = Arrays.asList(AlertDialogItemsDirector);

                alertdialogbuilderDirector.setMultiChoiceItems(AlertDialogItemsDirector, SelectedtruefalseDirector, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                    }
                });
                alertdialogbuilderDirector.setCancelable(false);

                alertdialogbuilderDirector.setTitle("Select Director Here");

                alertdialogbuilderDirector.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });


                AlertDialog dialog = alertdialogbuilderDirector.create();

                dialog.show();
            }
        });
        buttonActor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                alertdialogbuilderActor = new AlertDialog.Builder(MovieEdit.this);

                ItemsIntoListActor = Arrays.asList(AlertDialogItemsActor);

                alertdialogbuilderActor.setMultiChoiceItems(AlertDialogItemsActor, SelectedtruefalseActor, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                    }
                });
                alertdialogbuilderActor.setCancelable(false);

                alertdialogbuilderActor.setTitle("Select Actors Here");

                alertdialogbuilderActor.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });


                AlertDialog dialog = alertdialogbuilderActor.create();

                dialog.show();
            }
        });
    }

    //actions des boutons de la navigation bar
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_actor:
                Intent intent1 = new Intent(MovieEdit.this, Actors.class);
                startActivity(intent1);
                return true;

            case R.id.item_director:
                Intent intent2 = new Intent(MovieEdit.this, Directors.class);
                startActivity(intent2);
                return true;

            case R.id.item_movie:
                Intent intent3 = new Intent(MovieEdit.this, Movies.class);
                startActivity(intent3);
                return true;

            case R.id.item_about:
                Intent intent4 = new Intent(MovieEdit.this, About.class);
                startActivity(intent4);
                return true;

            case R.id.item_settings:
                Intent intent5 = new Intent(MovieEdit.this, Settings.class);
                startActivity(intent5);
                return true;

            default:
                return false;
        }
    }
}
