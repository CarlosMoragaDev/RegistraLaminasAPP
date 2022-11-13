package com.example.registralaminasapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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

    private EditText username, password;
    private Button btnsignin;
    DBHelper DB;
    private Button btnHuella;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        btnsignin = (Button) findViewById(R.id.btnsignin);
        DB = new DBHelper(this);
        btnHuella = (Button) findViewById(R.id.btnHuella);

        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user=username.getText().toString();
                String pass=password.getText().toString();

                if(TextUtils.isEmpty(user) || TextUtils.isEmpty(pass))
                    Toast.makeText(LoginActivity.this,"LLenar todos los campos", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkusepass= DB.checkusernamepassword(user,pass);
                    if(checkusepass==true){
                        Toast.makeText(LoginActivity.this, "Inicio de sesion exitoso", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        intent.putExtra("nombre", username.getText().toString());
                        startActivity(intent);
                    }else{
                        Toast.makeText(LoginActivity.this, "Error al iniciar sesion", Toast.LENGTH_SHORT).show();
                    }
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

    /*para ir a home agregando nombre de usuario
    public void nextPage2(View vista1){
        String mensaje = "Bienvenido";
        Toast toast = Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.START, 90,0);
        toast.show();

        Intent nextPage = new Intent(this, MainActivity.class);
        startActivity(nextPage);
    }*/

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
                intent.putExtra("nombre", username.getText().toString());
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
