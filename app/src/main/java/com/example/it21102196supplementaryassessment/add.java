package com.example.it21102196supplementaryassessment.;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class add extends AppCompatActivity {

    Button addbtn;
    EditText addemail,addname,addage;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        addbtn = (Button) findViewById(R.id.addbtn);
        addname = (EditText) findViewById(R.id.addname) ;
        addage = (EditText) findViewById(R.id.addage) ;
        addemail= (EditText) findViewById(R.id.addemail);

        DB = new DBHelper(this);

        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = addname.getText().toString();
                String age = addage.getText().toString();
                String email = addname.getText().toString();

                Boolean insertdetails = DB.insertuserdetails(name, age, email);
                if (insertdetails == true) {
                    Toast.makeText(add.this, "Exercise succesfully enetered", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(add.this, "Error adding exercise", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}