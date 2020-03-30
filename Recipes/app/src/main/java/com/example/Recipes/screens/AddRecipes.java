package com.example.Recipes.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.Recipes.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AddRecipes extends AppCompatActivity implements View.OnClickListener{
    ImageButton AddRecipes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipes);


        AddRecipes = (ImageButton) findViewById(R.id.Add);
        AddRecipes.setOnClickListener(this);

    }
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Add:
                Intent intent = new Intent(AddRecipes.this, Add_Form_Recipes.class);
                startActivity(intent);
                break;
        }
    }
}
