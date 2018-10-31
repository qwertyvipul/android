package com.example.sqlitedatabases;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.sql.SQLData;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
            SQLiteDatabase myDatabase = this.openOrCreateDatabase("Users", MODE_PRIVATE, null);
            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS users(name VARCHAR, age INT(3))");
            myDatabase.execSQL("INSERT INTO users(name, age) VALUES ('First User', 22)");
            myDatabase.execSQL("INSERT INTO users(name, age) VALUES ('Second User', 23)");

            Cursor c = myDatabase.rawQuery("SELECT * FROM users", null);

            int nameIndex = c.getColumnIndex("name");
            int ageIndex = c.getColumnIndex("age");

            c.moveToFirst();

            while(c != null){
                Log.i("UserDetails", c.getString(nameIndex));
                Log.i("UserDetails", Integer.toString(c.getInt(ageIndex)));

                c.moveToNext();
            }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
