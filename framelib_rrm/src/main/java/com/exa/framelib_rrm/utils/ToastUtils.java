package com.exa.framelib_rrm.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by acer on 2017/6/9.
 */
public class ToastUtils {

    public static void show(Context ctx, String msg){
        Toast.makeText(ctx.getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }

}
