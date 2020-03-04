package com.example.Recipes.data_note;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.Recipes.model_note.Note;

@Database(entities = {Note.class}, version = 2,exportSchema = false)
public abstract class NoteDataBase extends RoomDatabase {
    public static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(final SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE Note ADD COLUMN timestamp INTEGER DEFAULT 0 NOT NULL");
        }


    };
    public abstract NoteDao noteDao();
}
