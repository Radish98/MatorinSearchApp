package com.example.matorinsearchapp.dataBase;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class SaveDB {

    @PrimaryKey(autoGenerate = true)
    public long id;

    public int queue;

    public String title;

    public String link;

    public String snippet;

}
