package com.zhenman.asus.zhenman.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;


import com.zhenman.asus.zhenman.utils.sp.SPKey;
import com.zhenman.asus.zhenman.utils.sp.SPUtils;
import com.zhenman.asus.zhenman.view.login.MainActivity;

public class LoginUtils {
    public static boolean isLoginNotFinish(Context context) {
        Boolean ISlogin = (Boolean) SPUtils.get(context, SPKey.IS_LOGIN, false);
        if (!ISlogin) {
            context.startActivity(new Intent(context, MainActivity.class));
            return true;
        } else {
            return false;
        }
    }

    public static void isLoginFinish(Context context) {
        Boolean ISlogin = (Boolean) SPUtils.get(context, SPKey.IS_LOGIN, false);
        if (!ISlogin) {
            context.startActivity(new Intent(context, MainActivity.class));
            ((Activity) context).finish();
        }
    }
}
