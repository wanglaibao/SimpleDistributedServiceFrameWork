###   基于Spring可扩展Schema提供自定义配置支持
该文件重点介绍SpringFramework基于Schema风格的XML扩展机制，
通过Spring提供的xml扩展机制，我们可以加入自己的自定义标签,这样SpringFramework就会帮我们解析和管理自定义Bean.

#### 1.Spring FrameWork 扩展Schema的步骤

* 定义标签化的JavaBean以及有关的属性

* 编写.xsd定义文件

* 编写NamespaceHandler和BeanDefinitionParser的子类或者实现类分别完成解析和定义工作

* 编写spring.handlers和spring.schemas串联起所有部件

* 在定义bean的xml配置文件中应用







