package com.neuedu.pojo;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;
import java.util.List;

public class Workgrade {
    private Integer id;

    private Integer wId;

    private Date dat;

    private Integer adds;

    private Integer dels;

    private Integer stucount;

    private Integer stucommit;

    private Integer person;
    @JSONField(format="HH:mm:ss")
    private Date avgtime;
    private List<Workstudent> workstudents;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getwId() {
        return wId;
    }

    public void setwId(Integer wId) {
        this.wId = wId;
    }

    public Date getDat() {
        return dat;
    }

    public void setDat(Date dat) {
        this.dat = dat;
    }

    public Integer getAdds() {
        return adds;
    }

    public void setAdds(Integer adds) {
        this.adds = adds;
    }

    public Integer getDels() {
        return dels;
    }

    public void setDels(Integer dels) {
        this.dels = dels;
    }

    public Integer getStucount() {
        return stucount;
    }

    public void setStucount(Integer stucount) {
        this.stucount = stucount;
    }

    public Integer getStucommit() {
        return stucommit;
    }

    public void setStucommit(Integer stucommit) {
        this.stucommit = stucommit;
    }

    public Integer getPerson() {
        return person;
    }

    public void setPerson(Integer person) {
        this.person = person;
    }

    public Date getAvgtime() {
        return avgtime;
    }

    public void setAvgtime(Date avgtime) {
        this.avgtime = avgtime;
    }

    public List<Workstudent> getWorkstudents() {
        return workstudents;
    }

    public void setWorkstudents(List<Workstudent> workstudents) {
        this.workstudents = workstudents;
    }
}