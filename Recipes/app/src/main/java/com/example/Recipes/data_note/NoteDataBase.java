package com.example.Recipes.data_note;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.Recipes.data_own_recipes.RecipesDao;
import com.example.Recipes.model_Adding_Recipes.Own_Recipes;
import com.example.Recipes.model_note.Note;

@Database(entities = {Note.class,Own_Recipes.class}, version = 2,exportSchema = false)
@TypeConverters({Converters.class})
public abstract class NoteDataBase extends RoomDatabase {
    public static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(final SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE Note ADD COLUMN timestamp INTEGER DEFAULT 0 NOT NULL");
        }

    };
   // public static final Migration MIGRATION_2_3 = new Migration(2, 3) {
     //   @Override
       // public void migrate(final SupportSQLiteDatabase database) {
         //   database.execSQL("ALTER TABLE Own_Recipes ADD COLUMN screen STRING ");
           // database.execSQL("ALTER TABLE Own_Recipes DROP COLUMN screen");
        //}

    //};
    private static volatile NoteDataBase INSTANCE;

    public static NoteDataBase getDatabase(final Context context)
    {
        if (INSTANCE == null)
        {
            synchronized (NoteDataBase.class)
            {
                if (INSTANCE == null)
                {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            NoteDataBase.class,"app_datebase").allowMainThreadQueries().fallbackToDestructiveMigration().build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract AppDao appDao();
    //public abstract RecipesDao recipesDao();
}
