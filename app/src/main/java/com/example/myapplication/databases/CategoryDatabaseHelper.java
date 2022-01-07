package com.example.myapplication.databases;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CategoryDatabaseHelper extends SQLiteOpenHelper {
    private final static String DATABASE_NAME = "baza";
    private final static String COLUMN_NAME = "name";
    private final static String TABLE_NAME = "category";
    private final static String COLUMN_ID = "id";
    public CategoryDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String table = "create table "+TABLE_NAME+"(" +
                COLUMN_ID+"integer primary key autoincrement," +
                COLUMN_NAME+" text);";
        db.execSQL(table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+TABLE_NAME);
        onCreate(db);
    }

    public ArrayList<String> show(){

        ArrayList<String> categoryData = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("select *from "+TABLE_NAME,null);

        while (cursor.moveToNext()){
            String name = cursor.getString(1);
            categoryData.add(name);
        }
        cursor.close();
        return categoryData;

    }
}
