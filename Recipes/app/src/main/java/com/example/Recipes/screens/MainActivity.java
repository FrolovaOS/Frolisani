package com.example.Recipes.screens;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.Recipes.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    ImageButton AddRecipes,Home,Search,Notes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AddRecipes = (ImageButton) findViewById(R.id.AddRecipes);
        AddRecipes.setOnClickListener(this);
        Home = (ImageButton) findViewById(R.id.Home);
        Home.setOnClickListener(this);
        Search = (ImageButton) findViewById(R.id.Search);
        Search.setOnClickListener(this);
        Notes = (ImageButton) findViewById(R.id.Notes);
        Notes.setOnClickListener(this);

        }


    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.AddRecipes:
                Intent intent = new Intent(MainActivity.this, com.example.Recipes.screens.AddRecipes.class);
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
