package com.zhenman.asus.zhenman.model.event;

import java.util.List;

public class CommentLIstEvent {

    /**
     * state : 0
     * msg : 成功
     * data : {"commentId":"8","content":"fdafds434","catalogId":"1","userId":"260","likeNum":0,"like":false,"detailNum":0,"addTime":"1540455142000","author":false,"reUserId":null,"reContent":null,"reName":null,"reAuthor":false,"imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/headImage/7e55b65f5fee47ccb66a8f2f209e5f67_?imageMogr2/thumbnail/100x100","name":"ଲ 猜","detailId":null,"title":null,"roleNameList":null,"chapterSort":null,"json":"{\n\"text\":\"今天，@小伙 ，@xx\",\n\"textExtra\": [\n{\n\"start\":3 ,\n\"length\":4,\n\"id\":\"399\",\n\"textType\":1,\n\"link\":\"zmcartoon://message?userId=\"\n}\n]\n}","textDto":null,"titleDto":null,"commentDtoList":[{"commentId":null,"content":"fdafds434fdafds","catalogId":null,"userId":"260","likeNum":0,"like":false,"detailNum":0,"addTime":"1540455620000","author":false,"reUserId":null,"reContent":null,"reName":null,"reAuthor":false,"imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/headImage/7e55b65f5fee47ccb66a8f2f209e5f67_?imageMogr2/thumbnail/100x100","name":"ଲ 猜","detailId":"6","title":null,"roleNameList":null,"chapterSort":null,"json":"{\n\"text\":\"今天，@小伙 ，@xx\",\n\"textExtra\": [\n{\n\"start\":3 ,\n\"length\":4,\n\"id\":\"399\",\n\"textType\":1,\n\"link\":\"zmcartoon://message?userId=\"\n}\n]\n}","textDto":{"text":"今天，@小伙 ，@xx","textExtra":[{"start":3,"length":4,"id":"399","text":null,"textType":1,"link":"zmcartoon://message?userId="}]},"titleDto":null,"commentDtoList":null},{"commentId":null,"content":"fdafds434fdafds","catalogId":null,"userId":"260","likeNum":0,"like":false,"detailNum":0,"addTime":"1540455421000","author":false,"reUserId":null,"reContent":null,"reName":null,"reAuthor":false,"imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/headImage/7e55b65f5fee47ccb66a8f2f209e5f67_?imageMogr2/thumbnail/100x100","name":"ଲ 猜","detailId":"5","title":null,"roleNameList":null,"chapterSort":null,"json":"{\n\"text\":\"今天，@小伙 ，@xx\",\n\"textExtra\": [\n{\n\"start\":3 ,\n\"length\":4,\n\"id\":\"399\",\n\"textType\":1,\n\"link\":\"zmcartoon://message?userId=\"\n}\n]\n}","textDto":{"text":"今天，@小伙 ，@xx","textExtra":[{"start":3,"length":4,"id":"399","text":null,"textType":1,"link":"zmcartoon://message?userId="}]},"titleDto":null,"commentDtoList":null},{"commentId":null,"content":"fdafds434fdafds","catalogId":null,"userId":"260","likeNum":0,"like":false,"detailNum":0,"addTime":"1540455326000","author":false,"reUserId":null,"reContent":null,"reName":null,"reAuthor":false,"imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/headImage/7e55b65f5fee47ccb66a8f2f209e5f67_?imageMogr2/thumbnail/100x100","name":"ଲ 猜","detailId":"4","title":null,"roleNameList":null,"chapterSort":null,"json":"{\n\"text\":\"今天，@小伙 ，@xx\",\n\"textExtra\": [\n{\n\"start\":3 ,\n\"length\":4,\n\"id\":\"399\",\n\"textType\":1,\n\"link\":\"zmcartoon://message?userId=\"\n}\n]\n}","textDto":{"text":"今天，@小伙 ，@xx","textExtra":[{"start":3,"length":4,"id":"399","text":null,"textType":1,"link":"zmcartoon://message?userId="}]},"titleDto":null,"commentDtoList":null},{"commentId":null,"content":"fdafds434fdafds","catalogId":null,"userId":"260","likeNum":0,"like":false,"detailNum":0,"addTime":"1540455197000","author":false,"reUserId":null,"reContent":null,"reName":null,"reAuthor":false,"imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/headImage/7e55b65f5fee47ccb66a8f2f209e5f67_?imageMogr2/thumbnail/100x100","name":"ଲ 猜","detailId":"3","title":null,"roleNameList":null,"chapterSort":null,"json":"{\n\"text\":\"今天，@小伙 ，@xx\",\n\"textExtra\": [\n{\n\"start\":3 ,\n\"length\":4,\n\"id\":\"399\",\n\"textType\":1,\n\"link\":\"zmcartoon://message?userId=\"\n}\n]\n}","textDto":{"text":"今天，@小伙 ，@xx","textExtra":[{"start":3,"length":4,"id":"399","text":null,"textType":1,"link":"zmcartoon://message?userId="}]},"titleDto":null,"commentDtoList":null}]}
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
         * commentId : 8
         * content : fdafds434
         * catalogId : 1
         * userId : 260
         * likeNum : 0
         * like : false
         * detailNum : 0
         * addTime : 1540455142000
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
         * json : {
         "text":"今天，@小伙 ，@xx",
         "textExtra": [
         {
         "start":3 ,
         "length":4,
         "id":"399",
         "textType":1,
         "link":"zmcartoon://message?userId="
         }
         ]
         }
         * textDto : null
         * titleDto : null
         * commentDtoList : [{"commentId":null,"content":"fdafds434fdafds","catalogId":null,"userId":"260","likeNum":0,"like":false,"detailNum":0,"addTime":"1540455620000","author":false,"reUserId":null,"reContent":null,"reName":null,"reAuthor":false,"imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/headImage/7e55b65f5fee47ccb66a8f2f209e5f67_?imageMogr2/thumbnail/100x100","name":"ଲ 猜","detailId":"6","title":null,"roleNameList":null,"chapterSort":null,"json":"{\n\"text\":\"今天，@小伙 ，@xx\",\n\"textExtra\": [\n{\n\"start\":3 ,\n\"length\":4,\n\"id\":\"399\",\n\"textType\":1,\n\"link\":\"zmcartoon://message?userId=\"\n}\n]\n}","textDto":{"text":"今天，@小伙 ，@xx","textExtra":[{"start":3,"length":4,"id":"399","text":null,"textType":1,"link":"zmcartoon://message?userId="}]},"titleDto":null,"commentDtoList":null},{"commentId":null,"content":"fdafds434fdafds","catalogId":null,"userId":"260","likeNum":0,"like":false,"detailNum":0,"addTime":"1540455421000","author":false,"reUserId":null,"reContent":null,"reName":null,"reAuthor":false,"imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/headImage/7e55b65f5fee47ccb66a8f2f209e5f67_?imageMogr2/thumbnail/100x100","name":"ଲ 猜","detailId":"5","title":null,"roleNameList":null,"chapterSort":null,"json":"{\n\"text\":\"今天，@小伙 ，@xx\",\n\"textExtra\": [\n{\n\"start\":3 ,\n\"length\":4,\n\"id\":\"399\",\n\"textType\":1,\n\"link\":\"zmcartoon://message?userId=\"\n}\n]\n}","textDto":{"text":"今天，@小伙 ，@xx","textExtra":[{"start":3,"length":4,"id":"399","text":null,"textType":1,"link":"zmcartoon://message?userId="}]},"titleDto":null,"commentDtoList":null},{"commentId":null,"content":"fdafds434fdafds","catalogId":null,"userId":"260","likeNum":0,"like":false,"detailNum":0,"addTime":"1540455326000","author":false,"reUserId":null,"reContent":null,"reName":null,"reAuthor":false,"imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/headImage/7e55b65f5fee47ccb66a8f2f209e5f67_?imageMogr2/thumbnail/100x100","name":"ଲ 猜","detailId":"4","title":null,"roleNameList":null,"chapterSort":null,"json":"{\n\"text\":\"今天，@小伙 ，@xx\",\n\"textExtra\": [\n{\n\"start\":3 ,\n\"length\":4,\n\"id\":\"399\",\n\"textType\":1,\n\"link\":\"zmcartoon://message?userId=\"\n}\n]\n}","textDto":{"text":"今天，@小伙 ，@xx","textExtra":[{"start":3,"length":4,"id":"399","text":null,"textType":1,"link":"zmcartoon://message?userId="}]},"titleDto":null,"commentDtoList":null},{"commentId":null,"content":"fdafds434fdafds","catalogId":null,"userId":"260","likeNum":0,"like":false,"detailNum":0,"addTime":"1540455197000","author":false,"reUserId":null,"reContent":null,"reName":null,"reAuthor":false,"imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/headImage/7e55b65f5fee47ccb66a8f2f209e5f67_?imageMogr2/thumbnail/100x100","name":"ଲ 猜","detailId":"3","title":null,"roleNameList":null,"chapterSort":null,"json":"{\n\"text\":\"今天，@小伙 ，@xx\",\n\"textExtra\": [\n{\n\"start\":3 ,\n\"length\":4,\n\"id\":\"399\",\n\"textType\":1,\n\"link\":\"zmcartoon://message?userId=\"\n}\n]\n}","textDto":{"text":"今天，@小伙 ，@xx","textExtra":[{"start":3,"length":4,"id":"399","text":null,"textType":1,"link":"zmcartoon://message?userId="}]},"titleDto":null,"commentDtoList":null}]
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
        private String json;
        private Object textDto;
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

        public String getJson() {
            return json;
        }

        public void setJson(String json) {
            this.json = json;
        }

        public Object getTextDto() {
            return textDto;
        }

        public void setTextDto(Object textDto) {
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

        public static class CommentDtoListBean {
            /**
             * commentId : null
             * content : fdafds434fdafds
             * catalogId : null
             * userId : 260
             * likeNum : 0
             * like : false
             * detailNum : 0
             * addTime : 1540455620000
             * author : false
             * reUserId : null
             * reContent : null
             * reName : null
             * reAuthor : false
             * imageUrl : http://pa1qj1jlg.bkt.clouddn.com/headImage/7e55b65f5fee47ccb66a8f2f209e5f67_?imageMogr2/thumbnail/100x100
             * name : ଲ 猜
             * detailId : 6
             * title : null
             * roleNameList : null
             * chapterSort : null
             * json : {
             "text":"今天，@小伙 ，@xx",
             "textExtra": [
             {
             "start":3 ,
             "length":4,
             "id":"399",
             "textType":1,
             "link":"zmcartoon://message?userId="
             }
             ]
             }
             * textDto : {"text":"今天，@小伙 ，@xx","textExtra":[{"start":3,"length":4,"id":"399","text":null,"textType":1,"link":"zmcartoon://message?userId="}]}
             * titleDto : null
             * commentDtoList : null
             */

            private Object commentId;
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
            private String imageUrl;
            private String name;
            private String detailId;
            private Object title;
            private Object roleNameList;
            private Object chapterSort;
            private String json;
            private TextDtoBean textDto;
            private Object titleDto;
            private Object commentDtoList;

            public Object getCommentId() {
                return commentId;
            }

            public void setCommentId(Object commentId) {
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

            public Object getCommentDtoList() {
                return commentDtoList;
            }

            public void setCommentDtoList(Object commentDtoList) {
                this.commentDtoList = commentDtoList;
            }

            public static class TextDtoBean {
                /**
                 * text : 今天，@小伙 ，@xx
                 * textExtra : [{"start":3,"length":4,"id":"399","text":null,"textType":1,"link":"zmcartoon://message?userId="}]
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

                public static class TextExtraBean {
                    /**
                     * start : 3
                     * length : 4
                     * id : 399
                     * text : null
                     * textType : 1
                     * link : zmcartoon://message?userId=
                     */

                    private int start;
                    private int length;
                    private String id;
                    private Object text;
                    private int textType;
                    private String link;

                    public int getStart() {
                        return start;
                    }

                    public void setStart(int start) {
                        this.start = start;
                    }

                    public int getLength() {
                        return length;
                    }

                    public void setLength(int length) {
                        this.length = length;
                    }

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }

                    public Object getText() {
                        return text;
                    }

                    public void setText(Object text) {
                        this.text = text;
                    }

                    public int getTextType() {
                        return textType;
                    }

                    public void setTextType(int textType) {
                        this.textType = textType;
                    }

                    public String getLink() {
                        return link;
                    }

                    public void setLink(String link) {
                        this.link = link;
                    }
                }
            }
        }
    }
}
