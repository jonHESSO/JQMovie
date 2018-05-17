package com.jqmovie.jqmovie.db.Entities;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jonathan on 17.04.2018.
 */

/**
 * Entity model for Movie
 */

@IgnoreExtraProperties
public class Movie {

    @Exclude
    private String movieid;

    private String Name;
    private String Year;
    private String Genre;
    private String Synopsis;
    private String Picture;
    private String Director;
    private String Actor;

    public Movie(String movieid, String title, String year, String genre, String synopsis, String picture, String directorid, String actorid) {
        this.movieid = movieid;
        this.Name = title;
        this.Year = year;
        this.Genre = genre;
        this.Synopsis = synopsis;
        this.Picture = picture;
        this.Director = directorid;
        this.Actor = actorid;
    }

    public Movie(){};

    @Exclude
    public String getMovieid() {
        return movieid;
    }

    public void setMovieid(String movieid) {
        this.movieid = movieid;
    }

    public String getName() {
        return Name;
    }

    public void setName(String title) {
        this.Name = title;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        this.Year = year;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        this.Genre = genre;
    }

    public String getSynopsis() {
        return Synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.Synopsis = synopsis;
    }

    public String getPicture() {
        return Picture;
    }

    public void setPicture(String picture) {
        this.Picture = picture;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        this.Director = director;
    }

    public String getActor() {
        return Actor;
    }

    public void setActor(String actorid) {
        this.Actor = actorid;
    }

    //method for populating database on first run
    @Exclude
    public static List<Movie> populateData()
    {
        List<Movie> movieList = new ArrayList<>();

        /*
        movieList.add(new Movie("1","Titanic","1997","Drame","In September 1996, Brock Lovett was the coordinator of a team that meticulously searched the wreck of the Titanic, a giant, unsinkable liner that nevertheless knew a tragic fate. During a miniature submarine dive, he hopes to finally get his hands on the Heart of the Ocean, a unique jewel of inestimable value, worn by Louis XVI, whose discovery would bring him glory (this jewel is inspired by the blue diamond of the Crown). But there comes up from the depths a safe which turns out to contain only a drawing representing a naked girl wearing the pendant jewel. Thousands of miles away, an old lady, Rose Calvert, discovers this drawing on her television screen. She contacts Lovett and tells her that she is the girl in question. As one of the few survivors of the sinking of the Titanic still alive, she is taken on Lovett's crew boat and tells them about the ship's inaugural cruise, her sinking, and the love story she experienced with Jack Dawson, a third-class traveling artist.", "titanic","1","1")) ;
        movieList.add(new Movie("2","Catch Me If You Can","2002","Dramatic Comedy","In the sixties, young Frank Abagnale Jr. has become a master in the art of swindling, going so far as to embezzle $2.5 million and appear on FBI lists as one of the ten most wanted individuals in the United States. A true chameleon, Frank has identities as diverse as those of airline pilot, doctor, university professor or assistant prosecutor. Carl Hanratty, a strict-looking FBI agent, is stalking Frank Abagnale Jr. his priority mission, but the latter remains elusive for a long time...", "catchme","2","3")) ;
        movieList.add(new Movie("3","Saving Private Ryan","1998","War","As Allied forces land at Omaha Beach, Miller must lead his squad behind enemy lines on a particularly dangerous mission: to find and bring back safe and sound Private James Ryan, whose three brothers died in action within three days. As the squad advances into enemy territory, Miller's men ask questions. Do we have to risk the lives of eight men to save one?", "ryan","2","4")) ;
        movieList.add(new Movie("4","Interstellar","2014","Science-Fiction","The film tells the adventures of a group of explorers who use a recently discovered rift in space-time to push human limits and conquer astronomical distances in an interstellar journey.", "interstellar","3","6")) ;
        */
        return movieList ;



    }
}
