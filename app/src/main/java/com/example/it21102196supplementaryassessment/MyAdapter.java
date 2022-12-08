package com.example.it21102196supplementaryassessment;

//package com.example.testing;
//
//        import android.annotation.SuppressLint;
//        import android.content.Context;
//        import android.view.LayoutInflater;
//        import android.view.View;
//        import android.view.ViewGroup;
//        import android.widget.TextView;
//
//        import androidx.annotation.NonNull;
//        import androidx.recyclerview.widget.RecyclerView;
//
//        import java.text.BreakIterator;
//        import java.util.ArrayList;
//
//public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
//    private Context context;
//    private ArrayList Exercise, reps;
//    DBHelper DB;
//
//    public MyAdapter(Context context, ArrayList Exercise, ArrayList reps) {
//        this.context = context;
//        this.Exercise = Exercise;
//        this.reps = reps;
//
//    }
//
//    @NonNull
//    @Override
//    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View v = LayoutInflater.from(context).inflate(R.layout.userentry,parent,false);
//        return new MyViewHolder(v);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
//        holder.Exercise.setText(String.valueOf(Exercise.get(position)));
//        holder.reps.setText(String.valueOf(reps.get(position)));
//       // String Exercises = String.valueOf(Exercise.get(position));
//    }
//
//
//
//    @Override
//    public int getItemCount() {
//        return Exercise.size();
//    }
//
//    public class MyViewHolder extends RecyclerView.ViewHolder {
//
//        TextView Exercise, reps;
//        public MyViewHolder(@NonNull View itemView) {
//            super(itemView);
//            Exercise = itemView.findViewById(R.id.addex);
//            reps = itemView.findViewById(R.id.addreps);
//        }
//    }
//}


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
        Button delete;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textname);
            age = itemView.findViewById(R.id.textage);
            email = itemView.findViewById(R.id.textemail);
            delete = (Button) itemView.findViewById(R.id.deleteBtn);

        }
    }
}
