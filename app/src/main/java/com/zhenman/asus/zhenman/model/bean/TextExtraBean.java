package com.zhenman.asus.zhenman.model.bean;

public class TextExtraBean {
    public TextExtraBean(int start, int length, String id, String text, int textType, String link) {
        this.start = start;
        this.length = length;
        this.id = id;
        this.text = text;
        this.textType = textType;
        this.link = link;
    }

    /**
     * start : 0
     * length : 5
     * <p>
     * id : 255
     * text : @绝版青春
     * textType : 1
     * link : null
     */

    private int start;
    private int length;
    private String id;
    private String text;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
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

    @Override
    public String toString() {
        return "TextExtraBean{" +
                "start=" + start +
                ", length=" + length +
                ", id='" + id + '\'' +
                ", text='" + text + '\'' +
                ", textType=" + textType +
                ", link=" + link +
                '}';
    }
}