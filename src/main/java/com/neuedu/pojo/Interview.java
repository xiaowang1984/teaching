package com.neuedu.pojo;

import java.util.Date;
import java.util.List;

public class Interview {
    private Integer id;

    private String name;

    private Integer gId;

    private Date dat;

    private Integer isDel;

    private String question;

    private List<InterviewDetails> interviewDetailsList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getgId() {
        return gId;
    }

    public void setgId(Integer gId) {
        this.gId = gId;
    }

    public Date getDat() {
        return dat;
    }

    public void setDat(Date dat) {
        this.dat = dat;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question == null ? null : question.trim();
    }

    public List<InterviewDetails> getInterviewDetailsList() {
        return interviewDetailsList;
    }

    public void setInterviewDetailsList(List<InterviewDetails> interviewDetailsList) {
        this.interviewDetailsList = interviewDetailsList;
    }
}