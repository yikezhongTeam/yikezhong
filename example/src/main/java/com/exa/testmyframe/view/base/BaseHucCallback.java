package com.exa.testmyframe.view.base;

import android.content.Context;
import android.text.TextUtils;

import com.exa.framelib_rrm.base.model.http.tag.BaseTag;
import com.exa.framelib_rrm.base.view.BaseCallback;
import com.exa.framelib_rrm.utils.FrameLifeCircleLogUtils;
import com.exa.framelib_rrm.utils.ToastUtils;
import com.exa.testmyframe.model.bean.BaseResponse;
import com.exa.testmyframe.model.bean.Datas;
import com.exa.testmyframe.system.Constants;

/**
 * Created by acer on 2017/7/17.
 * 根据项目服务器返回的数据的结构进行修改
 * <Response, Data, Host>
 */
public abstract class BaseHucCallback<R, D, H, TAG extends BaseTag> extends BaseCallback<R, H, TAG> {

    public BaseHucCallback(H host, Context mContext) {
        super(host, mContext);
    }

//    @Override
//    protected boolean onDealNextResponse(R response, TAG tag) {
//        //FrameLifeCircleLogUtils.log("onDealNextResponse BaseHucCallback", tag);
//        if (response instanceof String) {//如果是网络请求或者本地操作，返回的是字符串
//            onNextSuccess((D) response, tag);
//        } else if(response instanceof BaseResponse){//如果是网络请求，并且返回的转换好的实体类
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
//        }else{
//            onNextSuccess((D) response, tag);
//        }
//        return false;//TODO 这里改成了false, 根据自己的需求修改
//    }

    @Override
    protected boolean onDealNextResponse(R response, TAG tag) {
        //FrameLifeCircleLogUtils.log("onDealNextResponse BaseHucCallback", tag);
        if(response instanceof BaseResponse){//如果是网络请求，并且返回的是转换好的实体类
            BaseResponse br = (BaseResponse) response;//TODO 不一定是BaseResponse，需要根据项目进行修改
            if (Constants.CODE_OK == br.code) {
                onNextSuccess((D) br.datas, tag);
            } else {
                onNextFailure(br, tag);
            }
        }else{//如果是网络请求，返回的是json字符串；或者本地操作，返回的是字符串或实体类
            //不需要处理结果，所以直接传到onNextSuccess里
            onNextSuccess((D) response, tag);
        }
        return false;//TODO 这里改成了false, 根据自己的需求修改
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
