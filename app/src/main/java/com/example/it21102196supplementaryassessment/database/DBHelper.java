package com.example.it21102196supplementaryassessment.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "userInfo.db";


    public DBHelper( Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String SQL_CREATE_ENTRIES = "CREATE TABLE " + UsersMaster.Users.TABLE_NAME + " (" +
                UsersMaster.Users._ID + " INTEGER PRIMARY KEY , " +
                UsersMaster.Users.COLUMN_NAME_NAME + " TEXT," +
                UsersMaster.Users.COLUMN_NAME_AGE + " TEXT," +
                UsersMaster.Users.COLUMN_NAME_ADDRESS + " TEXT," +
                UsersMaster.Users.COLUMN_NAME_CONTACTNUMBER + " TEXT)";

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
