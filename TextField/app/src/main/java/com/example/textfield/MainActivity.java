package com.example.textfield;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static TextView tvGoodname;
    private static EditText etGoodname;
    private static Button btnGoodnameSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvGoodname = (TextView)findViewById(R.id.tv_goodname);
        etGoodname = (EditText)findViewById(R.id.et_goodname);
        btnGoodnameSubmit = (Button)findViewById(R.id.btn_goodname_submit);

        btnGoodnameSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Name", etGoodname.getText().toString());
            }
        });
    }

    public void btnGoodnameMethod(View view){
        Log.i("Name", etGoodname.getText().toString());
    }


}
