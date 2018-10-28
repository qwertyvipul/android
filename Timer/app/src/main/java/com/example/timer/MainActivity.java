package com.example.timer;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CountDownTimer timer = new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Log.i("Seconds left", String.valueOf(millisUntilFinished/1000));
            }

            @Override
            public void onFinish() {
                Log.i("Seconds left", "Timer over!");
            }
        }.start();

        final int[] seconds = new int[1];
        final Handler handler = new Handler();
        Runnable run = new Runnable() {
            @Override
            public void run() {
                Log.i("Seconds Passed", String.valueOf(seconds[0]));
                handler.postDelayed(this, 1000);
                seconds[0]++;
            }
        };
        handler.post(run);

    }
}
