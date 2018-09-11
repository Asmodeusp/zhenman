package com.zhenman.asus.zhenman.view.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import cn.youngkaaa.yviewpager.YViewPager;

public class MyViewPager extends YViewPager {
    public MyViewPager(Context context) {
        super(context);
    }

    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private boolean isCanScroll = true;//是否可滑动
    private boolean isAllowScroll = true;//是否准许滑动

    public boolean isAllowScroll() {
        return isAllowScroll;
    }

    public void setAllowScroll(boolean allowScroll) {
        isAllowScroll = allowScroll;
        if (isAllowScroll) {
            setScanScroll(true);
        } else {
            setScanScroll(false);
        }
    }

    /**
     * 设置其是否能滑动换页
     *
     * @param isCanScroll false 不能换页， true 可以滑动换页
     */
    public void setScanScroll(boolean isCanScroll) {
        this.isCanScroll = isCanScroll;
    }

    public boolean isCanScroll() {
        return isCanScroll;
    }

    @Override
    public boolean onTouchEvent(MotionEvent arg0) {
        /* return false;//super.onTouchEvent(arg0); */

        if (isCanScroll)
            return super.onTouchEvent(arg0);
        else
            return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent arg0) {
        if (isCanScroll)
            return super.onInterceptTouchEvent(arg0);
        else
            return false;
    }

}