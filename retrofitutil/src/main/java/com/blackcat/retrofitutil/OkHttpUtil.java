package com.blackcat.retrofitutil;


import android.content.Context;

import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class OkHttpUtil {

    private final static String RESPONSE_CACHE = RetrofitUtil.getOkHttpConfig().RESPONSE_CACHE;
    private final static int RESPONSE_CACHE_SIZE = RetrofitUtil.getOkHttpConfig().RESPONSE_CACHE_SIZE;
    private final static int HTTP_CONNECT_TIMEOUT = RetrofitUtil.getOkHttpConfig().HTTP_CONNECT_TIMEOUT;
    private final static int HTTP_READ_TIMEOUT = RetrofitUtil.getOkHttpConfig().HTTP_READ_TIMEOUT;

    private static OkHttpClient okHttpClient;

    public static  OkHttpClient getInstatnce(Context context) {
        if (okHttpClient == null) {
            synchronized (OkHttpUtil.class){
                if (okHttpClient == null) {
                    okHttpClient = new OkHttpClient();
                    okHttpClient.setCache(new Cache(new File(context.getCacheDir(), RESPONSE_CACHE), RESPONSE_CACHE_SIZE));
                    okHttpClient.setConnectTimeout(HTTP_CONNECT_TIMEOUT, TimeUnit.MILLISECONDS);
                    okHttpClient.setReadTimeout(HTTP_READ_TIMEOUT, TimeUnit.MILLISECONDS);

                    if (getOkHttpConfig().isLog()) {
                        okHttpClient.networkInterceptors().add(new LoggingInterceptor());
                    }
                }
            }
        }
        return okHttpClient;
    }

//    private static OkHttpConfig okHttpConfig;
//    public static void setOkHttpConfig(OkHttpConfig okHttpConfig) {
//        OkHttpUtil.okHttpConfig = okHttpConfig;
//    }
    public static OkHttpConfig getOkHttpConfig() {
        return RetrofitUtil.getOkHttpConfig();
    }

}
