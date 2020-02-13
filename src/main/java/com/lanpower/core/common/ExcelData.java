package com.lanpower.core.common;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: pujx
 * @Date: 2019/5/13 16:22
 */
public class ExcelData implements Serializable {

    private static final long serialVersionUID = 4444017239100620999L;

    // 表头
    private String[] titles;

    // 数据
    private List<List<Object>> rows;

    // 页签名称
    private String name;

    public String[] getTitles() {
        return titles;
    }

    public void setTitles(String[] titles) {
        this.titles = titles;
    }

    public List<List<Object>> getRows() {
        return rows;
    }

    public void setRows(List<List<Object>> rows) {
        this.rows = rows;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
