package com.example.Recipes.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.Recipes.R;
import com.example.Recipes.screens.menu.drinks;
import com.example.Recipes.screens.menu.kitchen;
import com.example.Recipes.screens.menu.type_of_dish;
import com.example.Recipes.screens.menu.type_of_food;
import com.example.Recipes.screens.menu.type_of_product;

import java.util.ArrayList;
import java.util.HashMap;

public class search extends AppCompatActivity  implements View.OnClickListener{
    ImageButton Kitchen,Type_of_food, Type_of_dish,Drinks,Main_product;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        final EditText editText = (EditText)findViewById(R.id.Search);
        Kitchen = (ImageButton) findViewById(R.id.kitchen);
        Kitchen.setOnClickListener(this);
        Type_of_food = (ImageButton) findViewById(R.id.type_of_food);
        Type_of_food.setOnClickListener(this);
        Type_of_dish = (ImageButton) findViewById(R.id.type_of_dish);
        Type_of_dish.setOnClickListener(this);
        Main_product = (ImageButton) findViewById(R.id.main_product);
        Main_product.setOnClickListener(this);
        Drinks = (ImageButton) findViewById(R.id.drinks);
        Drinks.setOnClickListener(this);

        editText.setOnKeyListener(new View.OnKeyListener()
                                  {
                                      public boolean onKey(View v, int keyCode, KeyEvent event)
                                      {
                                          if(event.getAction() == KeyEvent.ACTION_DOWN &&
                                                  (keyCode == KeyEvent.KEYCODE_ENTER))
                                          {
                                              String NameRecipes = editText.getText().toString();
                                              return true;
                                          }
                                          return false;
                                      }
                                  }
        );
    }
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {

            case R.id.kitchen:
                Intent intent = new Intent(search.this, kitchen.class);
                startActivity(intent);
                break;
            case R.id.type_of_food:
                intent = new Intent(search.this, type_of_food.class);
                startActivity(intent);
                break;
            case R.id.type_of_dish:
                intent = new Intent(search.this, type_of_dish.class);
                startActivity(intent);
                break;
            case R.id.main_product:
                intent = new Intent(search.this, type_of_product.class);
                startActivity(intent);
                break;
            case R.id.drinks:
                intent = new Intent(search.this, drinks.class);
                startActivity(intent);
                break;
        }
    }


}
