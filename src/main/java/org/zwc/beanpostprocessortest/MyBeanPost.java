package org.zwc.beanpostprocessortest;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by zhangwenchao on 2017/12/1.
 */
public class MyBeanPost implements BeanPostProcessor {


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor.postProcessBeforeInitialization 正在预处理！");

        if ((bean instanceof Animal)) {

            Animal animal = (Animal) bean;

            animal.setAge(50);

            animal.setName("猴子");

            return bean;

        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        System.out.println("BeanPostProcessor.postProcessAfterInitialization 正在预处理！");

        if ((bean instanceof Animal)) {

            Animal animal = (Animal) bean;

            animal.setName("鸭子");

            return bean;

        }
        return bean;

    }
}
