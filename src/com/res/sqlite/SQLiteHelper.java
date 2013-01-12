package com.res.sqlite;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static android.database.sqlite.SQLiteDatabase.CursorFactory;

/**
 * Class Descriptions.
 * User: Riemannh
 * Date: 13-1-5
 * Time: 上午6:55
 * version:[]
 */
public class SQLiteHelper extends SQLiteOpenHelper {

    public SQLiteHelper(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.v("SQLiteHelper onCreate", "Creating all the tables");
        try {
            sqLiteDatabase.execSQL(SQLConstant.CREATE_TABLE_MENU_INFO);
            sqLiteDatabase.execSQL(SQLConstant.CREATE_TABLE_MENU_TYPE);
            sqLiteDatabase.execSQL(SQLConstant.CREATE_TABLE_TABLE_INFO);
        } catch (SQLException e) {
            Log.v("Create table exeception ", e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        String updateLog = "Upgrading from version " + oldVersion + " to " + newVersion + " , which will destory all old data";
        Log.w("TaskDBAdapter", updateLog);
        sqLiteDatabase.execSQL(SQLConstant.DROP_TABLE_MENU_INFO);
        sqLiteDatabase.execSQL(SQLConstant.DROP_TABLE_MENU_TYPE);
        sqLiteDatabase.execSQL(SQLConstant.DROP_TABLE_TABLE_INFO);
        onCreate(sqLiteDatabase);
    }


}
