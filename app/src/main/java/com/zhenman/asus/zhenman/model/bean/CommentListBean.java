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
        private List<CommentDtoListBean> commentDtoList;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<CommentDtoListBean> getCommentDtoList() {
            return commentDtoList;
        }

        public void setCommentDtoList(List<CommentDtoListBean> commentDtoList) {
            this.commentDtoList = commentDtoList;
        }


    }
}

