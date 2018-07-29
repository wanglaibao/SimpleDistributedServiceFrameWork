###     FactoryBean 介绍与使用 
Spring FactoryBean is a special beans in spring framework. 
It can be used as a bean factory to create other Spring managed beans. 
You may be already familiar with built-in FactoryBean such as JndiObjectFactoryBean which is used to lookup jndi object, 
LocalSessionFactoryBean which is used to create hibernate session object, but this article will tell you how to create your own FactoryBean with examples.

#### 1.The definition of this interface

```
    public interface FactoryBean<T> {
         T getObject() throws Exception;
         Class<T> getObjectType();
         boolean isSingleton();
   }
```
 