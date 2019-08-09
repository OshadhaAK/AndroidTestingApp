package com.example.stockapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import Models.Product;
import io.realm.Realm;
import io.realm.RealmResults;

public class CheckoutActivity extends AppCompatActivity {

    private Button btnCheckout;
    private TextView cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        btnCheckout = (Button)findViewById(R.id.btnCheckout);
        cart = (TextView)findViewById(R.id.cardList);

        Realm.init(this);
        Realm realm = Realm.getDefaultInstance();
        RealmResults<Product> products = realm.where(Product.class).findAllAsync();

        products.load();
        String output = "";
        for(Product product:products){
            output+=product.getProductName().toString()+"\n";
        }
        cart.setText(output+"\n");

        btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CheckoutActivity.this,SuccessActivity.class);
                startActivity(intent);
            }
        });
    }
}
