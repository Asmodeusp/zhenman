package com.zhenman.asus.zhenman.model.bean;

import java.util.List;

public class PurchaseHistoryBean {

    /**
     * state : 0
     * msg : 成功
     * data : {"pageNum":1,"pageSize":20,"startRow":0,"endRow":20,"total":16,"pages":1,"result":[{"eggId":1,"userId":272,"name":"文","type":3,"typeString":"打赏","amount":10,"addTime":"1534176000000","pgcId":null,"title":null},{"eggId":2,"userId":282,"name":"d0bb42ac绝版青春","type":2,"typeString":"打赏","amount":3,"addTime":"1534176000000","pgcId":null,"title":null},{"eggId":6,"userId":278,"name":"885bdb48不知南北找东西","type":2,"typeString":"打赏","amount":10,"addTime":"1534262400000","pgcId":24,"title":"菜鸟阎王"},{"eggId":7,"userId":278,"name":"885bdb48不知南北找东西","type":2,"typeString":"打赏","amount":10,"addTime":"1534262400000","pgcId":24,"title":"菜鸟阎王"},{"eggId":8,"userId":278,"name":"885bdb48不知南北找东西","type":2,"typeString":"打赏","amount":10,"addTime":"1534262400000","pgcId":24,"title":"菜鸟阎王"},{"eggId":9,"userId":278,"name":"885bdb48不知南北找东西","type":2,"typeString":"打赏","amount":10,"addTime":"1534262400000","pgcId":24,"title":"菜鸟阎王"},{"eggId":10,"userId":278,"name":"885bdb48不知南北找东西","type":2,"typeString":"打赏","amount":10,"addTime":"1534262400000","pgcId":24,"title":"菜鸟阎王"},{"eggId":11,"userId":278,"name":"885bdb48不知南北找东西","type":2,"typeString":"打赏","amount":10,"addTime":"1534262400000","pgcId":24,"title":"菜鸟阎王"},{"eggId":12,"userId":278,"name":"885bdb48不知南北找东西","type":2,"typeString":"打赏","amount":10,"addTime":"1534262400000","pgcId":24,"title":"菜鸟阎王"},{"eggId":13,"userId":278,"name":"885bdb48不知南北找东西","type":2,"typeString":"打赏","amount":10,"addTime":"1534262400000","pgcId":24,"title":"菜鸟阎王"},{"eggId":14,"userId":278,"name":"885bdb48不知南北找东西","type":2,"typeString":"打赏","amount":10,"addTime":"1534262400000","pgcId":24,"title":"菜鸟阎王"},{"eggId":15,"userId":278,"name":"885bdb48不知南北找东西","type":2,"typeString":"打赏","amount":10,"addTime":"1534262400000","pgcId":24,"title":"菜鸟阎王"},{"eggId":16,"userId":278,"name":"885bdb48不知南北找东西","type":2,"typeString":"打赏","amount":10,"addTime":"1534262400000","pgcId":24,"title":"菜鸟阎王"},{"eggId":17,"userId":278,"name":"885bdb48不知南北找东西","type":2,"typeString":"打赏","amount":10,"addTime":"1534262400000","pgcId":24,"title":"菜鸟阎王"},{"eggId":20,"userId":278,"name":"885bdb48不知南北找东西","type":2,"typeString":"打赏","amount":10,"addTime":"1534262400000","pgcId":24,"title":"菜鸟阎王"},{"eggId":21,"userId":278,"name":"885bdb48不知南北找东西","type":2,"typeString":"打赏","amount":10,"addTime":"1534435200000","pgcId":24,"title":"菜鸟阎王"}]}
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
         * total : 16
         * pages : 1
         * result : [{"eggId":1,"userId":272,"name":"文","type":3,"typeString":"打赏","amount":10,"addTime":"1534176000000","pgcId":null,"title":null},{"eggId":2,"userId":282,"name":"d0bb42ac绝版青春","type":2,"typeString":"打赏","amount":3,"addTime":"1534176000000","pgcId":null,"title":null},{"eggId":6,"userId":278,"name":"885bdb48不知南北找东西","type":2,"typeString":"打赏","amount":10,"addTime":"1534262400000","pgcId":24,"title":"菜鸟阎王"},{"eggId":7,"userId":278,"name":"885bdb48不知南北找东西","type":2,"typeString":"打赏","amount":10,"addTime":"1534262400000","pgcId":24,"title":"菜鸟阎王"},{"eggId":8,"userId":278,"name":"885bdb48不知南北找东西","type":2,"typeString":"打赏","amount":10,"addTime":"1534262400000","pgcId":24,"title":"菜鸟阎王"},{"eggId":9,"userId":278,"name":"885bdb48不知南北找东西","type":2,"typeString":"打赏","amount":10,"addTime":"1534262400000","pgcId":24,"title":"菜鸟阎王"},{"eggId":10,"userId":278,"name":"885bdb48不知南北找东西","type":2,"typeString":"打赏","amount":10,"addTime":"1534262400000","pgcId":24,"title":"菜鸟阎王"},{"eggId":11,"userId":278,"name":"885bdb48不知南北找东西","type":2,"typeString":"打赏","amount":10,"addTime":"1534262400000","pgcId":24,"title":"菜鸟阎王"},{"eggId":12,"userId":278,"name":"885bdb48不知南北找东西","type":2,"typeString":"打赏","amount":10,"addTime":"1534262400000","pgcId":24,"title":"菜鸟阎王"},{"eggId":13,"userId":278,"name":"885bdb48不知南北找东西","type":2,"typeString":"打赏","amount":10,"addTime":"1534262400000","pgcId":24,"title":"菜鸟阎王"},{"eggId":14,"userId":278,"name":"885bdb48不知南北找东西","type":2,"typeString":"打赏","amount":10,"addTime":"1534262400000","pgcId":24,"title":"菜鸟阎王"},{"eggId":15,"userId":278,"name":"885bdb48不知南北找东西","type":2,"typeString":"打赏","amount":10,"addTime":"1534262400000","pgcId":24,"title":"菜鸟阎王"},{"eggId":16,"userId":278,"name":"885bdb48不知南北找东西","type":2,"typeString":"打赏","amount":10,"addTime":"1534262400000","pgcId":24,"title":"菜鸟阎王"},{"eggId":17,"userId":278,"name":"885bdb48不知南北找东西","type":2,"typeString":"打赏","amount":10,"addTime":"1534262400000","pgcId":24,"title":"菜鸟阎王"},{"eggId":20,"userId":278,"name":"885bdb48不知南北找东西","type":2,"typeString":"打赏","amount":10,"addTime":"1534262400000","pgcId":24,"title":"菜鸟阎王"},{"eggId":21,"userId":278,"name":"885bdb48不知南北找东西","type":2,"typeString":"打赏","amount":10,"addTime":"1534435200000","pgcId":24,"title":"菜鸟阎王"}]
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
             * eggId : 1
             * userId : 272
             * name : 文
             * type : 3
             * typeString : 打赏
             * amount : 10
             * addTime : 1534176000000
             * pgcId : null
             * title : null
             */

            private int eggId;
            private int userId;
            private String name;
            private int type;
            private String typeString;
            private int amount;
            private String addTime;
            private Object pgcId;
            private Object title;

            public int getEggId() {
                return eggId;
            }

            public void setEggId(int eggId) {
                this.eggId = eggId;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getTypeString() {
                return typeString;
            }

            public void setTypeString(String typeString) {
                this.typeString = typeString;
            }

            public int getAmount() {
                return amount;
            }

            public void setAmount(int amount) {
                this.amount = amount;
            }

            public String getAddTime() {
                return addTime;
            }

            public void setAddTime(String addTime) {
                this.addTime = addTime;
            }

            public Object getPgcId() {
                return pgcId;
            }

            public void setPgcId(Object pgcId) {
                this.pgcId = pgcId;
            }

            public Object getTitle() {
                return title;
            }

            public void setTitle(Object title) {
                this.title = title;
            }
        }
    }
}
