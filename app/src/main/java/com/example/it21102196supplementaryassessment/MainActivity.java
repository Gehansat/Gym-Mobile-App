package com.example.it21102196supplementaryassessment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.it21102196supplementaryassessment.add;
import com.example.it21102196supplementaryassessment.view;

public class MainActivity extends AppCompatActivity {

    Button addudetails,viewudetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        addudetails = (Button) findViewById(R.id.button);
        addudetails.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openAdd();
            }
        });

        viewudetails = (Button) findViewById(R.id.button15);
        viewudetails.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openView();
            }
        });



    }
    public void openAdd(){
        Intent intent = new Intent(this, add.class );
        startActivity(intent);
    }

    public void openView(){
        Intent intent = new Intent(this, view.class );
        startActivity(intent);
    }
}