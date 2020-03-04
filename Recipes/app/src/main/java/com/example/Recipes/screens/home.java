package com.example.Recipes.screens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.Recipes.R;

public class home extends AppCompatActivity  implements View.OnClickListener {
    ImageButton Fridg, Favourite, Search, Notes, Back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Fridg = (ImageButton) findViewById(R.id.Fridg);
        Fridg.setOnClickListener(this);
        Favourite = (ImageButton) findViewById(R.id.Favorite);
        Favourite.setOnClickListener(this);
        Search = (ImageButton) findViewById(R.id.Search);
        Search.setOnClickListener(this);
        Notes = (ImageButton) findViewById(R.id.Notes);
        Notes.setOnClickListener(this);
        Back = (ImageButton) findViewById(R.id.Back);
        Back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.Fridg:
                Intent intent = new Intent(home.this, com.example.Recipes.screens.Fridg.class);
                startActivity(intent);
                break;
            case R.id.Notes:
                intent = new Intent(home.this, com.example.Recipes.screens.Note.Main_note.class);
                startActivity(intent);
                break;
            case R.id.Search:
                intent = new Intent(home.this, search.class);
                startActivity(intent);
                break;
            case R.id.Favorite:
                intent = new Intent(home.this, Favorite.class);
                startActivity(intent);
                break;
            case R.id.Back:
                intent = new Intent(home.this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }
}
