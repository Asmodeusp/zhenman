package com.zhenman.asus.zhenman.model.bean;

public class ThemeAttentionBean {


    /**
     * state : 0
     * msg : 成功
     * data : null
     */

    private int state;
    private String msg;
    private Object data;

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
