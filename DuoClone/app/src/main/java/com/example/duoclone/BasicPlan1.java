package com.example.duoclone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class BasicPlan1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_plan1);
    }

    public void gotoBasicPlan2(View view){
        Intent intent = new Intent(getApplicationContext(), BasicPlan2.class);
        startActivity(intent);
    }
}
