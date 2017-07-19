package com.exa.testmyframe.presenter;

import android.os.SystemClock;

import com.exa.framelib_rrm.base.model.http.tag.BaseTag;
import com.exa.framelib_rrm.retrofit.RetrofitHelper;
import com.exa.framelib_rrm.rx.RxCallback;
import com.exa.framelib_rrm.rx.RxHelper;
import com.exa.framelib_rrm.rx.RxBasePresenter;
import com.exa.testmyframe.model.bean.AddressInfo;
import com.exa.testmyframe.model.bean.ClassResponse;
import com.exa.testmyframe.model.http.TestApi;
import com.exa.testmyframe.system.Constants;

import io.reactivex.Observable;
import io.reactivex.Observer;

/**
 * Created by acer on 2017/7/15.
 * 使用Retrofit和RxJava请求网络数据；
 * 使用RxJava，执行本地异步耗时操作；
 * 使用RxJava，执行本地非耗时操作；
 * 不使用RxJava，执行本地非耗时操作；
 * 不使用RxJava，执行本地耗时操作；
 * 使用Retrofit和RxJava，请求网络数据，json，测试有参数的情况；
 * 不通过回调，执行本地非耗时操作；
 *
 * 非耗时操作可以使用回调，也可以不使用回调。
 */
public class TestReRxPresenter<T extends RxCallback> extends RxBasePresenter<T> {

    //使用Retrofit和RxJava，请求网络数据，转换成实体类
    public void testReRxGetBean(BaseTag tag){
        if(preCheck(true, tag)){//每个方法都必须先调用preCheck方法
            //因为createApi之后每个接口需要调用的方法不一样，所以无法再进行更多抽取
            Observable<ClassResponse> test = RetrofitHelper
                    .createApi(TestApi.class)
                    .testGetBean(Constants.LINK_MOBILE_CLASS);
            RxHelper.asyncGet(test, tag, this);
        }
    }

    //使用Retrofit和RxJava，请求网络数据，json
    public void testReRxGetString(BaseTag tag){
        if(preCheck(true, tag)){//每个方法都必须先调用preCheck方法
            Observable<String> test = RetrofitHelper
                    .createApi(TestApi.class)
                    .testGetJson(Constants.LINK_MOBILE_CLASS);
            RxHelper.asyncGet(test, tag, this);
        }
    }

    //使用RxJava，执行本地异步耗时操作
    public void testRxLocalAsync(BaseTag tag){
        if(preCheck(false, tag)){
            Observable<String> test = new Observable<String>() {
                @Override
                protected void subscribeActual(Observer<? super String> observer) {
                    for (int i = 0; i < 10; i++) {
                        SystemClock.sleep(1000);
                        observer.onNext("这是使用RxJava的第"+(i+1)+"个异步onNext");
                    }
                    observer.onComplete();
                }
            };
            RxHelper.asyncGet(test, tag, this);
        }
    }

    //使用RxJava，执行本地非耗时操作，得到字符串
    public void testRxLocalSyncGetString(BaseTag tag){
        if(preCheck(false, tag)){
            Observable<String> test = new Observable<String>() {
                @Override
                protected void subscribeActual(Observer<? super String> observer) {
                    //observer.onSubscribe();//不用手动调用？
                    for (int i = 0; i < 10; i++) {
                        observer.onNext("这是使用RxJava的第"+(i+1)+"个同步onNext");
                    }
                    observer.onComplete();
                }
            };
            RxHelper.syncGet(test, tag, this);
        }
    }

    //使用RxJava，执行本地非耗时操作，得到实体类
    public void testRxLocalSyncGetBean(BaseTag tag){
        if(preCheck(false, tag)){
            Observable<AddressInfo> test = new Observable<AddressInfo>() {
                @Override
                protected void subscribeActual(Observer<? super AddressInfo> observer) {
                    //observer.onSubscribe();//不用手动调用？
                    for (int i = 0; i < 10; i++) {
                        observer.onNext(new AddressInfo("这是使用RxJava的第"+(i+1)+"个同步onNext，实体类addressInfo"+(i+1)));
                    }
                    observer.onComplete();
                }
            };
            RxHelper.syncGet(test, tag, this);
        }
    }

    //不使用RxJava，执行本地非耗时操作
    public void testLocalSyncNoRx(BaseTag tag){
        if(preCheck(false, tag)){
//            //getMvpView().onRequestStart(tag);已经在preCheck方法里调用了，不需要再次调用
//            for (int i = 0; i < 10; i++) {
//                getMvpView().onNextResponse("这是不使用RxJava的第"+(i+1)+"个同步onNext", tag);
//            }
//            getMvpView().onRequestEnd(tag);

            getMvpView().onNextResponse("这是不使用RxJava的同步onNext", tag);
            getMvpView().onRequestEnd(tag);
        }
    }

    //不使用RxJava，执行本地耗时操作
    public void testLocalAsyncNoRx(final BaseTag tag){
        if(preCheck(false, tag)){
            new Thread(){
                @Override
                public void run() {
                    for (int i = 0; i <10 ; i++) {
                        SystemClock.sleep(1000);
                        //是在子线程里调用该方法的，所以在Activity里，如果需要更新UI，应该手动切换到主线程
                        getMvpView().onNextResponse("这是不使用RxJava第"+(i+1)+"个的同步onNext", tag);
                    }
                    //是在子线程里调用该方法的，所以在Activity里，如果需要更新UI，应该手动切换到主线程
                    getMvpView().onRequestEnd(tag);
                }
            }.start();
        }
    }

    //使用Retrofit和RxJava，请求网络数据，json，测试有参数的情况
    public void testReRxGetStringWithParam(BaseTag tag, String param){
        if(preCheck(true, tag, param)){//每个方法都必须先调用preCheck方法
            //因为createApi之后每个接口需要调用的方法不一样，所以无法再进行更多抽取
            Observable<String> test = RetrofitHelper
                    .createApi(TestApi.class)
                    .getNextGoodsClass(param);
            RxHelper.asyncGet(test, tag, this);
        }
    }

    //不通过回调，执行本地非耗时操作
    public int testNoCallback(int i){
        return i*100;
    }

}
