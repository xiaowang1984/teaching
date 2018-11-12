package com.neuedu.pojo;

import java.util.Date;
import java.util.List;

public class Work extends Page{
    private Integer id;

    private Integer gid;

    private String name;

    private Integer level;

    private String extend;

    private Integer type;

    private Integer count;

    private Integer language;

    private String point;

    private String url;

    private Integer provider;

    private Integer isDel;

    private Date startDat;

    private Date endDat;

    private String description;

    private List<Workgrade> workgrade;

    private Integer done;

    private Integer code;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getExtend() {
        return extend;
    }

    public void setExtend(String extend) {
        this.extend = extend == null ? null : extend.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getLanguage() {
        return language;
    }

    public void setLanguage(Integer language) {
        this.language = language;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point == null ? null : point.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getProvider() {
        return provider;
    }

    public void setProvider(Integer provider) {
        this.provider = provider;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public Date getStartDat() {
        return startDat;
    }

    public void setStartDat(Date startDat) {
        this.startDat = startDat;
    }

    public Date getEndDat() {
        return endDat;
    }

    public void setEndDat(Date endDat) {
        this.endDat = endDat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public List<Workgrade> getWorkgrade() {
        return workgrade;
    }

    public void setWorkgrade(List<Workgrade> workgrade) {
        this.workgrade = workgrade;
    }

    public Integer getDone() {
        return done;
    }

    public void setDone(Integer done) {
        this.done = done;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}