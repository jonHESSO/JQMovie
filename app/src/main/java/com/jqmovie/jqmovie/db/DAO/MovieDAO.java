package com.jqmovie.jqmovie.db.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.jqmovie.jqmovie.db.Entities.Actor;
import com.jqmovie.jqmovie.db.Entities.Movie;

import java.util.List;

/**
 * Created by Jonathan on 17.04.2018.
 */

/**
 * Interface for accessing the database and retrieving
 * , insertind, deleting and updating movies
 */

@Dao
public interface MovieDAO {

    @Query("SELECT * FROM MOVIES")
    List<Movie> getAll() ;

    @Query("SELECT * FROM MOVIES WHERE movieid = :movieid")
    Movie getMovie(int movieid) ;

    @Insert
    void insertAll(List<Movie> movies) ;

    @Update
    void update(Movie movie);

    @Insert
    void insert(Movie movie);

    @Delete
    void delete(Movie movie);

    @Query("SELECT * FROM MOVIES WHERE actorid Like :actorid")
    List<Movie> getMovieFromActor(int actorid) ;

    @Query("SELECT * FROM MOVIES WHERE directorid = :directorid")
    List<Movie> getMovieFromDirector(int directorid) ;
}
