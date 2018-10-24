package com.zhenman.asus.zhenman.model.bean;

public class SellEggplantBean {


    /**
     * state : 0
     * msg : 成功
     * data : {"id":1,"userId":299,"coinAmount":82,"eggplantAmount":10,"biteEggplantAmount":0,"unripeEggplantAmount":0,"addTime":"1540291478000"}
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
         * id : 1
         * userId : 299
         * coinAmount : 82
         * eggplantAmount : 10
         * biteEggplantAmount : 0
         * unripeEggplantAmount : 0
         * addTime : 1540291478000
         */

        private int id;
        private int userId;
        private int coinAmount;
        private int eggplantAmount;
        private int biteEggplantAmount;
        private int unripeEggplantAmount;
        private String addTime;

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

        public int getCoinAmount() {
            return coinAmount;
        }

        public void setCoinAmount(int coinAmount) {
            this.coinAmount = coinAmount;
        }

        public int getEggplantAmount() {
            return eggplantAmount;
        }

        public void setEggplantAmount(int eggplantAmount) {
            this.eggplantAmount = eggplantAmount;
        }

        public int getBiteEggplantAmount() {
            return biteEggplantAmount;
        }

        public void setBiteEggplantAmount(int biteEggplantAmount) {
            this.biteEggplantAmount = biteEggplantAmount;
        }

        public int getUnripeEggplantAmount() {
            return unripeEggplantAmount;
        }

        public void setUnripeEggplantAmount(int unripeEggplantAmount) {
            this.unripeEggplantAmount = unripeEggplantAmount;
        }

        public String getAddTime() {
            return addTime;
        }

        public void setAddTime(String addTime) {
            this.addTime = addTime;
        }
    }
}
