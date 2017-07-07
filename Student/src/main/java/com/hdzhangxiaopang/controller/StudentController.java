package com.hdzhangxiaopang.controller;

import com.hdzhangxiaopang.domain.Result;
import com.hdzhangxiaopang.service.StudentService;
import com.hdzhangxiaopang.domain.Student;
import com.hdzhangxiaopang.repository.StudentRespository;
import com.hdzhangxiaopang.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by zhangguilin on 2017/6/16.
 */
@RestController
public class StudentController {

    @Autowired
    private StudentRespository studentRespository;

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/getAll")
    public List<Student> getAll(){
        return  studentRespository.findAll();
    }

    @PostMapping(value = "/save")
    public Result<Student> Save(@Valid  Student student, BindingResult bindingResult){

        if(bindingResult.hasErrors()){

            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }

        student.setName(student.getName());
        student.setAge(student.getAge());
        return ResultUtil.success(studentRespository.save(student));
    }

    @GetMapping(value = "/getId/{id}")
    public Student getId(@PathVariable("id") Integer id){
        return studentRespository.findOne(id);
    }

    @PutMapping(value = "/updateById/{id}")
    public Student updateById(@PathVariable("id") Integer id,
                           @RequestParam("name")String name,
                           @RequestParam("age") Integer age){
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setAge(age);
        return studentRespository.save(student);
    }
    @DeleteMapping(value = "/deleteById/{id}")
    public void deleteById (@PathVariable("id") Integer id){
        studentRespository.delete(id);
    }

    @GetMapping(value = "/getByAge/{age}")
    public List<Student> getByAge(@PathVariable("age") Integer age){
        return studentRespository.findByAge(age);
    }

    @PostMapping(value = "/insertTwo")
    public void StudentTwo(){
        studentService.insertTwo();
    }

    @GetMapping(value = "/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
        studentService.getAge(id);
    }
    @GetMapping(value = "/testDevtools")
    public void TestDevtools(){
        System.out.println("gds");

    }
}



















