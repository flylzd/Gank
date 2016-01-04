package com.blackcat.gank.base;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.blackcat.gank.R;
import com.blackcat.gank.utils.StatusBarCompat;
import com.orhanobut.logger.Logger;

public class BaseActivity extends AppCompatActivity {

    private View rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int layoutId = getLayoutId();
        if (layoutId == 0) {
            Logger.d("Must initial layout id in the activity");
            return;
        }
        rootView = View.inflate(this, getLayoutId(), null);
        setContentView(rootView);

        StatusBarCompat.compat(this, getResources().getColor(R.color.colorPrimaryDark));
    }

    protected int getLayoutId() {
        return 0;
    }

    protected void initToolbar() {

    }

    protected void initView() {

    }

    protected View getRootView() {
        return rootView;
    }
}
