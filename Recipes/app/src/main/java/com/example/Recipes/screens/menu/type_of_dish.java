package com.example.Recipes.screens.menu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.Recipes.R;
import com.example.Recipes.screens.Recicler_search;

import java.util.ArrayList;

public class type_of_dish extends AppCompatActivity implements View.OnClickListener {
    public static final String EXTRA_REC2 = "type_of_dish.EXTRA_REC2";
    ImageButton Hot_dish,Soup,Salad,Bakery,Dessert;
    ArrayList<String> request = new ArrayList<String>();
    String req ="SELECT * FROM app_recipes WHERE recipes_id In (SELECT r_k_id FROM app_recipes_kitchen WHERE app_recipes_kitchen.Type_of_dish =?);";

    String data ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_type_of_dish);
        request.add(req);

        Hot_dish = (ImageButton) findViewById(R.id.hot_dish);
        Hot_dish.setOnClickListener(this);
        Soup = (ImageButton) findViewById(R.id.soup);
        Soup.setOnClickListener(this);
        Salad = (ImageButton) findViewById(R.id.salad);
        Salad.setOnClickListener(this);
        Bakery = (ImageButton) findViewById(R.id.bakery);
        Bakery.setOnClickListener(this);
        Dessert = (ImageButton) findViewById(R.id.dessert);
        Dessert.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.hot_dish:
                Intent intent = new Intent(type_of_dish.this, Recicler_search.class);
                data = "Второе блюдо";
                if(request.size()!= 1) request.remove(1);
                request.add(data);
                intent.putStringArrayListExtra(EXTRA_REC2,request); startActivity(intent);
                break;
            case R.id.soup:
                intent = new Intent(type_of_dish.this, Recicler_search.class);
                data = "Суп";
                if(request.size()!= 1) request.remove(1);
                request.add(data);
                intent.putStringArrayListExtra(EXTRA_REC2,request);
                startActivity(intent);
                break;
            case R.id.salad:
                intent = new Intent(type_of_dish.this, Recicler_search.class);
                data = "Салат";
                if(request.size()!= 1) request.remove(1);
                request.add(data);
                intent.putStringArrayListExtra(EXTRA_REC2,request);
                startActivity(intent);
                break;
            case R.id.bakery:
                intent = new Intent(type_of_dish.this, Recicler_search.class);
                data = "Выпечка";
                if(request.size()!= 1) request.remove(1);
                request.add(data);
                intent.putStringArrayListExtra(EXTRA_REC2,request);
                startActivity(intent);
                break;
            case R.id.dessert:
                intent = new Intent(type_of_dish.this, Recicler_search.class);
                data = "Десерт";
                if(request.size()!= 1) request.remove(1);
                request.add(data);
                intent.putStringArrayListExtra(EXTRA_REC2,request);
                startActivity(intent);
                break;

        }
    }
}
