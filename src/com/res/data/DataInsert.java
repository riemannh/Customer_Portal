package com.res.data;

import android.content.Context;
import com.res.pojo.DishInfoBean;
import com.res.pojo.DishTypeBean;
import com.res.sqlite.IDishInfoDAO;
import com.res.sqlite.IDishTypeDAO;
import com.res.sqlite.impl.DishInfoDAO;
import com.res.sqlite.impl.DishTypeDAO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: haoguanghao
 * Date: 13-2-16
 * Time: 下午10:34
 * To change this template use File | Settings | File Templates.
 */
public class DataInsert {
    /**
     * 将测试数据插入到数据库中
     *
     * @param context
     */
    public void insertTestData(Context context) {
        DataPrepare dataPrepare = new DataPrepare();
        List<DishTypeBean> dishTypeBeans = dataPrepare.getDishTypeBeans();
        List<DishInfoBean> dishInfoBeans = dataPrepare.getDishInfoBeans();

        IDishTypeDAO dishTypeDAO = new DishTypeDAO(context);
        IDishInfoDAO dishInfoDAO = new DishInfoDAO(context);

        dishTypeDAO.insertDishInfo(dishTypeBeans);
        dishInfoDAO.insertDishInfo(dishInfoBeans);
    }
}
