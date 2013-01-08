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
    public static final String CREATE_TABLE_MENU_INFO = "CREATE TABLE MENU_INFO " +
            "(" +
            "id Varchar2(16) NOT NULL," +
            "name Varchar2(256) NOT NULL," +
            "price Number NOT NULL," +
            "discount number NULL," +
            "type Varchar2(16) NOT NULL," +
            "pic_min_id Varchar2(16) NULL," +
            "pic_max_id Varchar2(16) NULL," +
            "video_id Varchar2(16) NULL," +
            "audio_id Varchar2(16) NULL," +
            ")";
    public static final String CREATE_TABLE_MENU_TYPE = "CREATE TABLE menu_type " +
            "(" +
            "id Varchar2 not null," +
            "name Varchar2 not null," +
            "pic_min_id Varchar2 null," +
            "pic_max_id Varchar2 null," +
            "video_id Varchar2 null," +
            "audio_id Varchar2 null" +
            ")";
    public static final String CREATE_TABLE_TABLE_INFO = "CREATE TABLE table_info" +
            "(" +
            "id  Varchar2  not null," +
            "name  Varchar2  not null," +
            "address  Varchar2  null," +
            "info  Varchar2  null," +
            "Status  Varchar2 null" +
            ")";

    //删除表格语句
    public static final String DROP_TABLE_MENU_INFO = "DROP TABLE MENU_INFO";
    public static final String DROP_TABLE_MENU_TYPE = "DROP TABLE MENU_TYPE";
    public static final String DROP_TABLE_TABLE_INFO = "DROP TABLE TABLE_INFO";
}
