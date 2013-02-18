package com.res.beans;

/**
 * Created with IntelliJ IDEA.
 * User: haoguanghao
 * Date: 13-2-16
 * Time: 下午9:00
 * To change this template use File | Settings | File Templates.
 */
public class DishTypeBean extends DishBean {

    /**
     * "CREATE TABLE DISH_TYPE " +
     * "(" +
     * "id Varchar2 not null," +
     * "name Varchar2 not null," +
     * "small_pic_addr Varchar2 null," +
     * "big_pic_addr Varchar2 null," +
     * "video_addr Varchar2 null," +
     * "audio_addr Varchar2 null" +
     * ")"
     */

    public static final String TABLE_NAME = "DISH_TYPE";
}
