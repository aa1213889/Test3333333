package com.example.testtttttttt3;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;

import com.example.testtttttttt3.Util.ToastUtil;

public class AnimationInterpolatorActivity extends AppCompatActivity {
  TextView textView1,textView2,textView3,textView4,textView5,textView6,textView7,textView8,textView9;
  Button buttonStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_interpolator);
        textView1 = findViewById(R.id.ai_tv_1);
        textView2 = findViewById(R.id.ai_tv_2);
        textView3 = findViewById(R.id.ai_tv_3);
        textView4 = findViewById(R.id.ai_tv_4);
        textView5 = findViewById(R.id.ai_tv_5);
        textView6 = findViewById(R.id.ai_tv_6);
        textView7 = findViewById(R.id.ai_tv_7);
        textView8 = findViewById(R.id.ai_tv_8);
        textView9 = findViewById(R.id.ai_tv_9);
        buttonStart = findViewById(R.id.ai_btn);
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Interpolator interpolator1 = new AccelerateInterpolator();
                scanle(textView1,interpolator1);
                Interpolator interpolator2 = new OvershootInterpolator();
                scanle(textView2,interpolator2);
                Interpolator interpolator3 = new AccelerateDecelerateInterpolator();
                scanle(textView3,interpolator3);
                Interpolator interpolator4 = new AnticipateInterpolator();
                scanle(textView4,interpolator4);
                Interpolator interpolator5 = new AnticipateOvershootInterpolator();
                scanle(textView5,interpolator5);
               // Interpolator interpolator6 = new BounceInterpolator();
                scanle(textView6,new BounceInterpolator());
                Interpolator interpolator7 = new CycleInterpolator(1);
                scanle(textView7,interpolator7);
                Interpolator interpolator8 = new DecelerateInterpolator();
                scanle(textView8,interpolator8);
                Interpolator interpolator9 = new LinearInterpolator();
                scanle(textView9,interpolator9);
            }
        });
    }
    public void scanle(View view,Interpolator interpolator){
        Animation translateAnimation = new TranslateAnimation(0,1000,0,0);
        translateAnimation.setDuration(8000);
        translateAnimation.setInterpolator(interpolator);
        view.startAnimation(translateAnimation);
    }
}
