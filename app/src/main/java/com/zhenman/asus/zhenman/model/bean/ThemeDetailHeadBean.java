package com.zhenman.asus.zhenman.model.bean;

public class ThemeDetailHeadBean {

    /**
     * state : 0
     * msg : 成功
     * data : {"subjectId":1,"description":"pick你的idol","name":"别人相机里的我","image":"http://pa1qj1jlg.bkt.clouddn.com/subject/0101-1.png","followNum":4,"followSubject":2}
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
         * subjectId : 1
         * description : pick你的idol
         * name : 别人相机里的我
         * image : http://pa1qj1jlg.bkt.clouddn.com/subject/0101-1.png
         * followNum : 4
         * followSubject : 2
         */

        private int subjectId;
        private String description;
        private String name;
        private String image;
        private int followNum;
        private int followSubject;

        public int getSubjectId() {
            return subjectId;
        }

        public void setSubjectId(int subjectId) {
            this.subjectId = subjectId;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getFollowNum() {
            return followNum;
        }

        public void setFollowNum(int followNum) {
            this.followNum = followNum;
        }

        public int getFollowSubject() {
            return followSubject;
        }

        public void setFollowSubject(int followSubject) {
            this.followSubject = followSubject;
        }
    }
}
