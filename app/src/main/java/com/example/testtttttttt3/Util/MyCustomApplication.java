package com.example.testtttttttt3.Util;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2018/6/6.
 */

public class MyCustomApplication extends Application {

   private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }
    public static Context getContext(){
        return context;
    }

}
