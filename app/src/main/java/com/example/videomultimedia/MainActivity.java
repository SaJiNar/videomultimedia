package com.example.videomultimedia;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;


public class MainActivity extends Activity implements View.OnClickListener {
    private Button btnPlay;
    private Button btnPause;
    private Button btnStop;
    private VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //We add here the name's video we want to play
        video = (VideoView) findViewById(R.id.videoView);
        String path = "android.resource://" + getPackageName() + "/" + R.raw.insertvideonamehere;
        video.setVideoURI(Uri.parse(path));

        //Botones para la interfaz
        btnPlay = (Button) findViewById(R.id.buttonPlay);
        btnPause = (Button) findViewById(R.id.buttonStop);
        btnStop = (Button) findViewById(R.id.buttonStop);

        //asignar controlador de eventos
        btnPlay.setOnClickListener(this);
        btnPause.setOnClickListener(this);
        btnStop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonPlay:
                video.start();
                break;
            case R.id.buttonPause:
                video.pause();
                break;
            case R.id.buttonStop:
                video.stopPlayback();
                video.seekTo(0);
                break;
        }
    }
}

