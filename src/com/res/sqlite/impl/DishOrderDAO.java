package com.res.sqlite.impl;

import android.content.ContentValues;
import android.content.Context;
import com.res.pojo.DishOrderBean;
import com.res.sqlite.IDishOrderDAO;
import com.res.sqlite.SQLiteBaseDAO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: PC
 * Date: 13-2-25
 * Time: 上午6:43
 * To change this template use File | Settings | File Templates.
 */
public class DishOrderDAO extends SQLiteBaseDAO implements IDishOrderDAO {
    /**
     * 构造方法，创建了dbHelper对象
     *
     * @param cont
     */
    public DishOrderDAO(Context cont) {
        super(cont);
    }

    @Override
    public void insertDishOrder(DishOrderBean dishOrderBean) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DishOrderBean.TABLE_ID, dishOrderBean.getTableId());
        contentValues.put(DishOrderBean.COUNT, dishOrderBean.getCount());
        contentValues.put(DishOrderBean.TOTAL_PRICE, dishOrderBean.getTotalPrice());
        contentValues.put(DishOrderBean.STATUS, dishOrderBean.getStatus());
        contentValues.put(DishOrderBean.CREATE_TIME, dishOrderBean.getCreateTime().toString());
        contentValues.put(DishOrderBean.DISH_ID, dishOrderBean.getDishId());
        database.insert(DishOrderBean.TABLE_NAME, DishOrderBean.ID, contentValues);
    }

    @Override
    public void insertDishOrderList(List<DishOrderBean> dishOrderBeanList) {
        for (DishOrderBean dishOrderBean : dishOrderBeanList) {
            insertDishOrder(dishOrderBean);
        }
    }

    @Override
    public void deleteDishOrderListAll() {
        database.delete(DishOrderBean.TABLE_NAME, null, null);
    }
}
