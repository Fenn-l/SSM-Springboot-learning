package com.ape.springboot_data_mybatis_01.pojo;

import java.io.Serializable;

public class QueryParam implements Serializable{
    private int page;
    private int rows;


    @Override
    public String toString() {
        return "QueryParam{" +
                "page=" + page +
                ", rows=" + rows +
                '}';
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public QueryParam() {
    }

    public QueryParam(int page, int rows) {
        this.page = page;
        this.rows = rows;
    }
}
