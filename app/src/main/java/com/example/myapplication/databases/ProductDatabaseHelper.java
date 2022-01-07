package com.example.myapplication.databases;

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
         String table = "create table "+TABLE_NAME+"(" +
                 COLUMN_ID+"integer primary key autoincrement," +
                 COLUMN_NAME+" text," +
                 COLUMN_PRICE+" text," +
                 COLUMN_C_ID+" integer);";

         db.execSQL(table);
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
        while (cursor.moveToNext()){
            String name = cursor.getString(1);
            String price = cursor.getString(2);
            int c_id = cursor.getInt(3);

            productData.add(new ProductData(name,price,c_id));
        }
        cursor.close();

        return productData;
    }



}
