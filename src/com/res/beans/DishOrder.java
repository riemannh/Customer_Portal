package com.res.beans;

import java.io.Serializable;

/**
 * <p>
 * 已点菜品订单信息
 * </p>
 * User: LICHEN
 * Date: 13-1-14
 * Time: 下午9:56
 * version: v1.0
 * since: v1.0
 */
public class DishOrder implements Serializable {
    private String id;
    private String name;
    private double price;
    private int count;

    public DishOrder(String name, double price, int count) {
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "DishOrder{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", count=" + count +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DishOrder dishOrder = (DishOrder) o;

        return !(name != null ? !name.equals(dishOrder.name) : dishOrder.name != null);

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
