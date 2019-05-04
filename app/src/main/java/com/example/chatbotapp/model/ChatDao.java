package com.example.chatbotapp.model;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface ChatDao {

    @Query("SELECT * from chat_table ORDER BY username ASC")
    LiveData<List<Chat>> getInOrder();

    @Insert
    void insert(Chat chat);

    @Query("DELETE FROM chat_table")
    void deleteAll();
}
