package com.zhenman.asus.zhenman.model.bean;

public class SellEggplantBean {


    /**
     * state : 0
     * msg : 成功
     * data : {"coinAmount":10000,"eggplantAmount":2,"biteEggplantAmount":3,"unripeEggplantAmount":0,"eggplantProportion":0.9,"biteEggplantProportion":0.6,"unripeEggplantProportion":0.05}
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
         * coinAmount : 10000
         * eggplantAmount : 2
         * biteEggplantAmount : 3
         * unripeEggplantAmount : 0
         * eggplantProportion : 0.9
         * biteEggplantProportion : 0.6
         * unripeEggplantProportion : 0.05
         */

        private int coinAmount;
        private int eggplantAmount;
        private int biteEggplantAmount;
        private int unripeEggplantAmount;
        private double eggplantProportion;
        private double biteEggplantProportion;
        private double unripeEggplantProportion;

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

        public double getEggplantProportion() {
            return eggplantProportion;
        }

        public void setEggplantProportion(double eggplantProportion) {
            this.eggplantProportion = eggplantProportion;
        }

        public double getBiteEggplantProportion() {
            return biteEggplantProportion;
        }

        public void setBiteEggplantProportion(double biteEggplantProportion) {
            this.biteEggplantProportion = biteEggplantProportion;
        }

        public double getUnripeEggplantProportion() {
            return unripeEggplantProportion;
        }

        public void setUnripeEggplantProportion(double unripeEggplantProportion) {
            this.unripeEggplantProportion = unripeEggplantProportion;
        }
    }
}
