package com.blackcat.gank.utils;


import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public class ResUtil {

    private static Context mContext;

    public static void init(Context context) {
        mContext = context.getApplicationContext();
    }

    private static void checkNotNull() {
        if (mContext == null) {
            throw new NullPointerException(
                    "Must initial call ResUtil.init(Context context) in your " +
                            "<? " +
                            "extends Application class>");
        }
    }

    public int getColor(int resId) {
        checkNotNull();
        return mContext.getResources().getColor(resId);
    }

//    public int getColor(int colorId, Resources.Theme theme) {
//        checkNotNull();
//        return mContext.getResources().getColor(colorId, theme);
//    }

    public String getString(int resId) {
        checkNotNull();
        return mContext.getResources().getString(resId);
    }

    public String getString(int resId, Object... formatArgs) {
        checkNotNull();
        return mContext.getResources().getString(resId, formatArgs);
    }

    public String[] getStringArray(int resId) {
        checkNotNull();
        return mContext.getResources().getStringArray(resId);
    }

    public Drawable getDrawable(int resId) {
        checkNotNull();
        return mContext.getResources().getDrawable(resId);
    }

}
