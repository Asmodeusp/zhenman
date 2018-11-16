package com.zhenman.asus.zhenman.model.bean;

import java.io.Serializable;
import java.util.List;

public class ResultBean implements Serializable{


        /**
         * name : 橙色?
         * id : 160
         * catalogId : null
         * userId : 305
         * type : 1
         * headImg : http://pa1qj1jlg.bkt.clouddn.com/headImage/9ac4f4681f4b4a79ad2b79ddb06a9274_?imageMogr2/thumbnail/200x200
         * finalImg : http://pa1qj1jlg.bkt.clouddn.com/PPN/1534496421251/669.jpg
         * coverImg : http://pa1qj1jlg.bkt.clouddn.com/PPN/1534496421251/669.jpg?imageMogr2/crop/1109.0x629.0/thumbnail/432x245.02073940486926
         * width : 432
         * height : 245.02073940486926
         * description :
         * likeNum : 1
         * commentNum : 0
         * shareNum : 0
         * shareImg : http://pa1qj1jlg.bkt.clouddn.com/PPN/1534496421251/669.jpg?watermark/3/image/aHR0cDovL3BhMXFqMWpsZy5ia3QuY2xvdWRkbi5jb20vbG9nb19ib3R0b20ucG5nP2ltYWdlTW9ncjIvdGh1bWJuYWlsLzIxeA==/gravity/SouthEast/dx/60/dy/17/text/QOapmeiJsj8=/font/5b6u6L2v6ZuF6buR/fontsize/276/fill/I0ZGRkZGRg==/gravity/SouthEast/dx/20/dy/20
         * follow : false
         * like : false
         * reCreate : false
         * subjectName : 你晒自拍我评分
         * subjectId : 2
         * pageDtoList : [{"imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/PPN/1534496421251/669.jpg?imageMogr2/crop/!432.0x245.02073940486926a0a0.0","width":"432.0","height":"245.02073940486926"}]
         */

        private String name;
        private String id;
        private Object catalogId;
        private String userId;
        private int type;
        private String headImg;
        private String finalImg;
        private String coverImg;
        private int width;
        private double height;
        private String description;
        private String likeNum;
        private String commentNum;
        private String shareNum;
        private String shareImg;
        private boolean follow;
        private boolean like;
        private boolean reCreate;
        private String subjectName;
        private int subjectId;
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

        public String getCoverImg() {
            return coverImg;
        }

        public void setCoverImg(String coverImg) {
            this.coverImg = coverImg;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public double getHeight() {
            return height;
        }

        public void setHeight(double height) {
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

        public String getShareImg() {
            return shareImg;
        }

        public void setShareImg(String shareImg) {
            this.shareImg = shareImg;
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

        public String getSubjectName() {
            return subjectName;
        }

        public void setSubjectName(String subjectName) {
            this.subjectName = subjectName;
        }

        public int getSubjectId() {
            return subjectId;
        }

        public void setSubjectId(int subjectId) {
            this.subjectId = subjectId;
        }

        public List<PageDtoListBean> getPageDtoList() {
            return pageDtoList;
        }

        public void setPageDtoList(List<PageDtoListBean> pageDtoList) {
            this.pageDtoList = pageDtoList;
        }

        public static class PageDtoListBean implements Serializable{
            /**
             * imageUrl : http://pa1qj1jlg.bkt.clouddn.com/PPN/1534496421251/669.jpg?imageMogr2/crop/!432.0x245.02073940486926a0a0.0
             * width : 432.0
             * height : 245.02073940486926
             */

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
