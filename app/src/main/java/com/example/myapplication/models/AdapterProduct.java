package com.example.myapplication.models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

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
        View itemView= LayoutInflater.from(context).inflate(R.layout.layout_item_product,parent,false);
        return  new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String name=list.get(position).getName();
        String prise=list.get(position).getPrice();
        int id=list.get(position).getC_id();

        holder.name.setText(name);
        holder.prise.setText(prise);
        holder.id.setText(id);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
class  MyViewHolder extends RecyclerView.ViewHolder{

    TextView name;
    TextView prise, id;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        name=itemView.findViewById(R.id.name);
        prise=itemView.findViewById(R.id.prise);
        id=itemView.findViewById(R.id.id);
    }
}
