package com.example.finfobject2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Dialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Vibrator;

import java.util.Locale;
import java.util.concurrent.TimeUnit;


public class Level_One extends AppCompatActivity{
    ConstraintLayout screenlayout;
    ImageButton Penholder, Pot, Crossbtn, Horn, Banana, Corn, Bucket;
    TextView Penholdertxt, Pottxt, Bananatxt, Corntxt, Buckettxt, Horntxt;
    TextView textviewtime ;
    ImageButton addPause;
    Vibrator vibrator;
    Dialog dialog;
    MediaPlayer bananamp3, bucketmp3, cornmp3, hornmp3, penholdermp3, potmp3, youwinmp3, youlossmp3, tryagain;
    //    MediaPlayer mysong;
    final String[] sDuration = new String[100];
    int clickcount=0;
    int Scoreboard = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_level_one);

        dialog = new Dialog(this);

        Penholder=findViewById(R.id.penholder_find);
        Pot = findViewById(R.id.pot_find);
        Horn = findViewById(R.id.horn_find);
        Banana = findViewById(R.id.banana_find);
        Corn = findViewById(R.id.corn_find);
        Bucket = findViewById(R.id.bucket_find);

        Penholdertxt = findViewById(R.id.txt1);
        Pottxt = findViewById(R.id.txt2);
        Corntxt = findViewById(R.id.txt3);
        Horntxt = findViewById(R.id.txt4);
        Bananatxt = findViewById(R.id.txt5);
        Buckettxt = findViewById(R.id.txt6);

        Crossbtn = findViewById(R.id.cross);
        textviewtime = findViewById(R.id.timeclock);
        addPause = findViewById(R.id.add_pause);

        screenlayout = findViewById(R.id.screen1);
        vibrator = (Vibrator)getSystemService(VIBRATOR_SERVICE);

//        mysong = MediaPlayer.create(Level_One.this, R.raw.backgroundmusic);
//        mysong.start();

//*************************************************************
//  Timer
        long duration = TimeUnit.SECONDS.toMillis(60);
        new CountDownTimer(duration, 1000) {
            @Override
            public void onTick(long l) {
                sDuration[0] = String.format(Locale.ENGLISH, "%02d : %02d",
                        TimeUnit.MILLISECONDS.toMinutes(l),
                        TimeUnit.MILLISECONDS.toSeconds(l) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(l)));
                textviewtime.setText(sDuration[0]);
                if(clickcount == 6){
                    cancel();
                }
            }

            @Override
            public void onFinish() {
                textviewtime.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext()
                        ,"Your Time's up",Toast.LENGTH_LONG).show();
//                Toast.makeText(Level_One.this, "", Toast.LENGTH_SHORT).show();
                openLoseDialog();
                youlossmp3 = MediaPlayer.create(Level_One.this, R.raw.youloss);
                youlossmp3.start();
            }
        }.start();

        addPause.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View view){
                openPauseDialog();

            }
        });

//***********************************************************************
// Image Button

        Penholder.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View view){
                Penholder.setVisibility(View.GONE);
                Penholdertxt.setVisibility(View.GONE);
                penholdermp3 = MediaPlayer.create(Level_One.this, R.raw.penholder);
                penholdermp3.start();
                Scoreboard += 10;


//#############################################
//                Count Image Button (Object)

                clickcount=clickcount+1;
                if(clickcount==6)
                {
                    //first time clicked to do this
                    openWinDialog();
                    youwinmp3 = MediaPlayer.create(Level_One.this, R.raw.youwin);
                    youwinmp3.start();
                    finish();

// ####################################################
//       Notification
                    NotificationCompat.Builder builder = new NotificationCompat.Builder(Level_One.this, "My Notification");
                    builder.setContentTitle("You Win");
                    builder.setContentText("Click notification and seen your Score");
                    builder.setSmallIcon(R.drawable.ic_time);
                    builder.setAutoCancel(true);

                    NotificationManagerCompat managerCompat = NotificationManagerCompat.from(Level_One.this);
                    managerCompat.notify(1, builder.build());

                    Intent intent = new Intent(Level_One.this, Dashboard.class);
                    PendingIntent pendingIntent = PendingIntent.getActivity(Level_One.this, 0, intent, 0);

                    builder.setContentIntent(pendingIntent);
                    NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                    notificationManager.notify(1, builder.build());

                }
            }
        });

        Bucket.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View view){
                Bucket.setVisibility(View.GONE);
                Buckettxt.setVisibility(View.GONE);
                bucketmp3 = MediaPlayer.create(Level_One.this, R.raw.bucket);
                bucketmp3.start();
                Scoreboard += 10;

//#############################################
//                Count Image Button (Object)

                clickcount=clickcount+1;
                if(clickcount==6)
                {
                    //first time clicked to do this
                    openWinDialog();
                    youwinmp3 = MediaPlayer.create(Level_One.this, R.raw.youwin);
                    youwinmp3.start();
                    finish();

// ####################################################
//       Notification
                    NotificationCompat.Builder builder = new NotificationCompat.Builder(Level_One.this, "My Notification");
                    builder.setContentTitle("You Win");
                    builder.setContentText("Click notification and seen your Score");
                    builder.setSmallIcon(R.drawable.ic_time);
                    builder.setAutoCancel(true);

                    NotificationManagerCompat managerCompat = NotificationManagerCompat.from(Level_One.this);
                    managerCompat.notify(1, builder.build());

                    Intent intent = new Intent(Level_One.this, Dashboard.class);
                    PendingIntent pendingIntent = PendingIntent.getActivity(Level_One.this, 0, intent, 0);

                    builder.setContentIntent(pendingIntent);
                    NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                    notificationManager.notify(1, builder.build());

                }
            }
        });

        Pot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Pot.setVisibility(View.GONE);
                Pottxt.setVisibility(View.GONE);
                potmp3 = MediaPlayer.create(Level_One.this, R.raw.pot);
                potmp3.start();

                Scoreboard+=10;
//#############################################
//                Count Image Button (Object)
                clickcount=clickcount+1;
                if(clickcount==6)
                {
                    //first time clicked to do this
                    openWinDialog();
                    youwinmp3 = MediaPlayer.create(Level_One.this, R.raw.youwin);
                    youwinmp3.start();
                    finish();
                    // ####################################################
//       Notification
                    NotificationCompat.Builder builder = new NotificationCompat.Builder(Level_One.this, "My Notification");
                    builder.setContentTitle("You Win");
                    builder.setContentText("Click notification and seen your Score");
                    builder.setSmallIcon(R.drawable.ic_time);
                    builder.setAutoCancel(true);

                    NotificationManagerCompat managerCompat = NotificationManagerCompat.from(Level_One.this);
                    managerCompat.notify(1, builder.build());

                    Intent intent = new Intent(Level_One.this, Dashboard.class);
                    PendingIntent pendingIntent = PendingIntent.getActivity(Level_One.this, 0, intent, 0);

                    builder.setContentIntent(pendingIntent);
                    NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                    notificationManager.notify(1, builder.build());
                }
            }

        });
        Corn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View view){
                Corn.setVisibility(View.GONE);
                Corntxt.setVisibility(View.GONE);
                cornmp3 = MediaPlayer.create(Level_One.this, R.raw.corn);
                cornmp3.start();


                Scoreboard+=10;
//#############################################
//                Count Image Button (Object)

                clickcount=clickcount+1;
                if(clickcount==6)
                {
                    //first time clicked to do this
                    openWinDialog();
                    youwinmp3 = MediaPlayer.create(Level_One.this, R.raw.youwin);
                    youwinmp3.start();
                    finish();
                    // ####################################################
//       Notification
                    NotificationCompat.Builder builder = new NotificationCompat.Builder(Level_One.this, "My Notification");
                    builder.setContentTitle("You Win");
                    builder.setContentText("Click notification and seen your Score");
                    builder.setSmallIcon(R.drawable.ic_time);
                    builder.setAutoCancel(true);

                    NotificationManagerCompat managerCompat = NotificationManagerCompat.from(Level_One.this);
                    managerCompat.notify(1, builder.build());

                    Intent intent = new Intent(Level_One.this, Dashboard.class);
                    PendingIntent pendingIntent = PendingIntent.getActivity(Level_One.this, 0, intent, 0);

                    builder.setContentIntent(pendingIntent);
                    NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                    notificationManager.notify(1, builder.build());
                }
            }
        });
        Horn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View view){
                Horn.setVisibility(View.GONE);
                Horntxt.setVisibility(View.GONE);
                hornmp3 = MediaPlayer.create(Level_One.this, R.raw.horn);
                hornmp3.start();

                Scoreboard+=10;
//#############################################
//                Count Image Button (Object)

                clickcount=clickcount+1;
                if(clickcount==6)
                {
                    //first time clicked to do this
                    openWinDialog();
                    youwinmp3 = MediaPlayer.create(Level_One.this, R.raw.youwin);
                    youwinmp3.start();
                    finish();

                    // ####################################################
//       Notification
                    NotificationCompat.Builder builder = new NotificationCompat.Builder(Level_One.this, "My Notification");
                    builder.setContentTitle("You Win");
                    builder.setContentText("Click notification and seen your Score");
                    builder.setSmallIcon(R.drawable.ic_time);
                    builder.setAutoCancel(true);

                    NotificationManagerCompat managerCompat = NotificationManagerCompat.from(Level_One.this);
                    managerCompat.notify(1, builder.build());

                    Intent intent = new Intent(Level_One.this, Dashboard.class);
                    PendingIntent pendingIntent = PendingIntent.getActivity(Level_One.this, 0, intent, 0);

                    builder.setContentIntent(pendingIntent);
                    NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                    notificationManager.notify(1, builder.build());


                }
            }
        });
        Banana.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View view){
                Banana.setVisibility(View.GONE);
                Bananatxt.setVisibility(View.GONE);
                bananamp3 = MediaPlayer.create(Level_One.this, R.raw.banana);
                bananamp3.start();

                Scoreboard+=10;

//                Count Image Button (Object)

                clickcount=clickcount+1;
                if(clickcount==6)
                {
                    //first time clicked to do this
                    openWinDialog();
                    youwinmp3 = MediaPlayer.create(Level_One.this, R.raw.youwin);
                    youwinmp3.start();
                    finish();

                    // ####################################################
//       Notification
                    NotificationCompat.Builder builder = new NotificationCompat.Builder(Level_One.this, "My Notification");
                    builder.setContentTitle("You Win");
                    builder.setContentText("Click notification and seen your Score");
                    builder.setSmallIcon(R.drawable.ic_time);
                    builder.setAutoCancel(true);

                    NotificationManagerCompat managerCompat = NotificationManagerCompat.from(Level_One.this);
                    managerCompat.notify(1, builder.build());

                    Intent intent = new Intent(Level_One.this, Dashboard.class);
                    PendingIntent pendingIntent = PendingIntent.getActivity(Level_One.this, 0, intent, 0);

                    builder.setContentIntent(pendingIntent);
                    NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                    notificationManager.notify(1, builder.build());

//#############################################
                }
            }
        });

        screenlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                vibrator.vibrate(100);
                Crossbtn.setVisibility(View.VISIBLE);
                tryagain = MediaPlayer.create(Level_One.this, R.raw.tryagain);
                tryagain.start();

                Crossbtn.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Crossbtn.setVisibility(View.GONE);
                    }
                }, 1000);
            }
        });
    }
//##################################################################
//    Loss Dialogbox

    private void openLoseDialog(){
        dialog.setContentView(R.layout.lose_layout_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

//        ConstraintLayout constraintLayout = findViewById(R.id.clossbg);
//        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
//        animationDrawable.setEnterFadeDuration(2500);
//        animationDrawable.setExitFadeDuration(5000);
//        animationDrawable.start();

        ImageView imageViewClose=dialog.findViewById(R.id.imageViewClose_4);
        TextView btnOk=dialog.findViewById(R.id.list_4);
        dialog.show();

        imageViewClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                Intent intent = new Intent(Level_One.this, LevelSlider.class);
                startActivity(intent);
                finish();
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                Intent intent = new Intent(Level_One.this, LevelSlider.class);
                startActivity(intent);
            }
        });
    }

    //######################################################################
// win dialogbox
    private void openWinDialog(){

        Intent i = new Intent(Level_One.this,windialog.class);
        i.putExtra("Time",sDuration[0]);
        i.putExtra("score",String.valueOf(Scoreboard));
        startActivity(i);
        finish();
    }
//###################################################################################
//are you sure btn

    private void openSureDialog(){
        dialog.setContentView(R.layout.sure_layout_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        TextView btnno=dialog.findViewById(R.id.btnNo);
        TextView btnyes=dialog.findViewById(R.id.btnYes);
        dialog.show();

        btnno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        btnyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Level_One.this);
                builder.setMessage("Are you sure you want to exit")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();

                            }
                        });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }
        });

    }
//#########################################################################3
//    onBackpress

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to exit")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(Level_One.this, LevelSlider.class);
                        startActivity(intent);
                        finish();
                    }
                })

                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

    private void openPauseDialog(){
        dialog.setContentView(R.layout.activity_pausebtn);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        ImageView imageViewClose=dialog.findViewById(R.id.closebtn2);
        TextView btnResume=dialog.findViewById(R.id.resume2);
        TextView btnRestart=dialog.findViewById(R.id.restart2);
        TextView btnHome=dialog.findViewById(R.id.home3);
        dialog.show();

        imageViewClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        btnResume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                Intent intent = new Intent(Level_One.this, Level_One.class);
                startActivity(intent);
                finish();
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                Intent intent = new Intent(Level_One.this, Dashboard.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
//        mysong.stop();
//        mysong.release();
    }
}