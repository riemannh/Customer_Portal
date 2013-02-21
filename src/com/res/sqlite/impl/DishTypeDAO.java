package com.res.sqlite.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.res.pojo.DishTypeBean;
import com.res.sqlite.IDishTypeDAO;
import com.res.sqlite.SQLiteBaseDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: haoguanghao
 * Date: 13-2-16
 * Time: 下午10:15
 * To change this template use File | Settings | File Templates.
 */
public class DishTypeDAO extends SQLiteBaseDAO implements IDishTypeDAO {
    /**
     * 构造方法，创建了dbHelper对象
     *
     * @param cont
     */
    public DishTypeDAO(Context cont) {
        super(cont);
    }

    /**
     *  "id Varchar2 not null," +
     "name Varchar2 not null," +
     "small_pic_addr Varchar2 null," +
     "big_pic_addr Varchar2 null," +
     "video_addr Varchar2 null," +
     "audio_addr Varchar2 null" +
     * @param dishTypeBean
     */
    @Override
    public void insertDishInfo(DishTypeBean dishTypeBean) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DishTypeBean.NAME,dishTypeBean.getName());
        contentValues.put(DishTypeBean.SMALL_PICTURE_ADDRESS,dishTypeBean.getSmallPictureAddress());
        contentValues.put(DishTypeBean.BIG_PRICTURE_ADDRESS,dishTypeBean.getBigPictureAddress());
        contentValues.put(DishTypeBean.VIDEO_ADDRESS,dishTypeBean.getVideoAddress());
        contentValues.put(DishTypeBean.AUDIO_ADDRESS,dishTypeBean.getAudioAddress());
        database.insert(DishTypeBean.TABLE_NAME,DishTypeBean.ID,contentValues);
    }

    @Override
    public void insertDishInfo(List<DishTypeBean> dishTypeBeanList) {
        for (DishTypeBean dishTypeBean:dishTypeBeanList){
            insertDishInfo(dishTypeBean);
        }
    }

    @Override
    public void updateDishInfo(DishTypeBean dishTypeBean) {

    }

    /**
     *  "id Varchar2 not null," +
     "name Varchar2 not null," +
     "small_pic_addr Varchar2 null," +
     "big_pic_addr Varchar2 null," +
     "video_addr Varchar2 null," +
     "audio_addr Varchar2 null" +
     */
    @Override
    public List<DishTypeBean> getAllDishType() {
        Cursor cursor = database.query(DishTypeBean.TABLE_NAME, null, null, null, null, null, DishTypeBean.ID +" DESC");
        List<DishTypeBean> dishTypeBeans = new ArrayList<DishTypeBean>();
        for (DishTypeBean dishTypeBean:dishTypeBeans){
            dishTypeBean.setId(cursor.getString(0));
            dishTypeBean.setName(cursor.getString(1));
            dishTypeBean.setSmallPictureAddress(cursor.getString(2));
            dishTypeBean.setBigPictureAddress(cursor.getString(3));
            dishTypeBean.setVideoAddress(cursor.getString(4));
            dishTypeBean.setAudioAddress(cursor.getString(5));
            dishTypeBeans.add(dishTypeBean);
        }
        return dishTypeBeans;
    }
}
