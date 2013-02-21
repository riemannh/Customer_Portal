package com.res.memory;

import com.res.beans.DishOrder;

import java.util.*;

/**
 * <p>
 * </p>
 * User: LICHEN
 * Date: 13-1-14
 * Time: 下午9:52
 * version: v1.0
 * since: v1.0
 */
public final class DishMemory {
    private static Map<String, DishOrder> dishOrderMap;

    private static DishMemory dishMemory = new DishMemory();

    //桌号
    private static String tableNo;

    //订单号
    private static String orderSeq;

    private DishMemory() {
        dishOrderMap = new HashMap<String, DishOrder>();
    }

    public static DishMemory getInstance() {
        return dishMemory;
    }

    /**
     * 添加订单
     *
     * @param dishOrder
     */
    public void addDishOrder(DishOrder dishOrder) {
        if (dishOrder == null || null == dishOrder.getName()) {
            throw new IllegalArgumentException();
        }
        if (isOrdered(dishOrder.getName())) {
            DishOrder orderedDish = dishOrderMap.get(dishOrder.getName());
            int count = orderedDish.getCount();
            orderedDish.setCount(++count);
            dishOrderMap.put(dishOrder.getName(), orderedDish);
        } else {
            dishOrderMap.put(dishOrder.getName(), dishOrder);
        }
    }

    /**
     * 删除订单
     *
     * @param name
     */
    public void removeDishOrder(String name) {
        dishOrderMap.remove(name);
    }

    /**
     * 清空订单
     */
    public void clearDishOrder() {
        dishOrderMap.clear();
    }

    /**
     * 订单数量
     *
     * @return
     */
    public int size() {
        return dishOrderMap.size();
    }

    public boolean isEmpty() {
        return dishOrderMap.isEmpty();
    }

    /**
     * 列出已点菜单名
     *
     * @return
     */
    public List<String> listOrderName() {
        Set<String> dishNameSet = dishOrderMap.keySet();
        List<String> nameList = new ArrayList<String>();
        nameList.addAll(dishNameSet);
        return nameList;
    }

    /**
     * 列出已点订单信息
     *
     * @return
     */
    public List<DishOrder> listDishOrder() {
        Collection<DishOrder> dishOrders = dishOrderMap.values();
        List<DishOrder> dishOrderList = new ArrayList<DishOrder>();
        dishOrderList.addAll(dishOrders);
        return dishOrderList;
    }

    public List<Map<String, Object>> listDishOrderMap() {
        Map<String, Object> orderMap;
        Collection<DishOrder> dishOrders = dishOrderMap.values();
        List<Map<String, Object>> dishOrderList = new ArrayList<Map<String, Object>>();
        for (DishOrder dishOrder : dishOrders) {
            orderMap = new HashMap<String, Object>();
            orderMap.put("name", dishOrder.getName());
            orderMap.put("count", dishOrder.getCount());
            dishOrderList.add(orderMap);
        }
        return dishOrderList;
    }

    public double totalCost() {
        double totalCost = 0;
        Collection<DishOrder> dishOrders = dishOrderMap.values();
        for (DishOrder dishOrder : dishOrders) {
            totalCost += dishOrder.getPrice() * dishOrder.getCount();
        }
        return totalCost;
    }

    public void selectTable(String tableNo) {
        DishMemory.tableNo = tableNo;
        DishMemory.orderSeq = String.valueOf(System.currentTimeMillis());
    }

    public String getOrderSeq() {
        return DishMemory.orderSeq;
    }

    public String getTableNo() {
        return DishMemory.tableNo;
    }

    public void delete(String name) {
        dishOrderMap.remove(name);
    }

    /**
     * 校验菜是否已点
     *
     * @param name
     * @return
     */
    private boolean isOrdered(String name) {
        return dishOrderMap.containsKey(name);
    }


}
