package com.example.it21102196supplementaryassessment.database;

import android.content.ContentValues;
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
    public void onCreate(SQLiteDatabase db) {

        String SQL_CREATE_ENTRIES = "CREATE TABLE " + UsersMaster.Users.TABLE_NAME + " (" +
                UsersMaster.Users._ID + " INTEGER PRIMARY KEY , " +
                UsersMaster.Users.COLUMN_NAME_NAME + " TEXT," +
                UsersMaster.Users.COLUMN_NAME_AGE + " TEXT," +
                UsersMaster.Users.COLUMN_NAME_ADDRESS + " TEXT," +
                UsersMaster.Users.COLUMN_NAME_CONTACTNUMBER + " TEXT)";

            db.execSQL(SQL_CREATE_ENTRIES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean addinfo(String name,String age,String address,String cnum){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(UsersMaster.Users.COLUMN_NAME_NAME,name);
        values.put(UsersMaster.Users.COLUMN_NAME_AGE,age);
        values.put(UsersMaster.Users.COLUMN_NAME_ADDRESS,address);
        values.put(UsersMaster.Users.COLUMN_NAME_CONTACTNUMBER,cnum);

        long result = db.insert(UsersMaster.Users.TABLE_NAME,null,values);

        if (result == -1)
            return false;
        else
            return true;




    }


}
