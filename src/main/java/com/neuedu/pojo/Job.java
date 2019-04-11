package com.neuedu.pojo;

public class Job extends Page{
    private Integer id;

    private String name;

    private Integer isDel;

    //是否为技术岗位
    private Integer is_type;

    public Integer getIs_type() {
        return is_type;
    }

    public void setIs_type(Integer is_type) {
        this.is_type = is_type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }
}