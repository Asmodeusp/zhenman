package com.zhenman.asus.zhenman.model.bean;

import java.util.List;

public class SerializationCatalogReadBean {


    /**
     * state : 0
     * msg : 成功
     * data : {"pgcChapterInfoDto":{"pre":false,"preId":null,"next":false,"nextId":null,"share":false,"collect":true,"end":false,"actorList":[{"name":"45ab5abb","headImg":null,"tagName":"导演","userId":"259","follow":false}]},"pgcCommentListByChapterId":[{"commentId":"328","content":"➐➒➒➎➎➒➑➑➎➑","catalogId":"92","userId":"407","likeNum":0,"like":false,"detailNum":0,"addTime":"1542097591000","author":false,"reUserId":null,"reContent":null,"reName":null,"reAuthor":false,"imageUrl":null,"name":"用户407","detailId":null,"title":null,"roleNameList":null,"chapterSort":null,"json":"{\"text\":\"➐➒➒➎➎➒➑➑➎➑\",\"textExtra\":[]}","textDto":null,"titleDto":null,"commentDtoList":null},{"commentId":"329","content":"➑➑➑➎","catalogId":"92","userId":"407","likeNum":0,"like":false,"detailNum":0,"addTime":"1542097616000","author":false,"reUserId":null,"reContent":null,"reName":null,"reAuthor":false,"imageUrl":null,"name":"用户407","detailId":null,"title":null,"roleNameList":null,"chapterSort":null,"json":"{\"text\":\"➑➑➑➎\",\"textExtra\":[]}","textDto":null,"titleDto":null,"commentDtoList":null}],"catalogPayInfo":{"catalogId":"92","pgcId":"37","title":"第1话  第1话","chapterSort":1,"isFree":2,"isPaid":2,"coinAmount":100,"amount":null,"exemption":0,"openAuto":false,"commentNum":2,"startPayCatalog":null,"freeEndCatalog":null,"defaultCatalogAmount":null,"shareImage":null,"type":7},"transfer":[{"imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/catalog/p1.jpg_1532753646408?imageMogr2/crop/!800.0x640.0a0a0.0","width":"800.0","height":"640.0"},{"imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/catalog/p1.jpg_1532753646408?imageMogr2/crop/!800.0x640.0a0a640.0","width":"800.0","height":"640.0"},{"imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/catalog/p1.jpg_1532753646408?imageMogr2/crop/!800.0x1082.0a0a1280.0","width":"800.0","height":"1082.0"}]}
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
         * pgcChapterInfoDto : {"pre":false,"preId":null,"next":false,"nextId":null,"share":false,"collect":true,"end":false,"actorList":[{"name":"45ab5abb","headImg":null,"tagName":"导演","userId":"259","follow":false}]}
         * pgcCommentListByChapterId : [{"commentId":"328","content":"➐➒➒➎➎➒➑➑➎➑","catalogId":"92","userId":"407","likeNum":0,"like":false,"detailNum":0,"addTime":"1542097591000","author":false,"reUserId":null,"reContent":null,"reName":null,"reAuthor":false,"imageUrl":null,"name":"用户407","detailId":null,"title":null,"roleNameList":null,"chapterSort":null,"json":"{\"text\":\"➐➒➒➎➎➒➑➑➎➑\",\"textExtra\":[]}","textDto":null,"titleDto":null,"commentDtoList":null},{"commentId":"329","content":"➑➑➑➎","catalogId":"92","userId":"407","likeNum":0,"like":false,"detailNum":0,"addTime":"1542097616000","author":false,"reUserId":null,"reContent":null,"reName":null,"reAuthor":false,"imageUrl":null,"name":"用户407","detailId":null,"title":null,"roleNameList":null,"chapterSort":null,"json":"{\"text\":\"➑➑➑➎\",\"textExtra\":[]}","textDto":null,"titleDto":null,"commentDtoList":null}]
         * catalogPayInfo : {"catalogId":"92","pgcId":"37","title":"第1话  第1话","chapterSort":1,"isFree":2,"isPaid":2,"coinAmount":100,"amount":null,"exemption":0,"openAuto":false,"commentNum":2,"startPayCatalog":null,"freeEndCatalog":null,"defaultCatalogAmount":null,"shareImage":null,"type":7}
         * transfer : [{"imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/catalog/p1.jpg_1532753646408?imageMogr2/crop/!800.0x640.0a0a0.0","width":"800.0","height":"640.0"},{"imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/catalog/p1.jpg_1532753646408?imageMogr2/crop/!800.0x640.0a0a640.0","width":"800.0","height":"640.0"},{"imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/catalog/p1.jpg_1532753646408?imageMogr2/crop/!800.0x1082.0a0a1280.0","width":"800.0","height":"1082.0"}]
         */

        private PgcChapterInfoDtoBean pgcChapterInfoDto;
        private CatalogPayInfoBean catalogPayInfo;
        private List<CommentDtoListBean> pgcCommentListByChapterId;
        private List<TransferBean> transfer;

        public PgcChapterInfoDtoBean getPgcChapterInfoDto() {
            return pgcChapterInfoDto;
        }

        public void setPgcChapterInfoDto(PgcChapterInfoDtoBean pgcChapterInfoDto) {
            this.pgcChapterInfoDto = pgcChapterInfoDto;
        }

        public CatalogPayInfoBean getCatalogPayInfo() {
            return catalogPayInfo;
        }

        public void setCatalogPayInfo(CatalogPayInfoBean catalogPayInfo) {
            this.catalogPayInfo = catalogPayInfo;
        }

        public List<CommentDtoListBean> getPgcCommentListByChapterId() {
            return pgcCommentListByChapterId;
        }

        public void setPgcCommentListByChapterId(List<CommentDtoListBean> pgcCommentListByChapterId) {
            this.pgcCommentListByChapterId = pgcCommentListByChapterId;
        }

        public List<TransferBean> getTransfer() {
            return transfer;
        }

        public void setTransfer(List<TransferBean> transfer) {
            this.transfer = transfer;
        }

        public static class PgcChapterInfoDtoBean {
            /**
             * pre : false
             * preId : null
             * next : false
             * nextId : null
             * share : false
             * collect : true
             * end : false
             * actorList : [{"name":"45ab5abb","headImg":null,"tagName":"导演","userId":"259","follow":false}]
             */

            private boolean pre;
            private Object preId;
            private boolean next;
            private Object nextId;
            private boolean share;
            private boolean collect;
            private boolean end;
            private List<ActorListBean> actorList;

            public boolean isPre() {
                return pre;
            }

            public void setPre(boolean pre) {
                this.pre = pre;
            }

            public Object getPreId() {
                return preId;
            }

            public void setPreId(Object preId) {
                this.preId = preId;
            }

            public boolean isNext() {
                return next;
            }

            public void setNext(boolean next) {
                this.next = next;
            }

            public Object getNextId() {
                return nextId;
            }

            public void setNextId(Object nextId) {
                this.nextId = nextId;
            }

            public boolean isShare() {
                return share;
            }

            public void setShare(boolean share) {
                this.share = share;
            }

            public boolean isCollect() {
                return collect;
            }

            public void setCollect(boolean collect) {
                this.collect = collect;
            }

            public boolean isEnd() {
                return end;
            }

            public void setEnd(boolean end) {
                this.end = end;
            }

            public List<ActorListBean> getActorList() {
                return actorList;
            }

            public void setActorList(List<ActorListBean> actorList) {
                this.actorList = actorList;
            }

            public static class ActorListBean {
                /**
                 * name : 45ab5abb
                 * headImg : null
                 * tagName : 导演
                 * userId : 259
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

        public static class CatalogPayInfoBean {
            /**
             * catalogId : 92
             * pgcId : 37
             * title : 第1话  第1话
             * chapterSort : 1
             * isFree : 2
             * isPaid : 2
             * coinAmount : 100
             * amount : null
             * exemption : 0
             * openAuto : false
             * commentNum : 2
             * startPayCatalog : null
             * freeEndCatalog : null
             * defaultCatalogAmount : null
             * shareImage : null
             * type : 7
             */

            private String catalogId;
            private String pgcId;
            private String title;
            private int chapterSort;
            private int isFree;
            private int isPaid;
            private int coinAmount;
            private int amount;
            private int exemption;
            private boolean openAuto;
            private int commentNum;
            private Object startPayCatalog;
            private Object freeEndCatalog;
            private Object defaultCatalogAmount;
            private Object shareImage;
            private int type;

            public String getCatalogId() {
                return catalogId;
            }

            public void setCatalogId(String catalogId) {
                this.catalogId = catalogId;
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

            public int getChapterSort() {
                return chapterSort;
            }

            public void setChapterSort(int chapterSort) {
                this.chapterSort = chapterSort;
            }

            public int getIsFree() {
                return isFree;
            }

            public void setIsFree(int isFree) {
                this.isFree = isFree;
            }

            public int getIsPaid() {
                return isPaid;
            }

            public void setIsPaid(int isPaid) {
                this.isPaid = isPaid;
            }

            public int getCoinAmount() {
                return coinAmount;
            }

            public void setCoinAmount(int coinAmount) {
                this.coinAmount = coinAmount;
            }

            public int getAmount() {
                return amount;
            }

            public void setAmount(int amount) {
                this.amount = amount;
            }

            public int getExemption() {
                return exemption;
            }

            public void setExemption(int exemption) {
                this.exemption = exemption;
            }

            public boolean isOpenAuto() {
                return openAuto;
            }

            public void setOpenAuto(boolean openAuto) {
                this.openAuto = openAuto;
            }

            public int getCommentNum() {
                return commentNum;
            }

            public void setCommentNum(int commentNum) {
                this.commentNum = commentNum;
            }

            public Object getStartPayCatalog() {
                return startPayCatalog;
            }

            public void setStartPayCatalog(Object startPayCatalog) {
                this.startPayCatalog = startPayCatalog;
            }

            public Object getFreeEndCatalog() {
                return freeEndCatalog;
            }

            public void setFreeEndCatalog(Object freeEndCatalog) {
                this.freeEndCatalog = freeEndCatalog;
            }

            public Object getDefaultCatalogAmount() {
                return defaultCatalogAmount;
            }

            public void setDefaultCatalogAmount(Object defaultCatalogAmount) {
                this.defaultCatalogAmount = defaultCatalogAmount;
            }

            public Object getShareImage() {
                return shareImage;
            }

            public void setShareImage(Object shareImage) {
                this.shareImage = shareImage;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }
        }


        public static class TransferBean {
            /**
             * imageUrl : http://pa1qj1jlg.bkt.clouddn.com/catalog/p1.jpg_1532753646408?imageMogr2/crop/!800.0x640.0a0a0.0
             * width : 800.0
             * height : 640.0
             */

            private String imageUrl;
            private String width;
            private String height;

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public String getWidth() {
                return width;
            }

            public void setWidth(String width) {
                this.width = width;
            }

            public String getHeight() {
                return height;
            }

            public void setHeight(String height) {
                this.height = height;
            }
        }
    }
}
