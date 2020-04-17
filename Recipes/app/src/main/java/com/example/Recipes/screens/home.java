package com.example.Recipes.screens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.Recipes.R;

import java.util.ArrayList;

public class home extends AppCompatActivity  implements View.OnClickListener {
    public static final String EXTRA_REC6 = "home.EXTRA_REC6";
    ArrayList<String> request = new ArrayList<String>();
    String req ;
    String data ;
    ImageButton Fridg, Favourite, Block, Notes, Back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Fridg = (ImageButton) findViewById(R.id.Fridg);
        Fridg.setOnClickListener(this);
        Favourite = (ImageButton) findViewById(R.id.Favorite);
        Favourite.setOnClickListener(this);
        Block = (ImageButton) findViewById(R.id.Search);
        Block.setOnClickListener(this);
        Notes = (ImageButton) findViewById(R.id.Notes);
        Notes.setOnClickListener(this);
        Back = (ImageButton) findViewById(R.id.Back);
        Back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.Fridg:
                Intent intent = new Intent(home.this, com.example.Recipes.screens.Fridg.class);
                startActivity(intent);
                break;
            case R.id.Notes:
                intent = new Intent(home.this, com.example.Recipes.screens.Note.Main_note.class);
                startActivity(intent);
                break;
            case R.id.Search://это блок просто не исправляется...
                intent = new Intent(home.this, Recicler_search.class);
                req="SELECT * FROM app_recipes WHERE recipes_block =?;";
                data = "1";
                request =  new ArrayList<String>();

                request.add(0,req);
                request.add(1,data);
                intent.putStringArrayListExtra(EXTRA_REC6,request);
                startActivity(intent);
                break;
            case R.id.Favorite:
                intent = new Intent(home.this, Recicler_search.class);
                req="SELECT * FROM app_recipes WHERE recipes_favorites =?;";
                data = "1";
                request =  new ArrayList<String>();

                request.add(0,req);
                request.add(1,data);
                intent.putStringArrayListExtra(EXTRA_REC6,request);
                startActivity(intent);
                break;
            case R.id.Back:
                intent = new Intent(home.this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }
}
