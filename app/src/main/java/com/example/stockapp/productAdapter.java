package com.example.stockapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import Models.Product;

public class productAdapter extends RecyclerView.Adapter<productAdapter.ViewHolder> {

    Context context;
    List<Product> list;

    public productAdapter() {
    }

    public productAdapter(Context context, List<Product> list) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public productAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        productAdapter.ViewHolder viewHolder = new productAdapter.ViewHolder(view);
        context = parent.getContext();
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final Product product = list.get(position);
        holder.textProduct.setText(product.getProductName());
        holder.imgProduct.setImageResource(product.getPrice());
        holder.productList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("message",product.getProductName());
                context.startActivity(intent);
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
        CardView productList;


            public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProduct = (ImageView)itemView.findViewById(R.id.imgProduct);
            textProduct = (TextView)itemView.findViewById(R.id.textProduct);
            productList = (CardView)itemView.findViewById(R.id.row);
        }
    }
}
