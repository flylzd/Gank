package com.blackcat.gank.utils;


import android.content.Context;
import android.widget.Toast;

public class ToastUtil {

    private static Context mContext;

    private ToastUtil() {
    }

    public static void register(Context context) {
        mContext = context.getApplicationContext();
    }

    private static void check() {
        if (mContext == null) {
            throw new NullPointerException(
                    "Must initial call ToastUtil.register(Context context) in your " +
                            "<? " +
                            "extends Application class>");
        }
    }

    public static void showShort(int resId) {
        check();
        Toast.makeText(mContext, resId, Toast.LENGTH_SHORT).show();
    }

    public static void showShort(String message) {
        check();
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    }

    public static void showLong(int resId) {
        check();
        Toast.makeText(mContext, resId, Toast.LENGTH_LONG).show();
    }

    public static void showLong(String message) {
        check();
        Toast.makeText(mContext, message, Toast.LENGTH_LONG).show();
    }

    public static void show(Context context, int resId, int duration) {
        Toast.makeText(context, resId, duration).show();
    }

    private static void show(Context context, String message, int duration) {
        Toast.makeText(context, message, duration).show();
    }
}
