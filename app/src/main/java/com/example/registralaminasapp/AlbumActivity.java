package com.example.registralaminasapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AlbumActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_layout);

        // Inicializar Animes
        List<Album> items = new ArrayList<>();
        items.add(new Album(R.drawable.portadadbz1, "10", "10", ""));
        items.add(new Album(R.drawable.portadadbz2, "10", "10", ""));

        // Obtener el Recycler
        recycler = (RecyclerView) findViewById(R.id.my_recycler_view);
        recycler.setHasFixedSize(true);

        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);

        // Crear un nuevo adaptador
        adapter = new AlbumAdapter(items);
        recycler.setAdapter(adapter);
    }

    public void chkPage(View vista){
        Intent nextPage = new Intent(this, ChkActivity.class);
        startActivity(nextPage);
    }
}
