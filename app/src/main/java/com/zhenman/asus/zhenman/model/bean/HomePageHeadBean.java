package com.zhenman.asus.zhenman.model.bean;

public class HomePageHeadBean {

    /**
     * state : 0
     * msg : 成功
     * data : {"sex":1,"name":"绝版青春","introduction":"ffdaf","headImg":"http://pa1qj1jlg.bkt.clouddn.com/headImage/eb34bd9db550436596bf29a4dadef13e_?roundPic/radius/!50p","follow":1,"works":2,"fans":10,"follows":1,"followSubject":1}
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
         * sex : 1
         * name : 绝版青春
         * introduction : ffdaf
         * headImg : http://pa1qj1jlg.bkt.clouddn.com/headImage/eb34bd9db550436596bf29a4dadef13e_?roundPic/radius/!50p
         * follow : 1
         * works : 2
         * fans : 10
         * follows : 1
         * followSubject : 1
         */

        private int sex;
        private String name;
        private String introduction;
        private String headImg;
        private int follow;
        private int works;
        private int fans;
        private int follows;
        private int followSubject;

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIntroduction() {
            return introduction;
        }

        public void setIntroduction(String introduction) {
            this.introduction = introduction;
        }

        public String getHeadImg() {
            return headImg;
        }

        public void setHeadImg(String headImg) {
            this.headImg = headImg;
        }

        public int getFollow() {
            return follow;
        }

        public void setFollow(int follow) {
            this.follow = follow;
        }

        public int getWorks() {
            return works;
        }

        public void setWorks(int works) {
            this.works = works;
        }

        public int getFans() {
            return fans;
        }

        public void setFans(int fans) {
            this.fans = fans;
        }

        public int getFollows() {
            return follows;
        }

        public void setFollows(int follows) {
            this.follows = follows;
        }

        public int getFollowSubject() {
            return followSubject;
        }

        public void setFollowSubject(int followSubject) {
            this.followSubject = followSubject;
        }
    }
}
