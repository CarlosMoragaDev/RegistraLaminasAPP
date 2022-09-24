package com.example.registralaminasapp;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class RegistroActivity extends AppCompatActivity {

    Button mostrarNotificacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro_layout);

        /*
        //notificacion
        mostrarNotificacion = (Button) findViewById(R.id.inicioSesion);
        mostrarNotificacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vista) {
                NotificationCompat.Builder mBuilder;
                NotificationManager mNotifyMgr = (NotificationManager)
                        getApplicationContext().getSystemService(NOTIFICATION_SERVICE);

                int icono = R.mipmap.ic_launcher;
                Intent i = new Intent(RegistroActivity.this, MainActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(RegistroActivity.this, 0, i,0);
                startActivity(i);
                mBuilder = new NotificationCompat.Builder(getApplicationContext())
                        .setContentIntent(pendingIntent)
                        .setSmallIcon(icono)
                        .setContentTitle("Aviso")
                        .setContentText("Nuevo usuario registrado")
                        .setVibrate(new long[]{100,250,100,500})
                        .setAutoCancel(true);

                mNotifyMgr.notify(1, mBuilder.build());

            }
        });*/


    }


}
