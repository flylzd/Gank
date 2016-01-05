package com.blackcat.gank.base;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.blackcat.gank.R;
import com.blackcat.gank.utils.StatusBarCompat;

public class BaseActivity extends AppCompatActivity {

    private static final int ERROR_LAYOUT_ID = 0;

    private View rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extras = getIntent().getExtras();
        if (null != extras) {
            getBundleExtras(extras);
        }

        onBeforeSetContentView();
        int layoutId = getLayoutId();
        if (layoutId == ERROR_LAYOUT_ID) {
            throw new NullPointerException("Must initial layout id in the activity");
        }
        rootView = View.inflate(this, getLayoutId(), null);
        setContentView(rootView);

        StatusBarCompat.compat(this, getResources().getColor(R.color.colorPrimaryDark));

        initViewsAndEvents(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    protected void getBundleExtras(Bundle extras) {

    }

    protected void onBeforeSetContentView() {

    }

    protected int getLayoutId() {
        return ERROR_LAYOUT_ID;
    }

    protected void initToolbar() {

    }

    protected void initViewsAndEvents(Bundle savedInstanceState) {

    }

    protected View getRootView() {
        return rootView;
    }
}
