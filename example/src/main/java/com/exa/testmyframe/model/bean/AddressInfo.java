package com.exa.testmyframe.model.bean;

import java.io.Serializable;

/**
 * Created by acer on 2017/7/8.
 */
public class AddressInfo implements Serializable{

    public String address_id;//":"2",
    public String member_id;//":"2",
    public String true_name;//":"xxxxxx",
    public String area_id;//":"37",
    public String city_id;//":"36",
    public String area_info;//":"北京 北京市 东城区",
    public String address;//":"xxxxxxxxx",
    public String tel_phone;//":null,
    public String mob_phone;//":"15367889900",
    public String is_default;//":"1",
    public String dlyp_id;//":"0"

    public AddressInfo(String area_info) {
        this.area_info = area_info;
    }

    public AddressInfo() {
    }
}
