package com.zhenman.asus.zhenman.model.bean;

import java.util.List;

public class ByFansBean {

    /**
     * state : 0
     * msg : 成功
     * data : [{"userId":"406","name":"Sunny","addTime":"1541054921000","headImg":"http://pa1qj1jlg.bkt.clouddn.com/headImage/1987e75dc37249eb99f6efe9803b5249_?imageMogr2/thumbnail/200x200","finalImg":null,"read":0,"follow":2,"introduction":null}]
     */

    private int state;
    private String msg;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * userId : 406
         * name : Sunny
         * addTime : 1541054921000
         * headImg : http://pa1qj1jlg.bkt.clouddn.com/headImage/1987e75dc37249eb99f6efe9803b5249_?imageMogr2/thumbnail/200x200
         * finalImg : null
         * read : 0
         * follow : 2
         * introduction : null
         */

        private String userId;
        private String name;
        private String addTime;
        private String headImg;
        private Object finalImg;
        private int read;
        private int follow;
        private Object introduction;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddTime() {
            return addTime;
        }

        public void setAddTime(String addTime) {
            this.addTime = addTime;
        }

        public String getHeadImg() {
            return headImg;
        }

        public void setHeadImg(String headImg) {
            this.headImg = headImg;
        }

        public Object getFinalImg() {
            return finalImg;
        }

        public void setFinalImg(Object finalImg) {
            this.finalImg = finalImg;
        }

        public int getRead() {
            return read;
        }

        public void setRead(int read) {
            this.read = read;
        }

        public int getFollow() {
            return follow;
        }

        public void setFollow(int follow) {
            this.follow = follow;
        }

        public Object getIntroduction() {
            return introduction;
        }

        public void setIntroduction(Object introduction) {
            this.introduction = introduction;
        }
    }
}
