package com.res.sqlite;

import com.res.pojo.DishTypeBean;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: haoguanghao
 * Date: 13-2-16
 * Time: 下午10:14
 * To change this template use File | Settings | File Templates.
 */
public interface IDishTypeDAO {

    void insertDishInfo(DishTypeBean dishTypeBean);

    void insertDishInfo(List<DishTypeBean> dishTypeBeanList);

    void updateDishInfo(DishTypeBean dishTypeBean);

    List<DishTypeBean> getAllDishType();
}
