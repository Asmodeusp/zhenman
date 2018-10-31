package com.zhenman.asus.zhenman.model.bean;

import java.util.List;

public class CommentListBean {


    /**
     * state : 0
     * msg : 成功
     * data : {"total":3,"commentDtoList":[{"commentId":"249","content":"@绝版青春 sdf","catalogId":"56","userId":"260","likeNum":1,"like":false,"detailNum":4,"addTime":"1540364757000","author":false,"reUserId":null,"reContent":null,"reName":null,"reAuthor":false,"imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/headImage/7e55b65f5fee47ccb66a8f2f209e5f67_?imageMogr2/thumbnail/100x100","name":"ଲ 猜","detailId":null,"title":null,"roleNameList":null,"chapterSort":null,"json":null,"textDto":{"text":"@绝版青春 sdf","textExtra":[{"start":0,"length":5,"id":"255","text":"@绝版青春","textType":1,"link":null}]},"titleDto":null,"commentDtoList":[{"commentId":"249","content":"@ଲ 猜 这➏➐➏➐➏➑","catalogId":null,"userId":"306","likeNum":0,"like":false,"detailNum":0,"addTime":"1540553625000","author":false,"reUserId":null,"reContent":null,"reName":null,"reAuthor":false,"imageUrl":null,"name":"432423","detailId":"173","title":null,"roleNameList":null,"chapterSort":null,"json":"{\"text\":\"@ଲ 猜 这➏➐➏➐➏➑\",\"textExtra\":[{\"id\":\"260\",\"start\":0,\"length\":4,\"text\":\"@ଲ 猜\",\"textType\":1}]}","textDto":{"text":"432423:@ଲ 猜 这➏➐➏➐➏➑","textExtra":[{"start":0,"length":6,"id":"306","text":"432423","textType":1,"link":null},{"start":6,"length":4,"id":"260","text":"@ଲ 猜","textType":1,"link":null}]},"titleDto":null,"commentDtoList":null},{"commentId":"249","content":"➍➎➏➑➎➎➏➒➏","catalogId":null,"userId":"306","likeNum":0,"like":false,"detailNum":0,"addTime":"1540549256000","author":false,"reUserId":null,"reContent":null,"reName":null,"reAuthor":false,"imageUrl":null,"name":"432423","detailId":"172","title":null,"roleNameList":null,"chapterSort":null,"json":"{\"text\":\"➍➎➏➑➎➎➏➒➏\",\"textExtra\":[]}","textDto":{"text":"432423:➍➎➏➑➎➎➏➒➏","textExtra":[{"start":0,"length":6,"id":"306","text":"432423","textType":1,"link":null}]},"titleDto":null,"commentDtoList":null}]},{"commentId":"256","content":"➐➏➏➑","catalogId":"56","userId":"306","likeNum":0,"like":false,"detailNum":0,"addTime":"1540548073000","author":false,"reUserId":null,"reContent":null,"reName":null,"reAuthor":false,"imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/headImage/94d8936576be447db4af912580b48987_?imageMogr2/thumbnail/100x100","name":"432423","detailId":null,"title":null,"roleNameList":null,"chapterSort":null,"json":null,"textDto":{"text":"➐➏➏➑","textExtra":[]},"titleDto":null,"commentDtoList":[]},{"commentId":"258","content":"➒➏➑➏","catalogId":"56","userId":"306","likeNum":0,"like":false,"detailNum":0,"addTime":"1540552950000","author":false,"reUserId":null,"reContent":null,"reName":null,"reAuthor":false,"imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/headImage/94d8936576be447db4af912580b48987_?imageMogr2/thumbnail/100x100","name":"432423","detailId":null,"title":null,"roleNameList":null,"chapterSort":null,"json":null,"textDto":{"text":"➒➏➑➏","textExtra":[]},"titleDto":null,"commentDtoList":[]}]}
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
         * total : 3
         * commentDtoList : [{"commentId":"249","content":"@绝版青春 sdf","catalogId":"56","userId":"260","likeNum":1,"like":false,"detailNum":4,"addTime":"1540364757000","author":false,"reUserId":null,"reContent":null,"reName":null,"reAuthor":false,"imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/headImage/7e55b65f5fee47ccb66a8f2f209e5f67_?imageMogr2/thumbnail/100x100","name":"ଲ 猜","detailId":null,"title":null,"roleNameList":null,"chapterSort":null,"json":null,"textDto":{"text":"@绝版青春 sdf","textExtra":[{"start":0,"length":5,"id":"255","text":"@绝版青春","textType":1,"link":null}]},"titleDto":null,"commentDtoList":[{"commentId":"249","content":"@ଲ 猜 这➏➐➏➐➏➑","catalogId":null,"userId":"306","likeNum":0,"like":false,"detailNum":0,"addTime":"1540553625000","author":false,"reUserId":null,"reContent":null,"reName":null,"reAuthor":false,"imageUrl":null,"name":"432423","detailId":"173","title":null,"roleNameList":null,"chapterSort":null,"json":"{\"text\":\"@ଲ 猜 这➏➐➏➐➏➑\",\"textExtra\":[{\"id\":\"260\",\"start\":0,\"length\":4,\"text\":\"@ଲ 猜\",\"textType\":1}]}","textDto":{"text":"432423:@ଲ 猜 这➏➐➏➐➏➑","textExtra":[{"start":0,"length":6,"id":"306","text":"432423","textType":1,"link":null},{"start":6,"length":4,"id":"260","text":"@ଲ 猜","textType":1,"link":null}]},"titleDto":null,"commentDtoList":null},{"commentId":"249","content":"➍➎➏➑➎➎➏➒➏","catalogId":null,"userId":"306","likeNum":0,"like":false,"detailNum":0,"addTime":"1540549256000","author":false,"reUserId":null,"reContent":null,"reName":null,"reAuthor":false,"imageUrl":null,"name":"432423","detailId":"172","title":null,"roleNameList":null,"chapterSort":null,"json":"{\"text\":\"➍➎➏➑➎➎➏➒➏\",\"textExtra\":[]}","textDto":{"text":"432423:➍➎➏➑➎➎➏➒➏","textExtra":[{"start":0,"length":6,"id":"306","text":"432423","textType":1,"link":null}]},"titleDto":null,"commentDtoList":null}]},{"commentId":"256","content":"➐➏➏➑","catalogId":"56","userId":"306","likeNum":0,"like":false,"detailNum":0,"addTime":"1540548073000","author":false,"reUserId":null,"reContent":null,"reName":null,"reAuthor":false,"imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/headImage/94d8936576be447db4af912580b48987_?imageMogr2/thumbnail/100x100","name":"432423","detailId":null,"title":null,"roleNameList":null,"chapterSort":null,"json":null,"textDto":{"text":"➐➏➏➑","textExtra":[]},"titleDto":null,"commentDtoList":[]},{"commentId":"258","content":"➒➏➑➏","catalogId":"56","userId":"306","likeNum":0,"like":false,"detailNum":0,"addTime":"1540552950000","author":false,"reUserId":null,"reContent":null,"reName":null,"reAuthor":false,"imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/headImage/94d8936576be447db4af912580b48987_?imageMogr2/thumbnail/100x100","name":"432423","detailId":null,"title":null,"roleNameList":null,"chapterSort":null,"json":null,"textDto":{"text":"➒➏➑➏","textExtra":[]},"titleDto":null,"commentDtoList":[]}]
         */

        private int total;
        private List<CommentDtoListBeanX> commentDtoList;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<CommentDtoListBeanX> getCommentDtoList() {
            return commentDtoList;
        }

        public void setCommentDtoList(List<CommentDtoListBeanX> commentDtoList) {
            this.commentDtoList = commentDtoList;
        }

        public static class CommentDtoListBeanX {
            /**
             * commentId : 249
             * content : @绝版青春 sdf
             * catalogId : 56
             * userId : 260
             * likeNum : 1
             * like : false
             * detailNum : 4
             * addTime : 1540364757000
             * author : false
             * reUserId : null
             * reContent : null
             * reName : null
             * reAuthor : false
             * imageUrl : http://pa1qj1jlg.bkt.clouddn.com/headImage/7e55b65f5fee47ccb66a8f2f209e5f67_?imageMogr2/thumbnail/100x100
             * name : ଲ 猜
             * detailId : null
             * title : null
             * roleNameList : null
             * chapterSort : null
             * json : null
             * textDto : {"text":"@绝版青春 sdf","textExtra":[{"start":0,"length":5,"id":"255","text":"@绝版青春","textType":1,"link":null}]}
             * titleDto : null
             * commentDtoList : [{"commentId":"249","content":"@ଲ 猜 这➏➐➏➐➏➑","catalogId":null,"userId":"306","likeNum":0,"like":false,"detailNum":0,"addTime":"1540553625000","author":false,"reUserId":null,"reContent":null,"reName":null,"reAuthor":false,"imageUrl":null,"name":"432423","detailId":"173","title":null,"roleNameList":null,"chapterSort":null,"json":"{\"text\":\"@ଲ 猜 这➏➐➏➐➏➑\",\"textExtra\":[{\"id\":\"260\",\"start\":0,\"length\":4,\"text\":\"@ଲ 猜\",\"textType\":1}]}","textDto":{"text":"432423:@ଲ 猜 这➏➐➏➐➏➑","textExtra":[{"start":0,"length":6,"id":"306","text":"432423","textType":1,"link":null},{"start":6,"length":4,"id":"260","text":"@ଲ 猜","textType":1,"link":null}]},"titleDto":null,"commentDtoList":null},{"commentId":"249","content":"➍➎➏➑➎➎➏➒➏","catalogId":null,"userId":"306","likeNum":0,"like":false,"detailNum":0,"addTime":"1540549256000","author":false,"reUserId":null,"reContent":null,"reName":null,"reAuthor":false,"imageUrl":null,"name":"432423","detailId":"172","title":null,"roleNameList":null,"chapterSort":null,"json":"{\"text\":\"➍➎➏➑➎➎➏➒➏\",\"textExtra\":[]}","textDto":{"text":"432423:➍➎➏➑➎➎➏➒➏","textExtra":[{"start":0,"length":6,"id":"306","text":"432423","textType":1,"link":null}]},"titleDto":null,"commentDtoList":null}]
             */

            private String commentId;
            private String content;
            private String catalogId;
            private String userId;
            private int likeNum;
            private boolean like;
            private int detailNum;
            private String addTime;
            private boolean author;
            private Object reUserId;
            private Object reContent;
            private Object reName;
            private boolean reAuthor;
            private String imageUrl;
            private String name;
            private Object detailId;
            private Object title;
            private Object roleNameList;
            private Object chapterSort;
            private Object json;
            private TextDtoBean textDto;
            private Object titleDto;
            private List<CommentDtoListBean> commentDtoList;

            public String getCommentId() {
                return commentId;
            }

            public void setCommentId(String commentId) {
                this.commentId = commentId;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getCatalogId() {
                return catalogId;
            }

            public void setCatalogId(String catalogId) {
                this.catalogId = catalogId;
            }

            public String getUserId() {
                return userId;
            }

            public void setUserId(String userId) {
                this.userId = userId;
            }

            public int getLikeNum() {
                return likeNum;
            }

            public void setLikeNum(int likeNum) {
                this.likeNum = likeNum;
            }

            public boolean isLike() {
                return like;
            }

            public void setLike(boolean like) {
                this.like = like;
            }

            public int getDetailNum() {
                return detailNum;
            }

            public void setDetailNum(int detailNum) {
                this.detailNum = detailNum;
            }

            public String getAddTime() {
                return addTime;
            }

            public void setAddTime(String addTime) {
                this.addTime = addTime;
            }

            public boolean isAuthor() {
                return author;
            }

            public void setAuthor(boolean author) {
                this.author = author;
            }

            public Object getReUserId() {
                return reUserId;
            }

            public void setReUserId(Object reUserId) {
                this.reUserId = reUserId;
            }

            public Object getReContent() {
                return reContent;
            }

            public void setReContent(Object reContent) {
                this.reContent = reContent;
            }

            public Object getReName() {
                return reName;
            }

            public void setReName(Object reName) {
                this.reName = reName;
            }

            public boolean isReAuthor() {
                return reAuthor;
            }

            public void setReAuthor(boolean reAuthor) {
                this.reAuthor = reAuthor;
            }

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Object getDetailId() {
                return detailId;
            }

            public void setDetailId(Object detailId) {
                this.detailId = detailId;
            }

            public Object getTitle() {
                return title;
            }

            public void setTitle(Object title) {
                this.title = title;
            }

            public Object getRoleNameList() {
                return roleNameList;
            }

            public void setRoleNameList(Object roleNameList) {
                this.roleNameList = roleNameList;
            }

            public Object getChapterSort() {
                return chapterSort;
            }

            public void setChapterSort(Object chapterSort) {
                this.chapterSort = chapterSort;
            }

            public Object getJson() {
                return json;
            }

            public void setJson(Object json) {
                this.json = json;
            }

            public TextDtoBean getTextDto() {
                return textDto;
            }

            public void setTextDto(TextDtoBean textDto) {
                this.textDto = textDto;
            }

            public Object getTitleDto() {
                return titleDto;
            }

            public void setTitleDto(Object titleDto) {
                this.titleDto = titleDto;
            }

            public List<CommentDtoListBean> getCommentDtoList() {
                return commentDtoList;
            }

            public void setCommentDtoList(List<CommentDtoListBean> commentDtoList) {
                this.commentDtoList = commentDtoList;
            }

            public static class TextDtoBean {
                /**
                 * text : @绝版青春 sdf
                 * textExtra : [{"start":0,"length":5,"id":"255","text":"@绝版青春","textType":1,"link":null}]
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

            public static class CommentDtoListBean {
                /**
                 * commentId : 249
                 * content : @ଲ 猜 这➏➐➏➐➏➑
                 * catalogId : null
                 * userId : 306
                 * likeNum : 0
                 * like : false
                 * detailNum : 0
                 * addTime : 1540553625000
                 * author : false
                 * reUserId : null
                 * reContent : null
                 * reName : null
                 * reAuthor : false
                 * imageUrl : null
                 * name : 432423
                 * detailId : 173
                 * title : null
                 * roleNameList : null
                 * chapterSort : null
                 * json : {"text":"@ଲ 猜 这➏➐➏➐➏➑","textExtra":[{"id":"260","start":0,"length":4,"text":"@ଲ 猜","textType":1}]}
                 * textDto : {"text":"432423:@ଲ 猜 这➏➐➏➐➏➑","textExtra":[{"start":0,"length":6,"id":"306","text":"432423","textType":1,"link":null},{"start":6,"length":4,"id":"260","text":"@ଲ 猜","textType":1,"link":null}]}
                 * titleDto : null
                 * commentDtoList : null
                 */

                private String commentId;
                private String content;
                private Object catalogId;
                private String userId;
                private int likeNum;
                private boolean like;
                private int detailNum;
                private String addTime;
                private boolean author;
                private Object reUserId;
                private Object reContent;
                private Object reName;
                private boolean reAuthor;
                private Object imageUrl;
                private String name;
                private String detailId;
                private Object title;
                private Object roleNameList;
                private Object chapterSort;
                private String json;
                private TextDtoBeanX textDto;
                private Object titleDto;
                private Object commentDtoList;

                public String getCommentId() {
                    return commentId;
                }

                public void setCommentId(String commentId) {
                    this.commentId = commentId;
                }

                public String getContent() {
                    return content;
                }

                public void setContent(String content) {
                    this.content = content;
                }

                public Object getCatalogId() {
                    return catalogId;
                }

                public void setCatalogId(Object catalogId) {
                    this.catalogId = catalogId;
                }

                public String getUserId() {
                    return userId;
                }

                public void setUserId(String userId) {
                    this.userId = userId;
                }

                public int getLikeNum() {
                    return likeNum;
                }

                public void setLikeNum(int likeNum) {
                    this.likeNum = likeNum;
                }

                public boolean isLike() {
                    return like;
                }

                public void setLike(boolean like) {
                    this.like = like;
                }

                public int getDetailNum() {
                    return detailNum;
                }

                public void setDetailNum(int detailNum) {
                    this.detailNum = detailNum;
                }

                public String getAddTime() {
                    return addTime;
                }

                public void setAddTime(String addTime) {
                    this.addTime = addTime;
                }

                public boolean isAuthor() {
                    return author;
                }

                public void setAuthor(boolean author) {
                    this.author = author;
                }

                public Object getReUserId() {
                    return reUserId;
                }

                public void setReUserId(Object reUserId) {
                    this.reUserId = reUserId;
                }

                public Object getReContent() {
                    return reContent;
                }

                public void setReContent(Object reContent) {
                    this.reContent = reContent;
                }

                public Object getReName() {
                    return reName;
                }

                public void setReName(Object reName) {
                    this.reName = reName;
                }

                public boolean isReAuthor() {
                    return reAuthor;
                }

                public void setReAuthor(boolean reAuthor) {
                    this.reAuthor = reAuthor;
                }

                public Object getImageUrl() {
                    return imageUrl;
                }

                public void setImageUrl(Object imageUrl) {
                    this.imageUrl = imageUrl;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getDetailId() {
                    return detailId;
                }

                public void setDetailId(String detailId) {
                    this.detailId = detailId;
                }

                public Object getTitle() {
                    return title;
                }

                public void setTitle(Object title) {
                    this.title = title;
                }

                public Object getRoleNameList() {
                    return roleNameList;
                }

                public void setRoleNameList(Object roleNameList) {
                    this.roleNameList = roleNameList;
                }

                public Object getChapterSort() {
                    return chapterSort;
                }

                public void setChapterSort(Object chapterSort) {
                    this.chapterSort = chapterSort;
                }

                public String getJson() {
                    return json;
                }

                public void setJson(String json) {
                    this.json = json;
                }

                public TextDtoBeanX getTextDto() {
                    return textDto;
                }

                public void setTextDto(TextDtoBeanX textDto) {
                    this.textDto = textDto;
                }

                public Object getTitleDto() {
                    return titleDto;
                }

                public void setTitleDto(Object titleDto) {
                    this.titleDto = titleDto;
                }

                public Object getCommentDtoList() {
                    return commentDtoList;
                }

                public void setCommentDtoList(Object commentDtoList) {
                    this.commentDtoList = commentDtoList;
                }

                public static class TextDtoBeanX {
                    /**
                     * text : 432423:@ଲ 猜 这➏➐➏➐➏➑
                     * textExtra : [{"start":0,"length":6,"id":"306","text":"432423","textType":1,"link":null},{"start":6,"length":4,"id":"260","text":"@ଲ 猜","textType":1,"link":null}]
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
    }
}

