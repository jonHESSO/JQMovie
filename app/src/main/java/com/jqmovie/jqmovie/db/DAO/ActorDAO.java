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
 * , insertind, deleting and updating actors
 */

@Dao
public interface ActorDAO {

    @Query("SELECT * FROM ACTORS")
    List<Actor> getAll() ;

    @Query("SELECT * FROM ACTORS WHERE actorid = :actorid")
    Actor getActor(int actorid) ;

    @Insert
    void insertAll(List<Actor> actors) ;

    @Insert
    void insert(Actor actor) ;

    @Update
    void update(Actor actor);

    @Delete
    void delete(Actor actor);

}
