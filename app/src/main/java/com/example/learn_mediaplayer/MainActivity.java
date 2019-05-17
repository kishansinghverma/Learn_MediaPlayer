package com.example.learn_mediaplayer;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer=MediaPlayer.create(MainActivity.this, R.raw.dhadak);

        VideoView videoView=findViewById(R.id.videoView);
        String path= "android.resource://"+getPackageName()+"/"+R.raw.vid;

        videoView.setVideoURI(Uri.parse(path));

        MediaController mediaController=new MediaController(this);

        mediaController.setMediaPlayer(videoView);
        videoView.setMediaController(mediaController);


        videoView.requestFocus();

    }
    public void action(View v)
    {
        if(((Button)v).getText().toString().equals("Play")) {
            mediaPlayer.start();
            ((Button)v).setText("Pause");
        }
        else {
            mediaPlayer.pause();
            ((Button)v).setText("Play");
        }
    }
}
