package com.blackcat.gank;


import android.app.Application;
import android.content.Context;

import com.blackcat.gank.utils.ToastUtil;

public class AppContext extends Application {

    private static Context instatnce;

    @Override
    public void onCreate() {
        super.onCreate();
        instatnce = this;
        ToastUtil.register(this);
    }

    public static Context getInstatnce() {
        return instatnce;
    }
}
