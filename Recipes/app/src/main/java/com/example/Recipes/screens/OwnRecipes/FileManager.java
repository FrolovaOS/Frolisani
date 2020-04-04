package com.example.Recipes.screens.OwnRecipes;

import android.content.Context;
import android.os.Environment;

import androidx.core.content.ContextCompat;

import java.io.File;

public class FileManager {
    private File currentDirectory;
    private final File rootDirectory;
    public FileManager(Context context) {
        File directory;
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            directory = Environment.getExternalStorageDirectory();
        } else {
            directory = ContextCompat.getDataDir(context);
        }
        rootDirectory = directory;
        //navigateTo(directory);
    }
}
