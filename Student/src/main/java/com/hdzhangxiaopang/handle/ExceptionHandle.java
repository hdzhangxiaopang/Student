package com.hdzhangxiaopang.handle;

import com.hdzhangxiaopang.domain.Result;
import com.hdzhangxiaopang.exception.StudentException;
import com.hdzhangxiaopang.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhangguilin on 2017/6/18.
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger  = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof StudentException){
            StudentException studentException = (StudentException) e;
            return ResultUtil.error(studentException.getCode(),studentException.getMessage());
        }else {
            logger.info("[系统异常]",e);
            return ResultUtil.error(-1,"未知错误!");
        }
    }

}

















