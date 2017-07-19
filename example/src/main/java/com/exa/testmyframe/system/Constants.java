package com.exa.testmyframe.system;

/**
 * Created by acer on 2017/6/9.
 */
public class Constants {
    //系统常量
    public static final String SYSTEM_TYPE = "android";
    public static final String SYSTEM_VERSION = "V1.0";
    public static final String SYSTEM_SHARE_NAME = "Yokey_Nsg";

    //public static final String LINK_MAIN = "http://169.254.159.111/";
    //public static final String LINK_MAIN = "http://169.254.2.120/";
    //public static final String LINK_MAIN = "http://192.168.56.1/";
    //public static final String LINK_MAIN = "http://192.168.1.105/";

    public static final String LINK_MAIN = "http://192.168.56.1/";
    //   public static final String LINK_MAIN = "http://192.168.1.8/";
    //   public static final String LINK_MAIN = "http://169.254.135.84/";

    public static final String LINK_WAP = LINK_MAIN + "wap/";
    public static final String LINK_WAP_FIND_PASSWORD = LINK_WAP + "tmpl/member/find_password.html";

//    public static final String LINK_MOBILE = LINK_MAIN + "mobile/index.php?act=";
    public static final String LINK_MOBILE = "mobile/index.php?act=";
    public static final String LINK_MOBILE_INDEX = LINK_MOBILE + "index";                                                          //首页 GET
    public static final String LINK_MOBILE_LOGIN = LINK_MOBILE + "login";                                                          //登录 POST
    public static final String LINK_MOBILE_REG = LINK_MOBILE + "login&op=register";                                                //注册 POST
    public static final String LINK_MOBILE_LOGOUT = LINK_MOBILE + "logout";                                                        //注销 POST
    public static final String LINK_MOBILE_USER = LINK_MOBILE + "member_index";                                                    //个人中心 POST
    public static final String LINK_MOBILE_CLASS = LINK_MOBILE + "goods_class";                                                    //分类 GET
    public static final String LINK_MOBILE_CART = LINK_MOBILE + "member_cart&op=cart_list";                                        //购物车 POST
    public static final String LINK_MOBILE_CART_DEL = LINK_MOBILE + "member_cart&op=cart_del";                                     //购物车删除 POST
    public static final String LINK_MOBILE_CART_ADD = LINK_MOBILE + "member_cart&op=cart_add";                                     //购物车添加 POST
    public static final String LINK_MOBILE_AREA = LINK_MOBILE + "area&op=index";                                     //地区列表 POST
    public static final String LINK_MOBILE_ORDER = LINK_MOBILE + "member_order&op=order_list";                                     //所有订单 POST
    public static final String LINK_MOBILE_ORDER_CANCEL = LINK_MOBILE + "member_order&op=order_cancel";                            //取消订单 POST
    public static final String LINK_MOBILE_ORDER_REFOUND = LINK_MOBILE + "member_refund&op=get_refund_list&page=100";              //退款订单 GET
    public static final String LINK_MOBILE_ORDER_REFOUND_INFO = LINK_MOBILE + "member_refund&op=get_refund_info";                  //退款订单详细 GET
    public static final String LINK_MOBILE_ORDER_RETURN = LINK_MOBILE + "member_return&op=get_return_list&page=100";               //退货订单 GET
    public static final String LINK_MOBILE_ADDRESS = LINK_MOBILE + "member_address&op=address_list";                               //收货地址 POST
    public static final String LINK_MOBILE_ADDRESS_ADD = LINK_MOBILE + "member_address&op=address_add";                            //添加收货地址 POST
    public static final String LINK_MOBILE_ADDRESS_DEL = LINK_MOBILE + "member_address&op=address_del";                            //删除收货地址 POST
    public static final String LINK_MOBILE_ADDRESS_EDIT = LINK_MOBILE + "member_address&op=address_edit";                          //编辑收货地址 POST
    public static final String LINK_MOBILE_GOODS_BODY = LINK_MOBILE + "goods&op=goods_body";                                       //商品介绍 GET
    public static final String LINK_MOBILE_GOODS_DETAIL = LINK_MOBILE + "goods&op=goods_detail";                                   //商品详细 GET
    public static final String LINK_MOBILE_GOODS_SEARCH = LINK_MOBILE + "goods&op=goods_list&page=100";                            //商品搜索 GET
    public static final String LINK_MOBILE_COLLECTION_BROWS = LINK_MOBILE + "member_goodsbrowse&op=browse_list&page=100";          //我的足迹列表 POST
    public static final String LINK_MOBILE_COLLECTION_GOODS = LINK_MOBILE + "member_favorites&op=favorites_list&page=100";         //商品收藏列表 POST
    public static final String LINK_MOBILE_COLLECTION_GOODS_ADD = LINK_MOBILE + "member_favorites&op=favorites_add";               //商品收藏添加 POST
    public static final String LINK_MOBILE_COLLECTION_GOODS_DEL = LINK_MOBILE + "member_favorites&op=favorites_del";               //商品收藏删除 POST
    public static final String LINK_MOBILE_COLLECTION_GOODS_CHECK = LINK_MOBILE + "member_favorites&op=favorites_check";           //商品是否收藏 POST
    public static final String LINK_MOBILE_COLLECTION_STORE = LINK_MOBILE + "member_favorites_store&op=favorites_list&page=100";   //店铺收藏列表 POST
    public static final String LINK_MOBILE_COLLECTION_STORE_ADD = LINK_MOBILE + "member_favorites_store&op=favorites_add";         //店铺收藏添加 POST
    public static final String LINK_MOBILE_COLLECTION_STORE_DEL = LINK_MOBILE + "member_favorites_store&op=favorites_del";         //店铺收藏删除 POST
    public static final String LINK_MOBILE_COLLECTION_STORE_CHECK = LINK_MOBILE + "member_favorites_store&op=favorites_check";     //店铺是否收藏 POST
    public static final String LINK_MOBILE_BUY_SETUP1 = LINK_MOBILE + "member_buy&op=buy_step1";                                   //商品购买第一步 POST
    public static final String LINK_MOBILE_BUY_SETUP2 = LINK_MOBILE + "member_buy&op=buy_step2";                                   //商品购买第二步 POST
    public static final String LINK_MOBILE_PAY_LIST = LINK_MOBILE + "member_payment&op=payment_list";                              //支付方式列表 POST
    public static final String LINK_MOBILE_PAY_INFO = LINK_MOBILE + "member_buy&op=pay";                                           //订单信息 POST
    public static final String LINK_MOBILE_PAY = LINK_MOBILE + "member_payment&op=pay_new";                                        //支付 GET


    public static final String LINK_ANDROID = LINK_MAIN + "android/";
    public static final String LINK_ANDROID_API = LINK_ANDROID + "api/";
    public static final String LINK_ANDROID_API_ADVERT = LINK_ANDROID_API + "advert.php";
    public static final String LINK_ANDROID_API_SYSTEM = LINK_ANDROID_API + "system.php";
    public static final String LINK_ANDROID_PUBLIC = LINK_ANDROID + "public/";
    public static final String LINK_ANDROID_PUBLIC_HELP = LINK_ANDROID_PUBLIC + "help.html";
    public static final String LINK_ANDROID_PUBLIC_ABOUT = LINK_ANDROID_PUBLIC + "about.html";
    public static final String LINK_ANDROID_PUBLIC_VERSION = LINK_ANDROID_PUBLIC + "version.html";

    public static final int CODE_OK = 200;//成功
    //Client Error
    public static final int CODE_BAD_REQUEST = 400; //Bad Request 因为错误的语法导致服务器无法理解请求信息。可能是参数没传对，比如client的值写错了
    public static final int CODE_FORBIDDEN = 403;//403 Forbidden 服务器接受请求，但是被拒绝处理。
    public static final int CODE_NOT_FOUND = 404;//404 Not Found 服务器已经找到任何匹配Request-URI的资源。
    //Server Error
    public static final int CODE_INTERNAL_SERVER_ERROR = 500;//500 Internal Server Error 服务器遭遇异常阻止了当前请求的执行
    public static final int CODE_NOT_IMPLEMENTED = 501;//501 Not Implemented 服务器没有相应的执行动作来完成当前请求。
    public static final int CODE_BAD_GATEWAY = 502;//502 Bad Gateway
    public static final int CODE_SERVICE_UNAVALIABLE = 503;//503 Service Unavailable 因为临时文件超载导致服务器不能处理当前请求。
    public static final int CODE_GATEWAY_TIMEOUT = 504;//504 Gateway Timeout
    public static final int CODE_HTTP_VERSION_NOT_SUPPORTED = 505;//505 Http Version Not Supported

    public static final String CLIENT = "android";
    public static final int DEFAILT_TIMEOUT = 10;

    public static final byte TAG_INVALID = 0;
    public static final byte TAG_LOGIN = 1;
    public static final byte TAG_REGISTER = 2;
    public static final byte TAG_LOGOUT = 3;
    public static final byte TAG_GET_TOP_CLASS = 4;
    public static final byte TAG_GET_SENCOND_CLASS = 5;
    public static final byte TAG_GET_THIRD_CLASS = 6;
    public static final byte TAG_GET_GOODS_DETAIL = 7;
    public static final byte TAG_ADD_TO_CART = 8;
    public static final byte TAG_DELETE_FROM_CART = 9;
    public static final byte TAG_BUY_SETUP1 = 10;
    public static final byte TAG_BUY_SETUP2 = 17;
    public static final byte TAG_AREA_PROVINCE = 11;
    public static final byte TAG_AREA_CITY = 12;
    public static final byte TAG_AREA_DISTRICT = 13;
    public static final byte TAG_AREA_SAVE_ADDRESS = 14;
    public static final byte TAG_AREA_EDIT_ADDRESS = 15;
    public static final byte TAG_DELETE_ADDRESS = 16;

}
