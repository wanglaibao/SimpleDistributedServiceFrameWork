package com.laibao.userdefinedxmltag.service.impl;

import com.laibao.userdefinedxmltag.domain.Person;
import com.laibao.userdefinedxmltag.service.PersonService;
import org.springframework.stereotype.Service;

/**
 * @author laibao wang
 * @date 2018-07-28
 * @version 1.0
 */
@Service("personService")
public class PersonServiceImpl implements PersonService {

    public Person getPersonByName(String name) {
        Person person = new Person();
        person.setName(name);
        person.setAddress("hangzhou");
        person.setAge(100);
        return person;
    }
}
