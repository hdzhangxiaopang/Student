package com.hdzhangxiaopang.properties;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by zhangguilin on 2017/6/14.
 */
@Component
@ConfigurationProperties(prefix = "student")
public class StudentProperties {
    private String grade;
    private Integer age;

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
