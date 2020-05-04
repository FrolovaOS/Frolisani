package com.example.Recipes.screens.OwnRecipes;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import com.example.Recipes.R;
import com.example.Recipes.model_Adding_Recipes.Own_Recipes;
import com.example.Recipes.screens.MainActivity;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDate;
import java.time.LocalTime;

public class Add_Form_Recipes extends AppCompatActivity implements View.OnClickListener {

  static final int GALLERY_REQUEST = 1;
  private static final int REQUEST_EXTERNAL_STORAGE = 1;
  EditText Time, Name, Instruction, Products;
  Spinner Level;
  Button AddPhoto, Save;
  String path = "";
  String folderToSave = Environment.getExternalStorageDirectory().toString();
  Bitmap bitmap = null;

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
      if (rep.name != "Не указано") Name.setText(rep.name);

      if (rep.time != "Не указано") Time.setText(rep.time);
      if (rep.instruction != "Не указано") Instruction.setText(rep.instruction);
      if (rep.products != "Не указано") Products.setText(rep.products);

    } else {
      rep = new Own_Recipes();
    }
  }

  @RequiresApi(api = Build.VERSION_CODES.O)
  @Override
  public void onClick(View v) {
    switch (v.getId()) {
      case R.id.AddPhoto:
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, GALLERY_REQUEST);

        break;
      case R.id.Save:
        if (Name.getText().length() > 0) {
          rep.name = Name.getText().toString();
        } else rep.name = "Не указано";
        if (Time.getText().length() > 0) {
          rep.time = Time.getText().toString();
        } else rep.time = "Не указано";
        if (Instruction.getText().length() > 0) {
          rep.instruction = Instruction.getText().toString();
        } else rep.instruction = "Не указано";
        if (Products.getText().length() > 0) {
          rep.products = Products.getText().toString();
        } else rep.products = "Не указано";
        if (Level.getAdapter().toString() != "Выберите сложность") {
          rep.level = Level.getSelectedItem().toString();
        } else rep.level = "Не указано";
        rep.timestamp = System.currentTimeMillis();
        try {

          SavePicture(folderToSave);
        } catch (IOException e) {
          e.printStackTrace();
        }
        if (bitmap != null) {

          rep.screen = path;
        }

        if (getIntent().hasExtra(EXTRA_REP)) {
          MainActivity.getInstanceRep().getAppDao().updateR(rep);
        } else {
          MainActivity.getInstanceRep().getAppDao().insertR(rep);
        }
        finish();
        break;

      default:
        throw new IllegalStateException("Unexpected value: " + v.getId());
    }
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
    super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

    switch (requestCode) {
      case GALLERY_REQUEST:
        if (resultCode == RESULT_OK) {

          Uri selectedImage = imageReturnedIntent.getData();
          try {
            bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImage);

          } catch (IOException e) {
            e.printStackTrace();
          }
        }
    }
  }

  @RequiresApi(api = Build.VERSION_CODES.O)
  private String SavePicture(String folderToSave) throws IOException {

    LocalDate dates = LocalDate.now();
    LocalTime time = LocalTime.now();
    OutputStream fOut = null;

    try {
      File file =
          new File(
              folderToSave,
              Integer.toString(dates.getYear())
                  + Integer.toString(dates.getMonthValue() + 1)
                  + Integer.toString(dates.getDayOfMonth())
                  + Integer.toString(time.getHour())
                  + Integer.toString(time.getMinute())
                  + ".jpg"); // создать уникальное имя для файла основываясь на дате сохранения
      if (file.exists()) {
        file.delete();
      }
      ActivityCompat.requestPermissions(
          this,
          new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE},
          REQUEST_EXTERNAL_STORAGE);
      if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
          == PackageManager.PERMISSION_GRANTED) {
        fOut = new FileOutputStream(file.getPath());
      }

      bitmap.compress(
          Bitmap.CompressFormat.JPEG, 85, fOut); // сохранять картинку в jpeg-формате с 85% сжатия.
      path = file.getPath();
      fOut.flush();
      fOut.close();
      MediaStore.Images.Media.insertImage(
          getContentResolver(),
          file.getAbsolutePath(),
          file.getName(),
          file.getName()); // регистрация в фотоальбоме
      path = file.getPath();
    } catch (
        Exception
            e) // здесь необходим блок отслеживания реальных ошибок и исключений, общий Exception
    // приведен в качестве примера
    {
      return e.getMessage();
    }
    return "";
  }

  public void onRequestPermissionsResult(
      int requestCode, String[] permissions, int[] grantResults) {

    boolean granted = true;
    if (requestCode == REQUEST_EXTERNAL_STORAGE) {

      if (grantResults.length > 0) {
        for (int result : grantResults) {
          if (result != PackageManager.PERMISSION_GRANTED) {
            granted = false;
          }
        }
      } else {
        granted = false;
      }
    }
  }
}
