package com.example.testtttttttt3.Util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Administrator on 2018/6/12.
 */

public class ToastUtil {
    private static Toast toast;
    public static void showToast(Context context, String content) {
        if (toast == null) {
            toast = Toast.makeText(context,
                    content,
                    Toast.LENGTH_SHORT);
        } else {
            toast.setText(content);
        }
        toast.show();
    }
}
