package com.exa.testmyframe.view.activity;

import android.content.Context;
import android.view.View;

import com.exa.framelib_rrm.base.model.http.tag.BaseTag;
import com.exa.framelib_rrm.utils.FrameLifeCircleLogUtils;
import com.exa.testmyframe.R;
import com.exa.testmyframe.presenter.TestHucPresenter;
import com.exa.testmyframe.system.Constants;
import com.exa.testmyframe.view.base.BaseActivity;
import com.exa.testmyframe.view.base.BaseHucCallback;

public class TestHucActivity extends BaseActivity<TestHucPresenter, TestHucActivity.HucCallback> {

    @Override
    protected int getContentViewId() {
        return R.layout.activity_test_huc;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initDatas() {
        bindPresenter(new TestHucPresenter(), new HucCallback(this, getApplicationContext()));
    }

    public void onButtonClick(View v){
        mPresenter.testHuc(Constants.LINK_MAIN + Constants.LINK_MOBILE_ADDRESS);
    }

    static class HucCallback extends BaseHucCallback<String, String, TestHucActivity, BaseTag> {

        public HucCallback(TestHucActivity host, Context mContext) {
            super(host, mContext);
        }

        @Override
        public String onCheckParamsLegality(BaseTag tag, Object... params) {
            FrameLifeCircleLogUtils.log("onCheckParamsLegality", tag);
            return null;
            //return "测试：参数异常提示信息";
        }

        @Override
        public void onRequestStart(BaseTag tag) {
            FrameLifeCircleLogUtils.log("onRequestStart", tag);
        }

        @Override
        protected void onNextSuccess(String datas, BaseTag tag) {
            FrameLifeCircleLogUtils.log("onNextSuccess", tag , datas);
        }

        @Override
        public void onRequestEnd(BaseTag tag) {
            FrameLifeCircleLogUtils.log("onRequestEnd", tag);
        }

    }

}
