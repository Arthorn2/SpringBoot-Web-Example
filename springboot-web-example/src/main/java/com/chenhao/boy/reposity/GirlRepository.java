package com.chenhao.boy.reposity;

import com.chenhao.boy.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author 陈浩
 * @Date 2017/8/21 19:48
 */
public interface GirlRepository extends JpaRepository<Girl,Integer>{
    public List<Girl> findByAge(Integer age);
}
