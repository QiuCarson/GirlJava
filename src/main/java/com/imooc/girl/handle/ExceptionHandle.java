package com.imooc.girl.handle;



import com.imooc.girl.domain.Result;
import com.imooc.girl.exception.GileException;
import com.imooc.girl.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger=LoggerFactory.getLogger(ExceptionHandle.class);
    @ExceptionHandler(value = Exception.class)

    @ResponseBody
    public Result handle(Exception e){
        if (e instanceof GileException){
            GileException gileException= (GileException) e;
            return ResultUtil.error(gileException.getCode(),gileException.getMessage());
        }else{
            logger.error("系统异常",e);
            return ResultUtil.error(-1,"未知错误");
        }

    }
}
