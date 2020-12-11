package com.alex.mybatisplus.service;

import java.util.List;

public interface StudentService {

    List<Student> findAll();
    List<Student> findAllByPage();
}
