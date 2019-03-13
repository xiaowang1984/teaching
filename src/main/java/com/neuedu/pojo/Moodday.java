package com.neuedu.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Moodday {
    private Integer id;

    private Date dat;

    private BigDecimal val;

    private Integer grade;

    private Integer stucount;

    private Integer comcount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDat() {
        return dat;
    }

    public void setDat(Date dat) {
        this.dat = dat;
    }

    public BigDecimal getVal() {
        return val;
    }

    public void setVal(BigDecimal val) {
        this.val = val;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getStucount() {
        return stucount;
    }

    public void setStucount(Integer stucount) {
        this.stucount = stucount;
    }

    public Integer getComcount() {
        return comcount;
    }

    public void setComcount(Integer comcount) {
        this.comcount = comcount;
    }
}