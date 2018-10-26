package com.example.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int activePlayer = 0;
    private int flag = 1;
    private int[][] winPositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8},
                                    {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
                                    {0, 4, 8}, {2, 4, 6}};

    private int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    private static TextView tvDisplay;
    private static Button btnPlayAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlayAgain = (Button)findViewById(R.id.btn_play_again);
        btnPlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });
    }

    public void dropIn(View view){
        tvDisplay = (TextView)findViewById(R.id.tv_display);

        ImageView icon = (ImageView)view;
        int tag = Integer.parseInt(icon.getTag().toString());
        if(gameState[tag] == 2 && flag == 1){
            if(activePlayer == 0){
                icon.setImageResource(R.drawable.zero);
                gameState[tag] = activePlayer;
                if(checkWin(activePlayer)){
                    tvDisplay.setText("Player - " + activePlayer + " Wins!");
                    flag = 0;
                }else{
                    activePlayer = 1;
                    tvDisplay.setText("Make Move: Player - " + activePlayer);
                }
            }else if(activePlayer == 1){
                icon.setImageResource(R.drawable.cross);
                gameState[tag] = activePlayer;
                if(checkWin(activePlayer)){
                    tvDisplay.setText("Player - " + activePlayer + " Wins!");
                    flag = 0;
                }else{
                    activePlayer = 0;
                    tvDisplay.setText("Make Move: Player - " + activePlayer);
                }
            }
        }
    }

    public boolean checkWin(int player){
        for(int[] position : winPositions){
            if(gameState[position[0]] == gameState[position[1]] &&
                    gameState[position[1]] == gameState[position[2]] &&
                    gameState[position[2]] == player){
                return true;
            }
        }
        return false;
    }
}
