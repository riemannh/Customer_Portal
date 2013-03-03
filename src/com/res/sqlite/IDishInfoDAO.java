package com.res.sqlite;

import com.res.pojo.DishInfoBean;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: haoguanghao
 * Date: 13-2-16
 * Time: 下午9:03
 * To change this template use File | Settings | File Templates.
 */
public interface IDishInfoDAO {

    void insertDishInfo(DishInfoBean dishInfoBean);

    void insertDishInfo(List<DishInfoBean> dishInfoBeans);

    void updateDishInfo(DishInfoBean dishInfoBean);

    List<DishInfoBean> getAllDishInfo();

    int getDishInfoCount();

    List<DishInfoBean> queryDishInfoList(int type);
}
