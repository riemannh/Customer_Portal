package com.res.sqlite.impl;

import android.content.ContentValues;
import android.content.Context;
import com.res.pojo.DishOrderBean;
import com.res.sqlite.IOrderInfoDAO;
import com.res.sqlite.SQLiteBaseDAO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Welcome
 * Date: 13-2-21
 * Time: 上午7:58
 * To change this template use File | Settings | File Templates.
 */
public class OrderInfoDAO extends SQLiteBaseDAO implements IOrderInfoDAO {
    /**
     * 构造方法，创建了dbHelper对象
     *
     * @param cont
     */
    public OrderInfoDAO(Context cont) {
        super(cont);
    }

    @Override
    public void insertOrderInfo(DishOrderBean dishOrderBean) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DishOrderBean.TABLE_ID, dishOrderBean.getTableId());
        contentValues.put(DishOrderBean.TOTAL_PRICE, dishOrderBean.getTotalPrice());
        contentValues.put(DishOrderBean.DISH_ID, dishOrderBean.getDishId());
        contentValues.put(DishOrderBean.COUNT, dishOrderBean.getCount());
        contentValues.put(DishOrderBean.CREATE_TIME, dishOrderBean.getCreateTime());
        database.insert(DishOrderBean.TABLE_NAME, DishOrderBean.ID, contentValues);
    }

    @Override
    public void insertOrderInfoList(List<DishOrderBean> dishOrderBeanList) {
        for (DishOrderBean dishOrderBean : dishOrderBeanList) {
            insertOrderInfo(dishOrderBean);
        }
    }
}
