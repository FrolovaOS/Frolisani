package com.example.Recipes.screens;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


import androidx.room.Room;


import com.example.Recipes.R;
import com.example.Recipes.data_note.NoteDao;
import com.example.Recipes.data_note.NoteDataBase;
import com.example.Recipes.data_own_recipes.RecipesDao;
import com.example.Recipes.data_own_recipes.RecipesDataBase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    ImageButton AddRecipes,Home,Search,Notes;

    private NoteDataBase database;
    private NoteDao noteDao;
    private static MainActivity instance;

    private RecipesDataBase databaseRecipes;
    private RecipesDao recipesDao;
    private static MainActivity instanceRep;

    public static MainActivity getInstance() {
        return instance;
    }

    public static MainActivity getInstanceRep() {
        return instanceRep;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        instance = this;
        instanceRep = this;

        database = Room.databaseBuilder(getApplicationContext(),
                NoteDataBase.class, "app-db-name").addMigrations(NoteDataBase.MIGRATION_1_2)
                .allowMainThreadQueries()
                .build();

        noteDao = database.noteDao();

        databaseRecipes = Room.databaseBuilder(getApplicationContext(),
                RecipesDataBase.class, "app-db-rep")
                .allowMainThreadQueries()
                .build();

        recipesDao = databaseRecipes.recipesDao();


        AddRecipes = (ImageButton) findViewById(R.id.AddRecipes);
        AddRecipes.setOnClickListener(this);
        Home = (ImageButton) findViewById(R.id.Home);
        Home.setOnClickListener(this);
        Search = (ImageButton) findViewById(R.id.Search);
        Search.setOnClickListener(this);
        Notes = (ImageButton) findViewById(R.id.Notes);
        Notes.setOnClickListener(this);

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



    public RecipesDataBase getDatabaseRep() {
        return databaseRecipes;
    }

    public void setDatabaseRep(RecipesDataBase database) {
        this.databaseRecipes = databaseRecipes;
    }

    public RecipesDao getRepDao() {
        return recipesDao;
    }

    public void setRepDao(NoteDao noteDao) {
        this.recipesDao = recipesDao;
    }



    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.AddRecipes:
                Intent intent = new Intent(MainActivity.this, com.example.Recipes.screens.OwnRecipes.AddRecipes.class);
                startActivity(intent);
                break;
            case R.id.Notes:
                 intent = new Intent(MainActivity.this, com.example.Recipes.screens.Note.Main_note.class);
                startActivity(intent);
                break;
            case R.id.Search:
                 intent = new Intent(MainActivity.this, search.class);
                startActivity(intent);
                break;
            case R.id.Home:
                 intent = new Intent(MainActivity.this, home.class);
                startActivity(intent);
                break;
        }
    }
}
