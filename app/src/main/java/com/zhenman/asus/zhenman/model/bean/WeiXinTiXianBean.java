package com.zhenman.asus.zhenman.model.bean;

public class WeiXinTiXianBean {

    /**
     * state : 0
     * msg : 成功
     * data : {"err_code":"V2_ACCOUNT_SIMPLE_BAN","err_code_des":"非实名用户账号不可发放"}
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
         * err_code : V2_ACCOUNT_SIMPLE_BAN
         * err_code_des : 非实名用户账号不可发放
         */

        private String err_code;
        private String err_code_des;

        public String getErr_code() {
            return err_code;
        }

        public void setErr_code(String err_code) {
            this.err_code = err_code;
        }

        public String getErr_code_des() {
            return err_code_des;
        }

        public void setErr_code_des(String err_code_des) {
            this.err_code_des = err_code_des;
        }
    }
}
