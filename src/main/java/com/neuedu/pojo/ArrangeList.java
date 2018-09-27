package com.neuedu.pojo;

import java.util.Date;

public class ArrangeList {
    private Integer id;

    private Integer aId;

    private Date date;

    private String morning;

    private String afternoon;

    private String night;

    private Float mtime;

    private Float atime;

    private Float ntime;

    private Integer isDel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMorning() {
        return morning;
    }

    public void setMorning(String morning) {
        this.morning = morning == null ? null : morning.trim();
    }

    public String getAfternoon() {
        return afternoon;
    }

    public void setAfternoon(String afternoon) {
        this.afternoon = afternoon == null ? null : afternoon.trim();
    }

    public String getNight() {
        return night;
    }

    public void setNight(String night) {
        this.night = night == null ? null : night.trim();
    }

    public Float getMtime() {
        return mtime;
    }

    public void setMtime(Float mtime) {
        this.mtime = mtime;
    }

    public Float getAtime() {
        return atime;
    }

    public void setAtime(Float atime) {
        this.atime = atime;
    }

    public Float getNtime() {
        return ntime;
    }

    public void setNtime(Float ntime) {
        this.ntime = ntime;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }
}