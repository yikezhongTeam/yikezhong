package com.exa.testmyframe.model.bean;

/**
 * Created by acer on 2017/6/12.
 * {"code":200,"datas":{"username":"123","userid":"2","key":"10885b1fb62665d2692d301455ae6eef"}}
 * {"code":400,"datas":{"error":"登录失败"}}
 */
public class BaseResponse<T extends Datas> {

    public int code;
    public T datas;

    @Override
    public String toString() {
        return "code="+code+", "+datas.toString();
    }
}
