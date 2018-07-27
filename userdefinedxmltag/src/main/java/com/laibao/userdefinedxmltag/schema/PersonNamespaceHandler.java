package com.laibao.userdefinedxmltag.schema;

import com.laibao.userdefinedxmltag.domain.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @author laibao wang
 * @date 2018-07-26
 * @version 1.0
 */
public class PersonNamespaceHandler extends NamespaceHandlerSupport {
    private Logger logger = LoggerFactory.getLogger(PersonNamespaceHandler.class);

    public void init() {
        registerBeanDefinitionParser("elementName", new PersonBeanDefinitionParser(Person.class));
    }
}
