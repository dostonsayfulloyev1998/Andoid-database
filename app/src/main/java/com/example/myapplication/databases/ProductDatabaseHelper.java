package com.example.myapplication.databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.myapplication.models.ProductData;

import java.util.ArrayList;

public class ProductDatabaseHelper extends SQLiteOpenHelper {
  private final static String DATABASE_NAME = "baza";
  private final static String TABLE_NAME = "product";
    private final static String COLUMN_ID = "id";
    private final static String COLUMN_NAME = "name";
  private final static String COLUMN_PRICE = "price";
  private final static String COLUMN_C_ID = "c_id";

    public ProductDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_PRICE + " TEXT, " +
                COLUMN_C_ID + " INTEGER);";
        db.execSQL(query);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public ArrayList<ProductData> show(){
         SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select *from "+TABLE_NAME,null);
        ArrayList<ProductData> productData = new ArrayList<>();
        cursor.moveToFirst();
        do{
            String name = cursor.getString(1);
            String price = cursor.getString(2);
            int c_id = cursor.getInt(3);

            productData.add(new ProductData(name,price,c_id));
        }while (cursor.moveToNext());
        cursor.close();

        return productData;
    }


    public long insert(String name,String price,int c_id){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_NAME,name);
        values.put(COLUMN_PRICE,price);
        values.put(COLUMN_C_ID,c_id);

        long t =  db.insert(TABLE_NAME,null,values);

        return t;
    }


}
