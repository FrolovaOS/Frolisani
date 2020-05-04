package com.example.Recipes.screens.OwnRecipes;

import static com.example.Recipes.screens.OwnRecipes.Add_Form_Recipes.EXTRA_REP;
import static com.example.Recipes.screens.Recicler_search.EXTRA_RECIPE;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import com.example.Recipes.R;
import com.example.Recipes.model_Adding_Recipes.Own_Recipes;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Objects;

public class RecipesView extends AppCompatActivity {
  ImageView Screen;
  TextView Products, Level, Time, Name, Instruction, Character;
  private static final int REQUEST_EXTERNAL_STORAGE = 1;
  public Own_Recipes rep;

  @RequiresApi(api = Build.VERSION_CODES.KITKAT)
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_recipes);

    ArrayList<String> recArray = new ArrayList<String>();

    Time = findViewById(R.id.Time1);
    Name = findViewById(R.id.Name);
    Instruction = findViewById(R.id.textView4);
    Products = findViewById(R.id.Food);
    Level = findViewById(R.id.Level);
    Screen = findViewById(R.id.imageView8);
    Character = findViewById(R.id.character);

    if (getIntent().hasExtra(EXTRA_REP)) {
      rep = getIntent().getParcelableExtra(EXTRA_REP);
      Name.setText(Objects.requireNonNull(rep).name);
      Time.setText(Objects.requireNonNull(rep).time);
      Instruction.setText(Objects.requireNonNull(rep).instruction);
      Products.setText(Objects.requireNonNull(rep).products);
      Level.setText(Objects.requireNonNull(rep).level);
      ActivityCompat.requestPermissions(
          this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_EXTERNAL_STORAGE);
      if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
          == PackageManager.PERMISSION_GRANTED) {
        if (rep.screen != null) {
          File image = new File(rep.screen);
          Bitmap bm = BitmapFactory.decodeFile(image.getAbsolutePath());
          Screen.setImageBitmap(bm);
        }
      }
    }

    if (getIntent().hasExtra(EXTRA_RECIPE)) {
      recArray = getIntent().getStringArrayListExtra(EXTRA_RECIPE);
      Name.setText(recArray.get(0));
      Character.setText(recArray.get(1));
      Instruction.setText(recArray.get(2));
      Products.setText(recArray.get(3));
      Time.setText(recArray.get(4));
      Level.setText(recArray.get(5));
      if (recArray.get(8) != "NULL") {

        InputStream inputStream = null;
        try {
          inputStream = getApplicationContext().getAssets().open(recArray.get(8));
        } catch (IOException e) {
          e.printStackTrace();
        }
        Drawable d = Drawable.createFromStream(inputStream, null);
        Screen.setImageDrawable(d);
        if (inputStream != null) {
          try {
            inputStream.close();
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
      }
    }
  }
}
