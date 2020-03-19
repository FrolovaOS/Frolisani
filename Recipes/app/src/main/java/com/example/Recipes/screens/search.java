package com.example.Recipes.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.Recipes.R;

public class search extends AppCompatActivity  implements View.OnClickListener{
    ImageButton recipe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        recipe = (ImageButton) findViewById(R.id.imageButton);
        recipe.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {

            case R.id.imageButton:
                Intent intent = new Intent(search.this, Recipes.class);
                startActivity(intent);
                break;
        }
    }
}
