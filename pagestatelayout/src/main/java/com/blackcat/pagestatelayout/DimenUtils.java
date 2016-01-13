package com.blackcat.pagestatelayout;


import android.content.Context;

public class DimenUtils {

    public static int dip2px(Context context, int dp) {
        float density = context.getResources().getDisplayMetrics().density;
        return (int) (dp * density + 0.5f);
    }
}
