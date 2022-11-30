package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity{

   @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);

       Button Schedule = (Button) findViewById(R.id.ButtonSchedule);
       Button Health = (Button) findViewById(R.id.ButtonHealth);
       Button Guide = (Button) findViewById(R.id.ButtonGuide);
       Button Profile = (Button) findViewById(R.id.ButtonProfile);

       Intent intent = new Intent();

       Profile.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent();
               intent.setClass(MainActivity.this,Profile.class);
               startActivity(intent);
           }
       });
       Schedule.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent();
               intent.setClass(MainActivity.this,Schedule.class);
               startActivity(intent);
           }
       });
       Health.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent();
               intent.setClass(MainActivity.this,Health.class);
               startActivity(intent);
           }
       });
       Guide.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent();
               intent.setClass(MainActivity.this,Guide.class);
               startActivity(intent);
           }
       });




   }




}