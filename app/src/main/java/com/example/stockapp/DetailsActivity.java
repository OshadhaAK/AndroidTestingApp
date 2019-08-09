package com.example.stockapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    private TextView textView;
    private Button button;
    private String product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        product = intent.getStringExtra("message");
        textView = (TextView)findViewById(R.id.textView);
        button = (Button)findViewById(R.id.addToCart);

        textView.setText("Product Name : " +product+ "\nDate of manufacture : \nDate of expiry : \nprice : ");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailsActivity.this,CheckoutActivity.class);
                startActivity(intent);
            }
        });
    }
}
