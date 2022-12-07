package com.example.it21102196supplementaryassessment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class view extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<String> name,age,email;
    DBHelper DB;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        DB = new DBHelper(this);
        name = new ArrayList<>();
        age = new ArrayList<>();
        email = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerview);
        adapter = new MyAdapter(this,name,age,email);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();



    }

    private void displaydata() {

        Cursor cursor = DB.getdata();
        if (cursor.getCount() == 0)
        {
            Toast.makeText(view.this,"No Entry Exists", Toast.LENGTH_SHORT).show();
//            return;
        }
        else
        {
            while(cursor.moveToNext())
            {
                name.add(cursor.getString(0));
                age.add(cursor.getString(1));
                email.add(cursor.getString(1));
            }
        }
    }
}