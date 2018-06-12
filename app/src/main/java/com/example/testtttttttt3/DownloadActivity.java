package com.example.testtttttttt3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DownloadActivity extends AppCompatActivity implements View.OnClickListener{

    private Button downButton,pauseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

        }
    }
}
