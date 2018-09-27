package com.neuedu.pojo;

import java.util.Date;
import java.util.List;

public class Arrange {
    private Integer id;

    private Integer gId;

    private Integer pId;

    private Integer type;

    private String project;

    private String git;

    private String note;

    private Integer tId;

    private Date startDate;

    private Date endDate;

    private Integer isDel;

    private List<ArrangeListWithBLOBs> arrangeList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getgId() {
        return gId;
    }

    public void setgId(Integer gId) {
        this.gId = gId;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project == null ? null : project.trim();
    }

    public String getGit() {
        return git;
    }

    public void setGit(String git) {
        this.git = git == null ? null : git.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public List<ArrangeListWithBLOBs> getArrangeList() {
        return arrangeList;
    }

    public void setArrangeList(List<ArrangeListWithBLOBs> arrangeList) {
        this.arrangeList = arrangeList;
    }

    @Override
    public String toString() {
        return "Arrange{" +
                "id=" + id +
                ", gId=" + gId +
                ", pId=" + pId +
                ", type=" + type +
                ", project='" + project + '\'' +
                ", git='" + git + '\'' +
                ", note='" + note + '\'' +
                ", tId=" + tId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", isDel=" + isDel +
                '}';
    }
}