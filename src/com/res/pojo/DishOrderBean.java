package com.res.pojo;

/**
 * Created with IntelliJ IDEA.
 * User: haoguanghao
 * Date: 13-2-21
 * Time: 下午10:14
 * To change this template use File | Settings | File Templates.
 */
public class DishOrderBean extends AbstractBean {
    /**
     * "(" +
     * "id Varchar2  not null," +
     * "table_id  Varchar2  not null," +
     * "total_price Varchar2  not null," +
     * "dish_id Varchar2  not null," +
     * "create_time date not null," +
     * "status Varchar2  not null" +
     * ")"
     */
    public static final String TABLE_NAME = "dish_order";
    public static final String TABLE_ID = "table_id";
    public static final String TOTAL_PRICE = "total_price";
    public static final String DISH_ID = "dish_id";
    public static final String COUNT = "count";
    public static final String CREATE_TIME = "create_time";
    public static final String STATUS = "status";

    private String tableId;
    private String totalPrice;
    private String dishId;
    private String count;
    private String createTime;
    private String status;

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getDishId() {
        return dishId;
    }

    public void setDishId(String dishId) {
        this.dishId = dishId;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "DishOrderBean{" +
                "tableId='" + tableId + '\'' +
                ", totalPrice='" + totalPrice + '\'' +
                ", dishId='" + dishId + '\'' +
                ", createTime='" + createTime + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
