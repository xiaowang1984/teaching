package com.neuedu.pojo;

import java.math.BigDecimal;

public class InterviewDetails {
    private Integer id;

    private Integer iId;

    private Integer sId;

    private Integer skill;

    private Integer express;

    private Integer isDel;

    private String mark;

    private Interview interview;

    private BigDecimal avgskill;

    private BigDecimal avgexpress;

    public BigDecimal getAvgskill() {
        return avgskill;
    }

    public void setAvgskill(BigDecimal avgskill) {
        this.avgskill = avgskill;
    }

    public BigDecimal getAvgexpress() {
        return avgexpress;
    }

    public void setAvgexpress(BigDecimal avgexpress) {
        this.avgexpress = avgexpress;
    }

    public Interview getInterview() {
        return interview;
    }

    public void setInterview(Interview interview) {
        this.interview = interview;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getiId() {
        return iId;
    }

    public void setiId(Integer iId) {
        this.iId = iId;
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public Integer getSkill() {
        return skill;
    }

    public void setSkill(Integer skill) {
        this.skill = skill;
    }

    public Integer getExpress() {
        return express;
    }

    public void setExpress(Integer express) {
        this.express = express;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
    }
}