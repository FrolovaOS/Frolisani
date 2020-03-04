package com.example.Recipes.screens.Note;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.Recipes.App;
import com.example.Recipes.model_note.Note;

import java.util.List;

public class NoteViewModel extends ViewModel {
    private LiveData<List<Note>> noteLiveData = App.getInstance().getNoteDao().getAllLiveData();

    public LiveData<List<Note>> getNoteLiveData() {
        return noteLiveData;
    }
}
