package com.res.sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author h00187621
 * @version v1.0
 * @date 12-8-11,上午10:40
 * @since IOT-OMP 1.0
 */

public class SQLiteBasicDAOOldVersion<T> {

    private SQLiteDatabase datebase;

    private static SQLiteBasicDAOOldVersion sqLiteBasicDAOOldVersion;

    private SQLiteBasicDAOOldVersion() {
        openOrCreateDateBase();
    }

    public static SQLiteBasicDAOOldVersion getInstance() {
        if (sqLiteBasicDAOOldVersion == null) {
            sqLiteBasicDAOOldVersion = new SQLiteBasicDAOOldVersion();
        }
        return sqLiteBasicDAOOldVersion;
    }

    private void openOrCreateDateBase() {
        datebase = SQLiteDatabase.openOrCreateDatabase("datebase",
                new SQLiteDatabase.CursorFactory() {
                    public Cursor newCursor(
                            SQLiteDatabase sqLiteDatabase, SQLiteCursorDriver sqLiteCursorDriver, String s,
                            SQLiteQuery sqLiteQuery) {
                        return null;
                    }
                });
    }

    private void closeDateBase() {
        datebase.close();
    }

    public List<T> query(String sql, String[] arguments, T bean)
            throws InvocationTargetException, IllegalAccessException {
        List<T> resultList = new ArrayList<T>();
        Cursor cursor = datebase.rawQuery(sql, arguments);
        if (cursor != null) {
            Method[] methods = bean.getClass().getMethods();
            if (cursor.moveToFirst()) {
                do {
                    for (Method method : methods) {
                        String methodName = method.getName();
                        if ("set".equalsIgnoreCase(methodName.substring(0, 2))) {
                            int numColumn = cursor.getColumnIndex(methodName.substring(3, methodName.length()));
                            method.invoke(bean, cursor.getString(numColumn));
                        }
                    }
                    resultList.add(bean);
                } while (cursor.moveToNext());
            }
        }
        return resultList;
    }

    public SQLiteDatabase getDatebase() {
        return datebase;
    }

    public void setDatebase(SQLiteDatabase datebase) {
        this.datebase = datebase;
    }
}
