package com.example.Recipes.screens.OwnRecipes;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.Recipes.R;
import com.example.Recipes.model_Adding_Recipes.Own_Recipes;
import com.example.Recipes.screens.MainActivity;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class Add_Form_Recipes extends AppCompatActivity implements View.OnClickListener{

    static final int GALLERY_REQUEST = 1;
    EditText Time, Name,Instruction,Products;
    Spinner Level;
    Button AddPhoto, Save;
    byte[] screen;
    Bitmap bitmap = null;

    ////////
    public static final String EXTRA_REP = "Add_Form_Recipes.EXTRA_REP";
    public Own_Recipes rep;

    public static void start(Activity caller, Own_Recipes rep) {
        Intent intent = new Intent(caller, Add_Form_Recipes.class);
        if (rep != null) {
            intent.putExtra(EXTRA_REP, rep);
        }
        caller.startActivity(intent);
    }
    public static void start1(Activity caller, Own_Recipes rep) {
        Intent intent = new Intent(caller, RecipesView.class);
        if (rep != null) {
            intent.putExtra(EXTRA_REP, rep);
        }
        caller.startActivity(intent);
    }
    //////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_form);

        AddPhoto = (Button) findViewById(R.id.AddPhoto);
        AddPhoto.setOnClickListener(this);
        Save = (Button) findViewById(R.id.Save);
        Save.setOnClickListener(this);

        Time = findViewById(R.id.Time1);
        Name = findViewById(R.id.NameOfRecipes);
        Instruction = findViewById(R.id.Instruction);
        Products = findViewById(R.id.Products);
        Level = findViewById(R.id.Level1);

        if (getIntent().hasExtra(EXTRA_REP)) {
            rep = getIntent().getParcelableExtra(EXTRA_REP);
            if(rep.name != "Не указано") Name.setText(rep.name);

            if(rep.time != "Не указано")  Time.setText(rep.time);
            if(rep.instruction != "Не указано") Instruction.setText(rep.instruction);
            if(rep.products != "Не указано") Products.setText(rep.products);
            //придумать что-ниудь чтобы сохранить адаптер
        } else {
            rep = new Own_Recipes();
        }



    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.AddPhoto:
                //посмотрть добавление фоток через кнопку
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, GALLERY_REQUEST);
               // screen = bitmapToBytes(bitmap);
                break;
            case R.id.Save:

               // Photo = bitmap;
                /////
                if (Name.getText().length() > 0) {
                    rep.name = Name.getText().toString();
                }else rep.name = "Не указано";
                if (Time.getText().length() > 0) {
                    rep.time = Time.getText().toString();
                }else rep.time = "Не указано";
                if (Instruction.getText().length() > 0) {
                    rep.instruction = Instruction.getText().toString();
                }else rep.instruction = "Не указано";
                if (Products.getText().length() > 0) {
                    rep.products = Products.getText().toString();
                }else rep.products = "Не указано";
                if(Level.getAdapter().toString() != "Выберите сложность") {
                    rep.level = Level.getSelectedItem().toString();
                 }
                else rep.level = "Не указано";
                rep.timestamp = System.currentTimeMillis();
                if(bitmap!=null) rep.screen = bitmapToBytes(bitmap);

                    if (getIntent().hasExtra(EXTRA_REP)) {
                        MainActivity.getInstanceRep().getRepDao().update(rep);
                    } else {
                        MainActivity.getInstanceRep().getRepDao().insert(rep);
                    }
                    finish();
                    //////////
                break;

        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

        switch(requestCode) {
            case GALLERY_REQUEST:
                if(resultCode == RESULT_OK){

                    Uri selectedImage = imageReturnedIntent.getData();
                    try {
                        bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImage);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
        }
    }
    public static byte[] getBytes(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, stream);
        return stream.toByteArray();
    }
    public static byte[] bitmapToBytes(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        bitmap.recycle();
        try {
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArray;
    }
    // convert from byte array to bitmap
    public static Bitmap getImage(byte[] image) {
        return BitmapFactory.decodeByteArray(image, 0, image.length);
    }
}
