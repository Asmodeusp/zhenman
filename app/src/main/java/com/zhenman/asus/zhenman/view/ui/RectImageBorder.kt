package com.zhenman.asus.zhenman.view.ui;

import android.content.Context
import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.widget.ImageView
import com.zhenman.asus.zhenman.R


/**
 * Desc 请描述这个文件
 * @Author YHang
 * Mail yihang_hu@dingyuegroup.cn
 * Data 2018\9\28 0028 15:58
 */

class RectImageBorder : ImageView {
    private var mBorderThickness = 0
    private var mContext: Context? = null
    private val defaultColor = -0x1
    // 如果只有其中一个有值，则只画一个圆形边框
    private var mBorderOutsideColor = 0
    private var mBorderInsideColor = 0
    // 控件默认长、宽
    private var defaultWidth = 0
    private var defaultHeight = 0

    //容器内部添加的ImageView
    private var rectBitmap: Drawable? = null

    constructor(context: Context) : super(context) {
        mContext = context
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        mContext = context
        setCustomAttributes(attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        mContext = context
        setCustomAttributes(attrs)
    }

    private fun setCustomAttributes(attrs: AttributeSet) {
        val a = mContext!!.obtainStyledAttributes(attrs,
                R.styleable.RectImageBorder)
        mBorderThickness = a.getDimensionPixelSize(
                R.styleable.RectImageBorder_rectImage_border_width, 0)
        mBorderOutsideColor = a
                .getColor(R.styleable.RectImageBorder_rectImage_border_color,
                        defaultColor)
        mBorderInsideColor = a.getColor(
                R.styleable.RectImageBorder_rectImage_border_color, defaultColor)
        rectBitmap = a.getDrawable(R.styleable.RectImageBorder_rectImage_background)
    }

    override fun onDraw(canvas: Canvas) {

        if (width == 0 || height == 0) {
            return
        }
        this.measure(0, 0)
        if (defaultWidth == 0 || defaultHeight == 0) {
            if (rectBitmap?.minimumHeight!! > rectBitmap?.minimumWidth!!) {
                defaultHeight = rectBitmap?.minimumHeight!! + dip2px(context, 6f)
                defaultWidth = rectBitmap?.minimumWidth!! + dip2px(context, 6f)
            } else {
                defaultWidth = rectBitmap?.minimumHeight!! + dip2px(context, 6f)
                defaultHeight = rectBitmap?.minimumWidth!! + dip2px(context, 6f)
            }
        }

        // 保证重新读取图片后不会因为图片大小而改变控件宽、高的大小（针对宽、高为wrap_content布局的imageview，但会导致margin无效）
        // if (defaultWidth != 0 && defaultHeight != 0) {
        // LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
        // defaultWidth, defaultHeight);
        // setLayoutParams(params);
        // }
        var radius = 0
        if (mBorderInsideColor != defaultColor && mBorderOutsideColor != defaultColor) {// 定义画两个边框，分别为外圆边框和内圆边框
            radius = (if (defaultWidth < defaultHeight)
                defaultWidth
            else
                defaultHeight) / 2 - 2 * mBorderThickness
            drawRectBorder(canvas, mBorderInsideColor)
            drawRectBorder(canvas, mBorderOutsideColor)
        } else if (mBorderInsideColor != defaultColor && mBorderOutsideColor == defaultColor) {// 定义画一个边框
            radius = (if (defaultWidth < defaultHeight)
                defaultWidth
            else
                defaultHeight) / 2 - mBorderThickness
            drawRectBorder(canvas, mBorderInsideColor)
        } else if (mBorderInsideColor == defaultColor && mBorderOutsideColor != defaultColor) {// 定义画一个边框
            radius = (if (defaultWidth < defaultHeight)
                defaultWidth
            else
                defaultHeight) / 2 - mBorderThickness
            drawRectBorder(canvas, mBorderOutsideColor)
        } else {// 没有边框
            radius = (if (defaultWidth < defaultHeight)
                defaultWidth
            else
                defaultHeight) / 2
        }

        canvas.drawBitmap((rectBitmap as BitmapDrawable).bitmap, (defaultWidth - rectBitmap?.minimumWidth!!) / 2f, (defaultHeight - rectBitmap?.minimumHeight!!) / 2f, null)
    }

    /**
     * <根据手机的分辨率从 dp 的单位 转成为 px(像素)>
     *
     *
     * context
     * dpValue
     * int
    </根据手机的分辨率从> */
    fun dip2px(context: Context?, dpValue: Float): Int {
        if (context == null) {
            return -1
        }
        val scale = context.resources.displayMetrics.density
        return (dpValue * scale + 0.5f).toInt()
    }

    /**
     * 获取裁剪后的圆形图片
     *
     * @param radius
     * 半径
     */
    fun getCroppedRoundBitmap(bmp: Bitmap?, radius: Int): Bitmap {
        var bmp = bmp
        var scaledSrcBmp: Bitmap?
        val diameter = radius * 2

        // 为了防止宽高不相等，造成圆形图片变形，因此截取长方形中处于中间位置最大的正方形图片
        val bmpWidth = bmp!!.width
        val bmpHeight = bmp!!.height
        var squareWidth = 0
        var squareHeight = 0
        var x = 0
        var y = 0
        var squareBitmap: Bitmap?
        when {
            bmpHeight > bmpWidth -> {// 高大于宽
                squareHeight = bmpWidth
                squareWidth = squareHeight
                x = 0
                y = (bmpHeight - bmpWidth) / 2
                // 截取正方形图片
                squareBitmap = Bitmap.createBitmap(bmp, x, y, squareWidth,
                        squareHeight)
            }
            bmpHeight < bmpWidth -> {// 宽大于高
                squareHeight = bmpHeight
                squareWidth = squareHeight
                x = (bmpWidth - bmpHeight) / 2
                y = 0
                squareBitmap = Bitmap.createBitmap(bmp, x, y, squareWidth,
                        squareHeight)
            }
            else -> squareBitmap = bmp
        }

        scaledSrcBmp = if (squareBitmap!!.width != diameter || squareBitmap!!.height != diameter) {
            Bitmap.createScaledBitmap(squareBitmap, diameter,
                    diameter, true)

        } else {
            squareBitmap
        }
        val output = Bitmap.createBitmap(scaledSrcBmp!!.width,
                scaledSrcBmp!!.height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(output)

        val paint = Paint()
        val rect = Rect(0, 0, scaledSrcBmp!!.width,
                scaledSrcBmp!!.height)

        paint.isAntiAlias = true
        paint.isFilterBitmap = true
        paint.isDither = true
        canvas.drawARGB(0, 0, 0, 0)
        canvas.drawCircle(scaledSrcBmp!!.width / 2f,
                scaledSrcBmp!!.height / 2f, scaledSrcBmp!!.width / 2f,
                paint)
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
        canvas.drawBitmap(scaledSrcBmp, rect, rect, paint)
        // bitmap回收(recycle导致在布局文件XML看不到效果)
        // bmp.recycle();
        // squareBitmap.recycle();
        // scaledSrcBmp.recycle();
        return output
    }

    /**
     * 边缘画圆
     */
    private fun drawRectBorder(canvas: Canvas, color: Int) {
        val paint = Paint()
        /* 去锯齿 */
        paint.isAntiAlias = true
        paint.isFilterBitmap = true
        paint.isDither = true
        paint.color = color
        /* 设置paint的　style　为STROKE：空心 */
        paint.style = Paint.Style.STROKE
        /* 设置paint的外框宽度 */
        paint.strokeWidth = mBorderThickness * 1f
        canvas.drawRect(0f, 0f, defaultWidth * 1f, defaultHeight * 1f, paint)
    }

}
