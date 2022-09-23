package com.example.registralaminasapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity{





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void nextPage1(View vista){
        Intent nextPage = new Intent(this, AlbumActivity.class);
        startActivity(nextPage);

    }


    public void nextPage2(View vista){
        Intent nextPage = new Intent(this, EvaluaActivity.class);
        startActivity(nextPage);

    }


}