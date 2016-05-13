package com.system.entity;

import java.io.Serializable;
import java.util.List;

/**
 *
 * 分页pager对象
 * Created by king on 2016/5/13.
 */
public class Pager<T> implements Serializable {

    private int pageSize;//每页显示多少条数据

    private int currentPage;//当前显示的页数

    private int totalRecord;//总共有多少条记录

    private int totalPage;//总共有多少页记录

    private List<T> dataList;//要显示的内容列表

    public Pager() {
    }

    public Pager(int pageSize, int currentPage, int totalRecord, int totalPage, List<T> dataList) {
        this.pageSize = pageSize;
        this.currentPage = currentPage;
        this.totalRecord = totalRecord;
        this.totalPage = totalPage;
        this.dataList = dataList;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    @Override
    public String toString() {
        return "Pager{" +
                "pageSize=" + pageSize +
                ", currentPage=" + currentPage +
                ", totalRecord=" + totalRecord +
                ", totalPage=" + totalPage +
                ", dataList=" + dataList +
                '}';
    }
}
