package com.example.testtttttttt3;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.testtttttttt3.Dao.DaoMaster;
import com.example.testtttttttt3.Dao.DaoSession;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @OnClick({R.id.btn_BaseAda ,R.id.btn_service,R.id.btn_broadcast,R.id.btn_share,R.id.btn_chat,R.id.btn_handler,R.id.btn_fragment,R.id.btn_shared,R.id.btn_litepal})
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
