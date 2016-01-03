package com.blackcat.gank;


import android.app.Application;
import android.content.Context;

import com.blackcat.gank.utils.ToastUtil;
import com.blackcat.retrofitutil.RetrofitUtil;
import com.orhanobut.logger.Logger;

public class AppContext extends Application {

    private static Context instatnce;

    @Override
    public void onCreate() {
        super.onCreate();
        instatnce = this;
        ToastUtil.register(this);
        RetrofitUtil.init(this);
        Logger.init();
    }

    public static Context getInstatnce() {
        return instatnce;
    }
}
