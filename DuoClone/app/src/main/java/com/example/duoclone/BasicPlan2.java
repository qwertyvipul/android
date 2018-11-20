package com.example.duoclone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class BasicPlan2 extends AppCompatActivity {

    private int correctAnswer = 5;
    private int userAnswer = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_plan2);
    }

    public void addTag(View view){
        Button click = (Button)view;
        int tag = Integer.parseInt(click.getTag().toString());

        userAnswer += tag;
    }

    public void check(View view){
        if(userAnswer == correctAnswer){
            Log.i("info", "Correct Answer");
        }else{
            Log.i("info", "Wrong Answer");
        }
    }
}
