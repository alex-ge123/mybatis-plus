package com.alex.mybatisplus.controller;


import com.alex.autogender1.mapper.PersonMapper;
import com.alex.autogender1.pojo.Person;
import com.alex.autogender1.request.PersonRequest;
import com.alex.mybatisplus.service.StudentService;
import com.alex.mybatisplus.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Alex
 * @since 2020-10-24
 */
@RestController
@RequestMapping(value = "/alex/")
public class StudentController {
 @Autowired(required = false)
    private StudentService studentService;
@Autowired(required = false)
private PersonMapper personMapper;
 @RequestMapping(value = "students",method = RequestMethod.GET)
 public String  findAll(){
    /* List<Student> all = studentService.findAll();
    System.out.println(all);*/

     PersonRequest personRequest = new PersonRequest();
     String nowTime = DateUtils.getNowTime();
     personRequest.setAddress("西安");
     personRequest.setAge(20);
     personRequest.setCreatetime(nowTime);
     personRequest.setUpdatetime(nowTime);
     personRequest.setPname("葛丽明");

     Date parsecreate= DateUtils.parse(personRequest.getCreatetime());

     Date parseUpdata = DateUtils.parse(personRequest.getUpdatetime());


     Person person = new Person();
     person.setPname(personRequest.getPname());
     person.setPid(9);
     person.setAge(personRequest.getAge());
     person.setAddress(person.getAddress());
     person.setCreatetime(parsecreate);
     person.setUpdatetime(parseUpdata);
     int insert = personMapper.insert(person);
     System.out.println(insert);
    return "ok";
 }
    @RequestMapping(value = "studentsbypage",method = RequestMethod.GET)
    public String  findAllByPage() {
        List<Student> all = studentService.findAll();
        System.out.println(all);
        return "ok";
    }

}
