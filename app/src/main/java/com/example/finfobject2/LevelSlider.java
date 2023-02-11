package com.example.finfobject2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.os.Bundle;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class LevelSlider extends AppCompatActivity {

    private ViewFlipper viewFlipper;

    private LinearLayout linearLayout1;
    private LinearLayout linearLayout2;
    private LinearLayout linearLayout3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_level_slider);

//        ConstraintLayout constraintLayout = findViewById(R.id.slider_background);
//        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
//        animationDrawable.setEnterFadeDuration(2500);
//        animationDrawable.setExitFadeDuration(5000);
//        animationDrawable.start();

        viewFlipper = findViewById(R.id.view_flipper);
        linearLayout1 = findViewById(R.id.activity1);
        linearLayout2 = findViewById(R.id.activity2);
        linearLayout3 = findViewById(R.id.activity3);

        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(LevelSlider.this, Level_One.class);
                startActivity(intent);
                finish();
            }
        });

        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(LevelSlider.this, Level_Two.class);
                startActivity(intent);
                finish();
            }
        });

        linearLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(LevelSlider.this, activity_level_three.class);
                startActivity(intent);
                finish();
            }
        });

//        viewFlipper.setFlipInterval(2000);
//        viewFlipper.startFlipping();

    }
    public void previousView(View v) {
        viewFlipper.setInAnimation(this, R.anim.slide_in_right);
        viewFlipper.setOutAnimation(this, R.anim.slide_out_left);
        viewFlipper.showPrevious();
    }
    public void nextView(View v){
        viewFlipper.setInAnimation(this, android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this, android.R.anim.slide_out_right);
        viewFlipper.showNext();
//        viewFlipper.setDisplayedChild();
    }
    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(LevelSlider.this, Dashboard.class);
        startActivity(intent);
        finish();
    }
}