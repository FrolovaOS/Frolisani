package com.example.Recipes.data_own_recipes;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.Recipes.model_Adding_Recipes.Own_Recipes;

import java.util.List;

@Dao
public interface RecipesDao {

    @Query("SELECT * FROM Own_Recipes")
    List<Own_Recipes> getAll();

    @Query("SELECT * FROM Own_Recipes")
    LiveData<List<Own_Recipes>> getAllLiveData();

    @Query("SELECT * FROM Own_Recipes WHERE uid IN (:RecipesIds)")
    List<Own_Recipes> loadAllByIds(int[] RecipesIds);

    @Query("SELECT * FROM Own_Recipes WHERE uid = :uid LIMIT 1")
    Own_Recipes findById(int uid);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Own_Recipes rep);

    @Update
    void update(Own_Recipes rep);

    @Delete
    void delete(Own_Recipes rep);
}
