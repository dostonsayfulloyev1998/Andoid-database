package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.adapter.AdapterProduct;
import com.example.myapplication.databases.CategoryDatabaseHelper;
import com.example.myapplication.databases.ProductDatabaseHelper;
import com.example.myapplication.models.ProductData;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ProductDatabaseHelper productDatabaseHelper;
    private CategoryDatabaseHelper categoryDatabaseHelper;
    private AdapterProduct adapterProduct;
    private RecyclerView resProduct;
    private ArrayList<ProductData> list;
    private FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resProduct = findViewById(R.id.res);
        fab = findViewById(R.id.fab);
       refresh();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.insert_layout,null);

                EditText name,price,c_id;
                name = view.findViewById(R.id.name);
                price = view.findViewById(R.id.price);
                c_id = view.findViewById(R.id.c_id);
                builder.setView(view);

                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        long i = productDatabaseHelper.insert(name.getText()+"",price.getText()+"", Integer.parseInt(c_id.getText()+""));

                        if (i>0){
                            Toast.makeText(MainActivity.this,"bazaga qoshildi",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

                refresh();
            }
        });
    }

    public void loadData(){
        list = new ArrayList<>();
        productDatabaseHelper = new ProductDatabaseHelper(this);
        list = productDatabaseHelper.show();
    }

    public void refresh(){
        loadData();
        adapterProduct = new AdapterProduct(list,this);
        resProduct.setAdapter(adapterProduct);
    }
}
