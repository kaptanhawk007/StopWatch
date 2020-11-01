package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnGetStarted;
    private ImageView frontImage;
    Animation anim_FrontImage,anim_one,anim_two;
    private TextView title,description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnGetStarted=findViewById(R.id.btnGetStarted);
        frontImage=findViewById(R.id.imgFront);
        title=findViewById(R.id.textTitle);
        description=findViewById(R.id.textDesription);
        anim_FrontImage= AnimationUtils.loadAnimation(MainActivity.this,R.anim.anim_front_image);
        anim_one=AnimationUtils.loadAnimation(this,R.anim.anim_one);
        anim_two=AnimationUtils.loadAnimation(this,R.anim.anim_two);
        frontImage.startAnimation(anim_FrontImage);
        title.startAnimation(anim_one);
        description.startAnimation(anim_one);
        btnGetStarted.startAnimation(anim_two);
        btnGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(MainActivity.this,StopwatchActivity.class);
                startActivity(intent);

            }
        });
    }
}