package com.zhenman.asus.zhenman.utils.alipay;

import android.app.Activity;
import android.os.Message;
import android.util.Log;

import com.alipay.sdk.app.AuthTask;
import com.zhenman.asus.zhenman.view.serializaion.SerializationCatalogReadActivity;

import java.util.Map;

public class AlipayUtils {
    public interface AuthAlipayListener {
        void authAlipayResult(AuthResult _authResult);
    }

    public interface PayAlipayListener {
        void payAlipayResult(PayResult _payResult);
    }
    /**
     * 支付宝授权功能
     *
     * @param _activity
     * @param _authAlipayString
     * @param _authAlipayListener
     */
    public static void authAlipay(final Activity _activity, final String _authAlipayString, final AuthAlipayListener _authAlipayListener) {
        try {
            Runnable authRunnable = new Runnable() {
                @Override
                public void run() {
                    // 构造AuthTask 对象
                    AuthTask authTask = new AuthTask(_activity);
                    // 调用授权接口，获取授权结果
                    final Map<String, String> result = authTask.authV2(_authAlipayString, true);
                    final AuthResult authResult = new AuthResult(result, true);
                    Runnable authRunnable = new Runnable() {

                        @Override
                        public void run() {
                            _authAlipayListener.authAlipayResult(authResult);
                        }
                    };
                }
            };
        } catch (Exception _e) {
            Log.e("2322", _e.getMessage());
        }
    }
}
