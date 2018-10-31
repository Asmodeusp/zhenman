package com.zhenman.asus.zhenman.model.bean;

import java.util.List;

public class ShelfCollectionBean {

    /**
     * state : 0
     * msg : 成功
     * data : {"pageNum":1,"pageSize":20,"startRow":0,"endRow":20,"total":2,"pages":1,"result":[{"lid":100,"updateStatus":0,"imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/pgc/竖版封面图_菜鸟阎王.jpg_1532695077877","totalChapter":3,"title":"菜鸟阎王","currentChapter":0,"pgcId":24},{"lid":96,"updateStatus":0,"imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/pgc/3a2a6118-b613-49bd-a786-71ceede08ee0.png_1532759860908","totalChapter":1,"title":"抗日奇侠","currentChapter":1,"pgcId":39}]}
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
         * total : 2
         * pages : 1
         * result : [{"lid":100,"updateStatus":0,"imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/pgc/竖版封面图_菜鸟阎王.jpg_1532695077877","totalChapter":3,"title":"菜鸟阎王","currentChapter":0,"pgcId":24},{"lid":96,"updateStatus":0,"imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/pgc/3a2a6118-b613-49bd-a786-71ceede08ee0.png_1532759860908","totalChapter":1,"title":"抗日奇侠","currentChapter":1,"pgcId":39}]
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
             * lid : 100
             * updateStatus : 0
             * imageUrl : http://pa1qj1jlg.bkt.clouddn.com/pgc/竖版封面图_菜鸟阎王.jpg_1532695077877
             * totalChapter : 3
             * title : 菜鸟阎王
             * currentChapter : 0
             * pgcId : 24
             */

            private int lid;
            private int updateStatus;
            private String imageUrl;
            private int totalChapter;
            private String title;
            private int currentChapter;
            private int pgcId;
            private boolean isDisplay;

            public boolean isDisplay() {
                return isDisplay;
            }

            public void setDisplay(Boolean display) {
                isDisplay = display;
            }

            public boolean isCheck() {

                return isCheck;
            }

            public void setCheck(boolean check) {
                isCheck = check;
            }

            private boolean isCheck;

            public int getLid() {
                return lid;
            }

            public void setLid(int lid) {
                this.lid = lid;
            }

            public int getUpdateStatus() {
                return updateStatus;
            }

            public void setUpdateStatus(int updateStatus) {
                this.updateStatus = updateStatus;
            }

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public int getTotalChapter() {
                return totalChapter;
            }

            public void setTotalChapter(int totalChapter) {
                this.totalChapter = totalChapter;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getCurrentChapter() {
                return currentChapter;
            }

            public void setCurrentChapter(int currentChapter) {
                this.currentChapter = currentChapter;
            }

            public int getPgcId() {
                return pgcId;
            }

            public void setPgcId(int pgcId) {
                this.pgcId = pgcId;
            }
        }
    }
}
