package com.exa.testmyframe.view.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.exa.framelib_rrm.base.presenter.BasePresenter;
import com.exa.framelib_rrm.base.view.BaseCallback;

/**
 * Created by acer on 2017/7/18.
 */
public abstract class BaseFragment<P extends BasePresenter, C extends BaseCallback> extends Fragment{

    protected View mView;
    protected P mPresenter;
    protected C mCallback;

//    public static BaseFragment getInstance(){
////        BaseFragment frag = new BaseFragment();
//        return frag;
//    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(getContentViewId(), container, false);
        return mView;
    }

    /**获取本页面的布局id*/
    protected abstract int getContentViewId();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViews();
        initDatas();
    }

    /**初始化控件*/
    protected abstract void initViews();

    /**初始化数据*/
    protected abstract void initDatas();

    /**
     * 关联Prsenter和Callback，
     * 不一定每个页面都需要请求网络，所以可以由子类选择是否调用这个方法
     * */
    protected void bindPresenter(P presenter, C callback) {
        mPresenter = presenter;
        mCallback = callback;
        mPresenter.attacView(mCallback);
    }

    @Override
    public void onDestroy() {
        //解除Prsenter和Callback关联
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        if (mCallback != null) {
            mCallback.onDestroy();
        }
        super.onDestroy();
    }

}
