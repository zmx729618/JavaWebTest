package org.zwc.beanpostprocessortest;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * Created by zhangwenchao on 2017/12/1.
 */
public class LifecycleBean implements InitializingBean, DisposableBean {

    private String lifeCycleBeanName;

    public void setLifeCycleBeanName(String lifeCycleBeanName) {
        System.out.println("Enter LifecycleBean.setLifeCycleBeanName(), lifeCycleBeanName = " + lifeCycleBeanName);
        this.lifeCycleBeanName = lifeCycleBeanName;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Enter LifecycleBean.destroy()");
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Enter LifecycleBean.afterPropertiesSet()");
    }
}
