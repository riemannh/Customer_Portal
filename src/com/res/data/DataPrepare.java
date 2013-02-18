package com.res.data;

import com.res.beans.DishInfoBean;
import com.res.beans.DishTypeBean;

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
        dishTypeBean1.setName("招牌");
        dishTypeBeans.add(dishTypeBean1);

        DishTypeBean dishTypeBean2 = new DishTypeBean();
        dishTypeBean2.setName("热菜");
        dishTypeBeans.add(dishTypeBean2);

        DishTypeBean dishTypeBean3 = new DishTypeBean();
        dishTypeBean3.setName("凉菜");
        dishTypeBeans.add(dishTypeBean3);

        DishTypeBean dishTypeBean4 = new DishTypeBean();
        dishTypeBean4.setName("甜点");
        dishTypeBeans.add(dishTypeBean4);

        DishTypeBean dishTypeBean5 = new DishTypeBean();
        dishTypeBean5.setName("酒水");
        dishTypeBeans.add(dishTypeBean5);

        DishTypeBean dishTypeBean6 = new DishTypeBean();
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
        DishInfoBean dishInfoBean;
        dishInfoBean = new DishInfoBean();
        //    dishInfoBean.setName();
    }
}
