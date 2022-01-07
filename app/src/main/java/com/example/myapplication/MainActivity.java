package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myapplication.databases.CategoryDatabaseHelper;
import com.example.myapplication.databases.ProductDatabaseHelper;

public class MainActivity extends AppCompatActivity {

    private ProductDatabaseHelper productDatabaseHelper;
    private CategoryDatabaseHelper categoryDatabaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}