package com.example.braintrainer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView tvTimer;
    private TextView tvScore;
    private TextView tvQuestion;
    private TextView tvOption0;
    private TextView tvOption1;
    private TextView tvOption2;
    private TextView tvOption3;

    private int flag;
    private int score;
    private int total;
    private int correctAnswer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTimer = (TextView)findViewById(R.id.tv_timer);
        tvScore = (TextView)findViewById(R.id.tv_score);
        tvQuestion = (TextView)findViewById(R.id.tv_question);
        tvOption0 = (TextView)findViewById(R.id.tv_option_0);
        tvOption1 = (TextView)findViewById(R.id.tv_option_1);
        tvOption2 = (TextView)findViewById(R.id.tv_option_2);
        tvOption3 = (TextView)findViewById(R.id.tv_option_3);
        tvTimer.setText("Create");


        this.tvTimer.setText("30s");
        //this.tvScore.setText(score + "/" + total);
        this.tvScore.setText("0/0");
        this.tvQuestion.setText("Brain Trainer");

    }


    public void evaluate(View view){
        if(this.flag == 1){
            TextView selectedOption = (TextView)view;
            int result = Integer.parseInt(selectedOption.getText().toString());

            if(result == this.correctAnswer){
                score++;
            }
            this.total++;
        }
        tvScore.setText(String.valueOf(this.score) + "/" + String.valueOf(this.total));
        gameOn();
    }


    public void play(View view){
        flag = 1;
        score = 0;
        total = 0;
        final Button btnPlay = (Button)view;
        btnPlay.setEnabled(false);
        CountDownTimer timer = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tvTimer.setText(String.valueOf(millisUntilFinished/1000) + "s");
            }

            @Override
            public void onFinish() {
                flag = 0;
                tvTimer.setText("0s");
                btnPlay.setEnabled(true);
            }
        }.start();
        gameOn();
    }


    public void gameOn(){

        if(flag == 1){
            tvScore.setText(score + "/" + total);

            Random randomInt = new Random();
            int num1 = randomInt.nextInt(50);
            int num2 = randomInt.nextInt(50);

            correctAnswer = num1 + num2;

            int choices[] = new int[4];


            for(int i=0; i<4; i++){
                do{
                    choices[i] = randomInt.nextInt(100);
                }while(choices[i] == correctAnswer);
            }


            int magicNumber = randomInt.nextInt(4);
            choices[magicNumber] = correctAnswer;

            tvQuestion.setText(String.valueOf(num1) + " + " + String.valueOf(num2));
            tvOption0.setText(String.valueOf(choices[0]));
            tvOption1.setText(String.valueOf(choices[1]));
            tvOption2.setText(String.valueOf(choices[2]));
            tvOption3.setText(String.valueOf(choices[3]));
        }
    }
}
