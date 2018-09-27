package com.neuedu.pojo;

public class ArrangeListWithBLOBs extends ArrangeList {
    private String work;

    private String remark;

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work == null ? null : work.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}