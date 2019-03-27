package com.neuedu.vo;


import com.github.pagehelper.PageInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @封装企业就业详情数据VO类
 */

@Getter
@Setter
@ToString
public class JobListVOCompanyDetil {
    //公司名称
    private String c_name;
    //总面试人数
    private Double c_num;
    //总offer人数
    private Double c_offer;
    //总入职人数
    private Integer c_in;
    //通过比率
    private String c_success;
    //总平均薪资
    private Double c_money;
    //详细信息
    private PageInfo pi;

}
