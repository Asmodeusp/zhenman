package com.zhenman.asus.zhenman.model.bean;

import java.util.List;

public class SerializationDetailsBean {


    /**
     * state : 0
     * msg : 成功
     * data : {"catalogId":"88","title":"深宫遗梦","imageUrl":"https://image.zhenmanapp.com/ZMAUTHOR/1541658863060/a.jpg","tag":"言情","introduction":"姐妹深情终抵不过男女之情，嫣儿告密，莫南被阉，云姬被迫入宫。而宫墙深围太妃当道，嫣儿主仆情深誓死力保云姬上演腹黑女上位，却不知悉数掌控的云姬与奸臣李鹤早已暗通曲款，设下了阴谋圈套，绊倒了权力之上的所有人。步步为营的线索将矛头都指向了嫣儿，而结局李鹤的出现让剧情惊天反转，欲望驱使阴谋，肉欲支配情感，尔虞我诈的背后到底是友情还是爱？深宫遗梦 [3]  的悲情梦魇正在讲述\u2026\u2026","chapterSort":"1","collect":false,"openAuto":false,"catalogNum":6,"actorList":[{"name":"测试托管2","headImg":"https://image.zhenmanapp.com/ZMAUTHOR/1541730190690/a.jpg","tagName":"演员","userId":"255","follow":false},{"name":"测试托管2","headImg":"https://image.zhenmanapp.com/ZMAUTHOR/1541730190690/a.jpg","tagName":"演员","userId":"255","follow":false},{"name":"测试托管2","headImg":"https://image.zhenmanapp.com/ZMAUTHOR/1541730190690/a.jpg","tagName":"演员","userId":"255","follow":false},{"name":"不知南北找东西","headImg":"http://pa1qj1jlg.bkt.clouddn.com/headImage/57522467e21a4e3aa04e3d8e06a3ef15_","tagName":"演员","userId":"258","follow":false},{"name":"ଲ 猜","headImg":"http://pa1qj1jlg.bkt.clouddn.com/headImage/7e55b65f5fee47ccb66a8f2f209e5f67_","tagName":"演员","userId":"260","follow":false},{"name":"meka","headImg":"http://pa1qj1jlg.bkt.clouddn.com/headImage/54cf2c3e45ea4cfeaeb81acbff72fe0b_","tagName":"演员","userId":"262","follow":false},{"name":"11-10 1857","headImg":"https://image.zhenmanapp.com/ZMAUTHOR/1541993384734/5f5b.jpg","tagName":"演员","userId":"424","follow":false}]}
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
         * catalogId : 88
         * title : 深宫遗梦
         * imageUrl : https://image.zhenmanapp.com/ZMAUTHOR/1541658863060/a.jpg
         * tag : 言情
         * introduction : 姐妹深情终抵不过男女之情，嫣儿告密，莫南被阉，云姬被迫入宫。而宫墙深围太妃当道，嫣儿主仆情深誓死力保云姬上演腹黑女上位，却不知悉数掌控的云姬与奸臣李鹤早已暗通曲款，设下了阴谋圈套，绊倒了权力之上的所有人。步步为营的线索将矛头都指向了嫣儿，而结局李鹤的出现让剧情惊天反转，欲望驱使阴谋，肉欲支配情感，尔虞我诈的背后到底是友情还是爱？深宫遗梦 [3]  的悲情梦魇正在讲述……
         * chapterSort : 1
         * collect : false
         * openAuto : false
         * catalogNum : 6
         * actorList : [{"name":"测试托管2","headImg":"https://image.zhenmanapp.com/ZMAUTHOR/1541730190690/a.jpg","tagName":"演员","userId":"255","follow":false},{"name":"测试托管2","headImg":"https://image.zhenmanapp.com/ZMAUTHOR/1541730190690/a.jpg","tagName":"演员","userId":"255","follow":false},{"name":"测试托管2","headImg":"https://image.zhenmanapp.com/ZMAUTHOR/1541730190690/a.jpg","tagName":"演员","userId":"255","follow":false},{"name":"不知南北找东西","headImg":"http://pa1qj1jlg.bkt.clouddn.com/headImage/57522467e21a4e3aa04e3d8e06a3ef15_","tagName":"演员","userId":"258","follow":false},{"name":"ଲ 猜","headImg":"http://pa1qj1jlg.bkt.clouddn.com/headImage/7e55b65f5fee47ccb66a8f2f209e5f67_","tagName":"演员","userId":"260","follow":false},{"name":"meka","headImg":"http://pa1qj1jlg.bkt.clouddn.com/headImage/54cf2c3e45ea4cfeaeb81acbff72fe0b_","tagName":"演员","userId":"262","follow":false},{"name":"11-10 1857","headImg":"https://image.zhenmanapp.com/ZMAUTHOR/1541993384734/5f5b.jpg","tagName":"演员","userId":"424","follow":false}]
         */

        private String catalogId;
        private String title;
        private String imageUrl;
        private String tag;
        private String introduction;
        private String chapterSort;
        private boolean collect;
        private boolean openAuto;
        private int catalogNum;
        private List<ActorListBean> actorList;

        public String getCatalogId() {
            return catalogId;
        }

        public void setCatalogId(String catalogId) {
            this.catalogId = catalogId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getIntroduction() {
            return introduction;
        }

        public void setIntroduction(String introduction) {
            this.introduction = introduction;
        }

        public String getChapterSort() {
            return chapterSort;
        }

        public void setChapterSort(String chapterSort) {
            this.chapterSort = chapterSort;
        }

        public boolean isCollect() {
            return collect;
        }

        public void setCollect(boolean collect) {
            this.collect = collect;
        }

        public boolean isOpenAuto() {
            return openAuto;
        }

        public void setOpenAuto(boolean openAuto) {
            this.openAuto = openAuto;
        }

        public int getCatalogNum() {
            return catalogNum;
        }

        public void setCatalogNum(int catalogNum) {
            this.catalogNum = catalogNum;
        }

        public List<ActorListBean> getActorList() {
            return actorList;
        }

        public void setActorList(List<ActorListBean> actorList) {
            this.actorList = actorList;
        }

        public static class ActorListBean {
            /**
             * name : 测试托管2
             * headImg : https://image.zhenmanapp.com/ZMAUTHOR/1541730190690/a.jpg
             * tagName : 演员
             * userId : 255
             * follow : false
             */

            private String name;
            private String headImg;
            private String tagName;
            private String userId;
            private boolean follow;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getHeadImg() {
                return headImg;
            }

            public void setHeadImg(String headImg) {
                this.headImg = headImg;
            }

            public String getTagName() {
                return tagName;
            }

            public void setTagName(String tagName) {
                this.tagName = tagName;
            }

            public String getUserId() {
                return userId;
            }

            public void setUserId(String userId) {
                this.userId = userId;
            }

            public boolean isFollow() {
                return follow;
            }

            public void setFollow(boolean follow) {
                this.follow = follow;
            }
        }
    }
}
