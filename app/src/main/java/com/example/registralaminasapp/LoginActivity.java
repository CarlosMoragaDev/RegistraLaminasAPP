package com.example.registralaminasapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;

import java.util.concurrent.Executor;

public class LoginActivity extends AppCompatActivity {

    private EditText emailUser;
    private EditText passUser;
    private Button btnInicio;
    private Button btnHuella;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);


        emailUser = (EditText) findViewById(R.id.emailUser);
        passUser = (EditText) findViewById(R.id.passUser);
        btnInicio = (Button) findViewById(R.id.btnInicio);
        btnHuella = (Button) findViewById(R.id.btnHuella);

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

        btnHuella.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BiometricPrompt.PromptInfo promptInfo = new BiometricPrompt.PromptInfo.Builder()
                        .setTitle("Porfavor utilice su huella")
                        .setDescription("Autenticación de Usuario")
                        .setNegativeButtonText("Cancelar")
                        .build();
                getPrompt().authenticate(promptInfo);

            }
        });
    }

    //para ir a registro usuario
    public void nextPage(View vista){
        Intent nextPage = new Intent(this, RegistroActivity.class);
        startActivity(nextPage);
    }

    //para ir a recuperar contrseña
    public void nextPageRes(View vista){
        Toast toast = Toast.makeText(this, "Pronto disponible", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.START, 90,0);
        toast.show();
    }

    //para ir a home agregando nombre de usuario
    public void nextPage2(View vista1){
        String mensaje = "Bienvenido";
        Toast toast = Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.START, 90,0);
        toast.show();

        Intent nextPage = new Intent(this, MainActivity.class);
        startActivity(nextPage);
    }

    //recursos para ingreso biometrico
    private BiometricPrompt getPrompt()
    {
        Executor executor = ContextCompat.getMainExecutor(this);
        BiometricPrompt.AuthenticationCallback callback = new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
                Toast.makeText(LoginActivity.this,errString, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                intent.putExtra("nombre", emailUser.getText().toString());
                startActivity(intent);
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
                Toast.makeText(LoginActivity.this, "Error al leer huella", Toast.LENGTH_SHORT).show();
            }
        };
        BiometricPrompt biometricPrompt = new BiometricPrompt(this,executor,callback);
        return biometricPrompt;
    }


}
