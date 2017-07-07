package com.hdzhangxiaopang.exception;

import com.hdzhangxiaopang.enums.ResultEnum;

/**
 * Created by zhangguilin on 2017/6/18.
 */
public class StudentException extends RuntimeException {
    /*spring只会对继承RuntimeException类的进行事务回滚,对继承Exception的不会进行*/

    private Integer code;

    public StudentException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
