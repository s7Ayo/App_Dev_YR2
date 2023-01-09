package com.example.vintage_cloapp_coursework.activites;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.vintage_cloapp_coursework.MainActivity;
import com.example.vintage_cloapp_coursework.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.security.MessageDigest;
import java.util.Base64;

public class LoginActivity2 extends AppCompatActivity {
    private EditText emailinput;
    private EditText passwordinput;
    Button button;
    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        button = (Button) findViewById(R.id.button);
        emailinput = (EditText) findViewById(R.id.email_address_input_loginpage);
        passwordinput = (EditText) findViewById(R.id.password_input_loginpage);


        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity2.this, MainActivity.class));
                final String email = emailinput.getText().toString();
                String password  = passwordinput.getText().toString();
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                    password = Base64.getEncoder().encodeToString(messageDigest.digest(password.getBytes("UTF-8")));
                } catch (Exception e) {
                    // handle the exception
                    return;
                }

                // Retrieve data from the database
                //DatabaseReference database = FirebaseDatabase.getInstance().getReference();
                String finalPassword = password;
                root.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        // Check if email exists in the database
                        if (dataSnapshot.child("users").hasChild(email)) {
                            // Email exists, check if password is correct
                            String correctPassword = dataSnapshot.child("users").child(email).child("password").getValue(String.class);
                            if (finalPassword.equals(correctPassword)) {
                                // Password is correct, allow user to sign in
                                Toast.makeText(getApplicationContext(), "LOGIN SUCCESSFULL", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(LoginActivity2.this, MainActivity.class));
                            } else {
                                // Password is incorrect, show error message
                                Toast.makeText(getApplicationContext(), "LOGIN UNSUCCESSFULL ", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            // Email does not exist, show error message
                            Toast.makeText(getApplicationContext(), "LOGIN UNSUCCESSFULL ", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        return;
                    }


                });
            }
        });
    }



    public void register(View view) {
        startActivity(new Intent(LoginActivity2.this, RegistrationActivity2.class));

    }

    public void mainActivity(View view) {
        startActivity(new Intent(LoginActivity2.this, MainActivity.class));

    }
}