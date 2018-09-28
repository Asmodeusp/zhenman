package com.zhenman.asus.zhenman.view.ui;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.zhy.autolayout.AutoLinearLayout;

public class MyImageView extends AutoLinearLayout {
    public MyImageView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint(1);

        canvas.drawPaint(paint);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }
}
