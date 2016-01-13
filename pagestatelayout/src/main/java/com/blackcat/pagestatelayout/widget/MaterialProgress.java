package com.blackcat.pagestatelayout.widget;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;

public class MaterialProgress extends View {

    private MaterialProgressDrawable mProgress;
    private static final int CIRCLE_BG_LIGHT = 0xFFFAFAFA;

    public MaterialProgress(Context context) {
        super(context);
        init();
    }

    public MaterialProgress(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MaterialProgress(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        /*创建加载动画Drawable*/
        mProgress = new MaterialProgressDrawable(getContext(), this);
        /*设置颜色*/
//        mProgress.setBackgroundColor(CIRCLE_BG_LIGHT);
        /*设置加载时的颜色值*/
        mProgress.setColorSchemeColors(0xFC9B4C8B, 0xFC9B7D7C, 0xFC439B7B, 0xFC2798DD, 0xFC2F27DD, 0xFCC745DD, 0xC1FFF238);
        mProgress.showArrow(false);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mProgress.draw(canvas);
    }

    /*当view设为可见的时候，动画开始执行，反之动画停止*/
    @Override
    public void setVisibility(int visibility) {
        if (visibility == GONE || visibility == INVISIBLE) {

            mProgress.stop();
        } else {
            mProgress.start();
            mProgress.showArrow(true);
        }
        super.setVisibility(visibility);
    }
}
