package com.example.Recipes.screens.menu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import com.example.Recipes.R;
import com.example.Recipes.screens.Recicler_search;
import java.util.ArrayList;

public class type_of_food extends AppCompatActivity implements View.OnClickListener {
  public static final String EXTRA_REC3 = "kitchen.EXTRA_REC3";
  ImageButton Vegan, Sport, PP;
  ArrayList<String> request = new ArrayList<String>();
  String req;
  String data1 = "1";
  String data2 = "0";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.menu_type_of_food);

    Vegan = (ImageButton) findViewById(R.id.vegan);
    Vegan.setOnClickListener(this);
    Sport = (ImageButton) findViewById(R.id.sport);
    Sport.setOnClickListener(this);
    PP = (ImageButton) findViewById(R.id.pp);
    PP.setOnClickListener(this);
  }

  @Override
  public void onClick(View v) {
    switch (v.getId()) {
      case R.id.vegan:
        Intent intent = new Intent(type_of_food.this, Recicler_search.class);
        req =
            "SELECT * FROM app_recipes WHERE recipes_id In (SELECT r_k_id FROM app_recipes_kitchen"
                + " WHERE Veg =?) AND recipes_block =?;";
        request = new ArrayList<String>();
        request.add(req);
        request.add(data1);
        request.add(data2);

        intent.putStringArrayListExtra(EXTRA_REC3, request);
        startActivity(intent);
        break;
      case R.id.sport:
        intent = new Intent(type_of_food.this, Recicler_search.class);
        req =
            "SELECT * FROM app_recipes WHERE recipes_id In (SELECT r_k_id FROM app_recipes_kitchen"
                + " WHERE Sport =?) AND recipes_block =?;";
        request = new ArrayList<String>();
        request.add(req);
        request.add(data1);
        request.add(data2);

        intent.putStringArrayListExtra(EXTRA_REC3, request);
        startActivity(intent);
        break;
      case R.id.pp:
        intent = new Intent(type_of_food.this, Recicler_search.class);
        req =
            "SELECT * FROM app_recipes WHERE recipes_id In (SELECT r_k_id FROM app_recipes_kitchen"
                + " WHERE pp =?) AND recipes_block =?;"; // исправить по названию в бд
        request = new ArrayList<String>();
        request.add(req);
        request.add(data1);
        request.add(data2);

        intent.putStringArrayListExtra(EXTRA_REC3, request);
        startActivity(intent);
        break;
    }
  }
}
