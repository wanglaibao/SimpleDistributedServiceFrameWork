###     FactoryBean 介绍与使用
 
#### 1. Overview of FactoryBean【马猴儿 严真真】
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

       
#### 3.Why use factory beans
* Factory beans are mostly used to implement framework facilities. some usage below.

* When looking up an object (such as a data source) from JNDI, we can use JndiObjectFactoryBean.

* When using classic Spring AOP to create a proxy for a bean, we can use ProxyFactoryBean.

* When creating a Hibernate session factory in the IoC container, we can use LocalSessionFactoryBean.
       
#### 4.Ways to Initialize
* just Initialize inside the method getObject()

* implementing the InitializingBean interface

* using @PostConstruct annotation

#### 5. to extends AbstractFactoryBean

* By extending the AbstractFactoryBean class, your factory bean can simply override the createInstance() method to create the target bean instance. 
    
  In addition, you have to return the target bean’s type in the getObjectType() method for the auto-wiring feature to work properly.

#### 6.Conclusion

* Using a FactoryBean can be a good practice to encapsulate complex construction logic or make configuring highly configurable objects easier in Spring.
       
 #### 7.document on line
 
 * [Spring Corner: Beyond the FactoryBean](http://joshlong.com/jl/blogPost/spring_corner_beyond_the_factorybean.html)
 
 * [What's a FactoryBean](https://spring.io/blog/2011/08/09/what-s-a-factorybean)
 
 * [How to use the Spring FactoryBean](http://www.baeldung.com/spring-factorybean)
 
 * [tutorials](https://github.com/eugenp/tutorials/tree/master/spring-core)
 
 * [非常好的DEMO资源](https://github.com/eugenp/tutorials)
 
 * [Spring FactoryBean Example](https://howtodoinjava.com/spring-core/how-to-create-beans-using-spring-factorybean/)