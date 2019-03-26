package com.neuedu.common;

/**
 * 维护状态码
 * */
public class ResponseCode {

    /**
     * 成功的状态码
     * */
    public static final  int SUCESS=0;

    /**
     * 失败时通用状态码
     * */
    public static  final int ERROR=100;

    /*
    * 用户登录失败状态码:密码错误
    * */
    public static final int ERROR_PASSWORD=1;

    /*用户不存在状态码*/
    public static final int INEXISTENCE_USER = 101;

    /*用户注册失败状态码：用户已存在*/
    public static final int EXIST_USER=1;

    /*用户注册失败状态码：邮箱已存在*/
    public static final int EXIST_EMAIL=2;

    /*获取用户信息失败状态码：用户未登录*/
    public static final int NO_LOGIN=10;

    /*忘记密码失败状态码：该用户未设置找回密码问题*/
    public static final int NO_QUESTION = 1;

    /*密码问题答案错误*/
    public static final int ERROR_ANSWER = 1;

    /*token已经失效*/
    public static final int LOSE_EFFICACY = 103;

    /*非法的token*/
    public static final int UNLAWFULNESS_TOKEN = 104;

    /*修改密码操作失效*/
    public static final int DEFEACTED_PASSWORDNEW = 1;

    /*修改密码操作失效*/
    public static final int ERROR_PASSWORDOLD = 1;

    /*用户未登录，无法获取当前用户信息,status=10强制退出*/
    public static final int FORCE_EXIT = 10;


    /*======================就业相关=================*/
    /*没有就业信息*/
    public  static final int MSG_NULL= 301;
}
