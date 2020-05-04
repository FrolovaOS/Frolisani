package com.example.Recipes.screens;

import static com.example.Recipes.screens.home.EXTRA_REC6;
import static com.example.Recipes.screens.menu.drinks.EXTRA_REC5;
import static com.example.Recipes.screens.menu.kitchen.EXTRA_REC1;
import static com.example.Recipes.screens.menu.type_of_dish.EXTRA_REC2;
import static com.example.Recipes.screens.menu.type_of_food.EXTRA_REC3;
import static com.example.Recipes.screens.menu.type_of_product.EXTRA_REC4;
import static com.example.Recipes.screens.search.EXTRA_REC7;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.Recipes.R;
import com.example.Recipes.screens.OwnRecipes.RecipesView;
import java.util.ArrayList;

public class Recicler_search extends AppCompatActivity {
  public static final String EXTRA_RECIPE = "Recicler_search.EXTRA_RECIPE";

  private RecyclerView recyclerView;
  private DatabaseHelper mDBHelper;
  private SQLiteDatabase mDb;
  ArrayList<String> request;
  ArrayList<String> recipe;
  Context context;

  public static void start1(Activity caller, ArrayList<String> rep) {
    Intent intent = new Intent(caller, RecipesView.class);
    if (rep != null) {
      intent.putStringArrayListExtra(EXTRA_RECIPE, rep);
    }
    caller.startActivity(intent);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.list_of_search);
    request = null;
    request = getIntent().getStringArrayListExtra(EXTRA_REC1);
    if (request == null) request = getIntent().getStringArrayListExtra(EXTRA_REC2);
    if (request == null) request = getIntent().getStringArrayListExtra(EXTRA_REC3);
    if (request == null) request = getIntent().getStringArrayListExtra(EXTRA_REC4);
    if (request == null) request = getIntent().getStringArrayListExtra(EXTRA_REC5);
    if (request == null) request = getIntent().getStringArrayListExtra(EXTRA_REC6);
    if (request == null) request = getIntent().getStringArrayListExtra(EXTRA_REC7);

    mDBHelper = new DatabaseHelper(this);
    recyclerView = findViewById(R.id.recyclerView);
    LinearLayoutManager linearLayoutManager =
        new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
    recyclerView.setLayoutManager(linearLayoutManager);
    recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    String querry = "";
    String[] where = new String[3];
    if (request.size() == 3) {
      querry = request.get(0);
      where = new String[] {request.get(1), request.get(2)};
    } else if (request.size() == 2) {
      querry = request.get(0);
      where = new String[] {request.get(1)};
    }

    mDb = mDBHelper.getReadableDatabase();
    ArrayList rec = mDBHelper.listRecipes(querry, where);
    final AdapterMainDB adapter = new AdapterMainDB(this, rec);
    recyclerView.setAdapter(adapter);
  }
}
