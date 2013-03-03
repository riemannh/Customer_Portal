package com.res.memory;

import android.graphics.Bitmap;

/**
 * <p>
 * 图片缓存
 * </p>
 * User: LICHEN
 * Date: 13-2-24
 * Time: 下午12:59
 * version: v1.0
 * since: v1.0
 */
public final class DishPicCache {
    private static DishPicCache dishPicCache = new DishPicCache();

    private DishPicCache() {

    }

    public static DishPicCache getInstance() {
        return dishPicCache;
    }

    public Bitmap getDishPicture(String key){
        return null;
    }

    public void putDishPicture2Cache(String key,Bitmap pic){

    }
}
