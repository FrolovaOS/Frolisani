package com.example.Recipes;

import android.app.Application;

import androidx.room.Room;

import com.example.Recipes.data_note.NoteDao;
import com.example.Recipes.data_note.NoteDataBase;

public class App extends Application {

    private NoteDataBase database;
    private NoteDao noteDao;

    private static App instance;

    public static App getInstance() {
        return instance;
    }
    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

        database = Room.databaseBuilder(getApplicationContext(),
                NoteDataBase.class, "app-db-name")
                .allowMainThreadQueries()
                .build();

        noteDao = database.noteDao();
    }
    public NoteDataBase getDatabase() {
        return database;
    }

    public void setDatabase(NoteDataBase database) {
        this.database = database;
    }

    public NoteDao getNoteDao() {
        return noteDao;
    }

    public void setNoteDao(NoteDao noteDao) {
        this.noteDao = noteDao;
    }
}
