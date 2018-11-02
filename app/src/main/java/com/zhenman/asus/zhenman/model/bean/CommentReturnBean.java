package com.zhenman.asus.zhenman.model.bean;

public class CommentReturnBean {

    /**
     * state : 0
     * msg : 成功
     * data : {"commentId":"1050","content":"含辛茹苦关关雎鸠@绝版青春","catalogId":null,"userId":"260","likeNum":0,"like":false,"detailNum":0,"addTime":"1541060866724","author":false,"reUserId":null,"reContent":null,"reName":null,"reAuthor":false,"imageUrl":"http://pa1qj1jlg.bkt.clouddn.com/headImage/7e55b65f5fee47ccb66a8f2f209e5f67_?imageMogr2/thumbnail/100x100","name":"ଲ 猜","detailId":null,"title":null,"roleNameList":null,"chapterSort":null,"json":"{\"text\":\"含辛茹苦关关雎鸠@绝版青春\",\"textExtra\":[{\"id\":\"0\",\"length\":5,\"start\":8,\"text\":\"@绝版青春\",\"textType\":1}]}","textDto":{"text":"含辛茹苦关关雎鸠@绝版青春","textExtra":[{"start":8,"length":5,"id":"0","text":"@绝版青春","textType":1,"link":null}]},"titleDto":null,"commentDtoList":null}
     */

    private int state;
    private String msg;
    private CommentDtoListBean data;

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

    public CommentDtoListBean getData() {
        return data;
    }

    public void setData(CommentDtoListBean data) {
        this.data = data;
    }



}
