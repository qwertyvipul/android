package com.example.downloadimage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    public class DownloadTask extends AsyncTask<String, Void, Bitmap>{

        @Override
        protected Bitmap doInBackground(String... urls) {
            URL url;
            HttpURLConnection urlConnection;

            try {
                url = new URL(urls[0]);
                urlConnection = (HttpURLConnection)url.openConnection();

                InputStream inputStream = urlConnection.getInputStream();

                //converts downlaoded data into image
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);

                return bitmap;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void downloadImage(View view){
        DownloadTask downloadTask = new DownloadTask();
        try {
            Bitmap image = downloadTask.execute("http://s3.amazonaws.com/cdn.roosterteeth.com/uploads/images/e3790c03-3230-4eb5-84a9-c43214c8dcca/md/2870592-1484544679927-photo.jpg").get();

            ImageView ivImage = (ImageView)findViewById(R.id.iv_image);
            ivImage.setImageBitmap(image);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
