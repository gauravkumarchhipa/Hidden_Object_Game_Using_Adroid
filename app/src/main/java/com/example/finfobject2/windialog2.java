package com.example.finfobject2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class windialog2 extends AppCompatActivity {

    protected ImageButton next1, list1, reload1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_windialog2);
        Intent intent = getIntent();
        String sessionId = intent.getStringExtra("Time");
        String score = intent.getStringExtra("score");
        TextView time = findViewById(R.id.timewin_4);
        TextView sscore = findViewById(R.id.score_4);
        sscore.setText("Your Score is : "+score);
        time.setText("Your Time Left is : "+sessionId + " Seconds");

        next1 = findViewById(R.id.nextlevel_4);
        list1 = findViewById(R.id.list_4);
        reload1 = findViewById(R.id.reload_4);
//        cross2 = findViewById(R.id.imageViewClose_4);

        next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(windialog2.this, activity_level_three.class);
                startActivity(intent);
                finish();
            }
        });

        reload1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(windialog2.this, Level_Two.class);
                startActivity(intent);
                finish();
            }
        });

        list1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(windialog2.this, LevelSlider.class);
                startActivity(intent);
                finish();
            }
        });

//        cross2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view){
//                Intent intent = new Intent(windialog2.this, Dashboard.class);
//                startActivity(intent);
//            }
//        });
    }
    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(windialog2.this, LevelSlider.class);
        startActivity(intent);
        finish();
    }
}