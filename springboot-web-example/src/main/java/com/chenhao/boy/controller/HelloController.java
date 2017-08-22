package com.chenhao.boy.controller;

import com.chenhao.boy.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author 陈浩
 * @Date 2017/8/21 18:53
*/

@RestController
public class HelloController {

    @Autowired
    private GirlProperties girlProperties;

    //@RequestMapping(value = "/hello", method = RequestMethod.GET)
    @GetMapping(value = "hello")
    public String say(@RequestParam(value = "id",required = false,defaultValue = "0") Integer myId){
        return "id:"+myId;
    }
}
