package com.example.testtttttttt3;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.testtttttttt3.Util.HttpUtil;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;
import okhttp3.internal.Util;

public class SharedPerferencesActivity extends AppCompatActivity {

    private EditText editTextName,editTextGrade,editTextSex,editTextWeight;
    private Button buttonSave,buttonDeletePic,buttonDownloadPic;
    private TextView textContent;
    private ImageView imageViewPic;
    public String requestBingPic = "http://guolin.tech/api/bing_pic";
    public SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_perferences);
        init();
        readSharedPreferences();
        preferences = getSharedPreferences("picShared",MODE_PRIVATE);
        String bingPic = preferences.getString("bing_pic","");
       if(bingPic !=null){
        Glide.with(SharedPerferencesActivity.this).load( bingPic).into(imageViewPic);
        }else {
           loadBingPic();
        }

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = getSharedPreferences("SharedPreferencesTest",MODE_PRIVATE).edit();
                editor.putString("name",editTextName.getText().toString());
                editor.putString("grade",editTextGrade.getText().toString());
                editor.putString("sex",editTextSex.getText().toString());
                editor.putString("weight",editTextWeight.getText().toString());
               // editor.remove("sex");  //删除指定键值对
                editor.apply();
                readSharedPreferences();
            }
        });
        buttonDownloadPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               loadBingPic();
            }
        });
        buttonDeletePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = getSharedPreferences("picShared",MODE_PRIVATE).edit();
                editor.clear();  //删除缓存
                editor.apply();
            }
        });
    }
    private void init(){
       editTextName = findViewById(R.id.sp_edit_name);
       editTextGrade = findViewById(R.id.sp_edit_grade);
       editTextSex = findViewById(R.id.sp_edit_sex);
       editTextWeight = findViewById(R.id.sp_edit_weight);
       buttonSave = findViewById(R.id.sp_btn_save);
       textContent = findViewById(R.id.sp_tv);
       buttonDeletePic = findViewById(R.id.sp_btn_delete_pic);
       buttonDownloadPic = findViewById(R.id.sp_btn_pic);
       imageViewPic = findViewById(R.id.sp_img);
    }
    private void readSharedPreferences(){
        SharedPreferences preferences = getSharedPreferences("SharedPreferencesTest",MODE_PRIVATE);
        String content ="name:"+preferences.getString("name","")+"\n"+"grade:"+preferences.getString("grade",null)+"\n"
                +"sex:"+preferences.getString("sex","")+"\n"+"weight:"+preferences.getString("weight","")+"\n";
        textContent.setText(content);
    }

    private void loadBingPic(){
        HttpUtil.sendOkHttpRequest(requestBingPic,new okhttp3.Callback(){
            @Override
            public void onFailure(Call call, IOException e) {
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
               final String bingPic = response.body().string();
                SharedPreferences.Editor editor = getSharedPreferences("picShared",MODE_PRIVATE).edit();
                editor.putString("bing_pic",bingPic);
                editor.apply();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Glide.with(SharedPerferencesActivity.this).load(bingPic).into(imageViewPic);
                    }
                });
            }
        });
    }
}
