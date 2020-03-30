package com.example.Recipes.screens.OwnRecipes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.Recipes.R;
import com.example.Recipes.model_Adding_Recipes.Own_Recipes;
import com.example.Recipes.model_note.Note;
import com.example.Recipes.screens.Note.NoteViewModel;

import java.util.List;

public class AddRecipes extends AppCompatActivity implements View.OnClickListener{
    ImageButton AddRecipes;
    private RecyclerView recyclerView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipes);


        AddRecipes = (ImageButton) findViewById(R.id.Add);
        AddRecipes.setOnClickListener(this);

        recyclerView1 = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView1.setLayoutManager(linearLayoutManager);
        recyclerView1.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        final Adapter adapter = new Adapter();
        recyclerView1.setAdapter(adapter);

        RepViewModel mainViewModel = ViewModelProviders.of(this).get(RepViewModel.class);
        mainViewModel.getRepLiveData().observe(this, new Observer<List<Own_Recipes>>() {
            @Override
            public void onChanged(List<Own_Recipes> recipes) {
                adapter.setItems(recipes);
            }
        });

    }
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Add:
                Intent intent = new Intent(AddRecipes.this, Add_Form_Recipes.class);
                startActivity(intent);
                break;
        }
    }
}
