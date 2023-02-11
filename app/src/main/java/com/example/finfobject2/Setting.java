package com.example.finfobject2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class Setting extends AppCompatActivity {

    Switch Sound;
    MediaPlayer mysong;


    private static String MY_PREFS = "switch_prefs";
    private static String LIGHT_STATUS = "Light_on";
    private static String SWITCH_STATUS = "Switch_status";

    boolean Switch_status;
    boolean Light_status;

    SharedPreferences myPreferences;
    SharedPreferences.Editor myEditor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

//        ConstraintLayout constraintLayout = findViewById(R.id.settingbg);
//        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
//        animationDrawable.setEnterFadeDuration(2500);
//        animationDrawable.setExitFadeDuration(5000);
//        animationDrawable.start();

        Sound = findViewById(R.id.switch1);
        mysong = MediaPlayer.create(Setting.this, R.raw.backgroundmusic);
        mysong.setLooping(true);
//        Music = findViewById(R.id.switch2);

        myPreferences = getSharedPreferences(MY_PREFS,MODE_PRIVATE);
        myEditor = getSharedPreferences(MY_PREFS,MODE_PRIVATE).edit();

        Switch_status = myPreferences.getBoolean(SWITCH_STATUS, false);
        Light_status = myPreferences.getBoolean(LIGHT_STATUS, false);

//        Sound.setChecked(Switch_status);
//        if(Light_status){
//            Toast.makeText(Setting.this, "On", Toast.LENGTH_SHORT).show();
////            mysong.start();
//        }else{
//            Toast.makeText(Setting.this, "Off", Toast.LENGTH_SHORT).show();
////            mysong.release();
//        }


        Sound.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(compoundButton.isChecked()) {
                    mysong.start();
//                    Toast.makeText(Setting.this, "On", Toast.LENGTH_SHORT).show();

                    myEditor.putBoolean(SWITCH_STATUS, true);
                    myEditor.putBoolean(LIGHT_STATUS, true);
                }else {
                    mysong.release();
//                    Toast.makeText(Setting.this, "Off", Toast.LENGTH_SHORT).show();
                    myEditor.putBoolean(SWITCH_STATUS, false);
                    myEditor.putBoolean(LIGHT_STATUS, false);

                    myEditor.apply();
                    Sound.setChecked(false);
                }
            }
        });


    }
    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(Setting.this, Dashboard.class);
        startActivity(intent);
        finish();
    }
}
