package com.zhenman.asus.zhenman.model.bean;

import java.util.List;

public class ByRewardedBean {


    /**
     * state : 0
     * msg : 成功
     * data : [{"userId":"299","name":"dsaf","addTime":"1540954215000","headImg":"http://pa1qj1jlg.bkt.clouddn.com/headImage/dedd9c65a9f64d039cccbc9adacfd8ef_809476-20170525194948388-774343317.png?imageMogr2/thumbnail/200x200","finalImg":"","coinAmount":"3","title":"","eggplantType":"3","read":0,"type":3,"catalogId":0,"titleDto":{"text":"@dsaf打赏了你3个未成熟的茄子","textExtra":[{"start":0,"length":5,"id":"299","text":"@dsaf","textType":1,"link":null},{"start":9,"length":8,"id":null,"text":"3个未成熟的茄子","textType":0,"link":null}]}},{"userId":"299","name":"dsaf","addTime":"1540954192000","headImg":"http://pa1qj1jlg.bkt.clouddn.com/headImage/dedd9c65a9f64d039cccbc9adacfd8ef_809476-20170525194948388-774343317.png?imageMogr2/thumbnail/200x200","finalImg":"http://pa1qj1jlg.bkt.clouddn.com/pgc/竖版封面图_菜鸟阎王.jpg_1532695077877?imageMogr2/crop/630.0x831.0/thumbnail/432x569.8285714285714","coinAmount":"2","title":"菜鸟阎王","eggplantType":"3","read":0,"type":2,"catalogId":65,"titleDto":{"text":"@dsaf在<<菜鸟阎王>>中打赏了你2个未成熟的茄子","textExtra":[{"start":0,"length":5,"id":"299","text":"@dsaf","textType":1,"link":null},{"start":19,"length":8,"id":null,"text":"2个未成熟的茄子","textType":0,"link":null}]}}]
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
         * userId : 299
         * name : dsaf
         * addTime : 1540954215000
         * headImg : http://pa1qj1jlg.bkt.clouddn.com/headImage/dedd9c65a9f64d039cccbc9adacfd8ef_809476-20170525194948388-774343317.png?imageMogr2/thumbnail/200x200
         * finalImg :
         * coinAmount : 3
         * title :
         * eggplantType : 3
         * read : 0
         * type : 3
         * catalogId : 0
         * titleDto : {"text":"@dsaf打赏了你3个未成熟的茄子","textExtra":[{"start":0,"length":5,"id":"299","text":"@dsaf","textType":1,"link":null},{"start":9,"length":8,"id":null,"text":"3个未成熟的茄子","textType":0,"link":null}]}
         */

        private String userId;
        private String name;
        private String addTime;
        private String headImg;
        private String finalImg;
        private String coinAmount;
        private String title;
        private String eggplantType;
        private int read;
        private int type;
        private int catalogId;
        private TitleDtoBean titleDto;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddTime() {
            return addTime;
        }

        public void setAddTime(String addTime) {
            this.addTime = addTime;
        }

        public String getHeadImg() {
            return headImg;
        }

        public void setHeadImg(String headImg) {
            this.headImg = headImg;
        }

        public String getFinalImg() {
            return finalImg;
        }

        public void setFinalImg(String finalImg) {
            this.finalImg = finalImg;
        }

        public String getCoinAmount() {
            return coinAmount;
        }

        public void setCoinAmount(String coinAmount) {
            this.coinAmount = coinAmount;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getEggplantType() {
            return eggplantType;
        }

        public void setEggplantType(String eggplantType) {
            this.eggplantType = eggplantType;
        }

        public int getRead() {
            return read;
        }

        public void setRead(int read) {
            this.read = read;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getCatalogId() {
            return catalogId;
        }

        public void setCatalogId(int catalogId) {
            this.catalogId = catalogId;
        }

        public TitleDtoBean getTitleDto() {
            return titleDto;
        }

        public void setTitleDto(TitleDtoBean titleDto) {
            this.titleDto = titleDto;
        }

        public static class TitleDtoBean {
            /**
             * text : @dsaf打赏了你3个未成熟的茄子
             * textExtra : [{"start":0,"length":5,"id":"299","text":"@dsaf","textType":1,"link":null},{"start":9,"length":8,"id":null,"text":"3个未成熟的茄子","textType":0,"link":null}]
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
    }
}
