package com.hdzhangxiaopang.service;

import com.hdzhangxiaopang.domain.Student;
import com.hdzhangxiaopang.enums.ResultEnum;
import com.hdzhangxiaopang.exception.StudentException;
import com.hdzhangxiaopang.repository.StudentRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zhangguilin on 2017/6/18.
 */
@Service
public class StudentService {

    @Autowired
    private StudentRespository studentRespository;

    @Transactional
    public void insertTwo(){
        Student student = new Student();
        student.setName("mayun");
        student.setAge(20);
        studentRespository.save(student);

        /*添加异常*/
        int a = 0;
        int b = 1;
        int c = b/a;

        Student student1 = new Student();
        student1.setName("mahuanteng");
        student1.setAge(20);
        studentRespository.save(student1);

    }

    public void getAge(Integer id) throws StudentException{
        Student student = new Student();
        student = studentRespository.findOne(id);
        int age  =student.getAge();
        if(age<10){
            //返回"你还在上小学吧"  code = 100
            throw new StudentException(ResultEnum.MIDDLE_SCHOOL);

        }else if(age>10 && age<16){
            //返回"你还在上初中吧" code = 101
            throw new StudentException(ResultEnum.PRIMARY_SCHOOL);
        }
    }

    public Student findOne(Integer id){
        return studentRespository.findOne(id);
    }

}

















