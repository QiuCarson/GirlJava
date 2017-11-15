package com.imooc.girl.exception;

import com.imooc.girl.enums.ResultEnum;

public class GileException extends RuntimeException{
    private Integer code;

    public GileException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code=resultEnum.getCode();

    }
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
