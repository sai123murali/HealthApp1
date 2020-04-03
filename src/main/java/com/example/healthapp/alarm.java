package com.example.healthapp;

import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.sax.StartElementListener;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import android.os.Bundle;

public class alarm extends AppCompatActivity {

    TextView timerTextView;
    SeekBar seekBar;
    Boolean counterIsActive = false;
    Button controllerButton;
    CountDownTimer countDownTimer;

    public void resetTimer()
    {
        timerTextView.setText("0:30");
        seekBar.setProgress(30);
        countDownTimer.cancel();
        controllerButton.setText("Go");
        seekBar.setEnabled(true);
        counterIsActive=false;
    }

    public void updateTimer(int secleft){

        int minutes = (int) secleft / 60;
        int sec = secleft - minutes * 60;

        String secString = Integer.toString(sec);

        if(sec<=9)
        {
            secString = "0"+secString;
        }

        timerTextView.setText(Integer.toString(minutes) + ":" + secString);
    }

    public void controlTime (View view)
    {
        if(counterIsActive==false) {
            counterIsActive = true;


            seekBar.setEnabled(false);

            controllerButton.setText("Stop");// Toast.makeText(MainActivity.this, "pressed", Toast.LENGTH_SHORT).show();
            countDownTimer= new CountDownTimer(seekBar.getProgress() * 1000 + 100, 1000) {

                @Override
                public void onTick(long l) {

                    updateTimer((int) l / 1000);

                }

                @Override
                public void onFinish() {

                    resetTimer();
                    //timerTextView.setText("0:00");
                    MediaPlayer mPlayer = MediaPlayer.create(getApplicationContext(), R.raw.airhorn);
                    mPlayer.start();

                }
            }.start();
        }else{
            resetTimer();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        seekBar = (SeekBar)findViewById(R.id.seekBar);

        timerTextView =(TextView)findViewById(R.id.timerTextView);
        controllerButton =(Button) findViewById(R.id.controllerButton);
        seekBar.setMax(600);//10*60
        seekBar.setProgress(30);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {


            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                updateTimer(i);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
