package com.rku.sqlitedatabaseapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE = "student";
    public static final String TABLE = "student_data";
    public static final String col_1 = "id";
    public static final String col_2 = "enrollno";
    public static final String col_3 = "first name";
    public static final String col_4 = "last name";
    public static final String col_5 = "email";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,ENROLNO TEXT,FIRSTNAME TEXT,LASTNAME TEXT,EMAIL TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE);
        onCreate(db);
    }
}
