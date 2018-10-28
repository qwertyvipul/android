package com.example.timestables;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TimesTableAdapter extends RecyclerView.Adapter<TimesTableAdapter.TimesTableViewHolder> {

    private static int[] table;
    private static int tableName;

    public TimesTableAdapter(int[] table){
        this.table = table;
        this.tableName = table[0];
    }

    @NonNull
    @Override
    public TimesTableViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.times_table_row, parent, false);

        return new TimesTableViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TimesTableViewHolder holder, int position) {
        holder.tvRowValue.setText(tableName + " x " + (position+1) + " = " + tableName*(position + 1));
    }

    @Override
    public int getItemCount() {
        return table.length;
    }

    public static class TimesTableViewHolder extends RecyclerView.ViewHolder{
        private static TextView tvRowValue;

        public TimesTableViewHolder(View itemView){
            super(itemView);
            tvRowValue = (TextView)itemView.findViewById(R.id.tv_row_value);
        }
    }
}
