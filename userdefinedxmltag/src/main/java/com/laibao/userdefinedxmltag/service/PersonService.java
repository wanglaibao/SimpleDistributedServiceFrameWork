package com.laibao.userdefinedxmltag.service;

import com.laibao.userdefinedxmltag.domain.Person;

/**
 * @author laibao wang
 * @date 2018-07-28
 * @version 1.0
 */
public interface PersonService {
    Person getPersonByName(String name);
}
