package com.example.stockapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import Models.Product;

public class cartAdapter extends RecyclerView.Adapter<cartAdapter.ViewHolder> {

        Context context;
        List<Product> list;

        public cartAdapter() {
                }

        public cartAdapter(Context context, List<Product> list) {
                this.list = list;
                this.context = context;
                }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_row,parent,false);
                ViewHolder viewHolder = new ViewHolder(view);
                context = parent.getContext();
                return viewHolder;
                }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
                Product product = list.get(position);
                holder.textProduct.setText(product.getProductName());
                holder.imgProduct.setImageResource(product.getPrice());
                holder.cartList.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                                Toast.makeText(context,"The position is:"+position,Toast.LENGTH_SHORT).show();
                        }
                });
                }

        @Override
        public int getItemCount() {
                return list.size();
                }

        class ViewHolder extends RecyclerView.ViewHolder{

                ImageView imgProduct;
                TextView textProduct;
                CardView cartList;


            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                imgProduct = (ImageView)itemView.findViewById(R.id.imgProduct);
                textProduct = (TextView)itemView.findViewById(R.id.textProduct);
                cartList = (CardView)itemView.findViewById(R.id.cartRow);
            }
        }
}

