package com.example.Recipes.screens.menu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import com.example.Recipes.R;
import com.example.Recipes.screens.Recicler_search;
import java.util.ArrayList;

public class kitchen extends AppCompatActivity implements View.OnClickListener {
  public static final String EXTRA_REC1 = "kitchen.EXTRA_REC1";
  ImageButton French, Greek, Italian, Russian, German, Brazilian, Caucasian, Japanese, English;
  ArrayList<String> request = new ArrayList<String>();
  String req =
      "SELECT * FROM app_recipes WHERE recipes_id In (SELECT r_k_id FROM app_recipes_kitchen WHERE"
          + " app_recipes_kitchen.kitchen_name =?) AND recipes_block =?;";
  String data1;
  String data2 = "0";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.menu_kitchen);

    French = (ImageButton) findViewById(R.id.french);
    French.setOnClickListener(this);
    Greek = (ImageButton) findViewById(R.id.greek);
    Greek.setOnClickListener(this);
    Italian = (ImageButton) findViewById(R.id.italian);
    Italian.setOnClickListener(this);

    Russian = (ImageButton) findViewById(R.id.russian);
    Russian.setOnClickListener(this);
    German = (ImageButton) findViewById(R.id.german);
    German.setOnClickListener(this);
    Brazilian = (ImageButton) findViewById(R.id.brazilian);
    Brazilian.setOnClickListener(this);

    Caucasian = (ImageButton) findViewById(R.id.caucasian);
    Caucasian.setOnClickListener(this);
    Japanese = (ImageButton) findViewById(R.id.japanese);
    Japanese.setOnClickListener(this);
    English = (ImageButton) findViewById(R.id.english);
    English.setOnClickListener(this);
  }

  @Override
  public void onClick(View v) {
    switch (v.getId()) {
      case R.id.french:
        Intent intent = new Intent(kitchen.this, Recicler_search.class);
        data1 = "Французская";
        request = new ArrayList<String>();
        request.add(req);
        request.add(data1);
        request.add(data2);
        intent.putStringArrayListExtra(EXTRA_REC1, request);
        startActivity(intent);
        break;
      case R.id.greek:
        intent = new Intent(kitchen.this, Recicler_search.class);
        data1 = "Греческая";
        request = new ArrayList<String>();
        request.add(req);
        request.add(data1);
        request.add(data2);
        intent.putStringArrayListExtra(EXTRA_REC1, request);
        startActivity(intent);
        break;
      case R.id.russian:
        intent = new Intent(kitchen.this, Recicler_search.class);
        data1 = "Русская";
        request = new ArrayList<String>();
        request.add(req);
        request.add(data1);
        request.add(data2);
        intent.putStringArrayListExtra(EXTRA_REC1, request);
        startActivity(intent);
        break;
      case R.id.italian:
        intent = new Intent(kitchen.this, Recicler_search.class);
        data1 = "Итальянская";
        request = new ArrayList<String>();
        request.add(req);
        request.add(data1);
        request.add(data2);
        intent.putStringArrayListExtra(EXTRA_REC1, request);
        startActivity(intent);
        break;
      case R.id.caucasian:
        intent = new Intent(kitchen.this, Recicler_search.class);
        data1 = "Кавказская";
        request = new ArrayList<String>();
        request.add(req);
        request.add(data1);
        request.add(data2);
        intent.putStringArrayListExtra(EXTRA_REC1, request);
        startActivity(intent);
        break;
      case R.id.japanese:
        intent = new Intent(kitchen.this, Recicler_search.class);
        data1 = "Японская";
        request = new ArrayList<String>();
        request.add(req);
        request.add(data1);
        request.add(data2);
        intent.putStringArrayListExtra(EXTRA_REC1, request);
        startActivity(intent);
        break;
      case R.id.german:
        intent = new Intent(kitchen.this, Recicler_search.class);
        data1 = "Немецкая";
        request = new ArrayList<String>();
        request.add(req);
        request.add(data1);
        request.add(data2);
        intent.putStringArrayListExtra(EXTRA_REC1, request);
        startActivity(intent);
        break;
      case R.id.english:
        intent = new Intent(kitchen.this, Recicler_search.class);
        data1 = "Английская";
        request = new ArrayList<String>();
        request.add(req);
        request.add(data1);
        request.add(data2);
        intent.putStringArrayListExtra(EXTRA_REC1, request);
        startActivity(intent);
        break;
      case R.id.brazilian:
        intent = new Intent(kitchen.this, Recicler_search.class);
        data1 = "Бразильская";
        request = new ArrayList<String>();
        request.add(req);
        request.add(data1);
        request.add(data2);
        intent.putStringArrayListExtra(EXTRA_REC1, request);
        startActivity(intent);
        break;
    }
  }
}
