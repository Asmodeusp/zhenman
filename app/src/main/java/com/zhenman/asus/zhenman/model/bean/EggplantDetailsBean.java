package com.zhenman.asus.zhenman.model.bean;

import java.io.Serializable;
import java.util.List;

public class EggplantDetailsBean {

    /**
     * state : 0
     * msg : 成功
     * data : [{"eggId":2,"userId":1,"name":"5","chapterSort":null,"chapterTitle":null,"type":4,"typeString":"0","amount":3,"addTime":"1540546564000","titleDto":{"text":"本次共计打包卖出6个茄子,收益3.90元，卖向支付宝。查看详情","textExtra":[{"start":27,"length":4,"id":"1","text":"查看详情","textType":1,"link":null}]},"detailDto":{"unripeEggplantAmount":"0","biteEggplantAmount":"5","eggplantAmount":"1","sellTo":2,"total":6,"amount":3.9,"addTime":"1540546564000"}}]
     */

    private int state;
    private String msg;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * eggId : 2
         * userId : 1
         * name : 5
         * chapterSort : null
         * chapterTitle : null
         * type : 4
         * typeString : 0
         * amount : 3
         * addTime : 1540546564000
         * titleDto : {"text":"本次共计打包卖出6个茄子,收益3.90元，卖向支付宝。查看详情","textExtra":[{"start":27,"length":4,"id":"1","text":"查看详情","textType":1,"link":null}]}
         * detailDto : {"unripeEggplantAmount":"0","biteEggplantAmount":"5","eggplantAmount":"1","sellTo":2,"total":6,"amount":3.9,"addTime":"1540546564000"}
         */

        private int eggId;
        private int userId;
        private String name;
        private Object chapterSort;
        private Object chapterTitle;
        private int type;
        private String typeString;
        private int amount;
        private String addTime;
        private TitleDtoBean titleDto;
        private DetailDtoBean detailDto;

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

        public Object getChapterSort() {
            return chapterSort;
        }

        public void setChapterSort(Object chapterSort) {
            this.chapterSort = chapterSort;
        }

        public Object getChapterTitle() {
            return chapterTitle;
        }

        public void setChapterTitle(Object chapterTitle) {
            this.chapterTitle = chapterTitle;
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

        public TitleDtoBean getTitleDto() {
            return titleDto;
        }

        public void setTitleDto(TitleDtoBean titleDto) {
            this.titleDto = titleDto;
        }

        public DetailDtoBean getDetailDto() {
            return detailDto;
        }

        public void setDetailDto(DetailDtoBean detailDto) {
            this.detailDto = detailDto;
        }

        public static class TitleDtoBean {
            /**
             * text : 本次共计打包卖出6个茄子,收益3.90元，卖向支付宝。查看详情
             * textExtra : [{"start":27,"length":4,"id":"1","text":"查看详情","textType":1,"link":null}]
             */

            private String text;
            private List<TextExtraBean> textExtra;

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public List<TextExtraBean> getTextExtra() {
                return textExtra;
            }

            public void setTextExtra(List<TextExtraBean> textExtra) {
                this.textExtra = textExtra;
            }

        }

        public static class DetailDtoBean implements Serializable {
            /**
             * unripeEggplantAmount : 0
             * biteEggplantAmount : 5
             * eggplantAmount : 1
             * sellTo : 2
             * total : 6
             * amount : 3.9
             * addTime : 1540546564000
             */

            private String unripeEggplantAmount;
            private String biteEggplantAmount;
            private String eggplantAmount;
            private int sellTo;
            private int total;
            private double amount;
            private String addTime;

            public String getUnripeEggplantAmount() {
                return unripeEggplantAmount;
            }

            public void setUnripeEggplantAmount(String unripeEggplantAmount) {
                this.unripeEggplantAmount = unripeEggplantAmount;
            }

            public String getBiteEggplantAmount() {
                return biteEggplantAmount;
            }

            public void setBiteEggplantAmount(String biteEggplantAmount) {
                this.biteEggplantAmount = biteEggplantAmount;
            }

            public String getEggplantAmount() {
                return eggplantAmount;
            }

            public void setEggplantAmount(String eggplantAmount) {
                this.eggplantAmount = eggplantAmount;
            }

            public int getSellTo() {
                return sellTo;
            }

            public void setSellTo(int sellTo) {
                this.sellTo = sellTo;
            }

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public double getAmount() {
                return amount;
            }

            public void setAmount(double amount) {
                this.amount = amount;
            }

            public String getAddTime() {
                return addTime;
            }

            public void setAddTime(String addTime) {
                this.addTime = addTime;
            }
        }
    }
}
