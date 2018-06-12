package com.example.testtttttttt3.Service;

/**
 * Created by Administrator on 2018/5/17.
 */

public interface DownloadListener {

    void onProgress(int progress);

    void onSuccess();

    void onFailed();

    void onPaused();

    void onCanceled();

}
