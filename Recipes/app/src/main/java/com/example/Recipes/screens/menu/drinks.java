package com.example.Recipes.screens.menu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import com.example.Recipes.R;
import com.example.Recipes.screens.Recicler_search;
import java.util.ArrayList;

public class drinks extends AppCompatActivity implements View.OnClickListener {
  public static final String EXTRA_REC5 = "kitchen.EXTRA_REC5";
  ImageButton Alco, Non_alco, hot;
  ArrayList<String> request = new ArrayList<String>();
  String req =
      "SELECT * FROM app_recipes WHERE recipes_id In (SELECT r_k_id FROM app_recipes_kitchen WHERE"
          + " app_recipes_kitchen.type_drink =?) AND recipes_block =?;";
  String data1;
  String data2 = "0";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.menu_drinks);

    Alco = (ImageButton) findViewById(R.id.alcoholic);
    Alco.setOnClickListener(this);
    Non_alco = (ImageButton) findViewById(R.id.non_alcoholic);
    Non_alco.setOnClickListener(this);
    hot = (ImageButton) findViewById(R.id.hot);
    hot.setOnClickListener(this);
  }

  @Override
  public void onClick(View v) {
    switch (v.getId()) {
      case R.id.alcoholic:
        Intent intent = new Intent(drinks.this, Recicler_search.class);
        data1 = "Алкогольный";
        // if (request.size() != 1) request.remove(1);
        request = new ArrayList<String>();
        request.add(req);
        request.add(data1);
        request.add(data2);
        intent.putStringArrayListExtra(EXTRA_REC5, request);
        startActivity(intent);
        break;
      case R.id.non_alcoholic:
        intent = new Intent(drinks.this, Recicler_search.class);
        data1 = "Безалкогольный";
        // if (request.size() != 1) request.remove(1);
        request = new ArrayList<String>();
        request.add(req);
        request.add(data1);
        request.add(data2);
        intent.putStringArrayListExtra(EXTRA_REC5, request);
        startActivity(intent);
        break;
      case R.id.hot:
        intent = new Intent(drinks.this, Recicler_search.class);
        data1 = "Горячий";
        // if (request.size() != 1) request.remove(1);
        request = new ArrayList<String>();
        request.add(req);
        request.add(data1);
        request.add(data2);
        intent.putStringArrayListExtra(EXTRA_REC5, request);
        startActivity(intent);
        break;
    }
  }
}
