package com.zhenman.asus.zhenman.model.bean;

public class ThirdPartyLoginBean {

    /**
     * state : 0
     * msg : 成功
     * data : {"isBindMobile":"0","headImg":"34324324","cityName":"32332323","sex":"1","name":"2323323","mobile":null,"id":"210","introduction":null,"token":"eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJqd3QiLCJpYXQiOjE1MzIxNjcwNzksInN1YiI6IntcInVzZXJJZFwiOjQsXCJyb2xlVHlwZVwiOm51bGwsXCJzZXNzaW9uSWRcIjpcIkNBMkFDNDZDM0ZGMEVERDA3MUUwNkFCODdBQTRBRDlBXCIsXCJ1c2VyQWdlbnRcIjpcIlBvc3RtYW5SdW50aW1lLzcuMS41XCIsXCJpbmRleFwiOjAsXCJyZWZyZXNoVG9rZW5cIjpmYWxzZX0iLCJleHAiOjE1NjM3MDMwNzl9.g_6KgrHDvTC0PFiOCR4smsaKBLJjiKDMvkfRL_7eUpw","refreshToken":"eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJqd3QiLCJpYXQiOjE1MzIxNjcwNzksInN1YiI6IntcInVzZXJJZFwiOjQsXCJyb2xlVHlwZVwiOm51bGwsXCJzZXNzaW9uSWRcIjpcIkNBMkFDNDZDM0ZGMEVERDA3MUUwNkFCODdBQTRBRDlBXCIsXCJ1c2VyQWdlbnRcIjpcIlBvc3RtYW5SdW50aW1lLzcuMS41XCIsXCJpbmRleFwiOjAsXCJyZWZyZXNoVG9rZW5cIjp0cnVlfSIsImV4cCI6MTU2MzcwMzA3OX0.zc_LW5AMWkBJzL5AcTmWm4GzvslONkhIPzVZRnUHtf0"}
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
         * headImg : 34324324
         * cityName : 32332323
         * sex : 1
         * name : 2323323
         * mobile : null
         * id : 210
         * introduction : null
         * token : eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJqd3QiLCJpYXQiOjE1MzIxNjcwNzksInN1YiI6IntcInVzZXJJZFwiOjQsXCJyb2xlVHlwZVwiOm51bGwsXCJzZXNzaW9uSWRcIjpcIkNBMkFDNDZDM0ZGMEVERDA3MUUwNkFCODdBQTRBRDlBXCIsXCJ1c2VyQWdlbnRcIjpcIlBvc3RtYW5SdW50aW1lLzcuMS41XCIsXCJpbmRleFwiOjAsXCJyZWZyZXNoVG9rZW5cIjpmYWxzZX0iLCJleHAiOjE1NjM3MDMwNzl9.g_6KgrHDvTC0PFiOCR4smsaKBLJjiKDMvkfRL_7eUpw
         * refreshToken : eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJqd3QiLCJpYXQiOjE1MzIxNjcwNzksInN1YiI6IntcInVzZXJJZFwiOjQsXCJyb2xlVHlwZVwiOm51bGwsXCJzZXNzaW9uSWRcIjpcIkNBMkFDNDZDM0ZGMEVERDA3MUUwNkFCODdBQTRBRDlBXCIsXCJ1c2VyQWdlbnRcIjpcIlBvc3RtYW5SdW50aW1lLzcuMS41XCIsXCJpbmRleFwiOjAsXCJyZWZyZXNoVG9rZW5cIjp0cnVlfSIsImV4cCI6MTU2MzcwMzA3OX0.zc_LW5AMWkBJzL5AcTmWm4GzvslONkhIPzVZRnUHtf0
         */

        private String isBindMobile;
        private String headImg;
        private String cityName;
        private String sex;
        private String name;
        private Object mobile;
        private String id;
        private Object introduction;
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

        public Object getMobile() {
            return mobile;
        }

        public void setMobile(Object mobile) {
            this.mobile = mobile;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Object getIntroduction() {
            return introduction;
        }

        public void setIntroduction(Object introduction) {
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
