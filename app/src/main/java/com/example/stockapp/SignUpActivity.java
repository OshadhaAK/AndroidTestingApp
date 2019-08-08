package com.example.stockapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    private Button signUpbtn;
    private EditText userName;
    private EditText emailAddress;
    private EditText phoneNumber;
    private EditText password;
    private String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signUpbtn = (Button)findViewById(R.id.btnSignup);
        userName = (EditText)findViewById(R.id.user_name);
        emailAddress = (EditText)findViewById(R.id.emailAddress);
        phoneNumber = (EditText)findViewById(R.id.phoneNum);
        password = (EditText)findViewById(R.id.addPassword);

        signUpbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(userName.getText().toString().isEmpty()){
                    userName.setError("Cannot be empty!");
                }
                else if(emailAddress.getText().toString().isEmpty()){
                    emailAddress.setError("Cannot be empty!");
                }
                else if(phoneNumber.getText().toString().isEmpty()){
                    phoneNumber.setError("Cannot be empty!");
                }
                else if(password.getText().toString().isEmpty()){
                    password.setError("Cannot be empty!");
                }
                else {
                    if (emailAddress.getText().toString().trim().matches(emailPattern)){
                        Toast.makeText(getApplicationContext(),"Welcome!",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(SignUpActivity.this,HomeActivity.class);
                        startActivity(intent);
                    }
                    else{
                        emailAddress.setError("Invalid email address!");
                    }

                }

            }
        });




    }
}
