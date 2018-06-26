package com.example.testtttttttt3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.testtttttttt3.Util.ToastUtil;

public class AnimationIntentActivity extends AppCompatActivity {
    Intent intent ;
    String data ;
    String data1,data2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_intent);
        TextView textView = findViewById(R.id.ami_tv);
        intent = getIntent();
        data = intent.getStringExtra("extra_data");
        textView.setText(data);
        data1 = "淡出淡入";
        data2 = "滑动切换";
    }

    @Override
    public void finish() {
        super.finish();
        if(data.equals(data1)){   //比较值是否一致
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
        } else if(data.equals(data2)){
            overridePendingTransition(0,R.anim.out_to2);
        }
    }
}
