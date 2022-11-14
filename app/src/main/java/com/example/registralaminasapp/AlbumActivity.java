package com.example.registralaminasapp;

import static com.example.registralaminasapp.DBmain.TABLENAME;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AlbumActivity extends AppCompatActivity {

    DBmain dBmain;
    SQLiteDatabase sqLiteDatabase;
    EditText nombre, normales, especiales;
    Button submit, display, edit;
    int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.album_layout);
        dBmain = new DBmain(this);
        //create method
        findid();
        insertData();
        editData();
    }

    private void editData() {
        if (getIntent().getBundleExtra("userdata")!=null){
            Bundle bundle=getIntent().getBundleExtra("userdata");
            id=bundle.getInt("id");
            nombre.setText(bundle.getString("nombre"));
            normales.setText(bundle.getString("normales"));
            especiales.setText(bundle.getString("especiales"));
            edit.setVisibility(View.VISIBLE);
            submit.setVisibility(View.GONE);
        }
    }

    private void insertData() {
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues cv = new ContentValues();
                cv.put("nombre", nombre.getText().toString());
                cv.put("normales", normales.getText().toString());
                cv.put("especiales", especiales.getText().toString());

                sqLiteDatabase = dBmain.getWritableDatabase();
                Long recinsert = sqLiteDatabase.insert(TABLENAME, null, cv);
                if (recinsert != null) {
                    Toast.makeText(AlbumActivity.this, "successfully inserted data", Toast.LENGTH_SHORT).show();
                    //clear when click on submit
                    nombre.setText("");
                    normales.setText("");
                    especiales.setText("");
                } else {
                    Toast.makeText(AlbumActivity.this, "something wrong try again", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //when click on display button open display data activity
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AlbumActivity.this, DisplayData.class);
                startActivity(intent);
            }
        });
        //storing edited data
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues cv=new ContentValues();
                cv.put("nombre",nombre.getText().toString());
                cv.put("normales",normales.getText().toString());
                cv.put("especiales",especiales.getText().toString());

                sqLiteDatabase=dBmain.getReadableDatabase();
                long recedit=sqLiteDatabase.update(TABLENAME,cv,"id="+id,null);
                if (recedit!=-1){
                    Toast.makeText(AlbumActivity.this, "Data updated successfully", Toast.LENGTH_SHORT).show();
                    submit.setVisibility(View.VISIBLE);
                    edit.setVisibility(View.GONE);
                }else{
                    Toast.makeText(AlbumActivity.this, "something wrong try again", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void findid() {
        nombre = (EditText) findViewById(R.id.edit_nombre);
        normales = (EditText) findViewById(R.id.edit_normales);
        especiales = (EditText) findViewById(R.id.edit_especiales);
        submit = (Button) findViewById(R.id.submit_btn);
        display = (Button) findViewById(R.id.display_btn);
        edit = (Button) findViewById(R.id.edit_btn);
    }
}
