###   基于Spring可扩展Schema提供自定义配置支持
Spring框架从2.0版本开始，提供了基于Schema风格的XML扩展机制，允许开发者扩展最基本的spring配置文件.
该文件重点介绍SpringFramework基于Schema风格的XML扩展机制，
通过Spring提供的xml扩展机制，我们可以加入自己的自定义标签,这样SpringFramework就会帮我们解析和管理自定义Bean.

#### 1.Spring FrameWork 扩展Schema的步骤

* 定义标签化的JavaBean以及有关的属性

* 编写.xsd定义文件

* 编写NamespaceHandler和BeanDefinitionParser的子类或者实现类分别完成解析和定义工作

* 编写spring.handlers和spring.schemas串联起所有部件

* 在定义bean的xml配置文件中应用


#### 2.在线技术参考文档

* [Appendix B. Extensible XML authoring](https://docs.spring.io/spring-framework/docs/2.5.6/reference/extensible-xml.html)

* [Extensible XML authoring](http://itmyhome.com/spring/extensible-xml.html)

* [Extensible XML authoring](https://docs.spring.io/spring-framework/docs/4.3.x/spring-framework-reference/htmlsingle/#xml-custom)

* [XML Schema Authoring](https://docs.spring.io/spring-framework/docs/5.0.8.RELEASE/spring-framework-reference/core.html#xml-custom)

* [基于Spring可扩展Schema提供自定义配置支持](https://blog.csdn.net/cutesource/article/details/5864562)

* [如何在spring中自定义xml标签](https://www.cnblogs.com/java-zhao/p/7619922.html)




