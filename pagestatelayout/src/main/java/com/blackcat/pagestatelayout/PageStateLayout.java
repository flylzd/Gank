package com.blackcat.pagestatelayout;


import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

public class PageStateLayout extends FrameLayout {

    private View mLoadingView;
    private View mEmptyView;
    private View mErrorView;
    private View mSucceedView;

    public PageStateLayout(Context context) {
        this(context, null);
    }

    public PageStateLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PageStateLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

    }



}
