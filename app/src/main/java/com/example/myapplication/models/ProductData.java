package com.example.myapplication.models;

public class ProductData {
    private String name;
    private String price;
    private int c_id;

    public ProductData(String name, String price, int c_id) {
        this.name = name;
        this.price = price;
        this.c_id = c_id;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public int getC_id() {
        return c_id;
    }
}
