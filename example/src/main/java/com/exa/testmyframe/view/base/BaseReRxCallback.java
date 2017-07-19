package com.exa.testmyframe.view.base;

import android.content.Context;
import android.text.TextUtils;

import com.exa.framelib_rrm.base.model.http.tag.BaseTag;
import com.exa.framelib_rrm.rx.RxCallback;
import com.exa.framelib_rrm.utils.FrameLifeCircleLogUtils;
import com.exa.framelib_rrm.utils.ToastUtils;
import com.exa.testmyframe.model.bean.BaseResponse;
import com.exa.testmyframe.system.Constants;

/**
 * Created by acer on 2017/7/16.
 * 一般一个项目只使用一个网络请求框架的话，写一个这样的类就行了；
 * 如果有多个网络请求框架，可能需要写多个，主要区别在于onDealNextResponse方法
 */
//<Response, Data, Host>
public abstract class BaseReRxCallback<R, D, H, TAG extends BaseTag> extends RxCallback<R, H, TAG> {

    public BaseReRxCallback(H host, Context mContext) {
        super(host, mContext);
    }

//    @Override
//    protected boolean onDealNextResponse(R response, TAG tag) {
//        //FrameLifeCircleLogUtils.log("onDealNextResponse BaseReRxCallback", tag);
//        if (response instanceof String) {//如果返回的是json字符串
//            onNextSuccess((D) response, tag);
//        } else {//如果返回的转换好的实体类
//            BaseResponse br = (BaseResponse) response;//TODO 不一定是BaseResponse，需要根据项目进行修改
//            if (Constants.CODE_OK == br.code) {
//                onNextSuccess((D) br.datas, tag);
//            } else {
//                if (!TextUtils.isEmpty(br.datas.error)) {
//                    ToastUtils.show(mAppContext, br.datas.error + "，错误码：" + br.code);
//                } else {
//                    ToastUtils.show(mAppContext, "错误码：" + br.code);
//                }
//                onNextFailure(tag);
//            }
//        }
//        return super.onDealNextResponse(response, tag);//TODO 根据自己的需求修改返回值
//    }

    @Override
    protected boolean onDealNextResponse(R response, TAG tag) {
        //FrameLifeCircleLogUtils.log("onDealNextResponse BaseReRxCallback", tag);
        if (response instanceof BaseResponse) {//如果是网络请求，并且返回的是转换好的实体类
            BaseResponse br = (BaseResponse) response;//TODO 不一定是BaseResponse，需要根据项目进行修改
            if (Constants.CODE_OK == br.code) {
                onNextSuccess((D) br.datas, tag);
            } else {
                onNextFailure(br, tag);
            }
        } else {
            //如果是网络请求，返回的是json字符串；或者本地操作，返回的是字符串或实体类;
            //不需要处理结果，所以直接传到onNextSuccess里
            onNextSuccess((D) response, tag);
        }
        return super.onDealNextResponse(response, tag);//TODO 根据自己的需求修改返回值
    }

    protected abstract void onNextSuccess(D datas, TAG tag);

    //对返回码不是200的情况进行统一处理
    protected void onNextFailure(BaseResponse br, TAG tag){
        FrameLifeCircleLogUtils.log("onNextFailure", tag);
        if (!TextUtils.isEmpty(br.datas.error)) {
            ToastUtils.show(mAppContext, br.datas.error + "，错误码：" + br.code);
        } else {
            ToastUtils.show(mAppContext, "错误码：" + br.code);
        }
    }

}
