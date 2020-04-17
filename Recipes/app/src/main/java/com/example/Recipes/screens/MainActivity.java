package com.example.Recipes.screens;
import android.Manifest;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


import com.example.Recipes.R;
import com.example.Recipes.data_note.AppDao;
import com.example.Recipes.data_note.NoteDataBase;


import java.io.IOException;

import static com.example.Recipes.data_note.NoteDataBase.getDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    ImageButton AddRecipes,Home,Search,Notes;

    private NoteDataBase database;
    private AppDao appDao;
    private DatabaseHelper mDBHelper;
    private SQLiteDatabase mDb;

    private static MainActivity instance;
    private static MainActivity instanceRep;

    public static MainActivity getInstance() {
        return instance;
    }

    public static MainActivity getInstanceRep() { return instanceRep; }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDBHelper = new DatabaseHelper(this);

        try {
            mDBHelper.updateDataBase();
        } catch (IOException mIOException) {
            throw new Error("UnableToUpdateDatabase");
        }

        try {
            mDb = mDBHelper.getWritableDatabase();
            System.out.println("DataBase connected");
        } catch (SQLException mSQLException) {
            throw mSQLException;
        }



        instance = this;
        instanceRep = this;
        database = getDatabase(getApplicationContext());

        appDao = database.appDao();


        AddRecipes = (ImageButton) findViewById(R.id.AddRecipes);
        AddRecipes.setOnClickListener(this);
        Home = (ImageButton) findViewById(R.id.Home);
        Home.setOnClickListener(this);
        Search = (ImageButton) findViewById(R.id.Search);
        Search.setOnClickListener(this);
        Notes = (ImageButton) findViewById(R.id.Notes);
        Notes.setOnClickListener(this);

        }


    public void setDatabase(NoteDataBase database) {
        this.database = database;
    }

    public AppDao getAppDao() {
        return appDao;
    }

    public void setNoteDao(AppDao AppDao) {
        this.appDao = AppDao;
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
