package com.blackcat.retrofitutil;


import android.content.Context;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

public class RetrofitUtil {

    private static Context mContext;
    private static Retrofit retrofit;
    private static OkHttpConfig okHttpConfig;

    public static void init(Context context) {
        mContext = context;
        okHttpConfig = new OkHttpConfig.OkHttpConfigBuilder().build();
    }

    public static void setOkHttpConfig(OkHttpConfig okHttpConfig) {
        RetrofitUtil.okHttpConfig = okHttpConfig;
    }

    public static OkHttpConfig getOkHttpConfig() {
        return okHttpConfig;
    }

    private static void checkNotNull() {
        if (mContext == null) {
            throw new NullPointerException("Must initial call RetrofitUtil.register(Context context)");
        }
    }

    public static <T> T createApiService(Class<T> clazz, String baseUrl) {
        checkNotNull();
        if (retrofit == null) {
            synchronized (RetrofitUtil.class) {
                if (retrofit == null) {
                    retrofit = new Retrofit.Builder()
                            .baseUrl(baseUrl)
                            .addConverterFactory(GsonConverterFactory.create())
//                            .addConverterFactory(GsonConverterFactory.create(GsonUtil.INSTANCE.get()))
                            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                            .client(OkHttpUtil.getInstatnce(mContext))
                            .build();
                }
            }
        }
        return retrofit.create(clazz);
    }

}
