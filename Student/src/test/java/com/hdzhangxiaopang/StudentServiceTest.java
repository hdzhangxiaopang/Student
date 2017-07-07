package com.hdzhangxiaopang;

import com.hdzhangxiaopang.domain.Student;
import com.hdzhangxiaopang.service.StudentService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by zhangguilin on 2017/6/18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void findOneStudent(){
        Student student = studentService.findOne(8);
        Assert.assertEquals(new Integer(12),student.getAge());
    }
}
