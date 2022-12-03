package com.example.it21102196supplementaryassessment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.it21102196supplementaryassessment.database.DBHelper;

public class MainActivity extends AppCompatActivity {

    Button btnadd;
    EditText addname,addage,addaddress,addcnum;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addname = findViewById(R.id.addname);
        addage = findViewById(R.id.addage);
        addaddress = findViewById(R.id.addaddress);
        addcnum = findViewById(R.id.addcnum);

        db = new DBHelper(this);

        btnadd = (Button) findViewById(R.id.btnadd);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = addname.getText().toString();
                String age = addage.getText().toString();
                String address = addaddress.getText().toString();
                String cnum = addcnum.getText().toString();

                Boolean insertEx = db.addinfo(name, age,address,cnum);
                if (insertEx == true) {
                    Toast.makeText(MainActivity.this, "Exercise succesfully enetered", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Error adding exercise", Toast.LENGTH_SHORT).show();
                }
                }


        });
    }

//    public void saveUser(View view){
//        String name = addname.getText().toString();
//        String age = addage.getText().toString();
//        String address = addaddress.getText().toString();
//        String contactnumber = addcnum.getText().toString();
//
//        DBHelper dbHelper = new DBHelper(this);
//
//        if(name.isEmpty()||age.isEmpty()||address.isEmpty()||contactnumber.isEmpty()){
//            Toast.makeText(this, "Please Enter the Values", Toast.LENGTH_SHORT).show();
//        }else{
//            long inserted = dbHelper.addinfo(name,age,address,contactnumber);
//
//            if(inserted > 0){
//                Toast.makeText(this, "Data Inserted Successfully", Toast.LENGTH_SHORT).show();
//            }else{
//                Toast.makeText(this, "Error ! Data not inserted!", Toast.LENGTH_SHORT).show();
//            }
//        }

    }



