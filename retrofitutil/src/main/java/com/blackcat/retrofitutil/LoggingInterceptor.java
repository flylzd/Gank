package com.blackcat.retrofitutil;


import com.orhanobut.logger.Logger;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.ResponseBody;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public class LoggingInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {

        long t1 = System.nanoTime();
        Request request = chain.request();
        Logger.i(String.format("Sending request : %s %n %s %n %s %n %s",
                request.url(), request.method(), chain.connection(), request.headers()));

        Response response = chain.proceed(request);
        long t2 = System.nanoTime();
        Logger.i(String.format("Received response for %s %nin %.1fms responseCode: %s %n%s",
                request.url(), (t2 - t1) / 1e6d,response.code(), response.headers()));
        return response;
    }
}
