package com.example.registralaminasapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
    }

    public void nextPageRes(View vista){
        Toast toast = Toast.makeText(this, "Trabajando", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.START, 90,0);
        toast.show();
    }

    public void nextPage2(View vista1){
        String mensaje = "Bienvenido";
        Toast toast = Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.START, 90,0);
        toast.show();

        Intent nextPage = new Intent(this, MainActivity.class);
        startActivity(nextPage);

    }

    public void nextPage(View vista){
        Intent nextPage = new Intent(this, RegistroActivity.class);
        startActivity(nextPage);
    }

}
