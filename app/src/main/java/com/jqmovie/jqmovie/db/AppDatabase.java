package com.jqmovie.jqmovie.db;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.jqmovie.jqmovie.db.DAO.ActorDAO;
import com.jqmovie.jqmovie.db.DAO.DirectorDAO;
import com.jqmovie.jqmovie.db.DAO.MovieDAO;
import com.jqmovie.jqmovie.db.Entities.Actor;
import com.jqmovie.jqmovie.db.Entities.Director;
import com.jqmovie.jqmovie.db.Entities.Movie;

import java.util.concurrent.Executors;

/**
 * Created by Jonathan on 17.04.2018.
 */

/**
 * Database entity used to connect to the database
 * and execute the different queries from the DOAs
 */

@Database(entities = {Actor.class, Director.class, Movie.class}, version = 1)

public abstract class AppDatabase extends RoomDatabase{

    //Instance of database entity
    private static AppDatabase INSTANCE;

    //methods to access the DAOs
    public abstract ActorDAO actorDAO();
    public abstract DirectorDAO directorDAO();
    public abstract MovieDAO movieDAO();

    private static final Object LOCK = new Object();

    //static method to retrieve database instance
    public synchronized static AppDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = buildDatabase(context);
        }
        return INSTANCE;
    }

    //static method to build database
    private static AppDatabase buildDatabase(final Context context) {
        return Room.databaseBuilder(context,
                AppDatabase.class,
                "my-database")
                //populates the database on creation
                .addCallback(new Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                        Executors.newSingleThreadScheduledExecutor().execute(new Runnable() {
                            @Override
                            public void run() {
                                getAppDatabase(context).actorDAO().insertAll(Actor.populateData());
                                getAppDatabase(context).directorDAO().insertAll(Director.populateData());
                                getAppDatabase(context).movieDAO().insertAll(Movie.populateData());

                            }
                        });
                    }
                })
                .allowMainThreadQueries()
                .build();
    }


}
