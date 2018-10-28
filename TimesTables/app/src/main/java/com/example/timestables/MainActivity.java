package com.example.timestables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static SeekBar sbTimes;
    private static RecyclerView rvTimesTable;
    private static TextView tvTableName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sbTimes = (SeekBar)findViewById(R.id.sb_times);
        rvTimesTable = (RecyclerView)findViewById(R.id.rv_times_table);
        tvTableName = (TextView)findViewById(R.id.tv_table_name);

        final int min = 1;
        int max = 20;

        sbTimes.setMax(max);
        sbTimes.setProgress(0);

        generateTable(0);

        sbTimes.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                int times;
                if(progress < min){
                    times = min;
                }else{
                    times = progress;
                }

                generateTable(times);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void generateTable(int times){
        int[] table = new int[10];

        for(int i=0; i<10; i++){
            table[i] = times * (i+1);
        }

        tvTableName.setText("Times Table : " + times);
        rvTimesTable.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvTimesTable.setAdapter(new TimesTableAdapter(table));
    }
}
