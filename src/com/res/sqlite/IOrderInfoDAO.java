package com.res.sqlite;

import com.res.pojo.DishOrderBean;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: haoguanghao
 * Date: 13-2-21
 * Time: 上午7:57
 * To change this template use File | Settings | File Templates.
 */
public interface IOrderInfoDAO {

    void insertOrderInfo(DishOrderBean dishOrderBean);

    void insertOrderInfoList(List<DishOrderBean> dishOrderBeanList);
}
