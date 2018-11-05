package com.zhenman.asus.zhenman.model.bean;

import java.util.List;

public class ByLikeBean {

    /**
     * state : 0
     * msg : 成功
     * data : [{"userId":"398","name":"哈哈哈哈哈哈","addTime":"1539075909000","headImg":"http://pa1qj1jlg.bkt.clouddn.com/headImage/9ab1836c5af14cf49e6b91b8ba3f512b_?imageMogr2/thumbnail/200x200","finalImg":"http://pa1qj1jlg.bkt.clouddn.com/UGC/33ba2402ed4d4757921b7d01dbf5a1cd_UGCMainImg","productId":"513","content":null,"json":null,"type":1,"textDto":null,"titleDto":{"text":"@哈哈哈哈哈哈 赞了你的作品","textExtra":[{"start":0,"length":7,"id":"398","text":null,"textType":1,"link":null}]},"read":0},{"userId":"399","name":"King Prisoner","addTime":"1540282930000","headImg":"http://pa1qj1jlg.bkt.clouddn.com/headImage/78df02c80ca24c438c9f04febf6bb37d_?imageMogr2/thumbnail/200x200","finalImg":"http://pa1qj1jlg.bkt.clouddn.com/UGC/7e20904f0a6b423491d63783d9b9029b_UGCMainImg","productId":"709","content":null,"json":null,"type":1,"textDto":null,"titleDto":{"text":"@King Prisoner 赞了你的作品","textExtra":[{"start":0,"length":14,"id":"399","text":null,"textType":1,"link":null}]},"read":0},{"userId":"306","name":"432423","addTime":"1540549169000","headImg":"http://pa1qj1jlg.bkt.clouddn.com/headImage/94d8936576be447db4af912580b48987_?imageMogr2/thumbnail/200x200","finalImg":"http://pa1qj1jlg.bkt.clouddn.com/pgc/p2429522972.jpg_1532400520150?imageMogr2/crop/630.0x831.0/thumbnail/432x569.8285714285714","productId":"21","content":"➑➑➑","json":null,"type":3,"textDto":null,"titleDto":{"text":"@432423 赞了你的评论","textExtra":[{"start":0,"length":7,"id":"306","text":null,"textType":1,"link":null}]},"read":0},{"userId":"306","name":"432423","addTime":"1540957919000","headImg":"http://pa1qj1jlg.bkt.clouddn.com/headImage/94d8936576be447db4af912580b48987_?imageMogr2/thumbnail/200x200","finalImg":"http://pa1qj1jlg.bkt.clouddn.com/UGC/67e40e7a278c4b919520b4bd901864fd_UGCMainImg?imageMogr2/crop/750.0x1017.0/thumbnail/432x585.792","productId":"715","content":"The new version was great for my kids but it was fun for them hsbsqwthemforfunwasitbutkidsmyforgreatwasversionnewThe@哈哈哈哈哈哈 ","json":null,"type":2,"textDto":null,"titleDto":{"text":"@432423 赞了你的评论","textExtra":[{"start":0,"length":7,"id":"306","text":null,"textType":1,"link":null}]},"read":0},{"userId":"306","name":"432423","addTime":"1540957946000","headImg":"http://pa1qj1jlg.bkt.clouddn.com/headImage/94d8936576be447db4af912580b48987_?imageMogr2/thumbnail/200x200","finalImg":"http://pa1qj1jlg.bkt.clouddn.com/pgc/p2429522972.jpg_1532400520150?imageMogr2/crop/630.0x831.0/thumbnail/432x569.8285714285714","productId":"21","content":"➑➎➎➎➑","json":null,"type":3,"textDto":null,"titleDto":{"text":"@432423 赞了你的评论","textExtra":[{"start":0,"length":7,"id":"306","text":null,"textType":1,"link":null}]},"read":0},{"userId":"306","name":"432423","addTime":"1540958767000","headImg":"http://pa1qj1jlg.bkt.clouddn.com/headImage/94d8936576be447db4af912580b48987_?imageMogr2/thumbnail/200x200","finalImg":"http://pa1qj1jlg.bkt.clouddn.com/UGC/096cf1b6cf004f129fc027d49b63da62_UGCMainImg?imageMogr2/crop/750.0x1017.0/thumbnail/432x585.792","productId":"710","content":"➏➐➏➐➏","json":null,"type":2,"textDto":null,"titleDto":{"text":"@432423 赞了你的评论","textExtra":[{"start":0,"length":7,"id":"306","text":null,"textType":1,"link":null}]},"read":0},{"userId":"306","name":"432423","addTime":"1541068298000","headImg":"http://pa1qj1jlg.bkt.clouddn.com/headImage/94d8936576be447db4af912580b48987_?imageMogr2/thumbnail/200x200","finalImg":"http://pa1qj1jlg.bkt.clouddn.com/UGC/e9075367d21f40eaa17cfbf8c01b8fba_UGCMainImg?imageMogr2/crop/750.0x1017.0/thumbnail/432x585.792","productId":"717","content":"➑➎➎","json":null,"type":2,"textDto":null,"titleDto":{"text":"@432423 赞了你的评论","textExtra":[{"start":0,"length":7,"id":"306","text":null,"textType":1,"link":null}]},"read":0}]
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
         * userId : 398
         * name : 哈哈哈哈哈哈
         * addTime : 1539075909000
         * headImg : http://pa1qj1jlg.bkt.clouddn.com/headImage/9ab1836c5af14cf49e6b91b8ba3f512b_?imageMogr2/thumbnail/200x200
         * finalImg : http://pa1qj1jlg.bkt.clouddn.com/UGC/33ba2402ed4d4757921b7d01dbf5a1cd_UGCMainImg
         * productId : 513
         * content : null
         * json : null
         * type : 1
         * textDto : null
         * titleDto : {"text":"@哈哈哈哈哈哈 赞了你的作品","textExtra":[{"start":0,"length":7,"id":"398","text":null,"textType":1,"link":null}]}
         * read : 0
         */

        private String userId;
        private String name;
        private String addTime;
        private String headImg;
        private String finalImg;
        private String productId;
        private Object content;
        private Object json;
        private int type;
        private Object textDto;
        private TitleDtoBean titleDto;
        private int read;

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

        public String getProductId() {
            return productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }

        public Object getContent() {
            return content;
        }

        public void setContent(Object content) {
            this.content = content;
        }

        public Object getJson() {
            return json;
        }

        public void setJson(Object json) {
            this.json = json;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public Object getTextDto() {
            return textDto;
        }

        public void setTextDto(Object textDto) {
            this.textDto = textDto;
        }

        public TitleDtoBean getTitleDto() {
            return titleDto;
        }

        public void setTitleDto(TitleDtoBean titleDto) {
            this.titleDto = titleDto;
        }

        public int getRead() {
            return read;
        }

        public void setRead(int read) {
            this.read = read;
        }

        public static class TitleDtoBean {
            /**
             * text : @哈哈哈哈哈哈 赞了你的作品
             * textExtra : [{"start":0,"length":7,"id":"398","text":null,"textType":1,"link":null}]
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
