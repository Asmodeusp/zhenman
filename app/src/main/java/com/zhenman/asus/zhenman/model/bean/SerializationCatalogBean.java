package com.zhenman.asus.zhenman.model.bean;

import java.util.List;

public class SerializationCatalogBean {


    /**
     * state : 0
     * msg : 成功
     * data : [{"catalogId":"82","pgcId":"29","title":"第3话","chapterSort":3,"isFree":2,"isPaid":2,"coinAmount":1,"exemption":0,"addTime":"1532415008000","updateTime":"1533119241000"},{"catalogId":"81","pgcId":"29","title":"第2话","chapterSort":2,"isFree":2,"isPaid":2,"coinAmount":1,"exemption":0,"addTime":"1532414968000","updateTime":"1533118817000"},{"catalogId":"80","pgcId":"29","title":"第1话","chapterSort":1,"isFree":2,"isPaid":2,"coinAmount":1,"exemption":0,"addTime":"1532414921000","updateTime":"1533118624000"}]
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
         * catalogId : 82
         * pgcId : 29
         * title : 第3话
         * chapterSort : 3
         * isFree : 2
         * isPaid : 2
         * coinAmount : 1
         * exemption : 0
         * addTime : 1532415008000
         * updateTime : 1533119241000
         */

        private String catalogId;
        private String pgcId;
        private String title;
        private int chapterSort;
        private int isFree;
        private int isPaid;
        private int coinAmount;
        private int exemption;
        private String addTime;
        private String updateTime;

        public String getCatalogId() {
            return catalogId;
        }

        public void setCatalogId(String catalogId) {
            this.catalogId = catalogId;
        }

        public String getPgcId() {
            return pgcId;
        }

        public void setPgcId(String pgcId) {
            this.pgcId = pgcId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getChapterSort() {
            return chapterSort;
        }

        public void setChapterSort(int chapterSort) {
            this.chapterSort = chapterSort;
        }

        public int getIsFree() {
            return isFree;
        }

        public void setIsFree(int isFree) {
            this.isFree = isFree;
        }

        public int getIsPaid() {
            return isPaid;
        }

        public void setIsPaid(int isPaid) {
            this.isPaid = isPaid;
        }

        public int getCoinAmount() {
            return coinAmount;
        }

        public void setCoinAmount(int coinAmount) {
            this.coinAmount = coinAmount;
        }

        public int getExemption() {
            return exemption;
        }

        public void setExemption(int exemption) {
            this.exemption = exemption;
        }

        public String getAddTime() {
            return addTime;
        }

        public void setAddTime(String addTime) {
            this.addTime = addTime;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }
    }
}
