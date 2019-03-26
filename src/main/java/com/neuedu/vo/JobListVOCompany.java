package com.neuedu.vo;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @封装企业就业数据VO类
 */

@Getter
@Setter
@ToString
public class JobListVOCompany {
    //公司名称
    private String c_name;
    //面试人数
    private Double c_num;
    //offer人数
    private Double c_offer;
    //成功率
    private String c_success;
    //平均薪资
    private Double c_money;

}
