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
import android.os.Vibrator;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class activity_level_three extends AppCompatActivity {

    ConstraintLayout screenlayout;
    ImageButton Trophy, Train, Crossbtn, Pizza, Sandwitch, Rose,Taddy, Bag;
    TextView Trophytxt, Traintxt,Pizzatxt, Sandwitchtxt, Rosetxt, textviewtime, Bagtxt, Taddytxt ;
    MediaPlayer trophymp3, trainmp3, pizzamp3, sandwitchmp3, rosemp3, bagmp3, taddymp3, youwinmp3, youlossmp3, tryagain;
    Vibrator vibrator;
    Dialog dialog;
    ImageButton addPause3;
//    MediaPlayer mysong;
    final String[] sDuration = new String[100];
    int clickcount=0;
    int Scoreboard = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_level_three);

        dialog = new Dialog(this);

        Trophy=findViewById(R.id.penholder_find);
        Train = findViewById(R.id.pot_find);
        Pizza = findViewById(R.id.horn_find);
        Sandwitch = findViewById(R.id.banana_find);
        Rose = findViewById(R.id.corn_find);
        Bag = findViewById(R.id.Bag_find);
        Taddy = findViewById(R.id.Taddy_find);

        Trophytxt = findViewById(R.id.txt1);
        Traintxt = findViewById(R.id.txt2);
        Rosetxt = findViewById(R.id.txt3);
        Pizzatxt = findViewById(R.id.txt4);
        Sandwitchtxt = findViewById(R.id.txt5);
        Bagtxt = findViewById(R.id.txt6);
        Taddytxt = findViewById(R.id.txt7);

        Crossbtn = findViewById(R.id.cross);
        textviewtime = findViewById(R.id.timeclock);

        addPause3 = findViewById(R.id.add_pause3);
        screenlayout = findViewById(R.id.screen1);
        vibrator = (Vibrator)getSystemService(VIBRATOR_SERVICE);

//        mysong = MediaPlayer.create(activity_level_three.this, R.raw.backgroundmusic);
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
                if(clickcount == 7){
                    cancel();
                }
            }

            @Override
            public void onFinish() {
                textviewtime.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext()
                        ,"Your Time's up",Toast.LENGTH_LONG).show();
                openLoseDialog();
                youlossmp3 = MediaPlayer.create(activity_level_three.this, R.raw.youloss);
                youlossmp3.start();
            }
        }.start();

        addPause3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View view){
                openPauseDialog();

            }
        });

//***********************************************************************
// Image Button

        Trophy.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View view){
                Trophy.setVisibility(View.GONE);
                Trophytxt.setVisibility(View.GONE);
                trophymp3 = MediaPlayer.create(activity_level_three.this, R.raw.trophy);
                trophymp3.start();
                Scoreboard += 10;
//#############################################
//                Count Image Button (Object)

                clickcount=clickcount+1;
                if(clickcount==7)
                {
                    //first time clicked to do this
                    openWinDialog();

                    youwinmp3 = MediaPlayer.create(activity_level_three.this, R.raw.youwin);
                    youwinmp3.start();

                    // ####################################################
//       Notification
                    NotificationCompat.Builder builder = new NotificationCompat.Builder(activity_level_three.this, "My Notification");
                    builder.setContentTitle("You Win");
                    builder.setContentText("Click notification and seen your Score");
                    builder.setSmallIcon(R.drawable.ic_time);
                    builder.setAutoCancel(true);

                    NotificationManagerCompat managerCompat = NotificationManagerCompat.from(activity_level_three.this);
                    managerCompat.notify(1, builder.build());

                    Intent intent = new Intent(activity_level_three.this, Dashboard.class);
                    PendingIntent pendingIntent = PendingIntent.getActivity(activity_level_three.this, 0, intent, 0);

                    builder.setContentIntent(pendingIntent);
                    NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                    notificationManager.notify(1, builder.build());
                    finish();


                }
            }
        });

        Taddy.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View view){
                Taddy.setVisibility(View.GONE);
                Taddytxt.setVisibility(View.GONE);
                taddymp3 = MediaPlayer.create(activity_level_three.this, R.raw.teddy);
                taddymp3.start();
                Scoreboard += 10;
//#############################################
//                Count Image Button (Object)

                clickcount=clickcount+1;
                if(clickcount==7)
                {
                    //first time clicked to do this
                    openWinDialog();

                    youwinmp3 = MediaPlayer.create(activity_level_three.this, R.raw.youwin);
                    youwinmp3.start();

                    // ####################################################
//       Notification
                    NotificationCompat.Builder builder = new NotificationCompat.Builder(activity_level_three.this, "My Notification");
                    builder.setContentTitle("You Win");
                    builder.setContentText("Click notification and seen your Score");
                    builder.setSmallIcon(R.drawable.ic_time);
                    builder.setAutoCancel(true);

                    NotificationManagerCompat managerCompat = NotificationManagerCompat.from(activity_level_three.this);
                    managerCompat.notify(1, builder.build());

                    Intent intent = new Intent(activity_level_three.this, Dashboard.class);
                    PendingIntent pendingIntent = PendingIntent.getActivity(activity_level_three.this, 0, intent, 0);

                    builder.setContentIntent(pendingIntent);
                    NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                    notificationManager.notify(1, builder.build());
                    finish();

                }
            }
        });

        Bag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Bag.setVisibility(View.GONE);
                Bagtxt.setVisibility(View.GONE);
                bagmp3 = MediaPlayer.create(activity_level_three.this, R.raw.bag);
                bagmp3.start();
                Scoreboard += 10;

//#############################################
//                Count Image Button (Object)
                clickcount=clickcount+1;
                if(clickcount==7)
                {
                    //first time clicked to do this
                    openWinDialog();

                    youwinmp3 = MediaPlayer.create(activity_level_three.this, R.raw.youwin);
                    youwinmp3.start();
                    // ####################################################
//       Notification
                    NotificationCompat.Builder builder = new NotificationCompat.Builder(activity_level_three.this, "My Notification");
                    builder.setContentTitle("You Win");
                    builder.setContentText("Click notification and seen your Score");
                    builder.setSmallIcon(R.drawable.ic_time);
                    builder.setAutoCancel(true);

                    NotificationManagerCompat managerCompat = NotificationManagerCompat.from(activity_level_three.this);
                    managerCompat.notify(1, builder.build());

                    Intent intent = new Intent(activity_level_three.this, Dashboard.class);
                    PendingIntent pendingIntent = PendingIntent.getActivity(activity_level_three.this, 0, intent, 0);

                    builder.setContentIntent(pendingIntent);
                    NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                    notificationManager.notify(1, builder.build());
                    finish();
                }
            }

        });

        Train.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Train.setVisibility(View.GONE);
                Traintxt.setVisibility(View.GONE);
                trainmp3 = MediaPlayer.create(activity_level_three.this, R.raw.train);
                trainmp3.start();
                Scoreboard += 10;

//#############################################
//                Count Image Button (Object)
                clickcount=clickcount+1;
                if(clickcount==7)
                {
                    //first time clicked to do this
                    openWinDialog();

                    youwinmp3 = MediaPlayer.create(activity_level_three.this, R.raw.youwin);
                    youwinmp3.start();
                    // ####################################################
//       Notification
                    NotificationCompat.Builder builder = new NotificationCompat.Builder(activity_level_three.this, "My Notification");
                    builder.setContentTitle("You Win");
                    builder.setContentText("Click notification and seen your Score");
                    builder.setSmallIcon(R.drawable.ic_time);
                    builder.setAutoCancel(true);

                    NotificationManagerCompat managerCompat = NotificationManagerCompat.from(activity_level_three.this);
                    managerCompat.notify(1, builder.build());

                    Intent intent = new Intent(activity_level_three.this, Dashboard.class);
                    PendingIntent pendingIntent = PendingIntent.getActivity(activity_level_three.this, 0, intent, 0);

                    builder.setContentIntent(pendingIntent);
                    NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                    notificationManager.notify(1, builder.build());
                    finish();
                }
            }

        });
        Pizza.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View view){
                Pizza.setVisibility(View.GONE);
                Pizzatxt.setVisibility(View.GONE);
                pizzamp3 = MediaPlayer.create(activity_level_three.this, R.raw.pizza);
                pizzamp3.start();
                Scoreboard += 10;

//#############################################
//                Count Image Button (Object)

                clickcount=clickcount+1;
                if(clickcount==7)
                {
                    //first time clicked to do this
                    openWinDialog();

                    youwinmp3 = MediaPlayer.create(activity_level_three.this, R.raw.youwin);
                    youwinmp3.start();
                    // ####################################################
//       Notification
                    NotificationCompat.Builder builder = new NotificationCompat.Builder(activity_level_three.this, "My Notification");
                    builder.setContentTitle("You Win");
                    builder.setContentText("Click notification and seen your Score");
                    builder.setSmallIcon(R.drawable.ic_time);
                    builder.setAutoCancel(true);

                    NotificationManagerCompat managerCompat = NotificationManagerCompat.from(activity_level_three.this);
                    managerCompat.notify(1, builder.build());

                    Intent intent = new Intent(activity_level_three.this, Dashboard.class);
                    PendingIntent pendingIntent = PendingIntent.getActivity(activity_level_three.this, 0, intent, 0);

                    builder.setContentIntent(pendingIntent);
                    NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                    notificationManager.notify(1, builder.build());
                    finish();
                }
            }
        });
        Sandwitch.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View view){
                Sandwitch.setVisibility(View.GONE);
                Sandwitchtxt.setVisibility(View.GONE);
                sandwitchmp3 = MediaPlayer.create(activity_level_three.this, R.raw.sandwitch);
                sandwitchmp3.start();
                Scoreboard += 10;

//#############################################
//                Count Image Button (Object)

                clickcount=clickcount+1;
                if(clickcount==7)
                {
                    //first time clicked to do this
                    openWinDialog();

                    youwinmp3 = MediaPlayer.create(activity_level_three.this, R.raw.youwin);
                    youwinmp3.start();

                    // ####################################################
//       Notification
                    NotificationCompat.Builder builder = new NotificationCompat.Builder(activity_level_three.this, "My Notification");
                    builder.setContentTitle("You Win");
                    builder.setContentText("Click notification and seen your Score");
                    builder.setSmallIcon(R.drawable.ic_time);
                    builder.setAutoCancel(true);

                    NotificationManagerCompat managerCompat = NotificationManagerCompat.from(activity_level_three.this);
                    managerCompat.notify(1, builder.build());

                    Intent intent = new Intent(activity_level_three.this, Dashboard.class);
                    PendingIntent pendingIntent = PendingIntent.getActivity(activity_level_three.this, 0, intent, 0);

                    builder.setContentIntent(pendingIntent);
                    NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                    notificationManager.notify(1, builder.build());
                    finish();


                }
            }
        });
        Rose.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View view){
                Rose.setVisibility(View.GONE);
                Rosetxt.setVisibility(View.GONE);
                rosemp3 = MediaPlayer.create(activity_level_three.this, R.raw.rose);
                rosemp3.start();
                Scoreboard += 10;

//                Count Image Button (Object)

                clickcount=clickcount+1;
                if(clickcount==7)
                {
                    //first time clicked to do this
                    openWinDialog();

                    youwinmp3 = MediaPlayer.create(activity_level_three.this, R.raw.youwin);
                    youwinmp3.start();

                    // ####################################################
//       Notification
                    NotificationCompat.Builder builder = new NotificationCompat.Builder(activity_level_three.this, "My Notification");
                    builder.setContentTitle("You Win");
                    builder.setContentText("Click notification and seen your Score");
                    builder.setSmallIcon(R.drawable.ic_time);
                    builder.setAutoCancel(true);

                    NotificationManagerCompat managerCompat = NotificationManagerCompat.from(activity_level_three.this);
                    managerCompat.notify(1, builder.build());

                    Intent intent = new Intent(activity_level_three.this, Dashboard.class);
                    PendingIntent pendingIntent = PendingIntent.getActivity(activity_level_three.this, 0, intent, 0);

                    builder.setContentIntent(pendingIntent);
                    NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                    notificationManager.notify(1, builder.build());
                    finish();

//#############################################
                }
            }
        });

        screenlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                vibrator.vibrate(100);
                Crossbtn.setVisibility(View.VISIBLE);
                tryagain = MediaPlayer.create(activity_level_three.this, R.raw.tryagain);
                tryagain.start();
                Scoreboard += 10;
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
                Intent intent = new Intent(activity_level_three.this, LevelSlider.class);
                startActivity(intent);
                finish();
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                Intent intent = new Intent(activity_level_three.this, LevelSlider.class);
                startActivity(intent);
                finish();
            }
        });
    }

    //######################################################################
// win dialogbox
    private void openWinDialog(){

        Intent i = new Intent(activity_level_three.this,windialog3.class);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(activity_level_three.this);
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
                                finish();

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
                        Intent intent = new Intent(activity_level_three.this, LevelSlider.class);
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
        dialog.setContentView(R.layout.activity_pausebtn2);
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
                Intent intent = new Intent(activity_level_three.this, activity_level_three.class);
                startActivity(intent);
                finish();
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                Intent intent = new Intent(activity_level_three.this, Dashboard.class);
                startActivity(intent);
                finish();
            }
        });
    }
//    @Override
//    protected void onPause() {
//        super.onPause();
//        mysong.stop();
//        mysong.release();
//
//    }
}