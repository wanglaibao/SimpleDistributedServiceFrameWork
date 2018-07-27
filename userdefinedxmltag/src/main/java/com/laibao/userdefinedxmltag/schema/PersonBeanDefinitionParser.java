package com.laibao.userdefinedxmltag.schema;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;


/**
 * @author laibao wang
 * @date 2018-07-27
 * @version 1.0
 */
public class PersonBeanDefinitionParser implements BeanDefinitionParser {
    private Logger logger = LoggerFactory.getLogger(PersonBeanDefinitionParser.class);

    private final Class<?> beanClass;

    public PersonBeanDefinitionParser(Class<?> beanClass) {
        this.beanClass = beanClass;
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        RootBeanDefinition beanDefinition = new RootBeanDefinition();
        beanDefinition.setBeanClass(beanClass);
        //beanDefinition.setLazyInit(false);
        BeanDefinitionRegistry beanDefinitionRegistry = parserContext.getRegistry();

        // 注册属性
        String name = element.getAttribute("name");
        String address = element.getAttribute("address");
        int age = Integer.parseInt(element.getAttribute("age"));

        BeanDefinitionHolder nameHolder = new BeanDefinitionHolder(beanDefinition, name);
        BeanDefinitionHolder addressHolder = new BeanDefinitionHolder(beanDefinition, address);
        BeanDefinitionHolder ageHolder = new BeanDefinitionHolder(beanDefinition, String.valueOf(age));

        BeanDefinitionReaderUtils.registerBeanDefinition(nameHolder, beanDefinitionRegistry);
        BeanDefinitionReaderUtils.registerBeanDefinition(addressHolder, beanDefinitionRegistry);
        BeanDefinitionReaderUtils.registerBeanDefinition(ageHolder, beanDefinitionRegistry);

        beanDefinition.getPropertyValues().add("name", name);
        beanDefinition.getPropertyValues().add("address", address);
        beanDefinition.getPropertyValues().add("age", age);
        //注册bean到BeanDefinitionRegistry中
        //beanDefinitionRegistry.registerBeanDefinition(beanClass.getName(),beanDefinition);
        return beanDefinition;
    }
}
