package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileNotFoundException;
import java.io.InputStream;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.Serializable;


public class Profile extends AppCompatActivity {
    EditText nameBox;
    EditText yearBox;
    EditText speciesBox;
    Button saveButton;
    SQLiteDatabase db;
    Cursor userCursor;
    long userId = 0;

    private DogRepository dogRepository;

    private ImageButton buttonImage;
    private final int Pick_image = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        dogRepository = new DogRepository((getApplication()));
        nameBox = findViewById(R.id.NameBox);
        yearBox = findViewById(R.id.AgeBox);
        speciesBox = findViewById(R.id.SpeciesBox);
        saveButton = findViewById(R.id.ButtonSave);
        buttonImage = (ImageButton) findViewById(R.id.ButtonImage);

        saveButton.setOnClickListener(view -> {
            String name = nameBox.getText().toString();
            int age = Integer.parseInt(yearBox.getText().toString());
            String species = speciesBox.getText().toString();
            dogRepository.insertDog(name, species, age);
            finish();
        });


        ImageButton PickImage = (ImageButton) findViewById(R.id.ButtonImage);
        PickImage.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_GET_CONTENT);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, 1);
            }

        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

        switch (requestCode) {
            case Pick_image:
                if (resultCode == RESULT_OK) {
                    try {

                        final Uri imageUri = imageReturnedIntent.getData();
                        final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                        final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                        buttonImage.setImageBitmap(selectedImage);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
        }
    }
}