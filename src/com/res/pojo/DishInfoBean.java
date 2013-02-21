package com.res.pojo;

/**
 * Created with IntelliJ IDEA.
 * User: haoguanghao
 * Date: 13-2-16
 * Time: 下午8:44
 * To change this template use File | Settings | File Templates.
 */
public class DishInfoBean extends DishBean {

    /**
     * "(" +
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
     * ")"
     */

    public static final String TABLE_NAME = "dish_info";
    public static final String DISH_TYPE = "type_id";
    public static final String PRICE = "price";
    public static final String DISCOUNT = "discount";
    public static final String NOTE = "note";


    private String typeId;
    private String price;
    private String discount;
    private String note;


    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }


    @Override
    public String toString() {
        return "DishInfoBean{" +
                "typeId='" + typeId + '\'' +
                ", price='" + price + '\'' +
                ", discount='" + discount + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
