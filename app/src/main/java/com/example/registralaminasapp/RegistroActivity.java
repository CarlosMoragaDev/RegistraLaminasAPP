package com.example.registralaminasapp;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import java.util.Random;

public class RegistroActivity extends AppCompatActivity {

    private Button btnregistrar;
    private EditText username, password, repassword;
    DBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro_layout);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        repassword = (EditText) findViewById(R.id.repassword);
        btnregistrar = (Button) findViewById(R.id.btnregistrar);
        DB= new DBHelper(this);

        btnregistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user= username.getText().toString();
                String pass= password.getText().toString();
                String repass= repassword.getText().toString();

                if(TextUtils.isEmpty(user) ||TextUtils.isEmpty(pass) || TextUtils.isEmpty(repass))
                    Toast.makeText(RegistroActivity.this, "Llenar todos los campos",Toast.LENGTH_SHORT).show();
                else{
                    if(pass.equals(repass)){
                        Boolean checkuser = DB.checkusername(user);
                        if(checkuser==false){
                            Boolean insert = DB.insertData(user,pass);
                            if(insert==true){
                                Toast.makeText(RegistroActivity.this, "Registro exitoso",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(RegistroActivity.this, "Fallo el registro",Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(RegistroActivity.this, "Usuario ya registrado",Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(RegistroActivity.this, "Contraseña no coincide",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

}
