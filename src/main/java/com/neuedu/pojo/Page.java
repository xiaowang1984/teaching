package com.neuedu.pojo;

import lombok.Data;

@Data
public class Page {
    private Integer pageNo=1;
    private Integer pageSize=9;
    private Integer withPage=1;
}
