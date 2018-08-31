package com.zhenman.asus.zhenman.model.bean;

public class GetMyDataBean {

    /**
     * state : 0
     * msg : 成功
     * data : {"sex":1,"name":"432423","introduction":"3gfds","headImg":"http://pa1qj1jlg.bkt.clouddn.com/headImage/17c3fe9985a74806a74604d923657a18_?roundPic/radius/!50p","birthdate":"r23432543"}
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
         * name : 432423
         * introduction : 3gfds
         * headImg : http://pa1qj1jlg.bkt.clouddn.com/headImage/17c3fe9985a74806a74604d923657a18_?roundPic/radius/!50p
         * birthdate : r23432543
         */

        private int sex;
        private String name;
        private String introduction;
        private String headImg;
        private String birthdate;

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

        public String getBirthdate() {
            return birthdate;
        }

        public void setBirthdate(String birthdate) {
            this.birthdate = birthdate;
        }
    }
}
