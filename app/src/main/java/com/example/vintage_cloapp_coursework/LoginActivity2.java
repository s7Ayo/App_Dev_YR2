package com.example.vintage_cloapp_coursework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
    }

    public void register(View view) {
        startActivity(new Intent(LoginActivity2.this,RegistrationActivity2.class));

    }

    public void mainActivity(View view) {
        startActivity(new Intent(LoginActivity2.this,MainActivity.class));

    }
}