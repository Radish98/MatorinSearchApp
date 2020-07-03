package com.example.matorinsearchapp.dataBase;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {SaveDB.class},version = 1, exportSchema = false)
public abstract class WatchListDB extends RoomDatabase {

    public abstract SaveDBDao saveDBDao();
}
