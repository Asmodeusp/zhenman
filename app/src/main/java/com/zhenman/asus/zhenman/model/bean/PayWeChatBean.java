package com.zhenman.asus.zhenman.model.bean;

import com.google.gson.annotations.SerializedName;

public class PayWeChatBean {

    /**
     * state : 0
     * msg : 成功
     * data : {"orderSign":{"appid":"wx658d27e48aa3a824","noncestr":"1536046661746","package":"Sign=WXPay","partnerid":"1507832901","prepayid":"wx0415373679812659677103151966591589","sign":"7712842227F77DE59B4C52869EF6EE50","timestamp":1536046661}}
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
         * orderSign : {"appid":"wx658d27e48aa3a824","noncestr":"1536046661746","package":"Sign=WXPay","partnerid":"1507832901","prepayid":"wx0415373679812659677103151966591589","sign":"7712842227F77DE59B4C52869EF6EE50","timestamp":1536046661}
         */

        private OrderSignBean orderSign;

        public OrderSignBean getOrderSign() {
            return orderSign;
        }

        public void setOrderSign(OrderSignBean orderSign) {
            this.orderSign = orderSign;
        }

        public static class OrderSignBean {
            /**
             * appid : wx658d27e48aa3a824
             * noncestr : 1536046661746
             * package : Sign=WXPay
             * partnerid : 1507832901
             * prepayid : wx0415373679812659677103151966591589
             * sign : 7712842227F77DE59B4C52869EF6EE50
             * timestamp : 1536046661
             */

            private String appid;
            private String noncestr;
            @SerializedName("package")
            private String packageX;
            private String partnerid;
            private String prepayid;
            private String sign;
            private int timestamp;

            public String getAppid() {
                return appid;
            }

            public void setAppid(String appid) {
                this.appid = appid;
            }

            public String getNoncestr() {
                return noncestr;
            }

            public void setNoncestr(String noncestr) {
                this.noncestr = noncestr;
            }

            public String getPackageX() {
                return packageX;
            }

            public void setPackageX(String packageX) {
                this.packageX = packageX;
            }

            public String getPartnerid() {
                return partnerid;
            }

            public void setPartnerid(String partnerid) {
                this.partnerid = partnerid;
            }

            public String getPrepayid() {
                return prepayid;
            }

            public void setPrepayid(String prepayid) {
                this.prepayid = prepayid;
            }

            public String getSign() {
                return sign;
            }

            public void setSign(String sign) {
                this.sign = sign;
            }

            public int getTimestamp() {
                return timestamp;
            }

            public void setTimestamp(int timestamp) {
                this.timestamp = timestamp;
            }
        }
    }
}
