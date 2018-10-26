package com.example.video;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    private static VideoView vvPeopleWalking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vvPeopleWalking = (VideoView)findViewById(R.id.vv_people_walking);
        vvPeopleWalking.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.people_walking);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(vvPeopleWalking);
        vvPeopleWalking.setMediaController(mediaController);
        
        vvPeopleWalking.start();
    }
}
