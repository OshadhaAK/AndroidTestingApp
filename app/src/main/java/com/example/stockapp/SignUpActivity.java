package com.example.stockapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUpActivity extends AppCompatActivity {

    private Button signUpbtn;
    private EditText userName;
    private EditText emailAddress;
    private EditText phoneNumber;
    private EditText password;
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
                Intent intent = new Intent(SignUpActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}
