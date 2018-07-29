package com.laibao.userdefinedxmltag.schema;

import com.laibao.userdefinedxmltag.domain.ProtocolBean;
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
public class MinaProtocolBeanDefinitionParser extends AbstractBeanDefinitionParser{

    public AbstractBeanDefinition parseInternal(Element element, ParserContext parserContext) {
        return parseComponent(element,parserContext);
    }

    private AbstractBeanDefinition parseComponent(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(ProtocolBean.class);

        String id = element.getAttribute("id");
        builder.addPropertyValue("id", id);

        String name = element.getAttribute("name");
        builder.addPropertyValue("name", name);

        String port = element.getAttribute("port");
        builder.addPropertyValue("port", port);

        String host = element.getAttribute("host");
        if (StringUtils.hasText(host)) {
            builder.addPropertyValue("host", host);
        }

        return builder.getBeanDefinition();
    }
}
