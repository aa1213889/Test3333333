package com.example.testtttttttt3.Broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class NormalBroadcastTestReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "received in NormalBroadcastTestReceiver"+
                "\n"+"action is "+"android.intent.action.NORMAL_TEST_BROADCAST", Toast.LENGTH_SHORT).show();
    }
}
