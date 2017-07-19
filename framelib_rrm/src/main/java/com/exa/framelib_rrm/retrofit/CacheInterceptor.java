package com.exa.framelib_rrm.retrofit;

import com.exa.framelib_rrm.utils.NetUtils;

import java.io.IOException;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by acer on 2017/7/18.
 * 缓存拦截器
 */
public class CacheInterceptor implements Interceptor{

    @Override
    public Response intercept(Chain chain) throws IOException {
        if(NetUtils.isConnected()){
            return chain.proceed(chain.request())
                    .newBuilder()
                    .removeHeader("pragma")//防止对下面的header("Cache-Control","max-age=0")产生影响
                    .removeHeader("Cache-Control")//防止对下面的header("Cache-Control","max-age=0")产生影响
                    .header("Cache-Control","max-age=0")
                    .build();
        }else{
            Request request = chain.request()
                    .newBuilder()
                    .cacheControl(CacheControl.FORCE_CACHE)
                    //.cacheControl(CacheControl.CACHED_ELSE_NETWORK)
                    .build();
            return chain.proceed(request);
        }
    }

}
