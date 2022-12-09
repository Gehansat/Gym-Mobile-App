package com.example.it21102196supplementaryassessment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "userDB.db";

    DBHelper(Context context) {
        super(context, "userDB.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table userdetails(name TEXT primary key , age TEXT,email TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int ii) {
        DB.execSQL("drop Table if exists userdetails");
    }

    public boolean insertuserdetails(String name, String age, String email) {
        SQLiteDatabase DB = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("age", age);
        contentValues.put("email", email);
        long result = DB.insert("userdetails", null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }


    public Cursor getdata() {
        SQLiteDatabase DB = getWritableDatabase();
        Cursor e = DB.rawQuery("Select * from userdetails", null);
        return e;
    }


    public Boolean deleteuserdetails(String na)
    {
        SQLiteDatabase userDB = this.getWritableDatabase();
        Cursor cursor = userDB.rawQuery("Select * from userdetails where name = ?", new String[]{na});
        if(cursor.getCount()>0)
        {
            long result = userDB.delete("userdetails", "name=?", new String[]{na});
            if(result==-1)
            {
                return  false;
            }
            else
            {
                return true;
            }
        }
        else
        {
            return false;
        }

    }





}
