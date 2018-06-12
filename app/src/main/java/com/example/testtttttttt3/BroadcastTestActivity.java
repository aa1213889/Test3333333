package com.example.testtttttttt3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import butterknife.OnClick;
import butterknife.ButterKnife;
public class BroadcastTestActivity extends AppCompatActivity {

    @OnClick({R.id.btn_b_network,R.id.btn_b_airplane_mode,R.id.btn_b_normal_broadcast,R.id.btn_b_ordered_broadcast,R.id.btn_b_local_broadcast})
    public void allOnClick(View view){
        switch (view.getId()){
            case R.id.btn_b_network:
                startActivity(new Intent(BroadcastTestActivity.this,NetWorkBroadcastTestActivity.class));
                break;
            case R.id.btn_b_airplane_mode:
                startActivity(new Intent(BroadcastTestActivity.this,AirplaneBroadcastTestActivity.class));
                break;
            case R.id.btn_b_normal_broadcast:
                startActivity(new Intent(BroadcastTestActivity.this,NormolBroadcastActivity.class));
                break;
            case R.id.btn_b_local_broadcast:
                startActivity(new Intent(BroadcastTestActivity.this,LocalBroadcastActivity.class));
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_test);
        ButterKnife.bind(this); //绑定初始化ButterKnife
    }
}
