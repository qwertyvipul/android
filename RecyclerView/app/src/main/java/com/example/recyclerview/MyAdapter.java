package com.example.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    private String[] data;

    //constructor to set the data
    public MyAdapter(String[] data){
        this.data = data;
    }

    @NonNull
    @Override
    //method to create the view for the row from the layout
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.my_row, parent, false);

        return new MyViewHolder(view);
    }

    //method to set the values to the row variables
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String name = data[position];
        holder.tvName.setText(name);
    }

    //method to get the length of the data
    @Override
    public int getItemCount() {
        return data.length;
    }

    //view holder class
    public static class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView tvName;
        public MyViewHolder(View view) {
            super(view);
            tvName = (TextView)itemView.findViewById(R.id.tv_name);
        }


    }
}
