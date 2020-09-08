package com.rku.sqlitedatabaseapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE = "student";
    public static final String TABLE = "student_data";
    public static final String col_1 = "id";
    public static final String col_2 = "enrollno";
    public static final String col_3 = "firstname";
    public static final String col_4 = "lastname";
    public static final String col_5 = "email";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE+"(Id INTEGER PRIMARY KEY AUTOINCREMENT,EnrollNo TEXT,FirstName TEXT,LastName TEXT,Email TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE);
        onCreate(db);
    }

    public boolean insertData(String enrollno, String fname, String lname){
        String e = fname.trim().toLowerCase()+"."+lname.trim().toLowerCase()+"@rku.ac.in";
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_2,enrollno);
        contentValues.put(col_3,fname);
        contentValues.put(col_4,lname);
        contentValues.put(col_5,e);
        long result = db.insert(TABLE,null,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
}
