package com.jqmovie.jqmovie.db.Entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import com.jqmovie.jqmovie.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jonathan on 17.04.2018.
 */

/**
 * Entity model for Movie
 */

@Entity(tableName = "MOVIES", foreignKeys =
        {@ForeignKey(   entity = Director.class,
                parentColumns = "directorid",
                childColumns = "directorid",
                onDelete = ForeignKey.CASCADE),
        @ForeignKey(entity = Actor.class,
                parentColumns = "actorid",
                childColumns = "actorid",
                onDelete = ForeignKey.CASCADE)})
public class Movie {

    @PrimaryKey(autoGenerate = true)
    private int movieid;

    private String title;
    private String year;
    private String genre;
    private String synopsis;
    private int picture;

    private int directorid;

    private int actorid;

    public Movie(int movieid, String title, String year, String genre, String synopsis, int picture, int directorid, int actorid) {
        this.movieid = movieid;
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.synopsis = synopsis;
        this.picture = picture;
        this.directorid = directorid;
        this.actorid = actorid;
    }

    public Movie(){};

    public int getMovieid() {
        return movieid;
    }

    public void setMovieid(int movieid) {
        this.movieid = movieid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public int getDirectorid() {
        return directorid;
    }

    public void setDirectorid(int directorid) {
        this.directorid = directorid;
    }

    public int getActorid() {
        return actorid;
    }

    public void setActorid(int actorid) {
        this.actorid = actorid;
    }

    //method for populating database on first run
    public static List<Movie> populateData()
    {
        List<Movie> movieList = new ArrayList<>();

        movieList.add(new Movie(1,"Titanic","1997","Drame","In September 1996, Brock Lovett was the coordinator of a team that meticulously searched the wreck of the Titanic, a giant, unsinkable liner that nevertheless knew a tragic fate. During a miniature submarine dive, he hopes to finally get his hands on the Heart of the Ocean, a unique jewel of inestimable value, worn by Louis XVI, whose discovery would bring him glory (this jewel is inspired by the blue diamond of the Crown). But there comes up from the depths a safe which turns out to contain only a drawing representing a naked girl wearing the pendant jewel. Thousands of miles away, an old lady, Rose Calvert, discovers this drawing on her television screen. She contacts Lovett and tells her that she is the girl in question. As one of the few survivors of the sinking of the Titanic still alive, she is taken on Lovett's crew boat and tells them about the ship's inaugural cruise, her sinking, and the love story she experienced with Jack Dawson, a third-class traveling artist.", R.mipmap.titanic,1,1)) ;
        movieList.add(new Movie(2,"Catch Me If You Can","2002","Dramatic Comedy","In the sixties, young Frank Abagnale Jr. has become a master in the art of swindling, going so far as to embezzle $2.5 million and appear on FBI lists as one of the ten most wanted individuals in the United States. A true chameleon, Frank has identities as diverse as those of airline pilot, doctor, university professor or assistant prosecutor. Carl Hanratty, a strict-looking FBI agent, is stalking Frank Abagnale Jr. his priority mission, but the latter remains elusive for a long time...", R.mipmap.catchme,2,3)) ;
        movieList.add(new Movie(3,"Saving Private Ryan","1998","War","As Allied forces land at Omaha Beach, Miller must lead his squad behind enemy lines on a particularly dangerous mission: to find and bring back safe and sound Private James Ryan, whose three brothers died in action within three days. As the squad advances into enemy territory, Miller's men ask questions. Do we have to risk the lives of eight men to save one?", R.mipmap.ryan,2,4)) ;
        movieList.add(new Movie(4,"Interstellar","2014","Science-Fiction","The film tells the adventures of a group of explorers who use a recently discovered rift in space-time to push human limits and conquer astronomical distances in an interstellar journey.", R.mipmap.interstellar,3,6)) ;
        return movieList ;



    }
}
