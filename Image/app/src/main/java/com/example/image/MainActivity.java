package com.example.image;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private static ImageView ivCat1;
    private static ImageView ivCat2;
    private static Button btnCat1;
    private static Button btnCat2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivCat1 = (ImageView)findViewById(R.id.iv_cat_1);
        ivCat2 = (ImageView)findViewById(R.id.iv_cat_2);
        btnCat1 = (Button)findViewById(R.id.btn_cat_1);
        btnCat2 = (Button)findViewById(R.id.btn_cat_2);

        ivCat1.setImageResource(R.drawable.cat_1);
        btnCat1.setEnabled(false);

        btnCat1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivCat2.animate().alpha(0f).setDuration(3000);
                ivCat1.setImageResource(R.drawable.cat_1);
                ivCat1.animate().alpha(1f).setDuration(3000);
                btnCat1.setEnabled(false);
                btnCat2.setEnabled(true);
            }
        });

        btnCat2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivCat1.animate().alpha(0f).setDuration(3000);
                ivCat2.setImageResource(R.drawable.cat_2);
                ivCat2.animate().alpha(1f).setDuration(3000);
                btnCat1.setEnabled(true);
                btnCat2.setEnabled(false);
            }
        });
    }
}
