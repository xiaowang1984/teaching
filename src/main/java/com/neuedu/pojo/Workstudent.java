package com.neuedu.pojo;

import java.util.Date;
import java.util.List;

public class Workstudent {
    private Integer id;

    private Integer sId;

    private Integer wId;

    private Date dat;

    private Integer adds;

    private Integer dels;

    private Integer count;

    private Boolean ischeck;

    private List<Workcommit> workcommits;

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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Boolean getIscheck() {
        return ischeck;
    }

    public void setIscheck(Boolean ischeck) {
        this.ischeck = ischeck;
    }

    public List<Workcommit> getWorkcommits() {
        return workcommits;
    }

    public void setWorkcommits(List<Workcommit> workcommits) {
        this.workcommits = workcommits;
    }
}