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

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import java.util.Random;

public class RegistroActivity extends AppCompatActivity {

    //Button mostrarNotificacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro_layout);



        /*
        //notificacion
        mostrarNotificacion = (Button) findViewById(R.id.btnRegistrar);
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

    public void message(View view){
        generateNotification();
    }

    private void generateNotification(){
        NotificationManager notificationManager = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel("NOTIFICATION_URGENT _ID", "My Notifications", NotificationManager.IMPORTANCE_HIGH);
            notificationChannel.setDescription("Channel description");
            notificationChannel.enableLights(true);
            notificationChannel.setVibrationPattern(new long[]{0, 1000, 500, 1000});
            notificationChannel.enableVibration(true);

            notificationChannel.setGroup("id");
            notificationChannel.setShowBadge(true);
            assert notificationManager != null;
            notificationManager.createNotificationChannel(notificationChannel);
        }


        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, "NOTIFICATION_URGENT _ID");

        notificationBuilder.setAutoCancel(true)
                .setDefaults(Notification.DEFAULT_ALL)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setTicker("Mensajes")
                .setContentTitle("Notificación")
                .setContentIntent(onClick())
                .setContentText("Nuevo usuario registrado")
                .setContentInfo("New");


        Random random = new Random();
        int m = random.nextInt(9999 - 1000) + 1000;
        assert notificationManager != null;
        notificationManager.notify(/*notification id*/m, notificationBuilder.build());

    }
    public PendingIntent  onClick(){
        Intent notificationIntent = new Intent(this,
                MainActivity.class);
        startActivity(notificationIntent);
        notificationIntent.putExtra("age", "13");
        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        return PendingIntent.getActivity(this, 0,
                notificationIntent, 0);

    }

}
