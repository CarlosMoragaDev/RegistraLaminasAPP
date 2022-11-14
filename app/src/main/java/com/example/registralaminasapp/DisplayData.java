package com.example.registralaminasapp;

import static com.example.registralaminasapp.DBmain.TABLENAME;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DisplayData extends AppCompatActivity {
    DBmain dBmain;
    SQLiteDatabase sqLiteDatabase;
    RecyclerView recyclerView;
    AlbumAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_layout);
        dBmain=new DBmain(this);
        //create method
        findid();
        displayData();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void displayData() {
        sqLiteDatabase=dBmain.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("select *from "+TABLENAME+"",null);
        ArrayList<Album> albumArrayList=new ArrayList<>();
        while (cursor.moveToNext()){
            int id=cursor.getInt(0);
            String nombre=cursor.getString(1);
            String normales=cursor.getString(2);
            String especiales=cursor.getString(3);
            albumArrayList.add(new Album(id, nombre, normales, especiales));
        }
        cursor.close();
        myAdapter=new AlbumAdapter(this,R.layout.singledata,albumArrayList,sqLiteDatabase);
        recyclerView.setAdapter(myAdapter);
    }

    private void findid() {
        recyclerView=findViewById(R.id.my_recycler_view);
    }

}
