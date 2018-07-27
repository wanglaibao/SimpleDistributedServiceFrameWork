package com.laibao.userdefinedxmltag.schema;

import com.laibao.userdefinedxmltag.domain.People;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 * @author laibao wang
 * @date 2018-07-27
 * @version 1.0
 */
public class PeopleBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

    @Override
    public Class<?> getBeanClass(Element element) {
        return People.class;
    }

    @Override
    public void doParse(Element element, BeanDefinitionBuilder builder) {
        String name = element.getAttribute("name");
        String age = element.getAttribute("age");
        String id = element.getAttribute("id");
        if (StringUtils.hasText(id)) {
            builder.addPropertyValue("id", id);
        }
        if (StringUtils.hasText(name)) {
            builder.addPropertyValue("name", name);
        }
        if (StringUtils.hasText(age)) {
            builder.addPropertyValue("age", age);
        }
    }
}
