package com.zhenman.asus.zhenman.model.bean;

public class FollowBean {

    /**
     * state : 0
     * msg : 成功
     * data : 1
     */

    private int state;
    private String msg;
    private int data;

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

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
