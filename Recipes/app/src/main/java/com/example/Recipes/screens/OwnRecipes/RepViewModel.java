package com.example.Recipes.screens.OwnRecipes;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.example.Recipes.model_Adding_Recipes.Own_Recipes;
import com.example.Recipes.screens.MainActivity;
import java.util.List;

public class RepViewModel extends ViewModel {
  private LiveData<List<Own_Recipes>> RepLiveData =
      MainActivity.getInstance().getAppDao().getAllLiveDataR();

  public LiveData<List<Own_Recipes>> getRepLiveData() {
    return RepLiveData;
  }
}
