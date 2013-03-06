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
    public static final int DATABASE_VERSION = 5;

    //建表语句
    public static final String CREATE_TABLE_DISH_INFO = "CREATE TABLE DISH_INFO " +
            "(" +
            "id Varchar2(16) NOT NULL," +
            "name Varchar2(256)," +
            "type_id Varchar2(16)," +
            "price Number," +
            "discount number," +
            "note Varchar2(16)," +
            "small_pic_addr Varchar2(16)," +
            "big_pic_addr Varchar2(16)," +
            "video_addr Varchar2(16)," +
            "audio_addr Varchar2(16)" +
            ")";
    public static final String CREATE_TABLE_DISH_TYPE = "CREATE TABLE DISH_TYPE " +
            "(" +
            "id Varchar2," +
            "name Varchar2," +
            "small_pic_addr Varchar2," +
            "big_pic_addr Varchar2," +
            "video_addr Varchar2," +
            "audio_addr Varchar2" +
            ")";
    public static final String CREATE_TABLE_TABLE_INFO = "CREATE TABLE TABLE_INFO" +
            "(" +
            "id  Varchar2," +
            "name  Varchar2," +
            "address  Varchar2," +
            "info  Varchar2," +
            "Status  Varchar2" +
            ")";
    /**
     * status 订单状态 1.预定；2，下单；3，完成；4，取消
     */
    public static final String CREATE_TABLE_ORDER_INFO = "CREATE TABLE ORDER_INFO" +
            "(" +
            "id Varchar2," +
            "table_id  Varchar2," +
            "total_price Varchar2," +
            "dish_id Varchar2," +
            "count Varchar2" +
            "create_time Varchar2," +
            "status Varchar2" +
            ")";

    //删除表格语句
    public static final String DROP_TABLE_DISH_INFO = "DROP TABLE IF EXISTS DISH_INFO";
    public static final String DROP_TABLE_DISH_TYPE = "DROP TABLE IF EXISTS DISH_TYPE";
    public static final String DROP_TABLE_TABLE_INFO = "DROP TABLE IF EXISTS TABLE_INFO";
    public static final String DROP_TABLE_ORDER_INFO = "DROP TABLE IF EXISTS ORDER_INFO";
}
