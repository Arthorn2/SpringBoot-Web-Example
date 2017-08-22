package com.chenhao.boy.service;

import com.chenhao.boy.domain.Girl;
import com.chenhao.boy.utils.ResultUtil;

import java.util.List;

/**
 * @Author 陈浩
 * @Date 2017/8/21 20:28
 */
public interface GirlService {
    public List<Girl> getGirlList();
    public Girl girlUpdate(Girl girl);
    public List<Girl> girlListByAge(Integer age);
    public Girl girlFindOne(Integer id);
    public Girl girAdd(Girl girl);
    public void insertTwo(Girl girl1,Girl girl2);
    public void getAge(Integer id)throws Exception;
}
