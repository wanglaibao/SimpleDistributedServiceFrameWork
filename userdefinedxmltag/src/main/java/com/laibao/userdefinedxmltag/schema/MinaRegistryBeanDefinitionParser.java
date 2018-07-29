package com.laibao.userdefinedxmltag.schema;

import com.laibao.userdefinedxmltag.domain.ReferenceBean;
import com.laibao.userdefinedxmltag.domain.RegistryBean;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 * @author laibao wang
 * @date 2018-07-28
 * @version 1.0
 */
public class MinaRegistryBeanDefinitionParser extends AbstractBeanDefinitionParser{

    public AbstractBeanDefinition parseInternal(Element element, ParserContext parserContext) {

        return parseComponent(element,parserContext);
    }

    private AbstractBeanDefinition parseComponent(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(RegistryBean.class);

        String id = element.getAttribute("id");
        builder.addPropertyValue("id", id);

        String protocol = element.getAttribute("protocol");
        builder.addPropertyValue("protocol", protocol);

        String address = element.getAttribute("address");
        builder.addPropertyValue("address", address);

        String username = element.getAttribute("username");
        if (StringUtils.hasText(username)) {
            builder.addPropertyValue("username", username);
        }

        String password = element.getAttribute("password");
        if (StringUtils.hasText(password)) {
            builder.addPropertyValue("password", password);
        }

        String check = element.getAttribute("check");
        if (StringUtils.hasText(check)) {
            builder.addPropertyValue("check", Boolean.valueOf(check));
        }

        return builder.getBeanDefinition();
    }
}
