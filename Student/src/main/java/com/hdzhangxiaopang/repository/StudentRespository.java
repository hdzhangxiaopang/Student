package com.hdzhangxiaopang.repository;

import com.hdzhangxiaopang.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by zhangguilin on 2017/6/16.
 */
public interface StudentRespository extends JpaRepository<Student,Integer> {

    //通过年龄查找
    public List<Student> findByAge(Integer age);
}
