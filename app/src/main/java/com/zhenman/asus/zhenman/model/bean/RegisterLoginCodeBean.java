package com.zhenman.asus.zhenman.model.bean;

public class RegisterLoginCodeBean {
    /**
     * state : 0
     * msg : 成功
     * data : {"isBindMobile":"0","headImg":"","cityName":"","sex":"","name":"ec33dcaf","mobile":"17695099093","id":"264","introduction":"","token":"eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJqd3QiLCJpYXQiOjE1MzI1NzQzNTUsInN1YiI6IntcInVzZXJJZFwiOjI2NCxcInJvbGVUeXBlXCI6bnVsbCxcInNlc3Npb25JZFwiOlwiNTg2MERBNDcyQkFFQ0MyQzJCRkNFOEY2MTQ4MUQyM0JcIixcInVzZXJBZ2VudFwiOlwiUG9zdG1hblJ1bnRpbWUvNy4xLjVcIixcImluZGV4XCI6MCxcInJlZnJlc2hUb2tlblwiOmZhbHNlfSIsImV4cCI6MTU2NDExMDM1NX0.nVERCJ2C2tTEM-zFPuK1ufP5tlDCHrQtr8L-j-n4K6o","refreshToken":"eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJqd3QiLCJpYXQiOjE1MzI1NzQzNTUsInN1YiI6IntcInVzZXJJZFwiOjI2NCxcInJvbGVUeXBlXCI6bnVsbCxcInNlc3Npb25JZFwiOlwiNTg2MERBNDcyQkFFQ0MyQzJCRkNFOEY2MTQ4MUQyM0JcIixcInVzZXJBZ2VudFwiOlwiUG9zdG1hblJ1bnRpbWUvNy4xLjVcIixcImluZGV4XCI6MCxcInJlZnJlc2hUb2tlblwiOnRydWV9IiwiZXhwIjoxNTY0MTEwMzU1fQ.rSvignyq1Y86e8VAwQrJmdWX9VC0m-kY_BEQ1L-gsE0"}
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
         * isBindMobile : 0
         * headImg :
         * cityName :
         * sex :
         * name : ec33dcaf
         * mobile : 17695099093
         * id : 264
         * introduction :
         * token : eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJqd3QiLCJpYXQiOjE1MzI1NzQzNTUsInN1YiI6IntcInVzZXJJZFwiOjI2NCxcInJvbGVUeXBlXCI6bnVsbCxcInNlc3Npb25JZFwiOlwiNTg2MERBNDcyQkFFQ0MyQzJCRkNFOEY2MTQ4MUQyM0JcIixcInVzZXJBZ2VudFwiOlwiUG9zdG1hblJ1bnRpbWUvNy4xLjVcIixcImluZGV4XCI6MCxcInJlZnJlc2hUb2tlblwiOmZhbHNlfSIsImV4cCI6MTU2NDExMDM1NX0.nVERCJ2C2tTEM-zFPuK1ufP5tlDCHrQtr8L-j-n4K6o
         * refreshToken : eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJqd3QiLCJpYXQiOjE1MzI1NzQzNTUsInN1YiI6IntcInVzZXJJZFwiOjI2NCxcInJvbGVUeXBlXCI6bnVsbCxcInNlc3Npb25JZFwiOlwiNTg2MERBNDcyQkFFQ0MyQzJCRkNFOEY2MTQ4MUQyM0JcIixcInVzZXJBZ2VudFwiOlwiUG9zdG1hblJ1bnRpbWUvNy4xLjVcIixcImluZGV4XCI6MCxcInJlZnJlc2hUb2tlblwiOnRydWV9IiwiZXhwIjoxNTY0MTEwMzU1fQ.rSvignyq1Y86e8VAwQrJmdWX9VC0m-kY_BEQ1L-gsE0
         */

        private String isBindMobile;
        private String headImg;
        private String cityName;
        private String sex;
        private String name;
        private String mobile;
        private String id;
        private String introduction;
        private String token;
        private String refreshToken;

        public String getIsBindMobile() {
            return isBindMobile;
        }

        public void setIsBindMobile(String isBindMobile) {
            this.isBindMobile = isBindMobile;
        }

        public String getHeadImg() {
            return headImg;
        }

        public void setHeadImg(String headImg) {
            this.headImg = headImg;
        }

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getIntroduction() {
            return introduction;
        }

        public void setIntroduction(String introduction) {
            this.introduction = introduction;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getRefreshToken() {
            return refreshToken;
        }

        public void setRefreshToken(String refreshToken) {
            this.refreshToken = refreshToken;
        }
    }
}
