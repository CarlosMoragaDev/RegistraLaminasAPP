package com.example.registralaminasapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    private Bundle bundle;
    private TextView saludoInicio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saludoInicio = (TextView) findViewById(R.id.saludoInicio);

        bundle = getIntent().getExtras();

        String saludo = bundle.getString("nombre");

        saludoInicio.append(" " + saludo);


    }
    public void nextPageAlbum(View vista){
        Intent nextPage = new Intent(this, AlbumActivity.class);
        startActivity(nextPage);

    }


    public void nextPageEvaluacion(View vista){
        Intent nextPage = new Intent(this, EvaluaActivity.class);
        startActivity(nextPage);

    }


}