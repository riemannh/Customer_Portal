package com.res.beans;

import java.io.Serializable;

/**
 * Class Descriptions.
 * User: Riemannh
 * Date: 13-1-8
 * Time: 下午9:46
 * version:[]
 */
public class AbstractBean {

    public static final String ID = "id";
    public static final String NAME = "name";

    protected String id;
    protected String name;

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

    @Override
    public String toString() {
        return "AbstractBean{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
