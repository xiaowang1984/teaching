package com.neuedu.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@ToString
public class JobListCompanyDetil {
    //班级名称
    /*修改2019.04.10这里实际上显示的是时间*/
    private Date gname;
    //学生姓名
    private String sname;
    //学校名称
    private String school;
    //薪资
    private BigDecimal salary;
    //职位
    private String jname;
}
