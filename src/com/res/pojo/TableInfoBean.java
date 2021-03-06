package com.res.pojo;

/**
 * Class Descriptions.
 * User: Riemannh
 * Date: 13-1-8
 * Time: 下午9:20
 * version:[]
 */
public class TableInfoBean extends AbstractBean {

    public static final String TABLE_NAME = "table_info";

    //表字段名称
    public static final String ADDRESS = "address";
    public static final String INFO = "info";
    public static final String STATUS = "status";

    public static final String AVAILABLE_STATUS = "0";
    public static final String BOOKED_STATUS = "1";
    public static final String USED_STATUS = "2";
    public static final String UNAVAILABLE_STATUS = "3";


    private String address;
    private String info;
    private String status;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TableInfoBean{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", info='" + info + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
