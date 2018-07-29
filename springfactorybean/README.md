###     FactoryBean 介绍与使用
 
 #### 1. Overview of FactoryBean
There are two kinds of beans in the Spring bean container: ordinary beans and factory beans. 
Spring uses the former directly, whereas latter can produce objects themselves, which are managed by the framework.
And, simply put, we can build a factory bean by implementing org.springframework.beans.factory.FactoryBean interface.

Spring FactoryBean is a special beans in spring framework. 
It can be used as a bean factory to create other Spring managed beans. 
You may be already familiar with built-in FactoryBean such as JndiObjectFactoryBean which is used to lookup jndi object, 
LocalSessionFactoryBean which is used to create hibernate session object, but this article will tell you how to create your own FactoryBean with examples.


#### 2.The Basics of Factory Beans
* the definition of  ```FactoryBean ```

```
    public interface FactoryBean<T> {
         T getObject() throws Exception;
         Class<T> getObjectType();
         boolean isSingleton();
   }
   
   getObject() – returns an object produced by the factory, and this is the object that will be used by Spring container
   getObjectType() – returns the type of object that this FactoryBean produces
   isSingleton() – denotes if the object produced by this FactoryBean is a singleton
```

* Implement a FactoryBean

* Use FactoryBean with XML-based Configuration
        
        <bean id="carFactoryBean" class="com.laibao.springrpc.facotybean.CarFactoryBean">
              <property name = "maker" value ="浙江飞龙汽车有限公司"/>
              <property name = "year" value ="2024"/>
              <property name="brand" value="金龙"/>
        </bean>
       
* To access the FactoryBean, we just need to add a “&” before the bean name.

* Use FactoryBean with Java-based Configuration
       
#### 3.Ways to Initialize
* just Initialize inside the method getObject()

* implementing the InitializingBean interface

* using @PostConstruct annotation

#### 4.AbstractFactoryBean


#### 5.Conclusion

* Using a FactoryBean can be a good practice to encapsulate complex construction logic or make configuring highly configurable objects easier in Spring.
       
 #### 6.document on line
 
 * [Spring Corner: Beyond the FactoryBean](http://joshlong.com/jl/blogPost/spring_corner_beyond_the_factorybean.html)
 
 * [What's a FactoryBean](https://spring.io/blog/2011/08/09/what-s-a-factorybean)
 
 * [How to use the Spring FactoryBean](http://www.baeldung.com/spring-factorybean)
 
 * [XML Schema Authoring](https://docs.spring.io/spring-framework/docs/5.0.8.RELEASE/spring-framework-reference/core.html#xml-custom)
 
 * [基于Spring可扩展Schema提供自定义配置支持](https://blog.csdn.net/cutesource/article/details/5864562)
 