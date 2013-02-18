package com.res.sqlite.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.res.beans.AbstractBean;
import com.res.beans.TableInfoBean;
import com.res.sqlite.ITableInfoDAO;
import com.res.sqlite.SQLiteBaseDAO;

import java.util.ArrayList;
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

    public long insertTableInfo(TableInfoBean tableInfoBean) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(TableInfoBean.NAME, tableInfoBean.getName());
        contentValues.put(TableInfoBean.ADDRESS, tableInfoBean.getAddress());
        contentValues.put(TableInfoBean.INFO, tableInfoBean.getInfo());
        contentValues.put(TableInfoBean.STATUS, tableInfoBean.getStatus());
        database.insert(TableInfoBean.TABLE_NAME, TableInfoBean.ID, contentValues);
        return 0;
    }

    public boolean insertTableInfo(List<TableInfoBean> tableInfoBeans) {
        for (TableInfoBean tableInfoBean : tableInfoBeans) {
            insertTableInfo(tableInfoBean);
        }
        return true;
    }

    public long updateTableInfo(AbstractBean abstractBean) {
        return 0;
    }

    /**
     * "CREATE TABLE table_info" +
     * "(" +
     * "id  Varchar2  not null," +
     * "name  Varchar2  not null," +
     * "address  Varchar2  null," +
     * "info  Varchar2  null," +
     * "Status  Varchar2 null" +
     * ")";
     *
     * @return
     */
    public List<TableInfoBean> getAllTableInfo() {
        Cursor cursor = database.query(TableInfoBean.TABLE_NAME, null, null, null, null, null, TableInfoBean.ID + " DESC");
        List<TableInfoBean> tableInfoBeans = new ArrayList<TableInfoBean>();
        for (TableInfoBean tableInfoBean : tableInfoBeans) {
            tableInfoBean.setInfo(cursor.getString(0));
            tableInfoBean.setName(cursor.getString(1));
            tableInfoBean.setAddress(cursor.getString(2));
            tableInfoBean.setInfo(cursor.getString(3));
            tableInfoBean.setStatus(cursor.getString(4));
            tableInfoBeans.add(tableInfoBean);
        }
        return tableInfoBeans;
    }
}
