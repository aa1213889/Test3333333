package com.example.testtttttttt3;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.testtttttttt3.Service.MyService;

public class ServiceTestActivity extends AppCompatActivity implements View.OnClickListener{

    private MyService.DownloadBinder downloadBinder;

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            downloadBinder = (MyService.DownloadBinder) iBinder;
            downloadBinder.startDownload();
            downloadBinder.getProgress();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_test);
        Button bindService = findViewById(R.id.btn_bind);
        bindService.setOnClickListener(this);
        Button unbindService = findViewById(R.id.btn_unbind);
        unbindService.setOnClickListener(this);
        Button downloadService = findViewById(R.id.btn_down_service);
        downloadService.setOnClickListener(this);
        Button easyAsyncTask = findViewById(R.id.btn_e_tsk);
        easyAsyncTask.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_bind:
                bindService(new Intent(this,MyService.class),connection,BIND_AUTO_CREATE); //绑定服务
                break;
            case R.id.btn_unbind:
                unbindService(connection);
                break;
            case R.id.btn_down_service:
                startActivity(new Intent(ServiceTestActivity.this,DownloadActivity.class));
                break;
            case R.id.btn_e_tsk:
                startActivity(new Intent(ServiceTestActivity.this,EasyAsyncTaskActivity.class));
                break;
            default:
                break;
        }
    }
}
