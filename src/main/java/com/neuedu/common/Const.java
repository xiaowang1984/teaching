package com.neuedu.common;

public class Const {

    public static final String CURRENTUSER = "current_user";

    public static final String TRADE_SUCCESS = "TRADE_SUCCESS";

    public static final String AUTOLOGINTOKEN = "autoLoginToken";

    public static final String JESSESSIONID_COOKIE = "JESSIONID_COOKIE";

    public enum ReponseCodeEnum {

        NEED_LOGIN(2, "需要登录"),
        NO_PRIVILEGE(3, "无权限操作"),
        //状态信息
        ERROR_PASSWORD(ResponseCode.ERROR_PASSWORD, "密码错误"),
        EMPTY_USERNAME(ResponseCode.ERROR, "用户名不能为空"),
        EMPTY_PASSWORD(ResponseCode.ERROR, "密码不能为空"),
        EMPTY_QUESTION(ResponseCode.ERROR, "问题不能为空"),
        EMPTY_ANSWER(ResponseCode.ERROR, "答案不能为空"),
        INEXISTENCE_USER(ResponseCode.INEXISTENCE_USER, "用户名不存在"),
        EXIST_USER(ResponseCode.EXIST_USER, "用户名已存在"),
        EXIST_EMAIL(ResponseCode.EXIST_EMAIL, "邮箱已注册"),
        EMPTY_PARAM(ResponseCode.ERROR, "注册信息不能为空"),
        EMPTY_PARAM2(ResponseCode.ERROR, "更新信息不能为空"),
        SUCCESS_USER(ResponseCode.SUCESS, "用户注册成功"),
        SUCCESS_MSG(ResponseCode.SUCESS, "校验成功"),
        NO_LOGIN(ResponseCode.NO_LOGIN, "用户未登录"),
        NO_QUESTION(ResponseCode.NO_QUESTION, "该用户未设置找回密码问题"),
        ERROR_ANSWER(ResponseCode.ERROR_ANSWER, "问题答案错误"),
        LOSE_EFFICACY(ResponseCode.LOSE_EFFICACY, "token已经失效"),
        UNLAWFULNESS_TOKEN(ResponseCode.UNLAWFULNESS_TOKEN, "非法的token"),
        DEFEACTED_PASSWORDNEW(ResponseCode.DEFEACTED_PASSWORDNEW, "修改密码操作失败"),
        SUCCESS_PASSWORDNEW(ResponseCode.SUCESS, "修改密码操作成功"),
        ERROR_PASSWORDOLD(ResponseCode.ERROR_PASSWORDOLD, "旧密码输入错误"),
        SUCCESS_USERMSG(ResponseCode.SUCESS, "更新个人信息成功"),
        FORCE_EXIT(ResponseCode.FORCE_EXIT, "用户未登录，无法获取当前用户信息"),
        LOGOUT(ResponseCode.SUCESS, "退出成功");


        private int code;
        private String desc;

        private ReponseCodeEnum(int code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }


    public enum RoleEnum {

        ROLE_ADMIN(0, "管理员"),
        ROLE_CUSTOMER(1, "普通用户");

        private int code;
        private String desc;

        private RoleEnum(int code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }

    //处理就业数据相关
    public enum JobListEnum {

        MSG_NULL(ResponseCode.MSG_NULL, "没有更多的就业信息~");
        private int code;
        private String desc;

        private JobListEnum(int code, String desc) {
            this.code = code;
            this.desc = desc;
        }


        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }

}
