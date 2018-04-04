package com.jqmovie.jqmovie.Actors;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import com.jqmovie.jqmovie.R;

public class Actors extends AppCompatActivity {

    GridView gridview;

    public static String[] actorList = {
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
    public static int[] actorImages = {
            R.mipmap.burns,
            R.mipmap.burstyn,
            R.mipmap.caine,
            R.mipmap.chastain,
            R.mipmap.damon,
            R.mipmap.dicaprio,
            R.mipmap.hanks,
            R.mipmap.hathaway,
            R.mipmap.irwin,
            R.mipmap.mcconaughey,
            R.mipmap.winslet,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actors);
        gridview = (GridView) findViewById(R.id.actorgrid);
        gridview.setAdapter(new ActorAdapter(this, actorList, actorImages));
    }

}
