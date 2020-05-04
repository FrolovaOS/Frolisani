package com.example.Recipes.data_note;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import com.example.Recipes.model_Adding_Recipes.Own_Recipes;
import com.example.Recipes.model_note.Note;
import java.util.List;

@Dao
public interface AppDao {

  @Query("SELECT * FROM Note")
  List<Note> getAll();

  @Query("SELECT * FROM Note")
  LiveData<List<Note>> getAllLiveData();

  @Query("SELECT * FROM Note WHERE uid IN (:noteIds)")
  List<Note> loadAllByIds(int[] noteIds);

  @Query("SELECT * FROM Note WHERE uid = :uid LIMIT 1")
  Note findById(int uid);

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  void insert(Note note);

  @Update
  void update(Note note);

  @Delete
  void delete(Note note);

  @Query("SELECT * FROM Own_Recipes")
  List<Own_Recipes> getAllR();

  @Query("SELECT * FROM Own_Recipes")
  LiveData<List<Own_Recipes>> getAllLiveDataR();

  @Query("SELECT * FROM Own_Recipes WHERE uid IN (:RecipesIds)")
  List<Own_Recipes> loadAllByIdsR(int[] RecipesIds);

  @Query("SELECT * FROM Own_Recipes WHERE uid = :uid LIMIT 1")
  Own_Recipes findByIdR(int uid);

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  void insertR(Own_Recipes rep);

  @Update
  void updateR(Own_Recipes rep);

  @Delete
  void deleteR(Own_Recipes rep);
}
