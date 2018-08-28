package com.zhenman.asus.zhenman.model.bean;

import java.util.List;

public class ClassifyBean {


    /**
     * state : 0
     * msg : 成功
     * data : {"pageNum":1,"pageSize":20,"startRow":0,"endRow":20,"total":6,"pages":1,"result":[{"imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/pgc/a3b7e22a64bf4911a59b98e51ebb2465_1.jpg.jpg","pgcId":"51","title":"8-7 （4）","tagName":"玄幻,都市,娱乐,恐怖","coverImg":"http://pa1qj1jlg.bkt.clouddn.com/pgc/a3b7e22a64bf4911a59b98e51ebb2465_1.jpg.jpg","catalogId":null,"catalogTitle":null,"chapterSort":null},{"imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/pgc/1cd7a551980e43519bd1ccfd9e76c25e_gx2.jpg","pgcId":"50","title":"8-7 (3)","tagName":"玄幻,都市","coverImg":"http://pa1qj1jlg.bkt.clouddn.com/pgc/1cd7a551980e43519bd1ccfd9e76c25e_gx2.jpg","catalogId":null,"catalogTitle":null,"chapterSort":null},{"imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/pgc/636e87b210bf48a490c30305a687ff78_noavatar.png","pgcId":"42","title":"123321321321","tagName":"都市,娱乐,玄幻,恐怖,言情,搞笑","coverImg":"http://pa1qj1jlg.bkt.clouddn.com/pgc/636e87b210bf48a490c30305a687ff78_noavatar.png","catalogId":null,"catalogTitle":null,"chapterSort":null},{"imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/pgc/faf2b2119313b07e932960e404d7912396dd8c41.jpg_1532759715763","pgcId":"40","title":"河神","tagName":"玄幻","coverImg":"http://pa1qj1jlg.bkt.clouddn.com/pgc/faf2b2119313b07e932960e404d7912396dd8c41.jpg_1532759715763","catalogId":null,"catalogTitle":null,"chapterSort":null},{"imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/pgc/s竖版封面图.jpg_1532695409177","pgcId":"28","title":"鬼瞳警探","tagName":"都市,玄幻,犯罪","coverImg":"http://pa1qj1jlg.bkt.clouddn.com/pgc/s竖版封面图.jpg_1532695409177","catalogId":null,"catalogTitle":null,"chapterSort":null},{"imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/pgc/竖版封面图_菜鸟阎王.jpg_1532695077877","pgcId":"24","title":"菜鸟阎王","tagName":"玄幻","coverImg":"http://pa1qj1jlg.bkt.clouddn.com/pgc/竖版封面图_菜鸟阎王.jpg_1532695077877","catalogId":null,"catalogTitle":null,"chapterSort":null}]}
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
         * total : 6
         * pages : 1
         * result : [{"imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/pgc/a3b7e22a64bf4911a59b98e51ebb2465_1.jpg.jpg","pgcId":"51","title":"8-7 （4）","tagName":"玄幻,都市,娱乐,恐怖","coverImg":"http://pa1qj1jlg.bkt.clouddn.com/pgc/a3b7e22a64bf4911a59b98e51ebb2465_1.jpg.jpg","catalogId":null,"catalogTitle":null,"chapterSort":null},{"imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/pgc/1cd7a551980e43519bd1ccfd9e76c25e_gx2.jpg","pgcId":"50","title":"8-7 (3)","tagName":"玄幻,都市","coverImg":"http://pa1qj1jlg.bkt.clouddn.com/pgc/1cd7a551980e43519bd1ccfd9e76c25e_gx2.jpg","catalogId":null,"catalogTitle":null,"chapterSort":null},{"imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/pgc/636e87b210bf48a490c30305a687ff78_noavatar.png","pgcId":"42","title":"123321321321","tagName":"都市,娱乐,玄幻,恐怖,言情,搞笑","coverImg":"http://pa1qj1jlg.bkt.clouddn.com/pgc/636e87b210bf48a490c30305a687ff78_noavatar.png","catalogId":null,"catalogTitle":null,"chapterSort":null},{"imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/pgc/faf2b2119313b07e932960e404d7912396dd8c41.jpg_1532759715763","pgcId":"40","title":"河神","tagName":"玄幻","coverImg":"http://pa1qj1jlg.bkt.clouddn.com/pgc/faf2b2119313b07e932960e404d7912396dd8c41.jpg_1532759715763","catalogId":null,"catalogTitle":null,"chapterSort":null},{"imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/pgc/s竖版封面图.jpg_1532695409177","pgcId":"28","title":"鬼瞳警探","tagName":"都市,玄幻,犯罪","coverImg":"http://pa1qj1jlg.bkt.clouddn.com/pgc/s竖版封面图.jpg_1532695409177","catalogId":null,"catalogTitle":null,"chapterSort":null},{"imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/pgc/竖版封面图_菜鸟阎王.jpg_1532695077877","pgcId":"24","title":"菜鸟阎王","tagName":"玄幻","coverImg":"http://pa1qj1jlg.bkt.clouddn.com/pgc/竖版封面图_菜鸟阎王.jpg_1532695077877","catalogId":null,"catalogTitle":null,"chapterSort":null}]
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
             * imageUrl : http://pa1qj1jlg.bkt.clouddn.com/pgc/a3b7e22a64bf4911a59b98e51ebb2465_1.jpg.jpg
             * pgcId : 51
             * title : 8-7 （4）
             * tagName : 玄幻,都市,娱乐,恐怖
             * coverImg : http://pa1qj1jlg.bkt.clouddn.com/pgc/a3b7e22a64bf4911a59b98e51ebb2465_1.jpg.jpg
             * catalogId : null
             * catalogTitle : null
             * chapterSort : null
             */

            private String imageUrl;
            private String pgcId;
            private String title;
            private String tagName;
            private String coverImg;
            private String catalogId;
            private String catalogTitle;
            private String chapterSort;

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public String getPgcId() {
                return pgcId;
            }

            public void setPgcId(String pgcId) {
                this.pgcId = pgcId;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getTagName() {
                return tagName;
            }

            public void setTagName(String tagName) {
                this.tagName = tagName;
            }

            public String getCoverImg() {
                return coverImg;
            }

            public void setCoverImg(String coverImg) {
                this.coverImg = coverImg;
            }

            public String getCatalogId() {
                return catalogId;
            }

            public void setCatalogId(String catalogId) {
                this.catalogId = catalogId;
            }

            public String getCatalogTitle() {
                return catalogTitle;
            }

            public void setCatalogTitle(String catalogTitle) {
                this.catalogTitle = catalogTitle;
            }

            public String getChapterSort() {
                return chapterSort;
            }

            public void setChapterSort(String chapterSort) {
                this.chapterSort = chapterSort;
            }
        }
    }
}
