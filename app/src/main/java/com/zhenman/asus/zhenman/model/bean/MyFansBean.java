package com.zhenman.asus.zhenman.model.bean;

import java.util.List;

public class MyFansBean {

    /**
     * state : 0
     * msg : 成功
     * data : {"pageNum":1,"pageSize":20,"startRow":0,"endRow":20,"total":3,"pages":1,"result":[{"userId":"306","imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/headImage/94d8936576be447db4af912580b48987_","name":"432423","introduction":"3gfds","addTime":"1535791193000","follow":1},{"userId":"380","imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/headImage/d659f5ce4ff14b79a44ddb1bc5eef148_","name":"绝版青春1","introduction":null,"addTime":"1535809011000","follow":1},{"userId":"398","imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/headImage/9ab1836c5af14cf49e6b91b8ba3f512b_","name":"哈哈哈哈哈","introduction":null,"addTime":"1539075924000","follow":3}]}
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
         * endRow : 20
         * total : 3
         * pages : 1
         * result : [{"userId":"306","imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/headImage/94d8936576be447db4af912580b48987_","name":"432423","introduction":"3gfds","addTime":"1535791193000","follow":1},{"userId":"380","imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/headImage/d659f5ce4ff14b79a44ddb1bc5eef148_","name":"绝版青春1","introduction":null,"addTime":"1535809011000","follow":1},{"userId":"398","imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/headImage/9ab1836c5af14cf49e6b91b8ba3f512b_","name":"哈哈哈哈哈","introduction":null,"addTime":"1539075924000","follow":3}]
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
             * userId : 306
             * imageUrl : http://pa1qj1jlg.bkt.clouddn.com/headImage/94d8936576be447db4af912580b48987_
             * name : 432423
             * introduction : 3gfds
             * addTime : 1535791193000
             * follow : 1
             */

            private String userId;
            private String imageUrl;
            private String name;
            private String introduction;
            private String addTime;
            private int follow;

            public String getUserId() {
                return userId;
            }

            public void setUserId(String userId) {
                this.userId = userId;
            }

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getIntroduction() {
                return introduction;
            }

            public void setIntroduction(String introduction) {
                this.introduction = introduction;
            }

            public String getAddTime() {
                return addTime;
            }

            public void setAddTime(String addTime) {
                this.addTime = addTime;
            }

            public int getFollow() {
                return follow;
            }

            public void setFollow(int follow) {
                this.follow = follow;
            }
        }
    }
}
