package com.res.sqlite;

import com.res.pojo.DishOrderBean;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: PC
 * Date: 13-2-25
 * Time: 上午6:42
 * To change this template use File | Settings | File Templates.
 */
public interface IDishOrderDAO {

    void insertDishOrder(DishOrderBean dishOrderBean);

    void insertDishOrderList(List<DishOrderBean> dishOrderBeanList);

    void deleteDishOrderListAll();
}
