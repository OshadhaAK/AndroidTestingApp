package com.example.stockapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {


    private RecyclerView productList;
    private List<String> list;
    private productAdapter adapter;
    private RequestQueue requestQueue;
    private ImageButton cartButton;

    private String url = "http://172.16.2.139:8081/movies/get-all";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        requestQueue = Volley.newRequestQueue(this);

        productList = (RecyclerView)findViewById(R.id.productList);
        cartButton = (ImageButton)findViewById(R.id.cartButton);

        productList.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();

        getNames();

        adapter = new productAdapter(this,list);
        productList.setAdapter(adapter);

        cartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, CheckoutActivity.class);
                startActivity(intent);
            }
        });

    }

    private void getNames(){
        JsonArrayRequest arrayRequest = new JsonArrayRequest(Request.Method.GET, this.url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        if (response.length() > 0) {
                            for (int i = 0; i < response.length(); i++) {
                                try {
                                    JSONObject jsonObject = response.getJSONObject(i);
                                    String name = jsonObject.get("name").toString();
                                    list.add(name);
                                } catch (JSONException e) {
                                    Log.e("Volley", "Invalid JSON Object.");
                                }
                            }
                        } else {

                        }
                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Volley", error.toString());
                    }
                }

        );

        requestQueue.add(arrayRequest);



    }
}
