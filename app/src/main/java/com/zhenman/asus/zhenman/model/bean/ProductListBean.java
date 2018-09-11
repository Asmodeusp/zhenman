package com.zhenman.asus.zhenman.model.bean;

import java.util.List;

public class ProductListBean {

    /**
     * state : 0
     * msg : 成功
     * data : [{"id":1,"userId":null,"price":1,"productType":0,"status":1,"showPrice":1,"productName":"1个茄子","comment":null,"images":null,"createTime":"1528722056000","updateTime":"1528722058000"},{"id":2,"userId":null,"price":2,"productType":0,"status":1,"showPrice":2,"productName":"2个茄子","comment":"","images":"","createTime":"1528722056000","updateTime":"1528722058000"},{"id":3,"userId":null,"price":5,"productType":0,"status":1,"showPrice":5,"productName":"5个茄子","comment":"","images":"","createTime":"1528722056000","updateTime":"1528722058000"},{"id":4,"userId":null,"price":10,"productType":0,"status":1,"showPrice":10,"productName":"10个茄子","comment":"","images":"","createTime":"1528722056000","updateTime":"1528722058000"},{"id":5,"userId":null,"price":50,"productType":0,"status":1,"showPrice":50,"productName":"50个茄子","comment":"","images":"","createTime":"1528722056000","updateTime":"1528722058000"},{"id":6,"userId":null,"price":100,"productType":0,"status":1,"showPrice":100,"productName":"100个茄子","comment":"","images":"","createTime":"1528722056000","updateTime":"1528722058000"}]
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
         * id : 1
         * userId : null
         * price : 1
         * productType : 0
         * status : 1
         * showPrice : 1
         * productName : 1个茄子
         * comment : null
         * images : null
         * createTime : 1528722056000
         * updateTime : 1528722058000
         */

        private int id;
        private Object userId;
        private int price;
        private int productType;
        private int status;
        private int showPrice;
        private String productName;
        private Object comment;
        private Object images;
        private String createTime;
        private String updateTime;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Object getUserId() {
            return userId;
        }

        public void setUserId(Object userId) {
            this.userId = userId;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getProductType() {
            return productType;
        }

        public void setProductType(int productType) {
            this.productType = productType;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getShowPrice() {
            return showPrice;
        }

        public void setShowPrice(int showPrice) {
            this.showPrice = showPrice;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public Object getComment() {
            return comment;
        }

        public void setComment(Object comment) {
            this.comment = comment;
        }

        public Object getImages() {
            return images;
        }

        public void setImages(Object images) {
            this.images = images;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }
    }
}
