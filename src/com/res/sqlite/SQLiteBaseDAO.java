package com.res.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;


/**
 * Class Descriptions.
 * User: Riemannh
 * Date: 13-1-5
 * Time: 下午8:54
 * version:[]
 */
public abstract class SQLiteBaseDAO {
    protected SQLiteDatabase database;
    protected Context context;
    protected SQLiteHelper dbHelper;

    /**
     * 构造方法，创建了dbHelper对象
     *
     * @param cont
     */
    public SQLiteBaseDAO(Context cont) {
        this.context = cont;
        dbHelper = new SQLiteHelper(context, SQLConstant.DATABASE_NAME, null, SQLConstant.DATABASE_VERSION);
    }


    /**
     * 打开数据库
     *
     * @throws SQLiteException
     */
    public void open() throws SQLiteException {
        try {
            database = dbHelper.getWritableDatabase();
        } catch (SQLiteException e) {
            Log.v("Open database exception caught", e.getMessage());
            database = dbHelper.getReadableDatabase();
        }
    }

    /**
     * 关闭数据库
     */
    public void close() {
        dbHelper.close();
    }

    /**
     * 删除所有的表
     */
    public void deleteTables() {
        database.execSQL(SQLConstant.DROP_TABLE_DISH_INFO);
        database.execSQL(SQLConstant.DROP_TABLE_DISH_TYPE);
        database.execSQL(SQLConstant.DROP_TABLE_TABLE_INFO);
    }


}
