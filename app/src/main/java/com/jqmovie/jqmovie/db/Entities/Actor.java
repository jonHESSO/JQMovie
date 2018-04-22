package com.jqmovie.jqmovie.db.Entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.jqmovie.jqmovie.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Jonathan on 17.04.2018.
 */

@Entity(tableName = "ACTORS")

public class Actor {

    @PrimaryKey/*(autoGenerate = true)*/
    private int actorid ;

    private String firstname;
    private String lastname;
    private String birthdate;
    private String biography ;
    private int picture;

    public Actor(int actorid, String firstname, String lastname, String birthdate, String biography, int picture) {
        this.actorid = actorid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.biography = biography;
        this.picture = picture;
    }

    public int getActorid() {
        return actorid;
    }

    public void setActorid(int actorid) {
        this.actorid = actorid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public static List<Actor> populateData()
    {
        List<Actor> actorList = new ArrayList<>();

        actorList.add(new Actor(1,"Leonardo","Di Caprio", "1980", "pretty boy", R.mipmap.dicaprio)) ;
        actorList.add(new Actor(2,"Matt Damon","Damon", "2000", "Tough boy",R.mipmap.damon)) ;

        return actorList ;



    }

}
