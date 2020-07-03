package com.example.matorinsearchapp.dataBase;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.matorinsearchapp.models.SearchItem;

import java.util.List;

@Dao
public interface SaveDBDao {

    @Insert
    void insert(SaveDB searchItem);

    @Query("SELECT * FROM savedb")
    List<SearchItem> getAll();

    @Query("SELECT COUNT(*) FROM savedb")
    int getCount();

    @Query("UPDATE savedb SET title = :title, queue = :queue, link = :link, snippet = :snippet WHERE queue = :queue")
    void update(String title, int queue, String link, String snippet );

}
