package com.example.andro.train;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Timer;


public class Start extends AppCompatActivity {
 ImageView imageView;
    Handler handler = new Handler();
    Timer timer = new Timer();
    Boolean n = false;
    int i;
    Animation animation;
    static ArrayList <java_train_journey>list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
     /*  imageView=findViewById(R.id.imageView2);
        i = 0;
        animation= AnimationUtils.loadAnimation(this,R.anim.rotate);
        imageView.startAnimation(animation);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        i++;
                        if(i>100){
                            startActivity(new Intent(Start.this, MainActivity.class));
                            timer.cancel();}
                        }

                });

            }
        }, 0, 60);
        list = new ArrayList<>();
        java_train_journey g = new java_train_journey();
        g.setFrom("minia");
        g.setTo("Alex");
        g.setPrice(0);
        g.setDecuman("No smoking\nman only\ntime  00 : 00\nname : andro\nplease you mast setdown in your chair.\nDon't bother anyone please.\n");
        java_train_journey ge = new java_train_journey();
        ge.setFrom("minia");
        ge.setTo("Alex");
        ge.setPrice(1000);
        ge.setDecuman("No smoking\nman only\ntime  00 : 00\nname : andro\nplease you mast setdown in your chair.\nDon't bother anyone please.\n");
        list.add(ge);
        java_train_journey gee = new java_train_journey();
        gee.setFrom("minia");
        gee.setTo("Alex");
        gee.setPrice(100);
        gee.setDecuman("No smoking\nman only\ntime  00 : 00\nname : andro\nplease you mast setdown in your chair.\nDon't bother anyone please.\n");
        list.add(gee);
        list.add(g);
        list.add(g);
        list.add(g);

    }

    @Override
    protected void onPostResume() {
        if (n) {
            System.exit(0);
        }
        super.onPostResume();
    }

    @Override
    protected void onStart() {
        if (n) {
            System.exit(0);
        }
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        n = true;
    */}
}
