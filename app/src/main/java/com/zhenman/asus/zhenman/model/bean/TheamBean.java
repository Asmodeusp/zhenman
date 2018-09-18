package com.zhenman.asus.zhenman.model.bean;

import java.util.List;

public class TheamBean {


    /**
     * state : 0
     * msg : 成功
     * data : [{"subjectId":"5","description":"","name":"秀出你的手绘","image":"http://pa1qj1jlg.bkt.clouddn.com/subject/0105-5.png","followSubject":2,"list":["http://pa1qj1jlg.bkt.clouddn.com/PP/1536545458591/371.jpg?imageMogr2/crop/1080.0x1660.0/thumbnail/432x664"]},{"subjectId":"3","description":"","name":"失败摄影集合","image":"http://pa1qj1jlg.bkt.clouddn.com/subject/0103-3.png","followSubject":2,"list":["http://pa1qj1jlg.bkt.clouddn.com/PP/1536313248199/249.jpg?imageMogr2/crop/1080.0x1660.0/thumbnail/432x664","http://pa1qj1jlg.bkt.clouddn.com/UGC/89a52afcccc746cf802fb3da51701d0f_UGCMainImg?imageMogr2/crop/750.0x1152.7777777777778/thumbnail/432x664","http://pa1qj1jlg.bkt.clouddn.com/PPN/1534497211941/669.jpg?imageMogr2/crop/1109.0x1704.5740740740741/thumbnail/432x664","http://pa1qj1jlg.bkt.clouddn.com/PP/1536313157047/167.jpg?imageMogr2/crop/1080.0x1660.0/thumbnail/432x664"]},{"subjectId":"6","description":"","name":"一起来diy","image":"http://pa1qj1jlg.bkt.clouddn.com/subject/0106-6.png","followSubject":1,"list":["http://pa1qj1jlg.bkt.clouddn.com/UGC/94837eaa81f74a348ddedacc22eef8ff_UGCMainImg?imageMogr2/crop/750.0x1152.7777777777778/thumbnail/432x664","http://pa1qj1jlg.bkt.clouddn.com/PP/1536545458556/121.jpg?imageMogr2/crop/1080.0x1660.0/thumbnail/432x664"]}]
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
         * subjectId : 5
         * description :
         * name : 秀出你的手绘
         * image : http://pa1qj1jlg.bkt.clouddn.com/subject/0105-5.png
         * followSubject : 2
         * list : ["http://pa1qj1jlg.bkt.clouddn.com/PP/1536545458591/371.jpg?imageMogr2/crop/1080.0x1660.0/thumbnail/432x664"]
         */

        private String subjectId;
        private String description;
        private String name;
        private String image;
        private int followSubject;
        private List<String> list;

        public String getSubjectId() {
            return subjectId;
        }

        public void setSubjectId(String subjectId) {
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

        public int getFollowSubject() {
            return followSubject;
        }

        public void setFollowSubject(int followSubject) {
            this.followSubject = followSubject;
        }

        public List<String> getList() {
            return list;
        }

        public void setList(List<String> list) {
            this.list = list;
        }
    }
}
