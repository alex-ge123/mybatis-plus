package com.alex.autogender1.request;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
