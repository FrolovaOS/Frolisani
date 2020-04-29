package com.example.Recipes.screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.Recipes.R;

import java.util.ArrayList;

public class Fridg extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DatabaseHelper mDBHelper;
    private SQLiteDatabase mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fridg);

        mDBHelper=new DatabaseHelper(this);
        recyclerView = findViewById(R.id.recyclerViewFridg);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        mDb = mDBHelper.getReadableDatabase();
        ArrayList prod = mDBHelper.listProduct();
        final Adapter_product adapter = new Adapter_product(this,prod);
        recyclerView.setAdapter(adapter);
    }
}
