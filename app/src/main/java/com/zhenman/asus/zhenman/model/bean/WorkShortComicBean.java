package com.zhenman.asus.zhenman.model.bean;

import java.util.List;

public class WorkShortComicBean {

    /**
     * state : 0
     * msg : 成功
     * data : {"pageNum":1,"pageSize":20,"startRow":0,"endRow":0,"total":2,"pages":0,"result":[{"name":"绝版青春","id":"59","catalogId":null,"userId":"255","type":1,"headImg":"http://pa1qj1jlg.bkt.clouddn.com/headImage/eb34bd9db550436596bf29a4dadef13e_","finalImg":"http://pa1qj1jlg.bkt.clouddn.com/UGC/2f663d7fa8084cb69dbcaf26598bd25c_UGCMainImg","coverImg":"http://pa1qj1jlg.bkt.clouddn.com/UGC/2f663d7fa8084cb69dbcaf26598bd25c_UGCMainImg?imageMogr2/crop/750.0x1152.7777777777778/thumbnail/432x664","width":750,"height":1618,"description":"测试","likeNum":"0","commentNum":"1","shareNum":"0","shareImg":null,"follow":true,"like":false,"reCreate":true,"subjectName":null,"subjectId":0,"pageDtoList":[{"imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/UGC/2f663d7fa8084cb69dbcaf26598bd25c_UGCMainImg?imageMogr2/crop/!750.0x600.0a0a0.0","width":"750.0","height":"600.0"},{"imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/UGC/2f663d7fa8084cb69dbcaf26598bd25c_UGCMainImg?imageMogr2/crop/!750.0x1018.0a0a600.0","width":"750.0","height":"1018.0"}]},{"name":"绝版青春","id":"57","catalogId":null,"userId":"255","type":1,"headImg":"http://pa1qj1jlg.bkt.clouddn.com/headImage/eb34bd9db550436596bf29a4dadef13e_","finalImg":"http://pa1qj1jlg.bkt.clouddn.com/UGC/17ebc2d7929d4e109e4d5e7272299268_UGCMainImg","coverImg":"http://pa1qj1jlg.bkt.clouddn.com/UGC/17ebc2d7929d4e109e4d5e7272299268_UGCMainImg?imageMogr2/crop/750.0x1152.7777777777778/thumbnail/432x664","width":750,"height":2996,"description":"测送您嘻嘻嘻嘻嘻嘻中敏民工民工漫你民工工","likeNum":"0","commentNum":"0","shareNum":"0","shareImg":null,"follow":true,"like":false,"reCreate":true,"subjectName":null,"subjectId":0,"pageDtoList":[{"imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/UGC/17ebc2d7929d4e109e4d5e7272299268_UGCMainImg?imageMogr2/crop/!750.0x600.0a0a0.0","width":"750.0","height":"600.0"},{"imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/UGC/17ebc2d7929d4e109e4d5e7272299268_UGCMainImg?imageMogr2/crop/!750.0x600.0a0a600.0","width":"750.0","height":"600.0"},{"imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/UGC/17ebc2d7929d4e109e4d5e7272299268_UGCMainImg?imageMogr2/crop/!750.0x600.0a0a1200.0","width":"750.0","height":"600.0"},{"imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/UGC/17ebc2d7929d4e109e4d5e7272299268_UGCMainImg?imageMogr2/crop/!750.0x1196.0a0a1800.0","width":"750.0","height":"1196.0"}]}]}
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
         * pageNum : 1
         * pageSize : 20
         * startRow : 0
         * endRow : 0
         * total : 2
         * pages : 0
         * result : [{"name":"绝版青春","id":"59","catalogId":null,"userId":"255","type":1,"headImg":"http://pa1qj1jlg.bkt.clouddn.com/headImage/eb34bd9db550436596bf29a4dadef13e_","finalImg":"http://pa1qj1jlg.bkt.clouddn.com/UGC/2f663d7fa8084cb69dbcaf26598bd25c_UGCMainImg","coverImg":"http://pa1qj1jlg.bkt.clouddn.com/UGC/2f663d7fa8084cb69dbcaf26598bd25c_UGCMainImg?imageMogr2/crop/750.0x1152.7777777777778/thumbnail/432x664","width":750,"height":1618,"description":"测试","likeNum":"0","commentNum":"1","shareNum":"0","shareImg":null,"follow":true,"like":false,"reCreate":true,"subjectName":null,"subjectId":0,"pageDtoList":[{"imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/UGC/2f663d7fa8084cb69dbcaf26598bd25c_UGCMainImg?imageMogr2/crop/!750.0x600.0a0a0.0","width":"750.0","height":"600.0"},{"imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/UGC/2f663d7fa8084cb69dbcaf26598bd25c_UGCMainImg?imageMogr2/crop/!750.0x1018.0a0a600.0","width":"750.0","height":"1018.0"}]},{"name":"绝版青春","id":"57","catalogId":null,"userId":"255","type":1,"headImg":"http://pa1qj1jlg.bkt.clouddn.com/headImage/eb34bd9db550436596bf29a4dadef13e_","finalImg":"http://pa1qj1jlg.bkt.clouddn.com/UGC/17ebc2d7929d4e109e4d5e7272299268_UGCMainImg","coverImg":"http://pa1qj1jlg.bkt.clouddn.com/UGC/17ebc2d7929d4e109e4d5e7272299268_UGCMainImg?imageMogr2/crop/750.0x1152.7777777777778/thumbnail/432x664","width":750,"height":2996,"description":"测送您嘻嘻嘻嘻嘻嘻中敏民工民工漫你民工工","likeNum":"0","commentNum":"0","shareNum":"0","shareImg":null,"follow":true,"like":false,"reCreate":true,"subjectName":null,"subjectId":0,"pageDtoList":[{"imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/UGC/17ebc2d7929d4e109e4d5e7272299268_UGCMainImg?imageMogr2/crop/!750.0x600.0a0a0.0","width":"750.0","height":"600.0"},{"imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/UGC/17ebc2d7929d4e109e4d5e7272299268_UGCMainImg?imageMogr2/crop/!750.0x600.0a0a600.0","width":"750.0","height":"600.0"},{"imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/UGC/17ebc2d7929d4e109e4d5e7272299268_UGCMainImg?imageMogr2/crop/!750.0x600.0a0a1200.0","width":"750.0","height":"600.0"},{"imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/UGC/17ebc2d7929d4e109e4d5e7272299268_UGCMainImg?imageMogr2/crop/!750.0x1196.0a0a1800.0","width":"750.0","height":"1196.0"}]}]
         */

        private int pageNum;
        private int pageSize;
        private int startRow;
        private int endRow;
        private int total;
        private int pages;
        private List<ResultBean> result;

        public int getPageNum() {
            return pageNum;
        }

        public void setPageNum(int pageNum) {
            this.pageNum = pageNum;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getStartRow() {
            return startRow;
        }

        public void setStartRow(int startRow) {
            this.startRow = startRow;
        }

        public int getEndRow() {
            return endRow;
        }

        public void setEndRow(int endRow) {
            this.endRow = endRow;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getPages() {
            return pages;
        }

        public void setPages(int pages) {
            this.pages = pages;
        }

        public List<ResultBean> getResult() {
            return result;
        }

        public void setResult(List<ResultBean> result) {
            this.result = result;
        }

        public static class ResultBean {
            /**
             * name : 绝版青春
             * id : 59
             * catalogId : null
             * userId : 255
             * type : 1
             * headImg : http://pa1qj1jlg.bkt.clouddn.com/headImage/eb34bd9db550436596bf29a4dadef13e_
             * finalImg : http://pa1qj1jlg.bkt.clouddn.com/UGC/2f663d7fa8084cb69dbcaf26598bd25c_UGCMainImg
             * coverImg : http://pa1qj1jlg.bkt.clouddn.com/UGC/2f663d7fa8084cb69dbcaf26598bd25c_UGCMainImg?imageMogr2/crop/750.0x1152.7777777777778/thumbnail/432x664
             * width : 750
             * height : 1618
             * description : 测试
             * likeNum : 0
             * commentNum : 1
             * shareNum : 0
             * shareImg : null
             * follow : true
             * like : false
             * reCreate : true
             * subjectName : null
             * subjectId : 0
             * pageDtoList : [{"imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/UGC/2f663d7fa8084cb69dbcaf26598bd25c_UGCMainImg?imageMogr2/crop/!750.0x600.0a0a0.0","width":"750.0","height":"600.0"},{"imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/UGC/2f663d7fa8084cb69dbcaf26598bd25c_UGCMainImg?imageMogr2/crop/!750.0x1018.0a0a600.0","width":"750.0","height":"1018.0"}]
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
            private int height;
            private String description;
            private String likeNum;
            private String commentNum;
            private String shareNum;
            private Object shareImg;
            private boolean follow;
            private boolean like;
            private boolean reCreate;
            private Object subjectName;
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

            public Object getShareImg() {
                return shareImg;
            }

            public void setShareImg(Object shareImg) {
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

            public Object getSubjectName() {
                return subjectName;
            }

            public void setSubjectName(Object subjectName) {
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

            public static class PageDtoListBean {
                /**
                 * imageUrl : http://pa1qj1jlg.bkt.clouddn.com/UGC/2f663d7fa8084cb69dbcaf26598bd25c_UGCMainImg?imageMogr2/crop/!750.0x600.0a0a0.0
                 * width : 750.0
                 * height : 600.0
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
    }
}
