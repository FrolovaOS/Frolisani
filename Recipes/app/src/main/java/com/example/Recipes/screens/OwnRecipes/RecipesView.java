package com.example.Recipes.screens.OwnRecipes;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.Recipes.R;
import com.example.Recipes.model_Adding_Recipes.Own_Recipes;

import java.util.Objects;

import static com.example.Recipes.screens.OwnRecipes.Add_Form_Recipes.EXTRA_REP;

public class RecipesView extends AppCompatActivity {
    ImageView screen;
    Bitmap screen1 = null;
    TextView Products,Level,Time,Name,Instruction;
   // private static final String EXTRA_REP = "Add_Form_Recipes.EXTRA_REP";
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
        screen = findViewById(R.id.imageView8);

        if (getIntent().hasExtra(EXTRA_REP)) {
            rep = getIntent().getParcelableExtra(EXTRA_REP);
            Name.setText(Objects.requireNonNull(rep).name);
            Time.setText(Objects.requireNonNull(rep).time);
            Instruction.setText(Objects.requireNonNull(rep).instruction);
            Products.setText(Objects.requireNonNull(rep).products);
            Level.setText(Objects.requireNonNull(rep).level);
            //rep.level = Level.getSelectedItem().toString();
            if(bytesToBitmap(rep.screen)!=null)  screen.setImageBitmap(bytesToBitmap(rep.screen));
                //screen1.createBitmap(bytesToBitmap(rep.screen));
            //screen1=bytesToBitmap(rep.screen);

        }
    }

    // convert from byte array to bitmap

        public static Bitmap bytesToBitmap(byte[] data) {
            if (data == null) {
                return null;
            }
            return BitmapFactory.decodeByteArray(data, 0, data.length);
        }
    }
