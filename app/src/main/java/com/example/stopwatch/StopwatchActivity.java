package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class StopwatchActivity extends AppCompatActivity {
    private Button btnStart,btnStop;
    ImageView clokcHand,imgClockCircle;
    Animation anim_RightToLeft,anim_LeftToRight;
    private Chronometer chronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);
        imgClockCircle=findViewById(R.id.imgClockCircle);

        btnStart=findViewById(R.id.btnStart);
        clokcHand=findViewById(R.id.imgClockHand);
        chronometer=findViewById(R.id.chronometer);
        btnStop=findViewById(R.id.btnStop);
        btnStop.setAlpha(0);
        anim_RightToLeft =AnimationUtils.loadAnimation(this,R.anim.anim_left_right);
        anim_LeftToRight=AnimationUtils.loadAnimation(this,R.anim.anim_right_left);
        btnStart.startAnimation(anim_RightToLeft);
        clokcHand.startAnimation(anim_RightToLeft);
        imgClockCircle.startAnimation(anim_LeftToRight);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnStop.animate().alpha(1).translationY(-80).setDuration(300).start();
                btnStart.animate().alpha(0).translationY(80).setDuration(300).start();
                btnStart.setEnabled(false);
                btnStop.setEnabled(true);
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnStop.setEnabled(false);
                btnStart.setEnabled(true);
                btnStart.animate().alpha(1).translationY(-80).setDuration(300).start();
                btnStop.animate().alpha(0).translationY(80).setDuration(300).start();
                chronometer.stop();
            }
        });
    }
}