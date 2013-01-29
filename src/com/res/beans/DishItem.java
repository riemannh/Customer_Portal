package com.res.beans;

/**
 * <p>
 * </p>
 * User: LICHEN
 * Date: 13-1-15
 * Time: 下午9:20
 * version: v1.0
 * since: v1.0
 */
public class DishItem {
    private int iconRes;
    private String tag;
    private String price;

    public DishItem(int iconRes, String tag, String price) {
        this.iconRes = iconRes;
        this.tag = tag;
        this.price = price;
    }

    public int getIconRes() {
        return iconRes;
    }

    public void setIconRes(int iconRes) {
        this.iconRes = iconRes;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
