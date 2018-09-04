package com.zhenman.asus.zhenman.model.bean;

public class MakeOrderBean {
    /**
     * state : 0
     * msg : 成功
     * data : {"id":64,"userId":299,"orderNumber":"ZM261535509846080","amount":1,"comment":"充值","createTime":"1535509846080","updateTime":"1535509846080","status":0,"type":1,"payFrom":null,"delFlag":0,"toUserId":262,"catalogId":66}
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
         * id : 64
         * userId : 299
         * orderNumber : ZM261535509846080
         * amount : 1
         * comment : 充值
         * createTime : 1535509846080
         * updateTime : 1535509846080
         * status : 0
         * type : 1
         * payFrom : null
         * delFlag : 0
         * toUserId : 262
         * catalogId : 66
         */

        private int id;
        private int userId;
        private String orderNumber;
        private Object amount;
        private String comment;
        private String createTime;
        private String updateTime;
        private int status;
        private int type;
        private Object payFrom;
        private int delFlag;
        private int toUserId;
        private int catalogId;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getOrderNumber() {
            return orderNumber;
        }

        public void setOrderNumber(String orderNumber) {
            this.orderNumber = orderNumber;
        }

        public Object getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
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

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public Object getPayFrom() {
            return payFrom;
        }

        public void setPayFrom(Object payFrom) {
            this.payFrom = payFrom;
        }

        public int getDelFlag() {
            return delFlag;
        }

        public void setDelFlag(int delFlag) {
            this.delFlag = delFlag;
        }

        public int getToUserId() {
            return toUserId;
        }

        public void setToUserId(int toUserId) {
            this.toUserId = toUserId;
        }

        public int getCatalogId() {
            return catalogId;
        }

        public void setCatalogId(int catalogId) {
            this.catalogId = catalogId;
        }
    }

}
