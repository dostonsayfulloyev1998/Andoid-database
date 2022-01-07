package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapplication.adapter.AdapterProduct;
import com.example.myapplication.databases.CategoryDatabaseHelper;
import com.example.myapplication.databases.ProductDatabaseHelper;
import com.example.myapplication.models.ProductData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ProductDatabaseHelper productDatabaseHelper;
    private CategoryDatabaseHelper categoryDatabaseHelper;
    private AdapterProduct adapterProduct;
    private RecyclerView resProduct;
    private ArrayList<ProductData> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resProduct = findViewById(R.id.res);
        loadData();
        adapterProduct = new AdapterProduct(list,this);
        resProduct.setAdapter(adapterProduct);
    }

    public void loadData(){
        list = new ArrayList<>();
        productDatabaseHelper = new ProductDatabaseHelper(this);
        list = productDatabaseHelper.show();
    }
}
