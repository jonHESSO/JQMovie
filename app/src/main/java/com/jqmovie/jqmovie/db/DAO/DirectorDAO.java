package com.jqmovie.jqmovie.db.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.jqmovie.jqmovie.db.Entities.Actor;
import com.jqmovie.jqmovie.db.Entities.Director;
import com.jqmovie.jqmovie.db.Entities.Movie;

import java.util.List;

/**
 * Created by Jonathan on 17.04.2018.
 */

/**
 * Interface for accessing the database and retrieving
 * , insertind, deleting and updating directors
 */

@Dao
public interface DirectorDAO {

    @Query("SELECT * FROM DIRECTORS")
    List<Director> getAll() ;

    @Query("SELECT * FROM DIRECTORS WHERE directorid = :directorid")
    Director getDirector(int directorid) ;

    @Insert
    void insertAll(List<Director> directors) ;

    @Insert
    void insert(Director director) ;

    @Update
    void update(Director director);

    @Delete
    void delete(Director director);
}
