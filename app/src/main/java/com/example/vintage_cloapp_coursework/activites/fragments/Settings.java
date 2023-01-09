package com.example.vintage_cloapp_coursework.activites.fragments;

import static com.firebase.ui.auth.AuthUI.getApplicationContext;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.vintage_cloapp_coursework.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Settings extends Fragment {
    // Assume that you have a Button and EditText fields in your layout
    Button updateButton;
    EditText emailEditText;
    EditText passwordEditText;
    EditText firstNameEditText;
    EditText lastNameEditText;
    EditText cardNumberEditText;
    EditText expiryDateEditText;
    EditText cvvEditText;

    // Reference to the Firebase database
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_settings, container, false);

        updateButton = root.findViewById(R.id.update_button);
        emailEditText = root.findViewById(R.id.edit_text_email);
        passwordEditText = root.findViewById(R.id.edit_text_password);
        firstNameEditText = root.findViewById(R.id.edit_text_first_name);
        lastNameEditText = root.findViewById(R.id.edit_text_last_name);
        cardNumberEditText = root.findViewById(R.id.edit_text_card_number);
        expiryDateEditText = root.findViewById(R.id.edit_text_expiry_date);
        cvvEditText = root.findViewById(R.id.edit_text_cvv);

        // Retrieve data from the database when the app starts
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // Get the data from the database
                String email = dataSnapshot.child("email").getValue(String.class);
                String password = dataSnapshot.child("password").getValue(String.class);
                String firstName = dataSnapshot.child("firstName").getValue(String.class);
                String lastName = dataSnapshot.child("lastName").getValue(String.class);
                String cardNumber = dataSnapshot.child("cardNumber").getValue(String.class);
                String expiryDate = dataSnapshot.child("expiryDate").getValue(String.class);
                String cvv = dataSnapshot.child("cvv").getValue(String.class);

                // Set the data in the EditText fields
                emailEditText.setText(email);
                passwordEditText.setText(password);
                firstNameEditText.setText(firstName);
                lastNameEditText.setText(lastName);
                cardNumberEditText.setText(cardNumber);
                expiryDateEditText.setText(expiryDate);
                cvvEditText.setText(cvv);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle error
            }
        });

        // Update the data in the database when the button is pressed
        updateButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onClick(View view) {
                // Get the data from the EditText fields
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                String firstName = firstNameEditText.getText().toString();
                String lastName = lastNameEditText.getText().toString();


                // Update the data in the database
                database.child("email").setValue(email);
                database.child("password").setValue(password);
                database.child("firstName").setValue(firstName);
                database.child("lastName").setValue(lastName);

                Toast.makeText(getApplicationContext(), "Settings Updated", Toast.LENGTH_SHORT).show();            }
        });

        return root;
    }
}

