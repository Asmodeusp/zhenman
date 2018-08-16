package com.zhenman.asus.zhenman.model.bean;

public class UserBean {

    /**
     * state : 0
     * msg : 成功
     * data : {"isBindMobile":"0","headImg":null,"sex":"0","name":null,"id":"220","introduction":null,"token":"eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJqd3QiLCJpYXQiOjE1MzIxNDIzNDUsInN1YiI6IntcInVzZXJJZFwiOjIyMCxcInJvbGVUeXBlXCI6bnVsbCxcInNlc3Npb25JZFwiOlwiNEZBNjQxRENGQTQ4RjVFREE4OTVFM0E2OTY1RjRDMURcIixcInVzZXJBZ2VudFwiOlwiUG9zdG1hblJ1bnRpbWUvNy4xLjVcIixcImluZGV4XCI6MCxcInJlZnJlc2hUb2tlblwiOmZhbHNlfSIsImV4cCI6MTU2MzY3ODM0NX0.ArkFwFLMWgG7F_8JoMvTu7pjXzsUWtN7Y2uQ-v0tGy4","refreshToken":"eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJqd3QiLCJpYXQiOjE1MzIxNDIzNDUsInN1YiI6IntcInVzZXJJZFwiOjIyMCxcInJvbGVUeXBlXCI6bnVsbCxcInNlc3Npb25JZFwiOlwiNEZBNjQxRENGQTQ4RjVFREE4OTVFM0E2OTY1RjRDMURcIixcInVzZXJBZ2VudFwiOlwiUG9zdG1hblJ1bnRpbWUvNy4xLjVcIixcImluZGV4XCI6MCxcInJlZnJlc2hUb2tlblwiOnRydWV9IiwiZXhwIjoxNTYzNjc4MzQ1fQ.UREwJZcXV2jUZhnvAIhBu0uiX0VnfZBJWEISt1biPoQ"}
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
         * headImg : null
         * sex : 0
         * name : null
         * id : 220
         * introduction : null
         * token : eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJqd3QiLCJpYXQiOjE1MzIxNDIzNDUsInN1YiI6IntcInVzZXJJZFwiOjIyMCxcInJvbGVUeXBlXCI6bnVsbCxcInNlc3Npb25JZFwiOlwiNEZBNjQxRENGQTQ4RjVFREE4OTVFM0E2OTY1RjRDMURcIixcInVzZXJBZ2VudFwiOlwiUG9zdG1hblJ1bnRpbWUvNy4xLjVcIixcImluZGV4XCI6MCxcInJlZnJlc2hUb2tlblwiOmZhbHNlfSIsImV4cCI6MTU2MzY3ODM0NX0.ArkFwFLMWgG7F_8JoMvTu7pjXzsUWtN7Y2uQ-v0tGy4
         * refreshToken : eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJqd3QiLCJpYXQiOjE1MzIxNDIzNDUsInN1YiI6IntcInVzZXJJZFwiOjIyMCxcInJvbGVUeXBlXCI6bnVsbCxcInNlc3Npb25JZFwiOlwiNEZBNjQxRENGQTQ4RjVFREE4OTVFM0E2OTY1RjRDMURcIixcInVzZXJBZ2VudFwiOlwiUG9zdG1hblJ1bnRpbWUvNy4xLjVcIixcImluZGV4XCI6MCxcInJlZnJlc2hUb2tlblwiOnRydWV9IiwiZXhwIjoxNTYzNjc4MzQ1fQ.UREwJZcXV2jUZhnvAIhBu0uiX0VnfZBJWEISt1biPoQ
         */

        private String isBindMobile;
        private Object headImg;
        private String sex;
        private Object name;
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

        public Object getHeadImg() {
            return headImg;
        }

        public void setHeadImg(Object headImg) {
            this.headImg = headImg;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public Object getName() {
            return name;
        }

        public void setName(Object name) {
            this.name = name;
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
