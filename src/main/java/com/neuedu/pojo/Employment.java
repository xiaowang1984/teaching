package com.neuedu.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Employment {
    private Integer id;

    private Integer sId;

    private String cName;
    private Integer jId=999;

    private Integer isSkill;

    private Integer type;

    private Integer offer;

    private Integer tId;

    private BigDecimal probation;

    private BigDecimal practice;

    private BigDecimal salary;

    private Integer insurance;

    private Integer fund;

    private Integer month;

    private Integer stock;

    private BigDecimal other;

    private Integer choice;

    //面试时间
    private Date cDate;

    //获得offer时间
    private Date offerDate;

    //就业时间
    private Date workDate;

    private Integer isDel;

    //岗位方向代号
    private Integer workType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public Integer getjId() {
        return jId;
    }

    public void setjId(Integer jId) {
        this.jId = jId;
    }

    public Integer getIsSkill() {
        return isSkill;
    }

    public void setIsSkill(Integer isSkill) {
        this.isSkill = isSkill;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getOffer() {
        return offer;
    }

    public void setOffer(Integer offer) {
        this.offer = offer;
    }

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public BigDecimal getProbation() {
        return probation;
    }

    public void setProbation(BigDecimal probation) {
        this.probation = probation;
    }

    public BigDecimal getPractice() {
        return practice;
    }

    public void setPractice(BigDecimal practice) {
        this.practice = practice;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Integer getInsurance() {
        return insurance;
    }

    public void setInsurance(Integer insurance) {
        this.insurance = insurance;
    }

    public Integer getFund() {
        return fund;
    }

    public void setFund(Integer fund) {
        this.fund = fund;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public BigDecimal getOther() {
        return other;
    }

    public void setOther(BigDecimal other) {
        this.other = other;
    }

    public Integer getChoice() {
        return choice;
    }

    public void setChoice(Integer choice) {
        this.choice = choice;
    }

    public Date getcDate() {
        return cDate;
    }

    public void setcDate(Date cDate) {
        this.cDate = cDate;
    }

    public Date getWorkDate() {
        return workDate;
    }

    public void setWorkDate(Date workDate) {
        this.workDate = workDate;
    }

    public Date getOfferDate() {
        return offerDate;
    }

    public void setOfferDate(Date offerDate) {
        this.offerDate = offerDate;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public Integer getWorkType() {
        return workType;
    }

    public void setWorkType(Integer workType) {
        this.workType = workType;
    }
}