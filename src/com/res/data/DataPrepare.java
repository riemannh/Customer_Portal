package com.res.data;

import com.res.pojo.DishInfoBean;
import com.res.pojo.DishTypeBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: haoguanghao
 * Date: 13-2-16
 * Time: 下午10:24
 * To change this template use File | Settings | File Templates.
 */
public class DataPrepare {

    private List<DishTypeBean> dishTypeBeans;
    private List<DishInfoBean> dishInfoBeans;

    /**
     * 准备测试数据
     */
    public DataPrepare() {
        dishInfoBeans = new ArrayList<DishInfoBean>();
        dishTypeBeans = new ArrayList<DishTypeBean>();
        setDishInfoBeans();
        setDishTypeBeans();
    }

    public List<DishTypeBean> getDishTypeBeans() {
        return dishTypeBeans;
    }

    /**
     * 准备菜品类型数据
     */
    private void setDishTypeBeans() {
        DishTypeBean dishTypeBean1 = new DishTypeBean();
        dishTypeBean1.setId("1");
        dishTypeBean1.setName("招牌");
        dishTypeBeans.add(dishTypeBean1);

        DishTypeBean dishTypeBean2 = new DishTypeBean();
        dishTypeBean2.setId("2");
        dishTypeBean2.setName("热菜");
        dishTypeBeans.add(dishTypeBean2);

        DishTypeBean dishTypeBean3 = new DishTypeBean();
        dishTypeBean3.setId("3");
        dishTypeBean3.setName("凉菜");
        dishTypeBeans.add(dishTypeBean3);

        DishTypeBean dishTypeBean4 = new DishTypeBean();
        dishTypeBean4.setId("4");
        dishTypeBean4.setName("甜点");
        dishTypeBeans.add(dishTypeBean4);

        DishTypeBean dishTypeBean5 = new DishTypeBean();
        dishTypeBean5.setId("5");
        dishTypeBean5.setName("酒水");
        dishTypeBeans.add(dishTypeBean5);

        DishTypeBean dishTypeBean6 = new DishTypeBean();
        dishTypeBean6.setId("6");
        dishTypeBean6.setName("面食");
        dishTypeBeans.add(dishTypeBean6);
    }

    public List<DishInfoBean> getDishInfoBeans() {
        return dishInfoBeans;
    }

    /**
     * 准备菜品数据
     */
    private void setDishInfoBeans() {
        DishInfoBean dishInfoBean1 = new DishInfoBean();
        dishInfoBean1.setId("1");
        dishInfoBean1.setName("碳烤鳕鱼");
        dishInfoBean1.setTypeId("1");
        dishInfoBean1.setPrice("108");
        dishInfoBean1.setSmallPictureAddress("tankaoxueyu.jpg");
        dishInfoBeans.add(dishInfoBean1);
        DishInfoBean dishInfoBean2 = new DishInfoBean();
        dishInfoBean2.setId("2");
        dishInfoBean2.setName("生煎秋刀鱼");
        dishInfoBean2.setTypeId("1");
        dishInfoBean2.setPrice("66");
        dishInfoBean2.setSmallPictureAddress("shengjianqiudaoyu.jpg");
        dishInfoBeans.add(dishInfoBean2);
        DishInfoBean dishInfoBean3 = new DishInfoBean();
        dishInfoBean3.setId("3");
        dishInfoBean3.setName("香菇炖鸡");
        dishInfoBean3.setTypeId("2");
        dishInfoBean3.setPrice("30");
        dishInfoBean3.setSmallPictureAddress("xianggudunji.jpg");
        dishInfoBeans.add(dishInfoBean3);
        DishInfoBean dishInfoBean4 = new DishInfoBean();
        dishInfoBean4.setId("4");
        dishInfoBean4.setName("糖醋虾仁");
        dishInfoBean4.setTypeId("2");
        dishInfoBean4.setPrice("48");
        dishInfoBean4.setSmallPictureAddress("tangcuixiaren.jpg");
        dishInfoBeans.add(dishInfoBean4);
        DishInfoBean dishInfoBean5 = new DishInfoBean();
        dishInfoBean5.setId("5");
        dishInfoBean5.setName("四季时蔬");
        dishInfoBean5.setTypeId("3");
        dishInfoBean5.setPrice("10");
        dishInfoBean5.setSmallPictureAddress("sijishishu.jpg");
        dishInfoBeans.add(dishInfoBean5);
        DishInfoBean dishInfoBean6 = new DishInfoBean();
        dishInfoBean6.setId("6");
        dishInfoBean6.setName("清炒芦笋");
        dishInfoBean6.setTypeId("3");
        dishInfoBean6.setPrice("20");
        dishInfoBean6.setSmallPictureAddress("qingchaolusun.jpg");
        dishInfoBeans.add(dishInfoBean6);
        DishInfoBean dishInfoBean7 = new DishInfoBean();
        dishInfoBean7.setId("7");
        dishInfoBean7.setName("榴莲酥");
        dishInfoBean7.setTypeId("4");
        dishInfoBean7.setPrice("30");
        dishInfoBean7.setSmallPictureAddress("liuliansu.jpg");
        dishInfoBeans.add(dishInfoBean7);
        DishInfoBean dishInfoBean8 = new DishInfoBean();
        dishInfoBean8.setId("8");
        dishInfoBean8.setName("柠檬蛋糕");
        dishInfoBean8.setTypeId("4");
        dishInfoBean8.setPrice("20");
        dishInfoBean8.setSmallPictureAddress("ningmengdangao.jpg");
        dishInfoBeans.add(dishInfoBean8);
        DishInfoBean dishInfoBean9 = new DishInfoBean();
        dishInfoBean9.setId("9");
        dishInfoBean9.setName("芝华士");
        dishInfoBean9.setTypeId("5");
        dishInfoBean9.setPrice("320");
        dishInfoBean9.setSmallPictureAddress("chivas.jpg");
        dishInfoBeans.add(dishInfoBean9);
        DishInfoBean dishInfoBean10 = new DishInfoBean();
        dishInfoBean10.setId("10");
        dishInfoBean10.setName("陶醉");
        dishInfoBean10.setTypeId("5");
        dishInfoBean10.setPrice("120");
        dishInfoBean10.setSmallPictureAddress("taozui.jpg");
        dishInfoBeans.add(dishInfoBean10);
        DishInfoBean dishInfoBean11 = new DishInfoBean();
        dishInfoBean11.setId("11");
        dishInfoBean11.setName("牛肉面");
        dishInfoBean11.setTypeId("6");
        dishInfoBean11.setPrice("20");
        dishInfoBean11.setSmallPictureAddress("niuroumian.jpg");
        dishInfoBeans.add(dishInfoBean11);
        DishInfoBean dishInfoBean12 = new DishInfoBean();
        dishInfoBean12.setId("12");
        dishInfoBean12.setName("葱油饼");
        dishInfoBean12.setTypeId("6");
        dishInfoBean12.setPrice("22");
        dishInfoBean12.setSmallPictureAddress("congyoubing.jpg");
        dishInfoBeans.add(dishInfoBean12);
    }
}
