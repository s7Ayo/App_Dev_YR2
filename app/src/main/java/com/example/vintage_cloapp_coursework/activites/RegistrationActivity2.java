package com.example.vintage_cloapp_coursework.activites;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vintage_cloapp_coursework.MainActivity;
import com.example.vintage_cloapp_coursework.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.security.MessageDigest;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;


public class RegistrationActivity2 extends AppCompatActivity {

    private EditText fnameinput;
    private EditText lnameinput;
    private EditText emailinput;
    private EditText passwordinput;
    private EditText repasswordinput;
    private EditText phonenumberinput;
    Button registerbutton;


    private  FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference();
// ...
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

        Map<String,Object> users = new HashMap<>();
        /*
        users.put("fname",fnameinput);
        users.put("lname", lnameinput);
        users.put("email", emailinput);
        users.put("password",passwordinput);
        users.put("phonenumber",phonenumberinput);
        */

        registerbutton.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (validateEmailAddress(emailinput) && validateFName(fnameinput) && validateLName(lnameinput) && validatePhnum(phonenumberinput) && validatePassword(passwordinput, repasswordinput)) {
                    // Use the view's context for the Toast
                    String fname =  fnameinput.getText().toString();
                    String lname =  lnameinput.getText().toString();
                    String email = emailinput.getText().toString();
                    String password  = passwordinput.getText().toString();
                    try {
                        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                        password = Base64.getEncoder().encodeToString(messageDigest.digest(password.getBytes("UTF-8")));
                    } catch (Exception e) {
                        // handle the exception
                        return;
                    }
                    String phonenumber = phonenumberinput.getText().toString();

                    users.put("fname",fname);
                    users.put("lname", lname);
                    users.put("email", email);
                    users.put("password", password);
                    users.put("phonenumber", phonenumber);

                    root.child("users").child(phonenumber).updateChildren(users);
                    //FirebaseDatabase.getInstance().setLogLevel(Logger.Level.DEBUG);
                    Toast.makeText(view.getContext(), "You have been registered", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RegistrationActivity2.this, LoginActivity2.class));



                    return;
                }else{
                    return;
                }
            }
        }));


    }


    private  boolean validateEmailAddress( EditText emailinput){
        String email =  emailinput.getText().toString();
        if(!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            //Toast.makeText(this,"valid email address",Toast.LENGTH_SHORT).show();
            return true;
        }else{
            Toast.makeText(this,"invalid email address",Toast.LENGTH_SHORT).show();
            return false;
        }

    }

    private boolean validateFName(EditText fnameinput){
        String Fname = fnameinput.getText().toString();
        if(Fname.isEmpty()){
            Toast.makeText(this, "Please Enter a Valid First Name",Toast.LENGTH_SHORT).show();
            return false;
        }else{
            return true;
        }

    }

    private boolean validateLName(EditText lnameinput){
        String Lname = lnameinput.getText().toString();
        if(Lname.isEmpty()){
            Toast.makeText(this, "Please Enter a Valid Last Name",Toast.LENGTH_SHORT).show();
            return false;
        }else{
            return true;
        }

    }

    private  boolean validatePassword(EditText passwordinput, EditText repasswordinput ){
        String password = passwordinput.getText().toString();
        String repassword = repasswordinput.getText().toString();
        if (!password.isEmpty() && !repassword.isEmpty() && password.equals(repassword)){
            return true;
        }else if(password.isEmpty()){

            Toast.makeText(this, "Please Enter a Password",Toast.LENGTH_SHORT).show();
            return false;

        }else if(repassword.isEmpty()) {

            Toast.makeText(this, "Please Enter a RePassword", Toast.LENGTH_SHORT).show();
            return false;

        }else{
            Toast.makeText(this, "Make your Password and Repassword the same",Toast.LENGTH_SHORT).show();
            return false;
        }


    }

    private boolean validatePhnum(EditText phonenumberinput ){
        String PhoneNUM = phonenumberinput.getText().toString();
        if (!PhoneNUM.isEmpty() && PhoneNUM.matches("^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$")){
            return true;
        }else{
            Toast.makeText(this, "Please Enter a Valid PhoneNumber",Toast.LENGTH_SHORT).show();
            return false;
        }

    }



    public void login(View view) {
        startActivity(new Intent(RegistrationActivity2.this, LoginActivity2.class));
    }




    public void mainActivity(View view) {
        startActivity(new Intent(RegistrationActivity2.this, MainActivity.class));

    }

}