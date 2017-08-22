package com.chenhao.boy.controller;

import com.chenhao.boy.aspect.HttpAspect;
import com.chenhao.boy.domain.Girl;
import com.chenhao.boy.domain.Result;
import com.chenhao.boy.service.GirlService;
import com.chenhao.boy.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Author 陈浩
 * @Date 2017/8/21 19:47
 */
@RestController
public class GirlController {

    private final static Logger logger= LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlService girlService;

    /**
     * 查询所有
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> getGirlList(){
        return girlService.getGirlList();
    }

    /**
     * 添加一个Girl
     * @return
     */
    //Girl.cupSize<=18,若大于18，bindingResult.hasErrors()=true
    @GetMapping(value = "/girlsAdd")
    public Result<Girl> girAdd(@Valid Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }

        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());
        return ResultUtil.success(girlService.girAdd(girl));
    }

    /**
     * 查询一个girl
     * @param id
     * @return
     */
    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id){
        logger.info("22222222");
        return girlService.girlFindOne(id);
    }

    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age){

        Girl girl = new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlService.girlUpdate(girl);
    }

    @GetMapping(value = "/girlsAge/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age){
        return girlService.girlListByAge(age);
    }

    /**
     * 插入两个Girl(事务管理)
     *
     */
    @GetMapping(value = "/girlsTwo")
    public void insertTwo(){
        Girl girl1 = new Girl();
        girl1.setAge(22);
        girl1.setCupSize("B");

        Girl girl2 = new Girl();
        girl2.setAge(22);
        girl2.setCupSize("FFFFFF");
        girlService.insertTwo(girl1,girl2);
    }

    @GetMapping(value = "/girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id)throws Exception{
        girlService.getAge(id);
    }
}
