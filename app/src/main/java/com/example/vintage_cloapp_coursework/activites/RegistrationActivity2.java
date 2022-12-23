package com.example.vintage_cloapp_coursework.activites;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vintage_cloapp_coursework.R;


public class RegistrationActivity2 extends AppCompatActivity {

    private EditText fnameinput;
    private EditText lnameinput;
    private EditText emailinput;
    private EditText passwordinput;
    private EditText repasswordinput;
    private EditText phonenumberinput;
    Button registerbutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration2);

        fnameinput = findViewById(R.id.firstname_input);
        lnameinput = findViewById(R.id.lastame_input);
        emailinput = findViewById(R.id.email_address_input);
        passwordinput = findViewById(R.id.password_input);
        repasswordinput = findViewById(R.id.re_password_input);
        phonenumberinput = findViewById(R.id.phone_number_input);
        registerbutton = findViewById(R.id.regist_button);

        registerbutton.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateEmailAddress(emailinput);

            }
        }));


    }

    private  boolean validateEmailAddress( EditText emailinput){
        String email =  emailinput.getText().toString();
        if(!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            Toast.makeText(this,"valid email address",Toast.LENGTH_SHORT).show();
            return true;
        }else{
            Toast.makeText(this,"invalid email address",Toast.LENGTH_SHORT).show();
            return false;
        }

    }

    public void login(View view) {
        startActivity(new Intent(RegistrationActivity2.this, LoginActivity2.class));
    }

/*    public void mainActivity(View view) {
        startActivity(new Intent(RegistrationActivity2.this, MainActivity.class));

    }*/
}