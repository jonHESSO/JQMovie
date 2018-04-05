package com.jqmovie.jqmovie.Actors;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jqmovie.jqmovie.R;

import java.util.Arrays;
import java.util.List;

public class ActorEdit extends AppCompatActivity {


    Button button;

    AlertDialog.Builder alertdialogbuilder;

    String[] AlertDialogItems = new String[]{
            "Titanic",
            "Catch me if you can",
            "Saving private Ryan",
            "Interstellar",
    };

    List<String> ItemsIntoList;

    boolean[] Selectedtruefalse = new boolean[]{
            false,
            false,
            false,
            false,
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actor_edit);

        button = (Button)findViewById(R.id.btn_addmovie_actor);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                alertdialogbuilder = new AlertDialog.Builder(ActorEdit.this);

                ItemsIntoList = Arrays.asList(AlertDialogItems);

                alertdialogbuilder.setMultiChoiceItems(AlertDialogItems, Selectedtruefalse, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                    }
                });
                alertdialogbuilder.setCancelable(false);

                alertdialogbuilder.setTitle("Select Movies Here");

                alertdialogbuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });


                AlertDialog dialog = alertdialogbuilder.create();

                dialog.show();
            }
        });
    }
}
