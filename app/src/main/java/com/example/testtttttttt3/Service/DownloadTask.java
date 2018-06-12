package com.example.testtttttttt3.Service;

import android.os.AsyncTask;
import android.os.Environment;

import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;

/**
 * Created by Administrator on 2018/5/17.
 */

public class DownloadTask extends AsyncTask<String, Integer, Integer> {

    public static final int TYPE_SUCCESS = 0;
    public static final int TYPE_FAILED = 1;
    public static final int TYPE_PAUSED = 2;
    public static final int TYPE_CANCELED = 3;

    private DownloadListener listener;

    private boolean isCanceled = false;

    private boolean isPaused = false;

    private int lastProgress;

    public DownloadTask(DownloadListener downloadListener) {
        listener = downloadListener;
    }

    @Override
    protected Integer doInBackground(String... params) {
        InputStream is = null;
        RandomAccessFile savedFile = null;
        File file = null;
        try {
         long downloadLength = 0; //记录已下载的文件长度
         String downloadUrl = params[0];
         String fileName = downloadUrl.substring(downloadUrl.lastIndexOf("/"));
         String directory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();
         file = new File(directory + fileName);
        }catch (Exception e){
            e.printStackTrace();
        }finally {

        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
    }
}
