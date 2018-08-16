package com.zhenman.asus.zhenman.model.bean;

import java.util.List;

public class SerializationCatalogBean {

    /**
     * state : 0
     * msg : 成功
     * data : [{"catalogId":"96","pgcId":"17","title":"测试章节","chapterSort":null,"isFree":1,"coinAmount":null,"addTime":"1532937095000","updateTime":"1532937095000"},{"catalogId":"90","pgcId":"17","title":"第3话","chapterSort":3,"isFree":1,"coinAmount":null,"addTime":"1532519931000","updateTime":"1533033619000"},{"catalogId":"89","pgcId":"17","title":"第2话","chapterSort":2,"isFree":1,"coinAmount":null,"addTime":"1532519898000","updateTime":"1533031236000"},{"catalogId":"88","pgcId":"17","title":"第1话","chapterSort":1,"isFree":1,"coinAmount":null,"addTime":"1532514010000","updateTime":"1532947639000"}]
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
         * catalogId : 96
         * pgcId : 17
         * title : 测试章节
         * chapterSort : null
         * isFree : 1
         * coinAmount : null
         * addTime : 1532937095000
         * updateTime : 1532937095000
         */

        private String catalogId;
        private String pgcId;
        private String title;
        private Object chapterSort;
        private int isFree;
        private Object coinAmount;
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

        public Object getChapterSort() {
            return chapterSort;
        }

        public void setChapterSort(Object chapterSort) {
            this.chapterSort = chapterSort;
        }

        public int getIsFree() {
            return isFree;
        }

        public void setIsFree(int isFree) {
            this.isFree = isFree;
        }

        public Object getCoinAmount() {
            return coinAmount;
        }

        public void setCoinAmount(Object coinAmount) {
            this.coinAmount = coinAmount;
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
