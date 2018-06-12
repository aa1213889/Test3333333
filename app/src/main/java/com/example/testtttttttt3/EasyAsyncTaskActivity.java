package com.example.testtttttttt3;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testtttttttt3.Service.TestEasyAsyncTask;

public class EasyAsyncTaskActivity extends AppCompatActivity {

    private Button button;
    private TextView textView;
    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_async_task);
        button=(Button) findViewById(R.id.button1);
        textView=(TextView) findViewById(R.id.textView1);
        seekBar=(SeekBar) findViewById(R.id.seekBar1);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                TestEasyAsyncTask myTask = new TestEasyAsyncTask(textView,seekBar);
                Toast.makeText(EasyAsyncTaskActivity.this, "开始播放", 1).show();
                myTask.execute(1000);
            }
        });
    }

//    @Override
//    public void onClick(View view) {
//        switch (view.getId()){
//            case R.id.tv_easy:
//                break;
//        }
//    }

}
