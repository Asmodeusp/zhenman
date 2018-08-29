package com.zhenman.asus.zhenman.model.bean;

public class MakeOrderBean {
    /**
     * state : 0
     * msg : 成功
     * data : {"id":64,"userId":299,"orderNumber":"ZM261535509846080","amount":1,"comment":"充值","createTime":"1535509846080","updateTime":"1535509846080","status":0,"type":1,"payFrom":null,"delFlag":0,"toUserId":262,"catalogId":66}
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
         * id : 64
         * userId : 299
         * orderNumber : ZM261535509846080
         * amount : 1
         * comment : 充值
         * createTime : 1535509846080
         * updateTime : 1535509846080
         * status : 0
         * type : 1
         * payFrom : null
         * delFlag : 0
         * toUserId : 262
         * catalogId : 66
         */

        private int id;
        private int userId;
        private String orderNumber;
        private int amount;
        private String comment;
        private String createTime;
        private String updateTime;
        private int status;
        private int type;
        private Object payFrom;
        private int delFlag;
        private int toUserId;
        private int catalogId;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getOrderNumber() {
            return orderNumber;
        }

        public void setOrderNumber(String orderNumber) {
            this.orderNumber = orderNumber;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public Object getPayFrom() {
            return payFrom;
        }

        public void setPayFrom(Object payFrom) {
            this.payFrom = payFrom;
        }

        public int getDelFlag() {
            return delFlag;
        }

        public void setDelFlag(int delFlag) {
            this.delFlag = delFlag;
        }

        public int getToUserId() {
            return toUserId;
        }

        public void setToUserId(int toUserId) {
            this.toUserId = toUserId;
        }

        public int getCatalogId() {
            return catalogId;
        }

        public void setCatalogId(int catalogId) {
            this.catalogId = catalogId;
        }
    }


    /*  *//**
     * state : 0
     * msg : 成功
     * data : {"id":17,"userId":299,"orderNumber":"ZM301535354525552","amount":3,"comment":null,"createTime":{"nano":552000000,"hour":15,"minute":22,"second":5,"year":2018,"month":"AUGUST","dayOfMonth":27,"dayOfWeek":"MONDAY","dayOfYear":239,"monthValue":8,"chronology":{"calendarType":"iso8601","id":"ISO"}},"updateTime":{"nano":552000000,"hour":15,"minute":22,"second":5,"year":2018,"month":"AUGUST","dayOfMonth":27,"dayOfWeek":"MONDAY","dayOfYear":239,"monthValue":8,"chronology":{"calendarType":"iso8601","id":"ISO"}},"status":0,"type":1,"payFrom":null,"delFlag":0,"toUserId":262,"catalogId":66}
     *//*

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
        *//**
         * id : 17
         * userId : 299
         * orderNumber : ZM301535354525552
         * amount : 3
         * comment : null
         * createTime : {"nano":552000000,"hour":15,"minute":22,"second":5,"year":2018,"month":"AUGUST","dayOfMonth":27,"dayOfWeek":"MONDAY","dayOfYear":239,"monthValue":8,"chronology":{"calendarType":"iso8601","id":"ISO"}}
         * updateTime : {"nano":552000000,"hour":15,"minute":22,"second":5,"year":2018,"month":"AUGUST","dayOfMonth":27,"dayOfWeek":"MONDAY","dayOfYear":239,"monthValue":8,"chronology":{"calendarType":"iso8601","id":"ISO"}}
         * status : 0
         * type : 1
         * payFrom : null
         * delFlag : 0
         * toUserId : 262
         * catalogId : 66
         *//*

        private int id;
        private int userId;
        private String orderNumber;
        private int amount;
        private Object comment;
        private CreateTimeBean createTime;
        private UpdateTimeBean updateTime;
        private int status;
        private int type;
        private Object payFrom;
        private int delFlag;
        private int toUserId;
        private int catalogId;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getOrderNumber() {
            return orderNumber;
        }

        public void setOrderNumber(String orderNumber) {
            this.orderNumber = orderNumber;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public Object getComment() {
            return comment;
        }

        public void setComment(Object comment) {
            this.comment = comment;
        }

        public CreateTimeBean getCreateTime() {
            return createTime;
        }

        public void setCreateTime(CreateTimeBean createTime) {
            this.createTime = createTime;
        }

        public UpdateTimeBean getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(UpdateTimeBean updateTime) {
            this.updateTime = updateTime;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public Object getPayFrom() {
            return payFrom;
        }

        public void setPayFrom(Object payFrom) {
            this.payFrom = payFrom;
        }

        public int getDelFlag() {
            return delFlag;
        }

        public void setDelFlag(int delFlag) {
            this.delFlag = delFlag;
        }

        public int getToUserId() {
            return toUserId;
        }

        public void setToUserId(int toUserId) {
            this.toUserId = toUserId;
        }

        public int getCatalogId() {
            return catalogId;
        }

        public void setCatalogId(int catalogId) {
            this.catalogId = catalogId;
        }

        public static class CreateTimeBean {
            *//**
             * nano : 552000000
             * hour : 15
             * minute : 22
             * second : 5
             * year : 2018
             * month : AUGUST
             * dayOfMonth : 27
             * dayOfWeek : MONDAY
             * dayOfYear : 239
             * monthValue : 8
             * chronology : {"calendarType":"iso8601","id":"ISO"}
             *//*

            private int nano;
            private int hour;
            private int minute;
            private int second;
            private int year;
            private String month;
            private int dayOfMonth;
            private String dayOfWeek;
            private int dayOfYear;
            private int monthValue;
            private ChronologyBean chronology;

            public int getNano() {
                return nano;
            }

            public void setNano(int nano) {
                this.nano = nano;
            }

            public int getHour() {
                return hour;
            }

            public void setHour(int hour) {
                this.hour = hour;
            }

            public int getMinute() {
                return minute;
            }

            public void setMinute(int minute) {
                this.minute = minute;
            }

            public int getSecond() {
                return second;
            }

            public void setSecond(int second) {
                this.second = second;
            }

            public int getYear() {
                return year;
            }

            public void setYear(int year) {
                this.year = year;
            }

            public String getMonth() {
                return month;
            }

            public void setMonth(String month) {
                this.month = month;
            }

            public int getDayOfMonth() {
                return dayOfMonth;
            }

            public void setDayOfMonth(int dayOfMonth) {
                this.dayOfMonth = dayOfMonth;
            }

            public String getDayOfWeek() {
                return dayOfWeek;
            }

            public void setDayOfWeek(String dayOfWeek) {
                this.dayOfWeek = dayOfWeek;
            }

            public int getDayOfYear() {
                return dayOfYear;
            }

            public void setDayOfYear(int dayOfYear) {
                this.dayOfYear = dayOfYear;
            }

            public int getMonthValue() {
                return monthValue;
            }

            public void setMonthValue(int monthValue) {
                this.monthValue = monthValue;
            }

            public ChronologyBean getChronology() {
                return chronology;
            }

            public void setChronology(ChronologyBean chronology) {
                this.chronology = chronology;
            }

            public static class ChronologyBean {
                *//**
                 * calendarType : iso8601
                 * id : ISO
                 *//*

                private String calendarType;
                private String id;

                public String getCalendarType() {
                    return calendarType;
                }

                public void setCalendarType(String calendarType) {
                    this.calendarType = calendarType;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }
            }
        }

        public static class UpdateTimeBean {
            *//**
             * nano : 552000000
             * hour : 15
             * minute : 22
             * second : 5
             * year : 2018
             * month : AUGUST
             * dayOfMonth : 27
             * dayOfWeek : MONDAY
             * dayOfYear : 239
             * monthValue : 8
             * chronology : {"calendarType":"iso8601","id":"ISO"}
             *//*

            private int nano;
            private int hour;
            private int minute;
            private int second;
            private int year;
            private String month;
            private int dayOfMonth;
            private String dayOfWeek;
            private int dayOfYear;
            private int monthValue;
            private ChronologyBeanX chronology;

            public int getNano() {
                return nano;
            }

            public void setNano(int nano) {
                this.nano = nano;
            }

            public int getHour() {
                return hour;
            }

            public void setHour(int hour) {
                this.hour = hour;
            }

            public int getMinute() {
                return minute;
            }

            public void setMinute(int minute) {
                this.minute = minute;
            }

            public int getSecond() {
                return second;
            }

            public void setSecond(int second) {
                this.second = second;
            }

            public int getYear() {
                return year;
            }

            public void setYear(int year) {
                this.year = year;
            }

            public String getMonth() {
                return month;
            }

            public void setMonth(String month) {
                this.month = month;
            }

            public int getDayOfMonth() {
                return dayOfMonth;
            }

            public void setDayOfMonth(int dayOfMonth) {
                this.dayOfMonth = dayOfMonth;
            }

            public String getDayOfWeek() {
                return dayOfWeek;
            }

            public void setDayOfWeek(String dayOfWeek) {
                this.dayOfWeek = dayOfWeek;
            }

            public int getDayOfYear() {
                return dayOfYear;
            }

            public void setDayOfYear(int dayOfYear) {
                this.dayOfYear = dayOfYear;
            }

            public int getMonthValue() {
                return monthValue;
            }

            public void setMonthValue(int monthValue) {
                this.monthValue = monthValue;
            }

            public ChronologyBeanX getChronology() {
                return chronology;
            }

            public void setChronology(ChronologyBeanX chronology) {
                this.chronology = chronology;
            }

            public static class ChronologyBeanX {
                *//**
                 * calendarType : iso8601
                 * id : ISO
                 *//*

                private String calendarType;
                private String id;

                public String getCalendarType() {
                    return calendarType;
                }

                public void setCalendarType(String calendarType) {
                    this.calendarType = calendarType;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }
            }
        }
    }*/

}
