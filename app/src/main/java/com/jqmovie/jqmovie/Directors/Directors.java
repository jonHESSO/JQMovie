package com.jqmovie.jqmovie.Directors;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import com.jqmovie.jqmovie.R;

public class Directors extends AppCompatActivity {

    GridView gridview;

    public static String[] directorList = {
            "James Cameron",
            "Steven Spielberg",
            "Chritopher Nolan",

    };
    public static int[] directorImages = {
            R.mipmap.cameron,
            R.mipmap.spielberg,
            R.mipmap.nolan,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directors);
        gridview = (GridView) findViewById(R.id.directorgrid);
        gridview.setAdapter(new DirectorAdapter(this, directorList, directorImages));
    }
}
