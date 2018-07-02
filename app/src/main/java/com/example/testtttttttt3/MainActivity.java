package com.example.testtttttttt3;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @OnClick({R.id.btn_BaseAda ,R.id.btn_service,R.id.btn_broadcast,R.id.btn_share,R.id.btn_chat,R.id.btn_handler,R.id.btn_fragment,
            R.id.btn_shared,R.id.btn_litepal,R.id.btn_animation,R.id.btn_Interpolator,R.id.btn_history_today})
    public void onViewClick(View view) {
        switch (view.getId()){
            case R.id.btn_BaseAda:
                startActivity(new Intent(MainActivity.this,BaseRecyclerViewAdapterHelperActivity.class));
                break;
            case R.id.btn_service:
                startActivity(new Intent(MainActivity.this,ServiceTestActivity.class));
                break;
            case R.id.btn_broadcast:
                startActivity(new Intent(MainActivity.this,BroadcastTestActivity.class));
                break;
            case R.id.btn_share:
                startActivity(new Intent(MainActivity.this,ThirdPartyLoginActivity.class));
                break;
            case R.id.btn_chat:
                startActivity(new Intent(MainActivity.this,ChatActivity.class));
                break;
            case R.id.btn_handler:
                startActivity(new Intent(MainActivity.this,HandlerTestActivity.class));
                break;
            case R.id.btn_fragment:
                startActivity(new Intent(MainActivity.this,FragmentTestActivity.class));
                break;
            case R.id.btn_shared:
                startActivity(new Intent(MainActivity.this,SharedPerferencesActivity.class));
                break;
            case R.id.btn_litepal:
                startActivity(new Intent(MainActivity.this,LitePalTestActivity.class));
                break;
            case R.id.btn_animation:
                startActivity(new Intent(MainActivity.this,AnimationTestActivity.class));
                break;
            case R.id.btn_Interpolator:
                startActivity(new Intent(MainActivity.this,AnimationInterpolatorActivity.class));
                break;
            case R.id.btn_history_today:
                startActivity(new Intent(MainActivity.this,HistoryTodayActivity.class));
                break;

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this); //绑定初始化ButterKnife
    }

    private long mExitTime;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //判断用户是否点击了“返回键”
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //与上次点击返回键时刻作差
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                //大于2000ms则认为是误操作，使用Toast进行提示
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                //并记录下本次点击“返回键”的时刻，以便下次进行判断
                mExitTime = System.currentTimeMillis();
            } else {
                //小于2000ms则认为是用户确实希望退出程序-调用System.exit()方法进行退出
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


}
