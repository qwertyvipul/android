package com.example.duoclone;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPreferences = this.getSharedPreferences("com.example.duoclone", Context.MODE_PRIVATE);
        String logggedInUsername = sharedPreferences.getString("username", "");

        Log.i("info", "Username\"" + logggedInUsername + "\"");

        if(logggedInUsername.equals("")){
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
        }else{
            setContentView(R.layout.activity_main);
        }
    }

    public void gotoBasicPlan(View view){
        Intent intent = new Intent(getApplicationContext(), BasicPlan1.class);
        startActivity(intent);
    }
}
