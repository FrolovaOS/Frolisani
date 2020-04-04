package com.example.Recipes.screens.OwnRecipes;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.Recipes.R;
import com.example.Recipes.model_Adding_Recipes.Own_Recipes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

import static com.example.Recipes.screens.OwnRecipes.Add_Form_Recipes.EXTRA_REP;

public class RecipesView extends AppCompatActivity {
    ImageView Screen;
    TextView Products,Level,Time,Name,Instruction;
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    public Own_Recipes rep;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);

        Time = findViewById(R.id.Time1);
        Name = findViewById(R.id.Name);
        Instruction = findViewById(R.id.textView4);
        Products = findViewById(R.id.Food);
        Level = findViewById(R.id.Level);
        Screen = findViewById(R.id.imageView8);

        if (getIntent().hasExtra(EXTRA_REP)) {
            rep = getIntent().getParcelableExtra(EXTRA_REP);
            Name.setText(Objects.requireNonNull(rep).name);
            Time.setText(Objects.requireNonNull(rep).time);
            Instruction.setText(Objects.requireNonNull(rep).instruction);
            Products.setText(Objects.requireNonNull(rep).products);
            Level.setText(Objects.requireNonNull(rep).level);
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE },
                    REQUEST_EXTERNAL_STORAGE);
            if (ActivityCompat.checkSelfPermission(this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE) ==
                    PackageManager.PERMISSION_GRANTED) {
                File image = new File(rep.screen);
                Bitmap bm = BitmapFactory.decodeFile(image.getAbsolutePath());
                Screen.setImageBitmap(bm);
            }

        }
    }


}
