package com.alex.mybatisplus.request;

import lombok.Data;

import java.io.Serializable;


@Data
public class PersonRequest implements Serializable {


    private String pname;

    private Integer age;

    private String address;

    private String  createtime;

    private String  updatetime;

}
