package com.neuedu.pojo;

import java.util.List;

public class Module {
    private Integer id;

    private String name;

    private Integer lId;

    private Integer sort;

    private Integer isDel;

    private List<Point> points;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

     public List<Point> getPoints() {
            return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getlId() {
        return lId;
    }

    public void setlId(Integer lId) {
        this.lId = lId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }
}