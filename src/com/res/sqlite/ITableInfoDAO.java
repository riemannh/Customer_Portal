package com.res.sqlite;

import com.res.beans.AbstractBean;
import com.res.beans.TableInfoBean;

import java.util.List;

/**
 * Class Descriptions.
 * User: Riemannh
 * Date: 13-1-8
 * Time: 下午9:59
 * version:[]
 */
public interface ITableInfoDAO {

    /**
     * 新增桌位信息
     *
     * @param abstractBean
     * @return
     */
    long insert(AbstractBean abstractBean);

    /**
     * 批量新增桌位信息
     *
     * @param tableInfoBeans
     * @return
     */
    boolean insert(List<TableInfoBean> tableInfoBeans);

    /**
     * 更新桌位信息
     *
     * @param abstractBean
     * @return
     */
    long update(AbstractBean abstractBean);

    /**
     * 获得所有桌位信息
     *
     * @return
     */
    public List<TableInfoBean> getAll();
}
