package com.chenhao.boy.utils;

import com.chenhao.boy.domain.Result;

/**
 * @Author 陈浩
 * @Date 2017/8/22 15:44
 */
public class ResultUtil {

    public static Result success(Object object){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("success");
        result.setData(object);
        return result;
    }

    public static Result success( ){

        return success(null);
    }


    public static Result error(Integer code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
