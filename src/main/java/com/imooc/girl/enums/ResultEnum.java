package com.imooc.girl.enums;

public enum ResultEnum {
    UNKONW_ERROR(-1,"未知错误"),
    SUCCESS(0,"success"),
    PRIMARY_SCHOOL(100,"上小学"),
    MIDDLE_SCHOOL(101,"上初中"),
    ;
    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
