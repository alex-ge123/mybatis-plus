package com.alex.autogender1.controller;


import com.alex.autogender1.mapper.PersonMapper;
import com.alex.autogender1.pojo.Person;
import com.alex.autogender1.request.PersonRequest;
import com.alex.autogender1.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author alexge
 * @since 2020-12-11
 */
@RestController
@RequestMapping("/autogender1/person")
public class PersonController {

    @Autowired
    private PersonService personService;
    @Autowired
    private PersonMapper personMapper;
    @RequestMapping(value = "/add",method = RequestMethod.POST)
 public String addPerson(@RequestBody PersonRequest personRequest){

        Person person = new Person();
        person.setPname(personRequest.getPname());
        person.setAge(personRequest.getAge());
        person.setAddress(person.getAddress());


        boolean b = personService.save(person);

        if(b)
        {  return "ok";}
        else {
            return  "垃圾";
        }
 }

    @RequestMapping(value = "/add2",method = RequestMethod.POST)
 public String addPersonTestMapper( @RequestBody PersonRequest personRequest){

        Person person = new Person();
        person.setPname(personRequest.getPname());
        person.setAge(personRequest.getAge());
        person.setAddress(person.getAddress());
        int insert = personMapper.insert(person);
    System.out.println(insert);

    return "insert"+insert;
    }
    @RequestMapping(value = "/add3",method = RequestMethod.GET)
    public String addPersonTest3( ){



        return "insert";
    }
}

