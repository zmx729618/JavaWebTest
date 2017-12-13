package org.zwc.beanpostprocessortest;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zhangwenchao on 2017/12/1.
 */
public class MainTest {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Animal animal = (Animal)ac.getBean("animal");
        System.out.println(animal.speak());

        LifecycleBean lifeCycleBean = (LifecycleBean)ac.getBean("lifeCycleBean");
        try {
            lifeCycleBean.destroy();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
