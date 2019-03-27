package com.neuedu.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class JobListCompanyDetil {
    //班级名称
    private String gname;
    //学生姓名
    private String sname;
    //学校名称
    private String school;
    //薪资
    private BigDecimal salary;
    //职位
    private String jname;
}
