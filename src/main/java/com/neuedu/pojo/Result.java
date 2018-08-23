package com.neuedu.pojo;

import java.util.List;

public class Result {
    private List<?> list;
    private Integer totalPage;
    private Integer pageNo;

    public Result(List<?> list, Integer totalPage, Integer pageNo) {
        this.list = list;
        this.totalPage = totalPage;
        this.pageNo = pageNo;
    }

    public List<?> getList() {
        return list;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public Integer getPageNo() {
        return pageNo;
    }
}
