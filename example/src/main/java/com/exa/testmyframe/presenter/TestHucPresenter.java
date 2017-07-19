package com.exa.testmyframe.presenter;

import com.exa.framelib_rrm.base.presenter.BasePresenter;
import com.exa.framelib_rrm.utils.HttpUtils;
import com.exa.testmyframe.view.base.BaseHucCallback;

/**
 * Created by acer on 2017/7/17.
 * 使用HttpURLConnection请求网络数据
 */
public class TestHucPresenter<T extends BaseHucCallback> extends BasePresenter<T> {

    //得到的是json字符串
    public void testHuc(String url){
        if(preCheck(true, null)){//每个方法都必须先调用preCheck方法
            //
            HttpUtils.doGetAsyn(url, new HttpUtils.CallBack() {
                @Override
                public void onRequestComplete(String result) {
                    getMvpView().onNextResponse(result, null);
                }

                @Override
                public void onError(Exception e) {
                    getMvpView().onError(e, null);
                }
            });
        }
    }

}
