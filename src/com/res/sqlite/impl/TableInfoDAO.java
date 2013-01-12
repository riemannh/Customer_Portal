package com.res.sqlite.impl;

import android.content.ContentValues;
import android.content.Context;
import com.res.beans.AbstractBean;
import com.res.beans.TableInfoBean;
import com.res.sqlite.ITableInfoDAO;
import com.res.sqlite.SQLiteBaseDAO;

import java.util.List;

/**
 * Class Descriptions.
 * User: Riemannh
 * Date: 13-1-8
 * Time: 上午7:19
 * version:[]
 */
public class TableInfoDAO extends SQLiteBaseDAO implements ITableInfoDAO {
    /**
     * 构造方法，创建了dbHelper对象
     *
     * @param cont
     */
    public TableInfoDAO(Context cont) {
        super(cont);
    }

    @Override
    public long insert(AbstractBean abstractBean) {
        ContentValues contentValues = new ContentValues();
        TableInfoBean tableInfoBean = (TableInfoBean) abstractBean;
        contentValues.put(TableInfoBean.NAME, tableInfoBean.getName());
        contentValues.put(TableInfoBean.ADDRESS, tableInfoBean.getAddress());
        contentValues.put(TableInfoBean.INFO, tableInfoBean.getInfo());
        contentValues.put(TableInfoBean.STATUS, tableInfoBean.getStatus());
        database.insert(TableInfoBean.TABLE_NAME, TableInfoBean.ID, contentValues);
        return 0;
    }

    @Override
    public boolean insert(List<TableInfoBean> tableInfoBeans) {
        for (TableInfoBean tableInfoBean : tableInfoBeans) {
            insert(tableInfoBean);
        }
        return true;
    }

    @Override
    public long update(AbstractBean abstractBean) {
        return 0;
    }

    public List<TableInfoBean> getAll() {
        database.query(TableInfoBean.TABLE_NAME, null, null, null, null, null, TableInfoBean.ID + " DESC");
        return null;
    }
}
