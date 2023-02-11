package com.example.finfobject2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class pausebtn3 extends AppCompatActivity {

    Button Resume;
    Button Restart;
    Button Home;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pausebtn3);

        Resume = findViewById(R.id.resume2);
        Restart = findViewById(R.id.restart2);
        Home = findViewById(R.id.home3);
//        dialog = new Dialog(this);


        Resume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                dialog.show();
                Toast.makeText(pausebtn3.this, "Resume", Toast.LENGTH_SHORT).show();
            }
        });

        Restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                dialog.show();
                Toast.makeText(pausebtn3.this, "Restart", Toast.LENGTH_SHORT).show();
            }
        });

        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                dialog.show();
                Toast.makeText(pausebtn3.this, "Home", Toast.LENGTH_SHORT).show();
            }
        });

    }
}