package com.example.testtttttttt3.Broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.widget.Toast;

public class AirplaneModeBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if(IsAirModeOn(context)) {
            Toast.makeText(context, "AirplaneMode is close", Toast.LENGTH_SHORT).show();
        }else Toast.makeText(context, "AirplaneMode is open", Toast.LENGTH_SHORT).show();
    }
    public static boolean IsAirModeOn(Context context) {
        return (Settings.System.getInt(context.getContentResolver(),
                Settings.System.AIRPLANE_MODE_ON, 0) == 1 ? true : false);
    }
}
