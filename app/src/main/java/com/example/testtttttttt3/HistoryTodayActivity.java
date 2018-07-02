package com.example.testtttttttt3;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class HistoryTodayActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        immersionSystemBar();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_today);
//        Window window = getWindow();
//        //如果系统5.0以上
//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
//            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//            window.setStatusBarColor(getResources().getColor(R.color.gray));
//        }
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR); //状态栏图标为黑色

    }
}
