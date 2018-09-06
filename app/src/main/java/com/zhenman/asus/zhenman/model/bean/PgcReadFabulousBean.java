package com.zhenman.asus.zhenman.model.bean;

public class PgcReadFabulousBean {
    /**
     * state : 2048
     * msg : 您已经点赞过这个评论
     * data : {}
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
    }
}
