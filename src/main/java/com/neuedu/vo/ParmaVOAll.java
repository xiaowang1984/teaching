package com.neuedu.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @封装前端传入查询参数,查询所有就业数据
 */

@Getter
@Setter
@ToString
public class ParmaVOAll {
    //分页参数相关
    private Integer pageNum = 1;
    private Integer pageSize = 10;

    //字段排序参数，默认按日期降序

    //企业=1&班级=0
    private Integer is_type;
    //公司名称
    private String c_name;
    //班级id
    private Integer id;
}
