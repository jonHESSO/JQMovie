package com.jqmovie.jqmovie.db.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.jqmovie.jqmovie.db.Entities.Actor;
import com.jqmovie.jqmovie.db.Entities.Movie;

import java.util.List;

/**
 * Created by Jonathan on 17.04.2018.
 */

@Dao

public interface MovieDAO {

    @Query("SELECT * FROM MOVIES")
    List<Movie> getAll() ;

    @Query("SELECT * FROM MOVIES WHERE movieid = :movieid")
    Movie getMovie(int movieid) ;

    @Insert
    void insertAll(List<Movie> movies) ;

}
