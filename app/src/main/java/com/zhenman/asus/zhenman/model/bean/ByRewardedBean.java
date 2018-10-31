package com.zhenman.asus.zhenman.model.bean;

import java.util.List;

public class ByRewardedBean {


    /**
     * state : 0
     * msg : 成功
     * data : [{"userId":"380","name":"绝版青春1","addTime":"1540458620000","headImg":"http://pa1qj1jlg.bkt.clouddn.com/headImage/d659f5ce4ff14b79a44ddb1bc5eef148_?imageMogr2/thumbnail/200x200","finalImg":"","coinAmount":"64","title":"","eggplantType":"3","read":0,"type":3,"catalogId":0},{"userId":"380","name":"绝版青春1","addTime":"1540458617000","headImg":"http://pa1qj1jlg.bkt.clouddn.com/headImage/d659f5ce4ff14b79a44ddb1bc5eef148_?imageMogr2/thumbnail/200x200","finalImg":"","coinAmount":"64","title":"","eggplantType":"3","read":0,"type":3,"catalogId":0},{"userId":"380","name":"绝版青春1","addTime":"1540458614000","headImg":"http://pa1qj1jlg.bkt.clouddn.com/headImage/d659f5ce4ff14b79a44ddb1bc5eef148_?imageMogr2/thumbnail/200x200","finalImg":"","coinAmount":"64","title":"","eggplantType":"3","read":0,"type":3,"catalogId":0},{"userId":"380","name":"绝版青春1","addTime":"1540458603000","headImg":"http://pa1qj1jlg.bkt.clouddn.com/headImage/d659f5ce4ff14b79a44ddb1bc5eef148_?imageMogr2/thumbnail/200x200","finalImg":"","coinAmount":"64","title":"","eggplantType":"3","read":0,"type":3,"catalogId":0},{"userId":"380","name":"绝版青春1","addTime":"1540457624000","headImg":"http://pa1qj1jlg.bkt.clouddn.com/headImage/d659f5ce4ff14b79a44ddb1bc5eef148_?imageMogr2/thumbnail/200x200","finalImg":"","coinAmount":"4","title":"","eggplantType":"3","read":0,"type":3,"catalogId":0},{"userId":"380","name":"绝版青春1","addTime":"1540457608000","headImg":"http://pa1qj1jlg.bkt.clouddn.com/headImage/d659f5ce4ff14b79a44ddb1bc5eef148_?imageMogr2/thumbnail/200x200","finalImg":"http://pa1qj1jlg.bkt.clouddn.com/pgc/竖版封面图_菜鸟阎王.jpg_1532695077877?imageMogr2/crop/630.0x831.0/thumbnail/432x569.8285714285714","coinAmount":"32","title":"菜鸟阎王","eggplantType":"3","read":0,"type":2,"catalogId":66},{"userId":"380","name":"绝版青春1","addTime":"1540457413000","headImg":"http://pa1qj1jlg.bkt.clouddn.com/headImage/d659f5ce4ff14b79a44ddb1bc5eef148_?imageMogr2/thumbnail/200x200","finalImg":"http://pa1qj1jlg.bkt.clouddn.com/pgc/竖版封面图_菜鸟阎王.jpg_1532695077877?imageMogr2/crop/630.0x831.0/thumbnail/432x569.8285714285714","coinAmount":"2","title":"菜鸟阎王","eggplantType":"3","read":0,"type":2,"catalogId":66},{"userId":"380","name":"绝版青春1","addTime":"1540457401000","headImg":"http://pa1qj1jlg.bkt.clouddn.com/headImage/d659f5ce4ff14b79a44ddb1bc5eef148_?imageMogr2/thumbnail/200x200","finalImg":"","coinAmount":"32","title":"","eggplantType":"3","read":0,"type":3,"catalogId":0},{"userId":"380","name":"绝版青春1","addTime":"1540457150000","headImg":"http://pa1qj1jlg.bkt.clouddn.com/headImage/d659f5ce4ff14b79a44ddb1bc5eef148_?imageMogr2/thumbnail/200x200","finalImg":"","coinAmount":"64","title":"","eggplantType":"3","read":0,"type":3,"catalogId":0}]
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
         * userId : 380
         * name : 绝版青春1
         * addTime : 1540458620000
         * headImg : http://pa1qj1jlg.bkt.clouddn.com/headImage/d659f5ce4ff14b79a44ddb1bc5eef148_?imageMogr2/thumbnail/200x200
         * finalImg :
         * coinAmount : 64
         * title :
         * eggplantType : 3
         * read : 0
         * type : 3
         * catalogId : 0
         */

        private String userId;
        private String name;
        private String addTime;
        private String headImg;
        private String finalImg;
        private String coinAmount;
        private String title;
        private String eggplantType;
        private int read;
        private int type;
        private int catalogId;

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

        public String getFinalImg() {
            return finalImg;
        }

        public void setFinalImg(String finalImg) {
            this.finalImg = finalImg;
        }

        public String getCoinAmount() {
            return coinAmount;
        }

        public void setCoinAmount(String coinAmount) {
            this.coinAmount = coinAmount;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getEggplantType() {
            return eggplantType;
        }

        public void setEggplantType(String eggplantType) {
            this.eggplantType = eggplantType;
        }

        public int getRead() {
            return read;
        }

        public void setRead(int read) {
            this.read = read;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getCatalogId() {
            return catalogId;
        }

        public void setCatalogId(int catalogId) {
            this.catalogId = catalogId;
        }
    }
}
