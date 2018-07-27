package com.laibao.userdefinedxmltag.schema;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @author laibao wang
 * @date 2018-07-27
 * @version 1.0
 */
public class PeopleNamespaceHandler extends NamespaceHandlerSupport {
    public void init() {
        registerBeanDefinitionParser("people", new PeopleBeanDefinitionParser());
    }
}
