package com.example.registralaminasapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText emailUser;
    private EditText passUser;
    private Button btnInicio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);


        emailUser = (EditText) findViewById(R.id.emailUser);
        passUser = (EditText) findViewById(R.id.passUser);
        btnInicio = (Button) findViewById(R.id.btnInicio);

        btnInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!emailUser.getText().toString().isEmpty() && !passUser.getText().toString().isEmpty()){
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("nombre", emailUser.getText().toString());
                    startActivity(intent);

                }
                else{
                    Toast.makeText(LoginActivity.this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }



    public void nextPage(View vista){
        Intent nextPage = new Intent(this, RegistroActivity.class);
        startActivity(nextPage);
    }

    public void nextPageRes(View vista){
        Toast toast = Toast.makeText(this, "Pronto disponible", Toast.LENGTH_SHORT);
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

}
