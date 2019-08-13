package com.example.stockapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import Models.Product;
import io.realm.Realm;
import io.realm.RealmResults;

public class CheckoutActivity extends AppCompatActivity {

    private Button btnCheckout;
    private  Button btnBackToHome;
    private RecyclerView cartList;
    private List<Product>list;
    private cartAdapter cartAdapter;

    public List<String>Products;
    public static final int[] ProductImgs = {R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        btnCheckout = (Button)findViewById(R.id.btnCheckout);

        btnBackToHome = (Button)findViewById(R.id.buttonBackHome);
        cartList = (RecyclerView)findViewById(R.id.cartList);
        cartList.setLayoutManager(new LinearLayoutManager(this));

        Realm.init(this);
        final Realm realm = Realm.getDefaultInstance();
        final RealmResults<Product> products = realm.where(Product.class).findAllAsync();

        products.load();
        Products = new ArrayList<>();
        for (Product product:products){
            Products.add(product.getProductName());
        }
        list = new ArrayList<>();
        for (int i=0;i<Products.size();i++){
            Product product = new Product();
            product.setProductName(Products.get(i));
            product.setPrice(ProductImgs[i]);

            list.add(product);
        }

        cartAdapter = new cartAdapter(this,list);
        cartList.setAdapter(cartAdapter);

        btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RealmResults<Product> results = realm.where(Product.class).findAll();
                realm.beginTransaction();
                results.deleteAllFromRealm();
                realm.commitTransaction();

                Intent intent = new Intent(CheckoutActivity.this,SuccessActivity.class);
                startActivity(intent);

            }
        });

        btnBackToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CheckoutActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}
