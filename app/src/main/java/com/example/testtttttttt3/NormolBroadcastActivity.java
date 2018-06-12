package com.example.testtttttttt3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NormolBroadcastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normol_broadcast);
        Button btnB = findViewById(R.id.btn_normal_broadcast_send);
        btnB.setOnClickListener( view ->  {
                Intent intent = new Intent("android.intent.action.NORMAL_TEST_BROADCAST");
                sendBroadcast(intent);
        });
    }
}
