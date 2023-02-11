package com.example.finfobject2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class windialog extends AppCompatActivity {

    protected ImageButton next, list, reload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_windialog);
        Intent intent = getIntent();
        String sessionId = intent.getStringExtra("Time");
        String score = intent.getStringExtra("score");
        TextView time = findViewById(R.id.timewin_4);
        TextView sscore = findViewById(R.id.score_4);
        sscore.setText("Your Score is : "+score);
        time.setText("Your Time Left is : "+sessionId + " Seconds");

        next = findViewById(R.id.nextlevel_4);
        list = findViewById(R.id.list_4);
        reload = findViewById(R.id.reload_4);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(windialog.this, Level_Two.class);
                startActivity(intent);
                finish();
            }
        });

        reload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(windialog.this, Level_One.class);
                startActivity(intent);
                finish();
            }
        });

        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(windialog.this, LevelSlider.class);
                startActivity(intent);
                finish();
            }
        });

    }
    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(windialog.this, LevelSlider.class);
        startActivity(intent);
        finish();
    }

}