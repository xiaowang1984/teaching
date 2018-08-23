package com.neuedu.message;

import lombok.Data;

@Data
public class Message {
    public Message(){}
    public Message(Integer code,String message) {
        this.code = code;
        this.message = message;
    }
    public Message(Integer code) {
        this.code = code;
        this.message = code==0?"保存失败":"保存成功";
    }
    private Integer code;
    private String message;
}
