package com.zhenman.asus.zhenman.model.bean;

import java.util.List;

public class ClassifyTagBean {

    /**
     * state : 0
     * msg : 成功
     * data : {"backgroundTags":[{"id":8,"tagName":"古代","tagType":3,"sort":12,"updateTime":"1528879435000"},{"id":9,"tagName":"现代","tagType":3,"sort":12,"updateTime":"1528879445000"}],"typeTags":[{"id":1,"tagName":"原创","tagType":1,"sort":12,"updateTime":"1530616947000"},{"id":2,"tagName":"改编","tagType":1,"sort":13,"updateTime":"1530756456000"},{"id":3,"tagName":"借鉴","tagType":1,"sort":15,"updateTime":"1528879525000"}],"statusTags":[{"id":4,"tagName":"更新中","tagType":2,"sort":12,"updateTime":"1528610925000"},{"id":10,"tagName":"完结","tagType":2,"sort":34,"updateTime":"1528879542000"}],"subjectTags":[{"id":11,"tagName":"言情","tagType":4,"sort":12,"updateTime":"1528879559000"},{"id":12,"tagName":"都市","tagType":4,"sort":34,"updateTime":"1528879572000"},{"id":13,"tagName":"玄幻","tagType":4,"sort":34,"updateTime":"1528883332000"},{"id":14,"tagName":"犯罪","tagType":4,"sort":45,"updateTime":"1528883348000"},{"id":15,"tagName":"青春","tagType":4,"sort":34,"updateTime":"1530698726000"},{"id":25,"tagName":"搞笑","tagType":4,"sort":12,"updateTime":"1528879559000"},{"id":26,"tagName":"娱乐","tagType":4,"sort":34,"updateTime":"1528879572000"},{"id":27,"tagName":"恐怖","tagType":4,"sort":34,"updateTime":"1528883332000"},{"id":28,"tagName":"古装","tagType":4,"sort":45,"updateTime":"1528883348000"},{"id":29,"tagName":"恶搞","tagType":4,"sort":34,"updateTime":"1530698726000"}]}
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
        private List<BackgroundTagsBean> backgroundTags;
        private List<TypeTagsBean> typeTags;
        private List<StatusTagsBean> statusTags;
        private List<SubjectTagsBean> subjectTags;

        public List<BackgroundTagsBean> getBackgroundTags() {
            return backgroundTags;
        }

        public void setBackgroundTags(List<BackgroundTagsBean> backgroundTags) {
            this.backgroundTags = backgroundTags;
        }

        public List<TypeTagsBean> getTypeTags() {
            return typeTags;
        }

        public void setTypeTags(List<TypeTagsBean> typeTags) {
            this.typeTags = typeTags;
        }

        public List<StatusTagsBean> getStatusTags() {
            return statusTags;
        }

        public void setStatusTags(List<StatusTagsBean> statusTags) {
            this.statusTags = statusTags;
        }

        public List<SubjectTagsBean> getSubjectTags() {
            return subjectTags;
        }

        public void setSubjectTags(List<SubjectTagsBean> subjectTags) {
            this.subjectTags = subjectTags;
        }

        public static class BackgroundTagsBean {
            /**
             * id : 8
             * tagName : 古代
             * tagType : 3
             * sort : 12
             * updateTime : 1528879435000
             */

            private int id;
            private String tagName;
            private int tagType;
            private int sort;
            private String updateTime;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTagName() {
                return tagName;
            }

            public void setTagName(String tagName) {
                this.tagName = tagName;
            }

            public int getTagType() {
                return tagType;
            }

            public void setTagType(int tagType) {
                this.tagType = tagType;
            }

            public int getSort() {
                return sort;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }
        }

        public static class TypeTagsBean {
            /**
             * id : 1
             * tagName : 原创
             * tagType : 1
             * sort : 12
             * updateTime : 1530616947000
             */

            private int id;
            private String tagName;
            private int tagType;
            private int sort;
            private String updateTime;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTagName() {
                return tagName;
            }

            public void setTagName(String tagName) {
                this.tagName = tagName;
            }

            public int getTagType() {
                return tagType;
            }

            public void setTagType(int tagType) {
                this.tagType = tagType;
            }

            public int getSort() {
                return sort;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }
        }

        public static class StatusTagsBean {
            /**
             * id : 4
             * tagName : 更新中
             * tagType : 2
             * sort : 12
             * updateTime : 1528610925000
             */

            private int id;
            private String tagName;
            private int tagType;
            private int sort;
            private String updateTime;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTagName() {
                return tagName;
            }

            public void setTagName(String tagName) {
                this.tagName = tagName;
            }

            public int getTagType() {
                return tagType;
            }

            public void setTagType(int tagType) {
                this.tagType = tagType;
            }

            public int getSort() {
                return sort;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }
        }

        public static class SubjectTagsBean {
            /**
             * id : 11
             * tagName : 言情
             * tagType : 4
             * sort : 12
             * updateTime : 1528879559000
             */

            private int id;
            private String tagName;
            private int tagType;
            private int sort;
            private String updateTime;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTagName() {
                return tagName;
            }

            public void setTagName(String tagName) {
                this.tagName = tagName;
            }

            public int getTagType() {
                return tagType;
            }

            public void setTagType(int tagType) {
                this.tagType = tagType;
            }

            public int getSort() {
                return sort;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }
        }
    }
}
