package com.example.registralaminasapp;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import java.util.Random;

public class RegistroActivity extends AppCompatActivity {

    private Button mostrarNotificacion;
    private Button btnGuardarReg;
    private EditText usuario;
    private EditText emailUsuario;
    private EditText comunaUsuario;
    private EditText passUsuario;
    private EditText confirmarPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro_layout);

        usuario = (EditText) findViewById(R.id.usuario);
        emailUsuario = (EditText) findViewById(R.id.emailUsuario);
        comunaUsuario = (EditText) findViewById(R.id.comunaUsuario);
        passUsuario = (EditText) findViewById(R.id.passUsuario);
        confirmarPass = (EditText) findViewById(R.id.confirmarPass);
        btnGuardarReg = (Button) findViewById(R.id.btnGuardarReg);

        btnGuardarReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!usuario.getText().toString().isEmpty() &&
                        !emailUsuario.getText().toString().isEmpty()
                        && !comunaUsuario.getText().toString().isEmpty()
                        && !passUsuario.getText().toString().isEmpty()
                        && !confirmarPass.getText().toString().isEmpty()) {
                    Intent intent = new Intent(RegistroActivity.this, MainActivity.class);
                    intent.putExtra("nombre", usuario.getText().toString());
                    startActivity(intent);

                } else {
                    Toast.makeText(RegistroActivity.this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
                }
            }

        });

    }

}
