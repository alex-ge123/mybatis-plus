package com.alex.autogender1.service.impl;

import com.alex.autogender1.pojo.Person;
import com.alex.autogender1.mapper.PersonMapper;
import com.alex.autogender1.service.PersonService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author alexge
 * @since 2020-12-11
 */
@Service
public class PersonServiceImpl extends ServiceImpl<PersonMapper, Person> implements PersonService {

}
