package com.example.testtttttttt3.Service;

import android.os.AsyncTask;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by Administrator on 2018/5/17.
 */

public class TestEasyAsyncTask extends AsyncTask<Integer,Integer,String> {

    private TextView txt;
    private SeekBar seekBar;

    public class DelayOperator {

        public void delay(){
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public TestEasyAsyncTask(TextView txt, SeekBar seekBar) {
        super();
        this.txt=txt;
        this.seekBar=seekBar;
    }

    //该方法不运行在UI线程中,主要用于异步操作,通过调用publishProgress()方法
    //触发onProgressUpdate对UI进行操作
    @Override
    protected String doInBackground(Integer... params) {
        int i=0;
        try {
            DelayOperator dop=new DelayOperator();
            for(i=10;i<=1000;i+=10)
            {
                dop.delay();
                publishProgress(i);
            }
        } catch (Exception e) {
        }

        return i+params[0].intValue()+"";
    }

    //该方法运行在UI线程中,可对UI控件进行设置
    @Override
    protected void onPreExecute() {
        try {
            txt.setText("正在播放");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void onProgressUpdate(Integer... values) {
        int value=values[0];
        seekBar.setProgress(value);
    }


}