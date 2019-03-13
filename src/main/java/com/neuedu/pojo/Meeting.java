package com.neuedu.pojo;

import java.util.Date;
import java.util.List;

public class Meeting {
    private Integer id;

    private String type;

    private Date date;

    private Integer gId;

    private Integer count;

    private Integer isDel;

    private List<MeetingDetail> meetingDetails;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getgId() {
        return gId;
    }

    public void setgId(Integer gId) {
        this.gId = gId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public List<MeetingDetail> getMeetingDetails() {
        return meetingDetails;
    }

    public void setMeetingDetails(List<MeetingDetail> meetingDetails) {
        this.meetingDetails = meetingDetails;
    }
}