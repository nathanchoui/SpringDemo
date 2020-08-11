package com.github.nathan.springframework;

import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @author nathan.z
 * @date 2020/7/30.
 */
public class SpingFrameworkDemo {

    public static void main(String[] args) {
        // 对资源的抽象
        Resource resource = new ClassPathResource("spring-context.xml");
        // spring的抽象工厂，最顶层是BeanFactory
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        // bean 定义读取器抽象。
        BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
        // 从资源中加载bean定义，然后用前面装载的注册器（defaultListableBeanFactory），讲资源定义的bean注册金BeanFactory
        beanDefinitionReader.loadBeanDefinitions(resource);

        Student nathan = defaultListableBeanFactory.getBean("student", Student.class);
        System.out.println(nathan.getAge());
        System.out.println(nathan.getName());

    }
}
