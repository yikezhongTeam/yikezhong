package com.exa.testmyframe.view.activity;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;

import com.exa.framelib_rrm.base.model.http.tag.BaseTag;
import com.exa.framelib_rrm.retrofit.RetrofitHelper;
import com.exa.framelib_rrm.utils.FrameLifeCircleLogUtils;
import com.exa.framelib_rrm.utils.ToastUtils;
import com.exa.testmyframe.R;
import com.exa.testmyframe.model.bean.AddressInfo;
import com.exa.testmyframe.model.bean.ClassResponse;
import com.exa.testmyframe.presenter.TestReRxPresenter;
import com.exa.testmyframe.system.Constants;
import com.exa.testmyframe.view.base.BaseActivity;
import com.exa.testmyframe.view.base.BaseReRxCallback;

/*
 *注意：
 * 当本页面上有多个Presenter里的方法需要用到Callback的话，每个用到Callback的方法都需要传一个BaseTag，而且不能重复；
 * 如果本页面只有一个方法要用到Callback，可以不传BaseTag；
 */
public class TestReRxActivity extends BaseActivity<TestReRxPresenter, TestReRxActivity.ReRxCallback> {

    private static final byte TAG_1 = 1;
    private static final byte TAG_2 = 2;
    private static final byte TAG_3 = 3;
    private static final byte TAG_4 = 4;
    private static final byte TAG_5 = 5;
    private static final byte TAG_6 = 6;
    private static final byte TAG_7 = 7;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_test_re_rx;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initDatas() {
        bindPresenter(new TestReRxPresenter<ReRxCallback>(),
                new ReRxCallback(this, getApplicationContext()));
        RetrofitHelper.init(Constants.LINK_MAIN);//初始化Retrofit默认的BaseUrl，只需要初始化一次
    }

    public void onButtonClick(View v){
        switch(v.getId()){
            case R.id.btn_test1:
                mPresenter.testReRxGetString(new BaseTag(TAG_1));
                mPresenter.testReRxGetBean(new BaseTag(TAG_2));
                break;
            case R.id.btn_test2:
                mPresenter.testRxLocalAsync(new BaseTag(TAG_3));
                break;
            case R.id.btn_test3:
                mPresenter.testRxLocalSyncGetString(new BaseTag(TAG_4));
                break;
            case R.id.btn_test4:
                mPresenter.testLocalSyncNoRx(new BaseTag(TAG_4));
                break;
            case R.id.btn_test5:
                mPresenter.testLocalAsyncNoRx(new BaseTag(TAG_5));
                break;
            case R.id.btn_test6:
                mPresenter.testReRxGetStringWithParam(new BaseTag(TAG_6), "1");
                //mNetPresenter.testReRxGetStringWithParam(new BaseTag(TAG_6), "一");
                break;
            case R.id.btn_test7:
                int result = mPresenter.testNoCallback(1);
                ToastUtils.show(this, "result="+result);
                break;
            case R.id.btn_test8:
                mPresenter.testRxLocalSyncGetBean(new BaseTag(TAG_7));
                break;
            case R.id.btn_next:
                startActivity(new Intent(this, TestHucActivity.class));
                break;
            default:
                break;
        }
    }

    private void dismissLoadingDialog(BaseTag tag) {

    }

    private void showLoadingDialog(BaseTag tag) {

    }

    static class ReRxCallback extends BaseReRxCallback<Object, Object, TestReRxActivity, BaseTag> {

        public ReRxCallback(TestReRxActivity host, Context context) {
            super(host, context);
        }

        @Override
        public String onCheckParamsLegality(BaseTag tag, Object...params) {
            FrameLifeCircleLogUtils.log("本次请求开始 onCheckParamsLegality", tag);
            if(tag.tag == TAG_1){
                return null;
            }else if(tag.tag == TAG_2) {
                return "第二个接口 测试：参数格式不正确";
            }else if(tag.tag == TAG_6) {
                if(!TextUtils.isDigitsOnly((String)params[0])){//如果不是数字的话
                    return "参数gc_id格式不正确";
                }
            }
            return null;
        }

        @Override
        public void onRequestStart(BaseTag tag) {
            FrameLifeCircleLogUtils.log("onRequestStart", tag);
            getHost().showLoadingDialog(tag);
        }

        @Override
        protected void onNextSuccess(Object datas, BaseTag tag) {
            if(tag.tag == TAG_1){
                FrameLifeCircleLogUtils.log("onNextSuccess", tag, "str length="+((String)datas).length());
            }else if(tag.tag == TAG_2){
                FrameLifeCircleLogUtils.log("onNextSuccess", tag ,"list="+((ClassResponse.ClassDatas)datas).class_list);
            }else if(tag.tag == TAG_7){
                FrameLifeCircleLogUtils.log("onNextSuccess", tag ,"bean="+((AddressInfo)datas).area_info);
            }else{
                FrameLifeCircleLogUtils.log("onNextSuccess", tag ,"str="+datas);
            }
        }

//        @Override
//        protected void onNextFailure(BaseTag tag) {
//            FrameLifeCircleLogUtils.log("onNextFailure", tag);
//        }

        @Override
        public void onRequestEnd(BaseTag tag) {
            FrameLifeCircleLogUtils.log("本次请求结束 onRequestEnd", tag);
            getHost().dismissLoadingDialog(tag);
        }

    }

}
