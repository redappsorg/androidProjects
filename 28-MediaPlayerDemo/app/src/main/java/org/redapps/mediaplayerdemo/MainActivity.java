package org.redapps.mediaplayerdemo;

import java.io.File;
import java.io.IOException;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

    protected static final String LOG_TAG = "MediaPlayerDemo";
    String fileName = "/sdcard/your_file_name.mp3";
    MediaPlayer mediaPlayer = new MediaPlayer();
    MediaPlayer player;
    int volume_level = 10, volume_incr = 10;
    boolean done;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View startButton = findViewById(R.id.play_button);
        startButton.setOnClickListener(this);

        View alarmButton = findViewById(R.id.alarm_button);
        alarmButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        try {
            switch (v.getId()) {
                case R.id.play_button:
                    playMedia(mediaPlayer, fileName);
                    break;
                case R.id.alarm_button:
                    playAlarm();
            }
        } catch (IOException e) {
            Toast.makeText(this, "Media Failure: " + e, Toast.LENGTH_LONG).show();
        }
    }

    private void playMedia(MediaPlayer mediaPlayer, String fileName) throws IOException {
        File file = new File(fileName);
        if (!file.canRead()) {
            Toast.makeText(this, "CANNOT READ " + fileName, Toast.LENGTH_SHORT).show();
            return;
        }
        mediaPlayer.setDataSource(fileName);
        mediaPlayer.prepare();
        Toast.makeText(this, "Start play", Toast.LENGTH_SHORT).show();
        mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Toast.makeText(MainActivity.this, "Media Play Complete", Toast.LENGTH_SHORT).show();
            }
        });
        mediaPlayer.start();
        Toast.makeText(this, "Started OK", Toast.LENGTH_SHORT).show();
    }

    void playAlarm() {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Wake up time!");
        alertDialog.setButton(AlertDialog.BUTTON1, "I'm awake!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                player.setOnCompletionListener(null);
                player.stop();
                player.release();
                done = true;
            }
        });
        alertDialog.show();
        player = MediaPlayer.create(this, R.raw.alarm_sound);
        player.setVolume(volume_level, volume_level);
        player.start();
        player.setOnCompletionListener(new OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer arg0) {
                volume_level += volume_incr;
                player.setVolume(volume_level, volume_level);
                player.start();
            }
        });
    }
}
