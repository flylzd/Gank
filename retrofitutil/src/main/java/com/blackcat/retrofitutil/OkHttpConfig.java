package com.blackcat.retrofitutil;


import android.util.ArrayMap;

public class OkHttpConfig {

    public ArrayMap<String, String> header;
    public String LOG_TAG = "RetrofitUtil";
    public String RESPONSE_CACHE = "retrofit_util_cache";
    public int RESPONSE_CACHE_SIZE =  5 * 1024 * 1024; // 10 MiB0;
    public int HTTP_CONNECT_TIMEOUT = 8 * 1000;
    public int HTTP_READ_TIMEOUT = 5 * 1000;
    public boolean LOG = true;
//    public Context app = null;

    public OkHttpConfig(String responseCache, int responseCacheSize, int httpConnectTimeout, int httpReadTimeout, boolean isLog, String logTag, ArrayMap<String, String> header) {
        this.RESPONSE_CACHE = responseCache;
        this.RESPONSE_CACHE_SIZE = responseCacheSize;
        this.HTTP_CONNECT_TIMEOUT = httpConnectTimeout;
        this.HTTP_READ_TIMEOUT = httpReadTimeout;
        this.LOG = isLog;
        this.LOG_TAG = logTag;
        this.header = header;
    }


    public String getLogTag() {
        return this.LOG_TAG;
    }

    public boolean isLog() {
        return this.LOG;
    }

    public static class OkHttpConfigBuilder {

        public ArrayMap<String, String> header;
        public String logTag = "RetrofitUtil";
        public String responseCache = "retrofit_util_cache";
        public int responseCacheSize = 5 * 1000;
        public int httpConnectTimeout = 8 * 1000;
        public int httpReadTimeout = 5 * 1000;
        public boolean isLog = BuildConfig.DEBUG;

        public OkHttpConfigBuilder responseCacheDir(String response_cache) {
            this.responseCache = response_cache;
            return this;
        }

        public OkHttpConfigBuilder responseCacheSize(int response_cache_size) {
            this.responseCacheSize = response_cache_size;
            return this;
        }

        public OkHttpConfigBuilder connectionTimeout(int http_connect_timeout) {
            this.httpConnectTimeout = http_connect_timeout;
            return this;
        }

        public OkHttpConfigBuilder readTimeout(int http_read_timeout) {
            this.httpReadTimeout = http_read_timeout;
            return this;
        }


        public OkHttpConfigBuilder log(boolean log) {
            this.isLog = log;
            return this;
        }

        public OkHttpConfigBuilder logTag(String log_tag) {
            this.logTag = log_tag;
            return this;
        }

        public OkHttpConfigBuilder header(ArrayMap<String, String> header) {
            this.header = header;
            return this;
        }

        public OkHttpConfig build() {
            return new OkHttpConfig(responseCache, responseCacheSize, httpConnectTimeout, httpReadTimeout, isLog, logTag, header);
        }
    }
}
