package com.res.sqlite.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.res.pojo.DishInfoBean;
import com.res.sqlite.IDishInfoDAO;
import com.res.sqlite.SQLiteBaseDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: haoguanghao
 * Date: 13-2-16
 * Time: 下午9:06
 * To change this template use File | Settings | File Templates.
 */
public class DishInfoDAO extends SQLiteBaseDAO implements IDishInfoDAO {
    /**
     * 构造方法，创建了dbHelper对象
     *
     * @param cont
     */
    public DishInfoDAO(Context cont) {
        super(cont);
    }

    public void insertDishInfo(DishInfoBean dishInfoBean) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DishInfoBean.ID, dishInfoBean.getId());
        contentValues.put(DishInfoBean.NAME, dishInfoBean.getName());
        contentValues.put(DishInfoBean.DISH_TYPE, dishInfoBean.getTypeId());
        contentValues.put(DishInfoBean.PRICE, dishInfoBean.getPrice());
        contentValues.put(DishInfoBean.DISCOUNT, dishInfoBean.getDiscount());
        contentValues.put(DishInfoBean.NOTE, dishInfoBean.getNote());
        contentValues.put(DishInfoBean.SMALL_PICTURE_ADDRESS, dishInfoBean.getSmallPictureAddress());
        contentValues.put(DishInfoBean.BIG_PRICTURE_ADDRESS, dishInfoBean.getBigPictureAddress());
        contentValues.put(DishInfoBean.VIDEO_ADDRESS, dishInfoBean.getVideoAddress());
        contentValues.put(DishInfoBean.AUDIO_ADDRESS, dishInfoBean.getAudioAddress());
        database.insert(DishInfoBean.TABLE_NAME, DishInfoBean.ID, contentValues);
    }

    public void insertDishInfo(List<DishInfoBean> dishInfoBeans) {
        for (DishInfoBean dishInfoBean : dishInfoBeans) {
            insertDishInfo(dishInfoBean);
        }
    }

    public void updateDishInfo(DishInfoBean dishInfoBean) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * "id Varchar2(16) NOT NULL," +
     * "name Varchar2(256) NOT NULL," +
     * "type_id Varchar2(16) NOT NULL," +
     * "price Number NOT NULL," +
     * "discount number NULL," +
     * "note Varchar2(16) NOT NULL," +
     * "small_pic_addr Varchar2(16) NULL," +
     * "big_pic_addr Varchar2(16) NULL," +
     * "video_addr Varchar2(16) NULL," +
     * "audio_addr Varchar2(16) NULL," +
     *
     * @return
     */
    public List<DishInfoBean> getAllDishInfo() {
        Cursor cursor = getDishInfoCursor();
        List<DishInfoBean> dishInfoBeans = new ArrayList<DishInfoBean>();
        for (DishInfoBean dishInfoBean : dishInfoBeans) {
            dishInfoBean.setId(cursor.getString(0));
            dishInfoBean.setName(cursor.getString(1));
            dishInfoBean.setTypeId(cursor.getString(2));
            dishInfoBean.setPrice(cursor.getString(3));
            dishInfoBean.setDiscount(cursor.getString(4));
            dishInfoBean.setNote(cursor.getString(5));
            dishInfoBean.setSmallPictureAddress(cursor.getString(6));
            dishInfoBean.setBigPictureAddress(cursor.getString(7));
            dishInfoBean.setVideoAddress(cursor.getString(8));
            dishInfoBean.setAudioAddress(cursor.getString(9));
            dishInfoBeans.add(dishInfoBean);
        }
        return dishInfoBeans;
    }

    /**
     * 查询列表数量
     *
     * @return
     */
    public int getDishInfoCount() {
        Cursor cursor = getDishInfoCursor();
        return cursor.getCount();
    }

    /**
     * 根据type查询菜单列表
     *
     * @param type 菜品类型
     * @return
     */
    public List<DishInfoBean> queryDishInfoList(int type) {
        Cursor cursor =
                database.query(DishInfoBean.TABLE_NAME, null, DishInfoBean.DISH_TYPE + "=" + type, null, null, null,
                        null);
        List<DishInfoBean> dishInfoList = new ArrayList<DishInfoBean>();
        DishInfoBean dishInfoBean;
        for (int i = 0; i < cursor.getCount(); i++) {
            if (cursor.moveToNext()) {
                dishInfoBean = new DishInfoBean();
                dishInfoBean.setId(cursor.getString(0));
                dishInfoBean.setName(cursor.getString(1));
                dishInfoBean.setTypeId(cursor.getString(2));
                dishInfoBean.setPrice(cursor.getString(3));
                dishInfoBean.setDiscount(cursor.getString(4));
                dishInfoBean.setNote(cursor.getString(5));
                dishInfoBean.setSmallPictureAddress(cursor.getString(6));
                dishInfoBean.setBigPictureAddress(cursor.getString(7));
                dishInfoBean.setVideoAddress(cursor.getString(8));
                dishInfoBean.setAudioAddress(cursor.getString(9));
                dishInfoList.add(dishInfoBean);
            }
        }
        return dishInfoList;
    }

    /**
     * 查询菜单信息Cursor对象
     *
     * @return
     */
    private Cursor getDishInfoCursor() {
        return database.query(DishInfoBean.TABLE_NAME, null, null, null, null, null, DishInfoBean.ID + " DESC");
    }
}
