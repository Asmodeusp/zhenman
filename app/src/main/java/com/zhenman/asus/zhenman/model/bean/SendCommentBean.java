package com.zhenman.asus.zhenman.model.bean;

import java.util.List;

public class SendCommentBean {

    public SendCommentBean(String text, List<TextExtraBean> textExtra) {
        this.text = text;
        this.textExtra = textExtra;
    }

    /**
     * text : 今天，@小伙 ，@xx
     * textExtra : [{"start":3,"length":4,"id":"399","textType":1,"link":"zmcartoon://message?userId="}]
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
