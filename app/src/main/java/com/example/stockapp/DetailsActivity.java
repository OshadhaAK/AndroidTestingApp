package com.example.stockapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import Models.Product;
import io.realm.Realm;

public class DetailsActivity extends AppCompatActivity {

    private TextView textView;
    private Button button;
    private String product;
    private Button btnHome;
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        product = intent.getStringExtra("message");
        textView = (TextView)findViewById(R.id.textView);
        button = (Button)findViewById(R.id.addToCart);
        btnHome = (Button)findViewById(R.id.btnHome);

        Realm.init(this);
        realm = Realm.getDefaultInstance();
        textView.setText("Product Name : " +product+ "\nDate of manufacture : \nDate of expiry : \nprice : ");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                realm.beginTransaction();
                Product obj = realm.createObject(Product.class);

                obj.setProductName(product);
                obj.setPrice(50);
                obj.setDateOfExpire("7/8/2015");
                obj.setDataOfManufacture("8/4/2010");

                realm.commitTransaction();
                finish();

                Intent intent = new Intent(DetailsActivity.this,CheckoutActivity.class);
                startActivity(intent);

                Toast.makeText(getApplicationContext(),"Added to cart!",Toast.LENGTH_SHORT).show();

            }
        });
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailsActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });

    }
}
