package com.example.vintage_cloapp_coursework.activites;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vintage_cloapp_coursework.MainActivity;
import com.example.vintage_cloapp_coursework.R;

import java.security.MessageDigest;
import java.util.Base64;

public class LoginActivity2 extends AppCompatActivity {
    private EditText emailinput;
    private EditText passwordinput;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        emailinput = findViewById(R.id.email_address_input_loginpage);
        passwordinput = findViewById(R.id.password_input_loginpage);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String email = emailinput.getText().toString();
                String password  = passwordinput.getText().toString();
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                    password = Base64.getEncoder().encodeToString(messageDigest.digest(password.getBytes("UTF-8")));
                } catch (Exception e) {
                    // handle the exception
                    return;
                }

            }
        } );

    }

    public void register(View view) {
        startActivity(new Intent(LoginActivity2.this, RegistrationActivity2.class));

    }

    public void mainActivity(View view) {
        startActivity(new Intent(LoginActivity2.this, MainActivity.class));

    }
}