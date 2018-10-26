package com.zhenman.asus.zhenman.utils;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;

import com.alipay.sdk.app.AuthTask;
import com.alipay.sdk.app.PayTask;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.zhenman.asus.zhenman.App;
import com.zhenman.asus.zhenman.model.bean.PayWeChatBean;
import com.zhenman.asus.zhenman.utils.alipay.AuthResult;
import com.zhenman.asus.zhenman.utils.alipay.PayResult;

import java.util.Map;

public class PayUtils {
    private static PayUtils payUtils;
    //支付标记
    private static final int SDK_PAY_FLAG = 1;
    private static final int SDK_AUTH_FLAG = 2;

    public static PayUtils getInstance() {
        if (payUtils == null) {
            synchronized (RetrofitUtils.class) {
                if (payUtils == null) {
                    payUtils = new PayUtils();
                }
            }
        }
        return payUtils;
    }


    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SDK_PAY_FLAG: {
                    @SuppressWarnings("unchecked")
                    PayResult payResult = new PayResult((Map<String, String>) msg.obj);
                    /**
                     对于支付结果，请商户依赖服务端的异步通知结果。同步通知结果，仅作为支付结束的通知。
                     */
                    String resultInfo = payResult.getResult();// 同步返回需要验证的信息
                    String resultStatus = payResult.getResultStatus();
                    // 判断resultStatus 为9000则代表支付成功
                    if (TextUtils.equals(resultStatus, "9000")) {
                        // 该笔订单是否真实支付成功，需要依赖服务端的异步通知。
                        Toast.makeText(App.context, "支付成功", Toast.LENGTH_SHORT).show();
                    } else {
                        // 该笔订单真实的支付结果，需要依赖服务端的异步通知。
                        Toast.makeText(App.context, "支付失败", Toast.LENGTH_SHORT).show();
                    }
                    break;
                }
                case SDK_AUTH_FLAG: {
                    @SuppressWarnings("unchecked")
                    AuthResult authResult = new AuthResult((Map<String, String>) msg.obj, true);
                    String resultStatus = authResult.getResultStatus();

                    // 判断resultStatus 为“9000”且result_code
                    // 为“200”则代表授权成功，具体状态码代表含义可参考授权接口文档
                    if (TextUtils.equals(resultStatus, "9000") && TextUtils.equals(authResult.getResultCode(), "200")) {
                        // 获取alipay_open_id，调支付时作为参数extern_token 的value
                        // 传入，则支付账户为该授权账户
                        Toast.makeText(App.context,
                                "授权成功\n" + String.format("authCode:%s", authResult.getAuthCode()), Toast.LENGTH_SHORT)
                                .show();

                    } else {
                        // 其他状态值则为授权失败
                        Toast.makeText(App.context, "授权失败" + String.format("authCode:%s", authResult.getAuthCode()), Toast.LENGTH_SHORT).show();

                    }
                    break;
                }
                default:
                    break;
            }

        }

    };

    /**
     * 支付宝支付业务
     *
     * @param
     */
    public void AliPay(final String orderSign, final Activity activity) {
        Runnable authRunnable = new Runnable() {

            @Override
            public void run() {

                PayTask alipay = new PayTask(activity);
                Map<String, String> result = alipay.payV2(orderSign, true);

                Message msg = new Message();
                msg.what = SDK_PAY_FLAG;
                msg.obj = result;
                mHandler.sendMessage(msg);
            }
        };
        // 必须异步调用
        Thread authThread = new Thread(authRunnable);
        authThread.start();
    }

    //微信支付
    public void WeChatPay(PayWeChatBean.DataBean.OrderSignBean orderSign) {
        // 通过WXAPIFactory工厂，获取IWXAPI的实例
        IWXAPI api = WXAPIFactory.createWXAPI(App.context, "wx658d27e48aa3a824");
        // 将该app注册到微信
//        api.registerApp("wx658d27e48aa3a824");
        PayReq request = new PayReq();
        request.appId = orderSign.getAppid();
        request.partnerId = orderSign.getPartnerid();
        request.prepayId = orderSign.getPrepayid();
        request.packageValue = orderSign.getPackageX();
        request.nonceStr = orderSign.getNoncestr();
        request.timeStamp = orderSign.getTimestamp() + "";
        request.sign = orderSign.getSign();
        api.sendReq(request);
//        paypopupWindow.dismiss();
    }

    /**
     * 支付宝账户授权业务
     */
    public void authV2(final String orderSign, final Activity activity) {
        Runnable authRunnable = new Runnable() {

            @Override
            public void run() {
                // 构造AuthTask 对象
                AuthTask authTask = new AuthTask(activity);
                // 调用授权接口，获取授权结果
                Map<String, String> result = authTask.authV2(orderSign, true);
                Message msg = new Message();
                msg.what = SDK_AUTH_FLAG;
                msg.obj = result;
                mHandler.sendMessage(msg);
            }
        };

        // 必须异步调用
        Thread authThread = new Thread(authRunnable);
        authThread.start();
    }



                   /* AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do", "app_id", "your private_key", "json", "GBK", "alipay_public_key", "RSA2");
                    AlipayFundTransToaccountTransferRequest request = new AlipayFundTransToaccountTransferRequest();
                    request.setBizContent("{" +
                            "    \"out_biz_no\":\"3142321423432\"," +
                            "    \"payee_type\":\"ALIPAY_LOGONID\"," +
                            "    \"payee_account\":\"abc@sina.com\"," +
                            "    \"amount\":\"12.23\"," +
                            "    \"payer_show_name\":\"上海交通卡退款\"," +
                            "    \"payee_real_name\":\"张三\"," +
                            "    \"remark\":\"转账备注\"," +
                            "  }");
                    Map map = new HashMap();
                    map.put("out_biz_no", "3142321423432");//生成订单号
                    map.put("payee_type", "ALIPAY_LOGONID");//固定值
                    map.put("payee_account", "abc@sina.com");//转账收款账户
                    map.put("amount", sellEggplantEggplantNum.getText().toString());//多少钱
                    map.put("payer_show_name", "账户提现");
                    map.put("payee_real_name", "Sunny");
                    map.put("remark", "真漫提现");
                    //org.json.JSONObject 将Map转换为JSON方法
                    JSONObject json = new JSONObject(map);
                    request.setBizContent(json);
                    AlipayFundTransToaccountTransferResponse response = alipayClient.execute(request);
                    if (response.isSuccess()) {
                        System.out.println("调用成功");
                    } else {
                        System.out.println("调用失败");
                    }*/
}
