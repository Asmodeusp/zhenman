package com.zhenman.asus.zhenman.utils;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.zhenman.asus.zhenman.model.bean.TextExtraBean;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MyClickSpan extends ClickableSpan {
    private int mHighLightColor = Color.parseColor("#b37feb");
    private boolean mUnderLine = false;
    private View.OnClickListener mClickListener;

    public MyClickSpan(View.OnClickListener listener) {
        this.mClickListener = listener;
    }


    public MyClickSpan(int color, boolean underline, View.OnClickListener listener) {
        this.mHighLightColor = color;
        this.mUnderLine = underline;
        this.mClickListener = listener;
    }


    @Override
    public void onClick(View widget) {
        if (mClickListener != null)
            mClickListener.onClick(widget);
    }


    @Override
    public void updateDrawState(TextPaint ds) {
        ds.setColor(mHighLightColor);
        ds.setUnderlineText(mUnderLine);
    }


    public static void setTextHighLightWithClick(TextView tv, String text, List<TextExtraBean> textExtraBeans, View.OnClickListener listener) {
        tv.setClickable(true);
        tv.setHighlightColor(Color.TRANSPARENT);
        tv.setMovementMethod(LinkMovementMethod.getInstance());
        SpannableString s = new SpannableString(text);
//        for (int i = 0; i < textExtraBeans.size(); i++) {
//            Pattern p = Pattern.compile(keyWord[i]);
//            Matcher m = p.matcher(s);
//            while (m.find()) {
//                    int start = m.start();
//                    int end = m.end();
//                s.setSpan(new MyClickSpan(listener), start, end,
//                        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//            }
//        }
        for (TextExtraBean textExtraBean : textExtraBeans) {
            s.setSpan(new MyClickSpan(listener),textExtraBean.getStart(),(textExtraBean.getStart()+textExtraBean.getLength()),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        tv.setText(s);
    }


    /**
     * 关键字高亮变色
     *
     * @param color   变化的色值
     * @param text    文字
     * @param keyword 文字中的关键字
     * @return
     */

    public static SpannableString matcherSearchTitle(int color, String text, String keyword) {
        SpannableString s = new SpannableString(text);
        Pattern p = Pattern.compile(keyword);
        Matcher m = p.matcher(s);
        while (m.find()) {
            int start = m.start();
            int end = m.end();
            s.setSpan(new ForegroundColorSpan(color), start, end,
                    Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        }
        return s;
    }


}
