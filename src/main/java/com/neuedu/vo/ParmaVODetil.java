package com.neuedu.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @封装前端传入查询参数,查询详细就业数据
 */

@Getter
@Setter
@ToString
public class ParmaVODetil {
    //分页参数相关
    private Integer pageNum = 1;
    private Integer pageSize = 10;

    //字段排序参数，默认按日期降序
    private String orderBy = "";

    //企业=1&班级=0
    private Integer is_type;
    //面试=0&offer=1&入职人数=2
    private Integer is_job;
    //查询公司的名称
    private String cname;
}
