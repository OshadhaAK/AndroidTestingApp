package com.example.stockapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button signUpButton;
    private Button signInButton;
    private EditText userName;
    private EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signUpButton = (Button)findViewById(R.id.SignUp);
        signInButton = (Button)findViewById(R.id.SignIn);
        userName = (EditText)findViewById(R.id.userName);
        password = (EditText)findViewById(R.id.password);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    Intent intent = new Intent(MainActivity.this,SignUpActivity.class);
                    startActivity(intent);



            }
        });

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(userName.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
                    Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                    startActivity(intent);
                }
                else if (userName.getText().toString().equals("") || password.getText().toString().equals("")){
                    if(userName.getText().toString().equals("")){
                        userName.setError("Cannot be empty!");
                    }
                    else if (password.getText().toString().equals("")){
                        password.setError("Cannot be empty!");
                    }

                }
                else {
                    Toast.makeText(getApplicationContext(),"Wrong Credentials",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
