package com.zhenman.asus.zhenman.model.bean;

public class ThirdPartyLoginBean {


    /**
     * state : 0
     * msg : 成功
     * data : {"birthdate":null,"weiboName":null,"headImg":"http://pa1qj1jlg.bkt.clouddn.com/headImage/d0a4cca3a1504e5790a6f3550b29fcd8_","sex":2,"weixinName":"Sunshine","mobile":null,"token":"eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJqd3QiLCJpYXQiOjE1MzU3MDU3NzAsInN1YiI6IntcInVzZXJJZFwiOjM3NCxcInJvbGVUeXBlXCI6bnVsbCxcInNlc3Npb25JZFwiOlwiMjBFNDJFNTc4OTUwQTM2OTI5RjM1NjVENTkzOEQyNjVcIixcInVzZXJBZ2VudFwiOlwiUG9zdG1hblJ1bnRpbWUvMy4wLjlcIixcImluZGV4XCI6MCxcInJlZnJlc2hUb2tlblwiOmZhbHNlfSIsImV4cCI6MTU2NzI0MTc3MH0.VYp6BfDrKS5EI9lZj0PDz_fs1JAvzHXIyEX89oovu-U","isBindMobile":"0","oauthId":"86","cityName":"","name":"Sunshine","id":"374","qqName":null,"introduction":null,"refreshToken":"eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJqd3QiLCJpYXQiOjE1MzU3MDU3NzAsInN1YiI6IntcInVzZXJJZFwiOjM3NCxcInJvbGVUeXBlXCI6bnVsbCxcInNlc3Npb25JZFwiOlwiMjBFNDJFNTc4OTUwQTM2OTI5RjM1NjVENTkzOEQyNjVcIixcInVzZXJBZ2VudFwiOlwiUG9zdG1hblJ1bnRpbWUvMy4wLjlcIixcImluZGV4XCI6MCxcInJlZnJlc2hUb2tlblwiOnRydWV9IiwiZXhwIjoxNTY3MjQxNzcwfQ.2W-1XIT-M1KK4v3XYStAavhkDgYLwbY6EnVPMzf1yNU"}
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
         * birthdate : null
         * weiboName : null
         * headImg : http://pa1qj1jlg.bkt.clouddn.com/headImage/d0a4cca3a1504e5790a6f3550b29fcd8_
         * sex : 2
         * weixinName : Sunshine
         * mobile : null
         * token : eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJqd3QiLCJpYXQiOjE1MzU3MDU3NzAsInN1YiI6IntcInVzZXJJZFwiOjM3NCxcInJvbGVUeXBlXCI6bnVsbCxcInNlc3Npb25JZFwiOlwiMjBFNDJFNTc4OTUwQTM2OTI5RjM1NjVENTkzOEQyNjVcIixcInVzZXJBZ2VudFwiOlwiUG9zdG1hblJ1bnRpbWUvMy4wLjlcIixcImluZGV4XCI6MCxcInJlZnJlc2hUb2tlblwiOmZhbHNlfSIsImV4cCI6MTU2NzI0MTc3MH0.VYp6BfDrKS5EI9lZj0PDz_fs1JAvzHXIyEX89oovu-U
         * isBindMobile : 0
         * oauthId : 86
         * cityName :
         * name : Sunshine
         * id : 374
         * qqName : null
         * introduction : null
         * refreshToken : eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJqd3QiLCJpYXQiOjE1MzU3MDU3NzAsInN1YiI6IntcInVzZXJJZFwiOjM3NCxcInJvbGVUeXBlXCI6bnVsbCxcInNlc3Npb25JZFwiOlwiMjBFNDJFNTc4OTUwQTM2OTI5RjM1NjVENTkzOEQyNjVcIixcInVzZXJBZ2VudFwiOlwiUG9zdG1hblJ1bnRpbWUvMy4wLjlcIixcImluZGV4XCI6MCxcInJlZnJlc2hUb2tlblwiOnRydWV9IiwiZXhwIjoxNTY3MjQxNzcwfQ.2W-1XIT-M1KK4v3XYStAavhkDgYLwbY6EnVPMzf1yNU
         */

        private Object birthdate;
        private Object weiboName;
        private String headImg;
        private int sex;
        private String weixinName;
        private Object mobile;
        private String token;
        private String isBindMobile;
        private String oauthId;
        private String cityName;
        private String name;
        private String id;
        private Object qqName;
        private Object introduction;
        private String refreshToken;

        public Object getBirthdate() {
            return birthdate;
        }

        public void setBirthdate(Object birthdate) {
            this.birthdate = birthdate;
        }

        public Object getWeiboName() {
            return weiboName;
        }

        public void setWeiboName(Object weiboName) {
            this.weiboName = weiboName;
        }

        public String getHeadImg() {
            return headImg;
        }

        public void setHeadImg(String headImg) {
            this.headImg = headImg;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public String getWeixinName() {
            return weixinName;
        }

        public void setWeixinName(String weixinName) {
            this.weixinName = weixinName;
        }

        public Object getMobile() {
            return mobile;
        }

        public void setMobile(Object mobile) {
            this.mobile = mobile;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getIsBindMobile() {
            return isBindMobile;
        }

        public void setIsBindMobile(String isBindMobile) {
            this.isBindMobile = isBindMobile;
        }

        public String getOauthId() {
            return oauthId;
        }

        public void setOauthId(String oauthId) {
            this.oauthId = oauthId;
        }

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Object getQqName() {
            return qqName;
        }

        public void setQqName(Object qqName) {
            this.qqName = qqName;
        }

        public Object getIntroduction() {
            return introduction;
        }

        public void setIntroduction(Object introduction) {
            this.introduction = introduction;
        }

        public String getRefreshToken() {
            return refreshToken;
        }

        public void setRefreshToken(String refreshToken) {
            this.refreshToken = refreshToken;
        }
    }
}
