package com.example.stockapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

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

import Models.Product;

public class HomeActivity extends AppCompatActivity {


    private RecyclerView productList;
    private List<Product> list;
    private productAdapter adapter;
    private RequestQueue requestQueue;

    private String url = "http://172.16.2.139:8081/movies/get-all";


    public static final int[] ProductImgs = {R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.g,R.drawable.h};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        requestQueue = Volley.newRequestQueue(this);

        productList = (RecyclerView)findViewById(R.id.productList);


        productList.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        for (int i = 0; i<8; i++){
            Product product = new Product();
            product.setProductName("Product" + i);
            product.setPrice(ProductImgs[i]);

            list.add(product);
        }


        //getNames();

        adapter = new productAdapter(this,list);
        productList.setAdapter(adapter);





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == R.id.action_cart){
            Intent intent = new Intent(HomeActivity.this,CheckoutActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);

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
                                    //list.add(name);
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
