package com.example.stockapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {


    private RecyclerView productList;
    private List<String> list;
    private productAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        productList = (RecyclerView)findViewById(R.id.productList);


        productList.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        for (int i=1;i<=20;i++){
            list.add("Product " + i);
        }

        adapter = new productAdapter(this,list);
        productList.setAdapter(adapter);

    }
}
