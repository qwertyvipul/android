package com.example.image;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private static ImageView ivCat;
    private static Button btnCat1;
    private static Button btnCat2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivCat = (ImageView)findViewById(R.id.iv_cat);
        btnCat1 = (Button)findViewById(R.id.btn_cat_1);
        btnCat2 = (Button)findViewById(R.id.btn_cat_2);

        ivCat.setImageResource(R.drawable.cat_1);
        btnCat1.setEnabled(false);

        btnCat1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivCat.setImageResource(R.drawable.cat_1);
                btnCat1.setEnabled(false);
                btnCat2.setEnabled(true);
            }
        });

        btnCat2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivCat.setImageResource(R.drawable.cat_2);
                btnCat1.setEnabled(true);
                btnCat2.setEnabled(false);
            }
        });
    }
}
