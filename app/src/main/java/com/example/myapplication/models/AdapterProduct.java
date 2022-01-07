package com.example.myapplication.models;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterProduct extends RecyclerView.Adapter<MyViewHolder> {

    private ArrayList <ProductData> list;
    private Context context;

    public AdapterProduct(ArrayList<ProductData> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

}
class  MyViewHolder extends RecyclerView.ViewHolder{

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
    }
}
