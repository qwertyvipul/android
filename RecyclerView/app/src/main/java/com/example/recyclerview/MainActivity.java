package com.example.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String names[] = {"Ram", "Gopal", "Verma"};

        RecyclerView rvNameList = (RecyclerView)findViewById(R.id.rv_name_list);
        rvNameList.setLayoutManager(new LinearLayoutManager(this));
        rvNameList.setAdapter(new MyAdapter(names));
    }
}

