package com.zhenman.asus.zhenman.view.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;


public class MyRecyclerView extends RecyclerView {

    private boolean isListViewTop;
    private boolean isListViewBottom;
    private int nowY;

    public MyRecyclerView(@NonNull Context context) {
        super(context);
    }

    public MyRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setInnerListView(RecyclerView mListView) throws NullPointerException {
        if (mListView == null) {

            throw new NullPointerException("ListView is NULL!");
        }
        mListView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                //得到当前显示的第一个item的view
                View firstChildView = recyclerView.getLayoutManager().getChildAt(0);
                //得到firstChildView的Top坐标值
                int firstChildTop = firstChildView.getTop();
                //得到Recyclerview的顶坐标减去顶部padding值，也就是显示内容最顶部的坐标
                int recyclerTop = recyclerView.getTop() - recyclerView.getPaddingTop();
                //通过这个firstChildView得到这个view当前的position值
                int firstPosition = recyclerView.getLayoutManager().getPosition(firstChildView);
                //得到当前显示的最后一个item的view
                View lastChildView = recyclerView.getLayoutManager().getChildAt(recyclerView.getLayoutManager().getChildCount() - 1);
                //得到lastChildView的bottom坐标值
                int lastChildBottom = lastChildView.getBottom();
                //得到Recyclerview的底部坐标减去底部padding值，也就是显示内容最底部的坐标
                int recyclerBottom = recyclerView.getBottom() - recyclerView.getPaddingBottom();
                //通过这个lastChildView得到这个view当前的position值
                int lastPosition = recyclerView.getLayoutManager().getPosition(lastChildView);

                if (firstChildTop == recyclerTop && firstPosition == 0) {
                    isListViewTop = true;
                } else {
                    isListViewTop = false;
                }
                if (lastChildBottom == recyclerBottom && lastPosition == recyclerView.getLayoutManager().getItemCount() - 1) {
                    isListViewBottom = true;
                } else {
                    isListViewBottom = false;
                }
                /*
                 *   当里面向上滑动时
                 * **/
                if (dy < 0) {

                }
                /*
                 * 向下滑动
                 * **/
                if (dy > 0) {

                }
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        boolean intercepted = false;
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                nowY = y;
                intercepted = super.onInterceptTouchEvent(event);
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                if (isListViewTop
                        && y > nowY) {
                    intercepted = true;
                    break;
                } else if (isListViewBottom
                        && y < nowY) {
                    intercepted = true;
                    break;
                }
                intercepted = false;
                break;
            }
            case MotionEvent.ACTION_UP: {
                intercepted = false;
                break;
            }
            default:
                break;
        }
        Log.d("MyRecyclerView", "intercepted:" + intercepted);
        return intercepted;
    }


}
