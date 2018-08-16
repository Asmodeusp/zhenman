package com.zhenman.asus.zhenman.model.bean;

import java.util.List;

public class SerializationBean {

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

        private Object catalogId;
        private Object title;
        private Object chapterSort;
        private List<PgcHotRecommendBean> pgcHotRecommend;
        private List<PgcSowingMapListBean> pgcSowingMapList;

        public Object getCatalogId() {
            return catalogId;
        }

        public void setCatalogId(Object catalogId) {
            this.catalogId = catalogId;
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

        public List<PgcHotRecommendBean> getPgcHotRecommend() {
            return pgcHotRecommend;
        }

        public void setPgcHotRecommend(List<PgcHotRecommendBean> pgcHotRecommend) {
            this.pgcHotRecommend = pgcHotRecommend;
        }

        public List<PgcSowingMapListBean> getPgcSowingMapList() {
            return pgcSowingMapList;
        }

        public void setPgcSowingMapList(List<PgcSowingMapListBean> pgcSowingMapList) {
            this.pgcSowingMapList = pgcSowingMapList;
        }

        public static class PgcHotRecommendBean {
            private String imageUrl;
            private String pgcId;
            private String title;
            private String tagName;
            private String coverImg;
            private Object catalogId;
            private Object catalogTitle;
            private Object chapterSort;

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

            public Object getCatalogId() {
                return catalogId;
            }

            public void setCatalogId(Object catalogId) {
                this.catalogId = catalogId;
            }

            public Object getCatalogTitle() {
                return catalogTitle;
            }

            public void setCatalogTitle(Object catalogTitle) {
                this.catalogTitle = catalogTitle;
            }

            public Object getChapterSort() {
                return chapterSort;
            }

            public void setChapterSort(Object chapterSort) {
                this.chapterSort = chapterSort;
            }
        }

        public static class PgcSowingMapListBean {
            private String imageUrl;
            private String jumpUrl;

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public String getJumpUrl() {
                return jumpUrl;
            }

            public void setJumpUrl(String jumpUrl) {
                this.jumpUrl = jumpUrl;
            }
        }
    }
}
