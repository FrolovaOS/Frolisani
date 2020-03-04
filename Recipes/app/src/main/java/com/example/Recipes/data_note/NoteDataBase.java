package com.example.Recipes.data_note;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.Recipes.model_note.Note;

@Database(entities = {Note.class}, version = 1, exportSchema = false)
public abstract class NoteDataBase extends RoomDatabase {
    public abstract NoteDao noteDao();
}
