package com.res.sqlite;

/**
 * Class Descriptions.
 * User: Riemannh
 * Date: 13-1-6
 * Time: 上午6:58
 * version:[]
 */
public class SQLConstant {
    public static final String DATABASE_NAME = "RESTAURANT_DATA_BASE";
    public static final int DATABASE_VERSION = 1;

    //建表语句
    public static final String CREATE_TABLE_DISH_INFO = "CREATE TABLE DISH_INFO " +
            "(" +
            "id Varchar2(16) NOT NULL," +
            "name Varchar2(256) NOT NULL," +
            "type_id Varchar2(16) NOT NULL," +
            "price Number NOT NULL," +
            "discount number NULL," +
            "note Varchar2(16) NOT NULL," +
            "small_pic_addr Varchar2(16) NULL," +
            "big_pic_addr Varchar2(16) NULL," +
            "video_addr Varchar2(16) NULL," +
            "audio_addr Varchar2(16) NULL," +
            ")";
    public static final String CREATE_TABLE_DISH_TYPE = "CREATE TABLE DISH_TYPE " +
            "(" +
            "id Varchar2 not null," +
            "name Varchar2 not null," +
            "small_pic_addr Varchar2 null," +
            "big_pic_addr Varchar2 null," +
            "video_addr Varchar2 null," +
            "audio_addr Varchar2 null" +
            ")";
    public static final String CREATE_TABLE_TABLE_INFO = "CREATE TABLE table_info" +
            "(" +
            "id  Varchar2  not null," +
            "name  Varchar2  not null," +
            "address  Varchar2  null," +
            "info  Varchar2  null," +
            "Status  Varchar2 null" +
            ")";
    /**
     * status 订单状态 1.预定；2，下单；3，完成；4，取消
     */
    public static final String CREATE_TABLE_ORDER_INFO = "CREATE TABLE order_info" +
            "(" +
            "id Varchar2  not null," +
            "table_id  Varchar2  not null," +
            "total_price Varchar2  not null," +
            "dish_id Varchar2  not null," +
            "count Varchar2 not null" +
            "create_time Varchar2 not null," +
            "status Varchar2  not null" +
            ")";

    //删除表格语句
    public static final String DROP_TABLE_DISH_INFO = "DROP TABLE DISH_INFO";
    public static final String DROP_TABLE_DISH_TYPE = "DROP TABLE DISH_TYPE";
    public static final String DROP_TABLE_TABLE_INFO = "DROP TABLE TABLE_INFO";
    public static final String DROP_TABLE_ORDER_INFO = "DROP TABLE ORDER_INFO";
}
