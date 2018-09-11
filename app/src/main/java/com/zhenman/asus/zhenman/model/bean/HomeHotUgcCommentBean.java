package com.zhenman.asus.zhenman.model.bean;

import java.util.List;

public class HomeHotUgcCommentBean {

    /**
     * state : 0
     * msg : 成功
     * data : {"pageNum":1,"pageSize":50,"startRow":0,"endRow":50,"total":8,"pages":1,"result":[{"commentId":"968","content":"123","catalogId":null,"userId":"259","likeNum":"0","like":false,"detailNum":null,"addTime":"1535445827000","author":false,"reUserId":"299","reContent":"立京臭**","reName":"dsaf","reAuthor":false,"imageUrl":null,"name":"45ab5abb","detailId":null,"title":null,"chapterSort":null,"pageBean":null},{"commentId":"967","content":"立京臭**","catalogId":null,"userId":"299","likeNum":"0","like":false,"detailNum":null,"addTime":"1533796950000","author":false,"reUserId":null,"reContent":null,"reName":null,"reAuthor":false,"imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/headImage/dedd9c65a9f64d039cccbc9adacfd8ef_809476-20170525194948388-774343317.png?roundPic/radius/!50p","name":"dsaf","detailId":null,"title":null,"chapterSort":null,"pageBean":null},{"commentId":"966","content":"**","catalogId":null,"userId":"299","likeNum":"0","like":false,"detailNum":null,"addTime":"1533796833000","author":false,"reUserId":null,"reContent":null,"reName":null,"reAuthor":false,"imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/headImage/dedd9c65a9f64d039cccbc9adacfd8ef_809476-20170525194948388-774343317.png?roundPic/radius/!50p","name":"dsaf","detailId":null,"title":null,"chapterSort":null,"pageBean":null},{"commentId":"962","content":"呃呃呃","catalogId":null,"userId":"287","likeNum":"0","like":false,"detailNum":null,"addTime":"1533557376000","author":true,"reUserId":null,"reContent":null,"reName":null,"reAuthor":false,"imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/headImage/990ca3b1f9a54e4d90bf8b213ceb55aa_?roundPic/radius/!50p","name":"文","detailId":null,"title":null,"chapterSort":null,"pageBean":null},{"commentId":"961","content":"不是","catalogId":null,"userId":"286","likeNum":"0","like":false,"detailNum":null,"addTime":"1533557007000","author":false,"reUserId":"287","reContent":"不是作者吗","reName":"文","reAuthor":true,"imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/headImage/5a804a2825c54e0fa25431b2a983ee63_?roundPic/radius/!50p","name":"f6c8ce11jojoman","detailId":null,"title":null,"chapterSort":null,"pageBean":null},{"commentId":"960","content":"不是呢","catalogId":null,"userId":"286","likeNum":"0","like":false,"detailNum":null,"addTime":"1533557000000","author":false,"reUserId":null,"reContent":null,"reName":null,"reAuthor":false,"imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/headImage/5a804a2825c54e0fa25431b2a983ee63_?roundPic/radius/!50p","name":"f6c8ce11jojoman","detailId":null,"title":null,"chapterSort":null,"pageBean":null},{"commentId":"959","content":"不是作者吗","catalogId":null,"userId":"287","likeNum":"0","like":false,"detailNum":null,"addTime":"1533556758000","author":true,"reUserId":null,"reContent":null,"reName":null,"reAuthor":false,"imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/headImage/990ca3b1f9a54e4d90bf8b213ceb55aa_?roundPic/radius/!50p","name":"文","detailId":null,"title":null,"chapterSort":null,"pageBean":null},{"commentId":"958","content":"呃呃呃","catalogId":null,"userId":"287","likeNum":"0","like":false,"detailNum":null,"addTime":"1533556750000","author":true,"reUserId":null,"reContent":null,"reName":null,"reAuthor":false,"imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/headImage/990ca3b1f9a54e4d90bf8b213ceb55aa_?roundPic/radius/!50p","name":"文","detailId":null,"title":null,"chapterSort":null,"pageBean":null}]}
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
         * pageSize : 50
         * startRow : 0
         * endRow : 50
         * total : 8
         * pages : 1
         * result : [{"commentId":"968","content":"123","catalogId":null,"userId":"259","likeNum":"0","like":false,"detailNum":null,"addTime":"1535445827000","author":false,"reUserId":"299","reContent":"立京臭**","reName":"dsaf","reAuthor":false,"imageUrl":null,"name":"45ab5abb","detailId":null,"title":null,"chapterSort":null,"pageBean":null},{"commentId":"967","content":"立京臭**","catalogId":null,"userId":"299","likeNum":"0","like":false,"detailNum":null,"addTime":"1533796950000","author":false,"reUserId":null,"reContent":null,"reName":null,"reAuthor":false,"imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/headImage/dedd9c65a9f64d039cccbc9adacfd8ef_809476-20170525194948388-774343317.png?roundPic/radius/!50p","name":"dsaf","detailId":null,"title":null,"chapterSort":null,"pageBean":null},{"commentId":"966","content":"**","catalogId":null,"userId":"299","likeNum":"0","like":false,"detailNum":null,"addTime":"1533796833000","author":false,"reUserId":null,"reContent":null,"reName":null,"reAuthor":false,"imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/headImage/dedd9c65a9f64d039cccbc9adacfd8ef_809476-20170525194948388-774343317.png?roundPic/radius/!50p","name":"dsaf","detailId":null,"title":null,"chapterSort":null,"pageBean":null},{"commentId":"962","content":"呃呃呃","catalogId":null,"userId":"287","likeNum":"0","like":false,"detailNum":null,"addTime":"1533557376000","author":true,"reUserId":null,"reContent":null,"reName":null,"reAuthor":false,"imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/headImage/990ca3b1f9a54e4d90bf8b213ceb55aa_?roundPic/radius/!50p","name":"文","detailId":null,"title":null,"chapterSort":null,"pageBean":null},{"commentId":"961","content":"不是","catalogId":null,"userId":"286","likeNum":"0","like":false,"detailNum":null,"addTime":"1533557007000","author":false,"reUserId":"287","reContent":"不是作者吗","reName":"文","reAuthor":true,"imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/headImage/5a804a2825c54e0fa25431b2a983ee63_?roundPic/radius/!50p","name":"f6c8ce11jojoman","detailId":null,"title":null,"chapterSort":null,"pageBean":null},{"commentId":"960","content":"不是呢","catalogId":null,"userId":"286","likeNum":"0","like":false,"detailNum":null,"addTime":"1533557000000","author":false,"reUserId":null,"reContent":null,"reName":null,"reAuthor":false,"imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/headImage/5a804a2825c54e0fa25431b2a983ee63_?roundPic/radius/!50p","name":"f6c8ce11jojoman","detailId":null,"title":null,"chapterSort":null,"pageBean":null},{"commentId":"959","content":"不是作者吗","catalogId":null,"userId":"287","likeNum":"0","like":false,"detailNum":null,"addTime":"1533556758000","author":true,"reUserId":null,"reContent":null,"reName":null,"reAuthor":false,"imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/headImage/990ca3b1f9a54e4d90bf8b213ceb55aa_?roundPic/radius/!50p","name":"文","detailId":null,"title":null,"chapterSort":null,"pageBean":null},{"commentId":"958","content":"呃呃呃","catalogId":null,"userId":"287","likeNum":"0","like":false,"detailNum":null,"addTime":"1533556750000","author":true,"reUserId":null,"reContent":null,"reName":null,"reAuthor":false,"imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/headImage/990ca3b1f9a54e4d90bf8b213ceb55aa_?roundPic/radius/!50p","name":"文","detailId":null,"title":null,"chapterSort":null,"pageBean":null}]
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
             * commentId : 968
             * content : 123
             * catalogId : null
             * userId : 259
             * likeNum : 0
             * like : false
             * detailNum : null
             * addTime : 1535445827000
             * author : false
             * reUserId : 299
             * reContent : 立京臭**
             * reName : dsaf
             * reAuthor : false
             * imageUrl : null
             * name : 45ab5abb
             * detailId : null
             * title : null
             * chapterSort : null
             * pageBean : null
             */

            private String commentId;
            private String content;
            private Object catalogId;
            private String userId;
            private String likeNum;
            private boolean like;
            private Object detailNum;
            private String addTime;
            private boolean author;
            private String reUserId;
            private String reContent;
            private String reName;
            private boolean reAuthor;
            private Object imageUrl;
            private String name;
            private Object detailId;
            private Object title;
            private Object chapterSort;
            private Object pageBean;

            public String getCommentId() {
                return commentId;
            }

            public void setCommentId(String commentId) {
                this.commentId = commentId;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
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

            public String getLikeNum() {
                return likeNum;
            }

            public void setLikeNum(String likeNum) {
                this.likeNum = likeNum;
            }

            public boolean isLike() {
                return like;
            }

            public void setLike(boolean like) {
                this.like = like;
            }

            public Object getDetailNum() {
                return detailNum;
            }

            public void setDetailNum(Object detailNum) {
                this.detailNum = detailNum;
            }

            public String getAddTime() {
                return addTime;
            }

            public void setAddTime(String addTime) {
                this.addTime = addTime;
            }

            public boolean isAuthor() {
                return author;
            }

            public void setAuthor(boolean author) {
                this.author = author;
            }

            public String getReUserId() {
                return reUserId;
            }

            public void setReUserId(String reUserId) {
                this.reUserId = reUserId;
            }

            public String getReContent() {
                return reContent;
            }

            public void setReContent(String reContent) {
                this.reContent = reContent;
            }

            public String getReName() {
                return reName;
            }

            public void setReName(String reName) {
                this.reName = reName;
            }

            public boolean isReAuthor() {
                return reAuthor;
            }

            public void setReAuthor(boolean reAuthor) {
                this.reAuthor = reAuthor;
            }

            public Object getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(Object imageUrl) {
                this.imageUrl = imageUrl;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Object getDetailId() {
                return detailId;
            }

            public void setDetailId(Object detailId) {
                this.detailId = detailId;
            }

            public Object getTitle() {
                return title;
            }

            public void setTitle(Object title) {
                this.title = title;
            }

            public Object getChapterSort() {
                return chapterSort;
            }

            public void setChapterSort(Object chapterSort) {
                this.chapterSort = chapterSort;
            }

            public Object getPageBean() {
                return pageBean;
            }

            public void setPageBean(Object pageBean) {
                this.pageBean = pageBean;
            }
        }
    }
}
