package com.laibao.springrpc.facotybean;

import com.laibao.springrpc.domain.Person;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author laibao wang
 * @date 2018-07-26
 * @version 1.0
 */
public class PersonFactoryBean implements FactoryBean<Person>{

    private String personStringArr;

    private Person person;

    public Person getObject() throws Exception {
        person = new Person();
        String[]  personArr =  personStringArr.split("#");
        person.setName(personArr[0]);
        person.setAddress(personArr[1]);
        person.setAge(Integer.parseInt(personArr[2]));
        return person;
    }

    public Class<?> getObjectType() {
        return Person.class;
    }

    public void setPersonStringArr(String personStringArr) {
        this.personStringArr = personStringArr;
    }
}
