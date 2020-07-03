package com.example.matorinsearchapp.dataBase;

import android.app.Application;
import androidx.room.Room;


public class App extends Application {
    public static App instance;

    private WatchListDB watchListDB;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        watchListDB = Room.databaseBuilder(this, WatchListDB.class, "database").build();
    }

    public static App getInstance(){ return instance;}

    public WatchListDB getWatchListDB() {return watchListDB; }
}
