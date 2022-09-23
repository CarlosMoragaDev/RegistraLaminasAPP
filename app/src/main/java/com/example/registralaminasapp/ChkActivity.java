package com.example.registralaminasapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class ChkActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener  {



    String[] listaAlbum = {"Todas", "Faltantes", "Repetidas"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chk_layout);

        //Accediendo a spinner
        Spinner spin = (Spinner)findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);

        //array
        ArrayAdapter Album= new ArrayAdapter(this,android.R.layout.simple_spinner_item,listaAlbum);
        Album.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //datos de array al spinner
        spin.setAdapter(Album);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

