package com.chenhao.boy.service.serviceImpl;

import com.chenhao.boy.domain.Girl;
import com.chenhao.boy.reposity.GirlRepository;
import com.chenhao.boy.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author 陈浩
 * @Date 2017/8/21 20:29
 */
@Service
public class GirlServiceImpl implements GirlService{
    @Autowired
    private GirlRepository girlRepository;

    public List<Girl> getGirlList(){
        return girlRepository.findAll();
    }

    public Girl girlFindOne(Integer id){
        return girlRepository.findOne(id);
    }

    public Girl girlUpdate(Girl girl){

        return girlRepository.save(girl);
    }

    public List<Girl> girlListByAge(Integer age){
        return girlRepository.findByAge(age);
    }

    public Girl girAdd(Girl girl) {

        return girlRepository.save(girl);
    }

    /**
     *事务管理 @Transactional 若其中一个没有插入进去，两个都不会插入数据库
     * @param girl1
     * @param girl2
     */
    @Transactional
    public void insertTwo(Girl girl1,Girl girl2){
        girlRepository.save(girl1);
        girlRepository.save(girl2);
    }

    public void getAge(Integer id) throws Exception{
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();
        if (age<10){
            throw  new Exception("你还在上小学");
        }else if (age>10 && age<16){
            throw  new Exception("你还在上初中");
        }
    }
}
