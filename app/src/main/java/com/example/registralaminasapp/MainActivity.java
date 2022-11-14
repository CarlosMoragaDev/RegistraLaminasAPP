package com.example.registralaminasapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Bundle bundle;
    private TextView saludoInicio;

    //clasesasynctask
    Button btnAlbumProceso;
    ProgressBar progressBarProceso;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saludoInicio = (TextView) findViewById(R.id.saludoInicio);

        bundle = getIntent().getExtras();

        String saludo = bundle.getString("nombre");

        saludoInicio.append(" " + saludo);

        //AsyncTask
        btnAlbumProceso = (Button) findViewById(R.id.btnAlbumProceso);
        progressBarProceso = (ProgressBar) findViewById(R.id.progressBarProceso);

        btnAlbumProceso.setOnClickListener(this);


    }
    public void nextPageAlbum(View vista){
        Intent nextPage = new Intent(this, AlbumActivity.class);
        startActivity(nextPage);

    }


    public void nextPageEvaluacion(View vista){
        Intent nextPage = new Intent(this, EvaluaActivity.class);
        startActivity(nextPage);

    }

    //componentes de proceso AsyncTask
    //ASyncTask

    private void UnSegundo(){
        try{
            Thread.sleep(200);
        }catch (InterruptedException e){}
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAlbumProceso:
                EjemploAsyncTask ejemploAsyncTask = new
                        EjemploAsyncTask();
                ejemploAsyncTask.execute();
                break;
            default:
                break;
        }
    }

    private class EjemploAsyncTask extends
            AsyncTask<Void,Integer,Boolean> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBarProceso.setMax(100);
            progressBarProceso.setProgress(0);
        }
        @Override
        protected Boolean doInBackground(Void... params) {
            for(int i=1; i<=10; i++){
                UnSegundo();
                publishProgress(i*10);
                if(isCancelled()){
                    break;
                }
            }
            return true;
        }
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBarProceso.setProgress(values[0].intValue());
        }
        @Override
        protected void onPostExecute(Boolean aVoid) {
            super.onPostExecute(aVoid);
            Toast.makeText(getBaseContext(),"Creacion de Album Finalizada en AsyncTask", Toast.LENGTH_LONG).show();
            Intent nextPage = new Intent(MainActivity.this, AlbumActivity.class);
            startActivity(nextPage);
        }
        @Override
        protected void onCancelled() {
            super.onCancelled();
            Toast.makeText(getBaseContext(),
                    "La creacion ha sido cancelada", Toast.LENGTH_LONG).show();
        }
    }

    public void nextPageMapa(View vista){
        Intent nextPage = new Intent(this, MapaActivity.class);
        startActivity(nextPage);

    }




}