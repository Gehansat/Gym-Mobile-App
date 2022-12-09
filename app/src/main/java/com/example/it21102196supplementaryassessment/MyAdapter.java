package com.example.it21102196supplementaryassessment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private ArrayList name, age,email;
    DBHelper DB;


    public MyAdapter(Context context, ArrayList name, ArrayList age,ArrayList email) {
        this.context = context;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View otherView = LayoutInflater.from(context).inflate(R.layout.userentry,parent,false);
        return new MyViewHolder(otherView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {


        holder.name.setText(String.valueOf(name.get(position)));
        holder.age.setText(String.valueOf(age.get(position)));
        holder.email.setText(String.valueOf(email.get(position)));


        String Ex = String.valueOf(name.get(position));

        //delete button
        holder.delete.setOnClickListener(new View.OnClickListener() {
            DBHelper db = new DBHelper(context);
            @Override
            public void onClick(View view) {
                Boolean deleteAct = db.deleteuserdetails(Ex);
                if (deleteAct == true) {
                    Toast.makeText(context, "Deleted Successfully", Toast.LENGTH_SHORT).show();
                    name.remove(position);
                    notifyDataSetChanged ();
                }
                else
                    Toast.makeText(context, "Failed to delete", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name, age,email;
        Button delete,update;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textname);
            age = itemView.findViewById(R.id.textage);
            email = itemView.findViewById(R.id.textemail);
            delete = (Button) itemView.findViewById(R.id.deleteBtn);
        }


    }
}
