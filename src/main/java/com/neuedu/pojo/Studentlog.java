package com.neuedu.pojo;

import java.util.Date;

public class Studentlog {
    public Studentlog(){

    }
    private Integer id;

    private Integer sid;

    private Date dat;

    private Integer moodcode;

    private Integer lecturercode;

    private Integer managercode;

    private String wtxt;

    private String moodtxt;

    private String lecturertxt;

    private String managertxt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Date getDat() {
        return dat;
    }

    public void setDat(Date dat) {
        this.dat = dat;
    }

    public Integer getMoodcode() {
        return moodcode;
    }

    public void setMoodcode(Integer moodcode) {
        this.moodcode = moodcode;
    }

    public Integer getLecturercode() {
        return lecturercode;
    }

    public void setLecturercode(Integer lecturercode) {
        this.lecturercode = lecturercode;
    }

    public Integer getManagercode() {
        return managercode;
    }

    public void setManagercode(Integer managercode) {
        this.managercode = managercode;
    }

    public String getWtxt() {
        return wtxt;
    }

    public void setWtxt(String wtxt) {
        this.wtxt = wtxt == null ? null : wtxt.trim();
    }

    public String getMoodtxt() {
        return moodtxt;
    }

    public void setMoodtxt(String moodtxt) {
        this.moodtxt = moodtxt == null ? null : moodtxt.trim();
    }

    public String getLecturertxt() {
        return lecturertxt;
    }

    public void setLecturertxt(String lecturertxt) {
        this.lecturertxt = lecturertxt == null ? null : lecturertxt.trim();
    }

    public String getManagertxt() {
        return managertxt;
    }

    public void setManagertxt(String managertxt) {
        this.managertxt = managertxt == null ? null : managertxt.trim();
    }
}