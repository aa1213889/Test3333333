package com.example.testtttttttt3.Service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    private DownloadBinder downloadBinder = new DownloadBinder();

    public class DownloadBinder extends Binder{
        public void startDownload(){
            Log.d("MyService","startDownload executed!");
        }
        public int getProgress(){
            Log.d("MyService","getProgress executed!");
            return 999;
        }
    }

    public MyService() {
    }

    @Override
    public void onCreate() {
        Log.d("MyService","onCreate executed!");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("MyService","onStartCommand executed!");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.d("MyService","onDestroy executed!");
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return downloadBinder;
    }
}
