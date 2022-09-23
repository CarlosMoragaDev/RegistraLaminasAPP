package com.example.registralaminasapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class EvaluaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.evalua_layout);

    }

    public void nextPage(View vista){
        Intent nextPage = new Intent(this,MainActivity.class);
        startActivity(nextPage);

    }


}
