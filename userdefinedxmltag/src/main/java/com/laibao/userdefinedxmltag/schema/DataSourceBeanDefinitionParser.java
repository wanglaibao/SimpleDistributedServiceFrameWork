package com.laibao.userdefinedxmltag.schema;

import com.laibao.userdefinedxmltag.domain.DataSource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.w3c.dom.Element;

/**
 * @author laibao wang
 * @date 2018-07-27
 * @version 1.0
 */
public class DataSourceBeanDefinitionParser extends AbstractSingleBeanDefinitionParser{

    @Override
    public Class<?> getBeanClass(Element element) {
        return DataSource.class;
    }


    @Override
    public void doParse(Element element, BeanDefinitionBuilder builder) {
        String id = element.getAttribute("id");
        String url = element.getAttribute("url");
        String userName = element.getAttribute("userName");
        String passWord = element.getAttribute("passWord");

        if (StringUtils.isNotBlank(id)) {
            builder.addPropertyValue("id", id);
        }

        if (StringUtils.isNotBlank(url)) {
            builder.addPropertyValue("url", url);
        }

        if (StringUtils.isNotBlank(userName)) {
            builder.addPropertyValue("userName", userName);
        }

        if (StringUtils.isNotBlank(passWord)) {
            builder.addPropertyValue("passWord", passWord);
        }
    }
}
