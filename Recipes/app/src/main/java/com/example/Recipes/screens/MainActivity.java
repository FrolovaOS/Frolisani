package com.example.Recipes.screens;

import static com.example.Recipes.data_note.NoteDataBase.getDatabase;

import android.content.ContentValues;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import com.example.Recipes.R;
import com.example.Recipes.data_note.AppDao;
import com.example.Recipes.data_note.NoteDataBase;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

  private static final int REQUEST_EXTERNAL_STORAGE = 1;

  ImageButton AddRecipes, Home, Search, Notes;

  private NoteDataBase database;
  private AppDao appDao;
  private DatabaseHelper mDBHelper;
  private SQLiteDatabase mDb;

  private static MainActivity instance;
  private static MainActivity instanceRep;

  public static MainActivity getInstance() {
    return instance;
  }

  public static MainActivity getInstanceRep() {
    return instanceRep;
  }

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

    ContentValues cv = new ContentValues();
    cv.put("picture", "omlet_klass4.jpeg");
    mDb.update("app_recipes", cv, "recipes_id = ?", new String[] {String.valueOf(10000)});
    cv.clear();
    cv.put("picture", "omlet-s-syrom-i-pomidorami-cherri.jpg");
    mDb.update("app_recipes", cv, "recipes_id = ?", new String[] {String.valueOf(10001)});
    cv.clear();
    cv.put("picture", "caesar_klass.jpg");
    mDb.update("app_recipes", cv, "recipes_id = ?", new String[] {String.valueOf(10002)});
    cv.clear();
    cv.put("picture", "caesar_krevetky.jpg");
    mDb.update("app_recipes", cv, "recipes_id = ?", new String[] {String.valueOf(10003)});
    cv.clear();
    cv.put("picture", "vatrushka.jpg");
    mDb.update("app_recipes", cv, "recipes_id = ?", new String[] {String.valueOf(10004)});
    cv.clear();
    cv.put("picture", "vatrushka_s_povidlom.jpg");
    mDb.update("app_recipes", cv, "recipes_id = ?", new String[] {String.valueOf(10006)});
    cv.clear();
    cv.put("picture", "vatrushka.jpg");
    mDb.update("app_recipes", cv, "recipes_id = ?", new String[] {String.valueOf(10005)});
    cv.clear();
    cv.put("picture", "chi_klass.jpg");
    mDb.update("app_recipes", cv, "recipes_id = ?", new String[] {String.valueOf(10007)});
    cv.clear();
    cv.put("picture", "chi_chicken.jpg");
    mDb.update("app_recipes", cv, "recipes_id = ?", new String[] {String.valueOf(10008)});
    cv.clear();
    cv.put("picture", "chi_grib.jpg");
    mDb.update("app_recipes", cv, "recipes_id = ?", new String[] {String.valueOf(10009)});
    cv.clear();
    cv.put("picture", "golubci.jpg");
    mDb.update("app_recipes", cv, "recipes_id = ?", new String[] {String.valueOf(10010)});
    cv.clear();
    cv.put("picture", "olive.jpg");
    mDb.update("app_recipes", cv, "recipes_id = ?", new String[] {String.valueOf(10011)});
    cv.clear();
    cv.put("picture", "pasha.jpg");
    mDb.update("app_recipes", cv, "recipes_id = ?", new String[] {String.valueOf(10012)});
    cv.clear();
    cv.put("picture", "pasha.jpg");
    mDb.update("app_recipes", cv, "recipes_id = ?", new String[] {String.valueOf(10013)});
    cv.clear();
    cv.put("picture", "pasha_klubnika.jpg");
    mDb.update("app_recipes", cv, "recipes_id = ?", new String[] {String.valueOf(10012)});
    cv.clear();
    cv.put("picture", "lukovi_soup.jpg");
    mDb.update("app_recipes", cv, "recipes_id = ?", new String[] {String.valueOf(10200)});
    cv.clear();
    cv.put("picture", "kruasani.jpg");
    mDb.update("app_recipes", cv, "recipes_id = ?", new String[] {String.valueOf(10201)});
    cv.clear();
    cv.put("picture", "ratatui.jpg");
    mDb.update("app_recipes", cv, "recipes_id = ?", new String[] {String.valueOf(10202)});
    cv.clear();
    cv.put("picture", "ratatui_kartoshka.jpg");
    mDb.update("app_recipes", cv, "recipes_id = ?", new String[] {String.valueOf(10203)});
    cv.clear();
    cv.put("picture", "blanmage.jpg");
    mDb.update("app_recipes", cv, "recipes_id = ?", new String[] {String.valueOf(10204)});
    cv.clear();
    cv.put("picture", "hachapuri.jpg");
    mDb.update("app_recipes", cv, "recipes_id = ?", new String[] {String.valueOf(10400)});
    cv.clear();
    cv.put("picture", "hachapuri_tvorog.jpg");
    mDb.update("app_recipes", cv, "recipes_id = ?", new String[] {String.valueOf(10401)});
    cv.clear();
    cv.put("picture", "pasta_boloneze.jpg");
    mDb.update("app_recipes", cv, "recipes_id = ?", new String[] {String.valueOf(20000)});
    cv.clear();
    cv.put("picture", "pasta_karbonara.jpg");
    mDb.update("app_recipes", cv, "recipes_id = ?", new String[] {String.valueOf(20001)});
    cv.clear();
    cv.put("picture", "rizotto.jpg");
    mDb.update("app_recipes", cv, "recipes_id = ?", new String[] {String.valueOf(20002)});
    cv.clear();
    cv.put("picture", "rizotta_kurica_gribi.jpg");
    mDb.update("app_recipes", cv, "recipes_id = ?", new String[] {String.valueOf(20003)});
    cv.clear();
    cv.put("picture", "rizotto_krevetki.jpg");
    mDb.update("app_recipes", cv, "recipes_id = ?", new String[] {String.valueOf(20004)});
    cv.clear();
    cv.put("picture", "pizza_margarita.jpg");
    mDb.update("app_recipes", cv, "recipes_id = ?", new String[] {String.valueOf(20005)});
    cv.clear();
    cv.put("picture", "pizza_peperony.jpg");
    mDb.update("app_recipes", cv, "recipes_id = ?", new String[] {String.valueOf(20006)});
    cv.clear();
    cv.put("picture", "pizza_ananasi.jpg");
    mDb.update("app_recipes", cv, "recipes_id = ?", new String[] {String.valueOf(20007)});
    cv.clear();
    cv.put("picture", "pizza_4_sir.jpg");
    mDb.update("app_recipes", cv, "recipes_id = ?", new String[] {String.valueOf(20008)});
    cv.clear();
    cv.put("picture", "tikvenni_soup.jpg");
    mDb.update("app_recipes", cv, "recipes_id = ?", new String[] {String.valueOf(20100)});
    cv.clear();
    cv.put("picture", "tikvennisoup_s_sirom.jpg");
    mDb.update("app_recipes", cv, "recipes_id = ?", new String[] {String.valueOf(20101)});
    cv.clear();
    cv.put("picture", "vinegret.jpg");
    mDb.update("app_recipes", cv, "recipes_id = ?", new String[] {String.valueOf(10014)});
    cv.clear();
    cv.put("picture", "vinegret_s_fasolu.jpg");
    mDb.update("app_recipes", cv, "recipes_id = ?", new String[] {String.valueOf(10015)});
    cv.clear();
    cv.put("picture", "pudding.jpg");
    mDb.update("app_recipes", cv, "recipes_id = ?", new String[] {String.valueOf(20200)});
    cv.clear();
    cv.put("picture", "shik_pudding.jpg");
    mDb.update("app_recipes", cv, "recipes_id = ?", new String[] {String.valueOf(20201)});
    cv.clear();
    cv.put("picture", "bananov_pudding.jpg");
    mDb.update("app_recipes", cv, "recipes_id = ?", new String[] {String.valueOf(20202)});
    cv.clear();
    cv.put("picture", "sharlotka.jpg");
    mDb.update("app_recipes", cv, "recipes_id = ?", new String[] {String.valueOf(20300)});
    cv.clear();
    cv.put("picture", "sharlotka_s_grushei.jpg");
    mDb.update("app_recipes", cv, "recipes_id = ?", new String[] {String.valueOf(20301)});
    cv.clear();
    cv.put("picture", "malinoviy napitok.jpeg");
    mDb.update("app_recipes", cv, "recipes_id = ?", new String[] {String.valueOf(20500)});
    cv.clear();
    cv.put("picture", "smuzi_selderey.jpg");
    mDb.update("app_recipes", cv, "recipes_id = ?", new String[] {String.valueOf(20501)});
    cv.clear();
    cv.put("picture", "zeleniy_char_s_imbirem.jpg");
    mDb.update("app_recipes", cv, "recipes_id = ?", new String[] {String.valueOf(20502)});
    cv.clear();
    cv.put("picture", "zeleniy_smuzzi_s_kivi.jpg");
    mDb.update("app_recipes", cv, "recipes_id = ?", new String[] {String.valueOf(10016)});
    cv.clear();
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
    switch (v.getId()) {
      case R.id.AddRecipes:
        Intent intent =
                new Intent(MainActivity.this, com.example.Recipes.screens.OwnRecipes.AddRecipes.class);
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
