package com.laibao.userdefinedxmltag.schema;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @author laibao wang
 * @date 2018-07-28
 * @version 1.0
 */
public class MinaNamespaceHandler extends NamespaceHandlerSupport{
    public void init() {
        registerBeanDefinitionParser("service", new MinaServiceBeanDefinitionParser());
        registerBeanDefinitionParser("reference", new MinaReferenceBeanDefinitionParser());
        registerBeanDefinitionParser("registry", new MinaRegistryBeanDefinitionParser());
        registerBeanDefinitionParser("protocol", new MinaProtocolBeanDefinitionParser());
    }
}
