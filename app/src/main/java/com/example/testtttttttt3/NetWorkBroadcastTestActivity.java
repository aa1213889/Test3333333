package com.example.testtttttttt3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class NetWorkBroadcastTestActivity extends AppCompatActivity {

    NetworkChangeReceiver networkChangeReceiver = new NetworkChangeReceiver();
    IntentFilter intentFilter = new IntentFilter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net_work_broadcast_test);
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(networkChangeReceiver,intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(networkChangeReceiver);//避免内存泄漏
    }

    class NetworkChangeReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
            //系统服务类，专门来管理网络连接
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if(networkInfo != null&&networkInfo.isAvailable()){//网络信息是否为空和网络信息是否有效
                Toast.makeText(context,"network is available",Toast.LENGTH_SHORT).show();
            }else  Toast.makeText(context,"network is unavailable",Toast.LENGTH_SHORT).show();
        }
    }
}
