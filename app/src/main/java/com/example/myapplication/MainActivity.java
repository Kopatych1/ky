package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.database.DogDBItem;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    private TextView textView3;

    private DogRepository dogRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dogRepository = new DogRepository(getApplication());
        Button Schedule = (Button) findViewById(R.id.ButtonSchedule);
        Button Health = (Button) findViewById(R.id.ButtonHealth);
        Button Guide = (Button) findViewById(R.id.ButtonGuide);
        Button Profile = (Button) findViewById(R.id.ButtonProfile);
        textView3 = (TextView) findViewById(R.id.textView3);

        Intent intent = new Intent();

        Profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, Profile.class);
                startActivity(intent);
            }
        });
        Schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, Schedule.class);
                startActivity(intent);
            }
        });
        Health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, Health.class);
                startActivity(intent);
            }
        });
        Guide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, Guide.class);
                startActivity(intent);
            }
        });

        dogRepository.getDogList().observe(this, new Observer<List<DogDBItem>>() {
            @Override
            public void onChanged(List<DogDBItem> dogDBItems) {
                if (dogDBItems.size() > 0) {
                    DogDBItem lastItem = dogDBItems.get(dogDBItems.size() - 1);
                    textView3.setText(lastItem.getName() + " " + lastItem.getClassification() + " " + lastItem.getAge());
                }
            }
        });

    }
}




