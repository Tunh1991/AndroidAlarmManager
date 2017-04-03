package com.svmc.alarm;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.TextView;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class OutPut extends Activity {
    TextView textmessage;
    String stringValue;
    private String url;
    private String audioName;
    Date date;
    private MediaPlayer mediaPlayer;
    private Timer timer;
    private ArrayList<File> playNow;
    int i = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);

        url = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath();
        File directory = new File(url);
        File[] files = directory.listFiles();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateNow = new Date();

        ArrayList<File> mp3File = new ArrayList<File>(files.length);
        playNow = new ArrayList<File>(files.length);
        for (int i = 0; i < files.length; i++) {
            String nameFile = files[i].getName();
            Log.d("Files", " " + nameFile);
            if (nameFile.endsWith("mp3")) {

                String date = nameFile.split("]")[0].replace("[", "");
                String date_now = dateFormat.format(dateNow);
                if (date_now.compareTo(date) == 0) {
                    playNow.add(files[i]);
                }
            }


        }
        for (int i = 0; i < playNow.size(); i++) {
            Log.d("Tutu", playNow.get(i).getName());
            Date dateModified = new Date(playNow.get(i).lastModified());
            Log.d("teoteo", dateModified.toString());
        }

        Intent intentPlayMusic = new Intent();

        mediaPlayer = MediaPlayer.create(this, Uri.fromFile(playNow.get(0)));
        mediaPlayer.start();
        timer = new Timer();
        if (playNow.size() > 1)
            playNext();


    }


    public void playNext() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                mediaPlayer.reset();
                mediaPlayer = MediaPlayer.create(OutPut.this, Uri.fromFile(playNow.get(++i)));
                mediaPlayer.start();
                if (playNow.size() > i + 1) {
                    playNext();
                }
            }
        }, mediaPlayer.getDuration() + 100);
    }
}


