package com.blackcat.retrofitutil;


import com.orhanobut.logger.Logger;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.Request;

import java.io.IOException;

public class LoggingInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {

        long t1 = System.nanoTime();
        Request request = chain.request();
        Logger.i(String.format("Sending request : %s %n %s %n %s",
                request.url(), chain.connection(), request.headers()));
        Response response = chain.proceed(request);
        long t2 = System.nanoTime();
        Logger.i(String.format("Received response for %s in %.1fms %n %s",
                request.url(), (t2 - t1) / 1e6d, response.headers()));
        Logger.i(String.format("Received response for %s %n %s ",request.url(), response.body().toString()));
        return response;
    }
}
