package com.example.testtttttttt3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FragmentTestActivity extends AppCompatActivity {

    @OnClick({R.id.fgt_btn_easy,R.id.fgt_btn_dynamic,R.id.fgt_btn_news})
    public void onViewClick(View view) {
        switch (view.getId()){
            case R.id.fgt_btn_easy:
                startActivity(new Intent(getApplicationContext(),EasyFragmentTestActivity.class));
                break;
            case R.id.fgt_btn_dynamic:
                startActivity(new Intent(getApplicationContext(),DynamicFragmentTestActivity.class));
                break;
            case R.id.fgt_btn_news:
                startActivity(new Intent(getApplicationContext(),NewsMainActivity.class));
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_test);
        ButterKnife.bind(this); //绑定初始化ButterKnife
    }
}
