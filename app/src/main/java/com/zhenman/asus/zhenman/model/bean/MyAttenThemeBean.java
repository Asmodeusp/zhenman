package com.zhenman.asus.zhenman.model.bean;

import java.util.List;

public class MyAttenThemeBean {

    /**
     * state : 0
     * msg : 成功
     * data : {"pageNum":1,"pageSize":20,"startRow":0,"endRow":20,"total":4,"pages":1,"result":[{"subjectId":"1","description":"pick你的idol","name":"别人相机里的我","image":"http://pa1qj1jlg.bkt.clouddn.com/subject/0101-1.png","followSubject":1},{"subjectId":"2","description":"冬天的蜡烛","name":"你晒自拍我评分","image":"http://pa1qj1jlg.bkt.clouddn.com/subject/0102-2.png","followSubject":1},{"subjectId":"5","description":"","name":"秀出你的手绘","image":"http://pa1qj1jlg.bkt.clouddn.com/subject/0105-5.png","followSubject":1},{"subjectId":"6","description":"","name":"一起来diy","image":"http://pa1qj1jlg.bkt.clouddn.com/subject/0106-6.png","followSubject":1}]}
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
         * total : 4
         * pages : 1
         * result : [{"subjectId":"1","description":"pick你的idol","name":"别人相机里的我","image":"http://pa1qj1jlg.bkt.clouddn.com/subject/0101-1.png","followSubject":1},{"subjectId":"2","description":"冬天的蜡烛","name":"你晒自拍我评分","image":"http://pa1qj1jlg.bkt.clouddn.com/subject/0102-2.png","followSubject":1},{"subjectId":"5","description":"","name":"秀出你的手绘","image":"http://pa1qj1jlg.bkt.clouddn.com/subject/0105-5.png","followSubject":1},{"subjectId":"6","description":"","name":"一起来diy","image":"http://pa1qj1jlg.bkt.clouddn.com/subject/0106-6.png","followSubject":1}]
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
             * subjectId : 1
             * description : pick你的idol
             * name : 别人相机里的我
             * image : http://pa1qj1jlg.bkt.clouddn.com/subject/0101-1.png
             * followSubject : 1
             */

            private String subjectId;
            private String description;
            private String name;
            private String image;
            private int followSubject;

            public String getSubjectId() {
                return subjectId;
            }

            public void setSubjectId(String subjectId) {
                this.subjectId = subjectId;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public int getFollowSubject() {
                return followSubject;
            }

            public void setFollowSubject(int followSubject) {
                this.followSubject = followSubject;
            }
        }
    }
}
