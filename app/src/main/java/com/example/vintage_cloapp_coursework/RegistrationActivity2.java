package com.example.vintage_cloapp_coursework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RegistrationActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration2);
    }

    public void login(View view) {
        startActivity(new Intent(RegistrationActivity2.this,LoginActivity2.class));
    }

    public void mainActivity(View view) {
        startActivity(new Intent(RegistrationActivity2.this,MainActivity.class));

    }
}