package com.zhenman.asus.zhenman.model.bean;

import java.util.List;

public class HomeHotBean {
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
        private String name;
        private String id;
        private Object catalogId;
        private String userId;
        private int type;
        private String headImg;
        private String finalImg;
        private Object coverImg;
        private int width;
        private int height;
        private String description;
        private String likeNum;
        private String commentNum;
        private String shareNum;
        private boolean follow;
        private boolean like;
        private boolean reCreate;
        private String challengeFlag;
        private int challengeId;
        private List<PageDtoListBean> pageDtoList;

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

        public Object getCatalogId() {
            return catalogId;
        }

        public void setCatalogId(Object catalogId) {
            this.catalogId = catalogId;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getHeadImg() {
            return headImg;
        }

        public void setHeadImg(String headImg) {
            this.headImg = headImg;
        }

        public String getFinalImg() {
            return finalImg;
        }

        public void setFinalImg(String finalImg) {
            this.finalImg = finalImg;
        }

        public Object getCoverImg() {
            return coverImg;
        }

        public void setCoverImg(Object coverImg) {
            this.coverImg = coverImg;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getLikeNum() {
            return likeNum;
        }

        public void setLikeNum(String likeNum) {
            this.likeNum = likeNum;
        }

        public String getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(String commentNum) {
            this.commentNum = commentNum;
        }

        public String getShareNum() {
            return shareNum;
        }

        public void setShareNum(String shareNum) {
            this.shareNum = shareNum;
        }

        public boolean isFollow() {
            return follow;
        }

        public void setFollow(boolean follow) {
            this.follow = follow;
        }

        public boolean isLike() {
            return like;
        }

        public void setLike(boolean like) {
            this.like = like;
        }

        public boolean isReCreate() {
            return reCreate;
        }

        public void setReCreate(boolean reCreate) {
            this.reCreate = reCreate;
        }

        public String getChallengeFlag() {
            return challengeFlag;
        }

        public void setChallengeFlag(String challengeFlag) {
            this.challengeFlag = challengeFlag;
        }

        public int getChallengeId() {
            return challengeId;
        }

        public void setChallengeId(int challengeId) {
            this.challengeId = challengeId;
        }

        public List<PageDtoListBean> getPageDtoList() {
            return pageDtoList;
        }

        public void setPageDtoList(List<PageDtoListBean> pageDtoList) {
            this.pageDtoList = pageDtoList;
        }

        public static class PageDtoListBean {
            private String imageUrl;
            private String width;
            private String height;

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public String getWidth() {
                return width;
            }

            public void setWidth(String width) {
                this.width = width;
            }

            public String getHeight() {
                return height;
            }

            public void setHeight(String height) {
                this.height = height;
            }
        }
    }
}
