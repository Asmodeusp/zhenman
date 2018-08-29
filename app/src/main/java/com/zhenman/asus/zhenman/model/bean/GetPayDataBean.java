package com.zhenman.asus.zhenman.model.bean;

public class GetPayDataBean {

    /**
     * state : 0
     * msg : 成功
     * data : {"orderSign":"alipay_sdk=alipay-sdk-java-3.3.49.ALL&app_id=2018060960348052&biz_content=%7B%22out_trade_no%22%3A%22ZM991535076014567%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%2C%22timeout_express%22%3A%2230m%22%2C%22total_amount%22%3A%223.00%22%7D&charset=utf-8&format=json&method=alipay.trade.app.pay&notify_url=https%3A%2F%2Fapi.dev.zhenmanapp.com%2FuserOrder%2FappAliPayNotify&sign=eLhiCXgnHoLPbKz1Pg5sJbPCUHq1jLAW0s3Us5Az27pGMVfTBN3lslJW%2BIsyucbZdRXOmPdgQlrcs0aJUhqPySRjctfVGYDPaqGWDIhnoWkC95E7A3rk6wp2Snw3ur2aCo2HDeIBFVSk%2F8mfISHF%2FwrqSicZWokHu8n3TdS39%2FRZsrxuy4Wtgpgv%2F4Gdx2xtApOetZDyqSQMReFXzU7emNOVuLBnCkRQL64tAby92ChENs88R1KA%2B%2FSulbRT3252Q%2B2Stljr6lIH6Ev4N5T2QVaBZcFPbUKnnC7K3JfB8YhJzx81myKN5RcpkoUaMkS7tKmRGyc3b65zoOpemEi8cA%3D%3D&sign_type=RSA2&timestamp=2018-08-27+14%3A42%3A28&version=1.0"}
     */

    private int state;
    private String msg;
    private DataBean data;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * orderSign : alipay_sdk=alipay-sdk-java-3.3.49.ALL&app_id=2018060960348052&biz_content=%7B%22out_trade_no%22%3A%22ZM991535076014567%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%2C%22timeout_express%22%3A%2230m%22%2C%22total_amount%22%3A%223.00%22%7D&charset=utf-8&format=json&method=alipay.trade.app.pay&notify_url=https%3A%2F%2Fapi.dev.zhenmanapp.com%2FuserOrder%2FappAliPayNotify&sign=eLhiCXgnHoLPbKz1Pg5sJbPCUHq1jLAW0s3Us5Az27pGMVfTBN3lslJW%2BIsyucbZdRXOmPdgQlrcs0aJUhqPySRjctfVGYDPaqGWDIhnoWkC95E7A3rk6wp2Snw3ur2aCo2HDeIBFVSk%2F8mfISHF%2FwrqSicZWokHu8n3TdS39%2FRZsrxuy4Wtgpgv%2F4Gdx2xtApOetZDyqSQMReFXzU7emNOVuLBnCkRQL64tAby92ChENs88R1KA%2B%2FSulbRT3252Q%2B2Stljr6lIH6Ev4N5T2QVaBZcFPbUKnnC7K3JfB8YhJzx81myKN5RcpkoUaMkS7tKmRGyc3b65zoOpemEi8cA%3D%3D&sign_type=RSA2&timestamp=2018-08-27+14%3A42%3A28&version=1.0
         */

        private String orderSign;

        public String getOrderSign() {
            return orderSign;
        }

        public void setOrderSign(String orderSign) {
            this.orderSign = orderSign;
        }
    }
}
