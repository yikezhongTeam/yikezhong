package com.exa.testmyframe.model.bean;

import java.util.ArrayList;

/**
 * Created by acer on 2017/7/17.
 */
public class AddressListResponse extends BaseResponse<AddressListResponse.AddressListDatas>{

    public class AddressListDatas extends Datas{
        public ArrayList<AddressInfo> address_list;
    }

}
