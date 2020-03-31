package com.example.Recipes.data_own_recipes;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.example.Recipes.model_Adding_Recipes.Own_Recipes;


@Database(entities = {Own_Recipes.class}, version = 1,exportSchema = false)
public abstract class RecipesDataBase extends RoomDatabase{
    public abstract RecipesDao recipesDao();
}

