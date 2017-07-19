package com.exa.testmyframe.model.bean;

import java.util.ArrayList;

/**
 * Created by acer on 2017/6/15.
 */
public class ClassResponse extends BaseResponse<ClassResponse.ClassDatas>{

    public static class ClassDatas extends Datas{
        public ArrayList<GoodsClass> class_list;
    }

    public static class GoodsClass{
        public String gc_id;
        public String gc_name;
        public String type_id;
        public String type_name;
        public String gc_parent_id;
        public String commis_rate;
        public String gc_sort;
        public String gc_virtual;
        public String gc_title;
        public String gc_keywords;
        public String gc_description;
        public String show_type;
        public String image;
        public String text;
        public int itemViewType;
        public ArrayList<GoodsClass> nextlevel;
        public boolean expanded;

        public int leftPosition;
    }

}
