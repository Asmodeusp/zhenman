package com.zhenman.asus.zhenman.model.bean;

import java.util.List;

public class SerializationDetailsBean {

    /**
     * state : 0
     * msg : 成功
     * data : {"catalogId":"88","title":"深宫遗梦","imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/pgc/22222.jpg_1532234490692","tag":"言情,青春2","introduction":"姐妹深情终抵不过男女之情，嫣儿告密，莫南被阉，云姬被迫入宫。而宫墙深围太妃当道，嫣儿主仆情深誓死力保云姬上演腹黑女上位，却不知悉数掌控的云姬与奸臣李鹤早已暗通曲款，设下了阴谋圈套，绊倒了权力之上的所有人。步步为营的线索将矛头都指向了嫣儿，而结局李鹤的出现让剧情惊天反转，欲望驱使阴谋，肉欲支配情感，尔虞我诈的背后到底是友情还是爱？深宫遗梦 [3]  的悲情梦魇正在讲述\u2026\u2026","chapterSort":"1","collect":false,"actorList":[{"name":"绝版青春","headImg":"http://pa1qj1jlg.bkt.clouddn.com/headImage/eb34bd9db550436596bf29a4dadef13e_","tagName":"演员","userId":"255","follow":false}]}
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
         * imageUrl : http://pa1qj1jlg.bkt.clouddn.com/pgc/22222.jpg_1532234490692
         * tag : 言情,青春2
         * introduction : 姐妹深情终抵不过男女之情，嫣儿告密，莫南被阉，云姬被迫入宫。而宫墙深围太妃当道，嫣儿主仆情深誓死力保云姬上演腹黑女上位，却不知悉数掌控的云姬与奸臣李鹤早已暗通曲款，设下了阴谋圈套，绊倒了权力之上的所有人。步步为营的线索将矛头都指向了嫣儿，而结局李鹤的出现让剧情惊天反转，欲望驱使阴谋，肉欲支配情感，尔虞我诈的背后到底是友情还是爱？深宫遗梦 [3]  的悲情梦魇正在讲述……
         * chapterSort : 1
         * collect : false
         * actorList : [{"name":"绝版青春","headImg":"http://pa1qj1jlg.bkt.clouddn.com/headImage/eb34bd9db550436596bf29a4dadef13e_","tagName":"演员","userId":"255","follow":false}]
         */

        private String catalogId;
        private String title;
        private String imageUrl;
        private String tag;
        private String introduction;
        private String chapterSort;
        private boolean collect;
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

        public List<ActorListBean> getActorList() {
            return actorList;
        }

        public void setActorList(List<ActorListBean> actorList) {
            this.actorList = actorList;
        }

        public static class ActorListBean {
            /**
             * name : 绝版青春
             * headImg : http://pa1qj1jlg.bkt.clouddn.com/headImage/eb34bd9db550436596bf29a4dadef13e_
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
