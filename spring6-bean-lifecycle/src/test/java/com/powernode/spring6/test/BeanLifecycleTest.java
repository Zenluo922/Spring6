package com.powernode.spring6.test;

import com.powernode.spring6.bean.Student;
import com.powernode.spring6.bean.User;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifecycleTest {
    @Test
    public void testRegisterBean(){
        Student student = new Student();
        System.out.println(student);

        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        factory.registerSingleton("studentBean",student);

        Object studentBean = factory.getBean("studentBean");
        System.out.println(studentBean);
    }
    @Test
    public void testUser(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        User user = applicationContext.getBean("user", User.class);
        System.out.println("第六步，使用bean:"+user);
        ClassPathXmlApplicationContext context = (ClassPathXmlApplicationContext) applicationContext;
        context.close();

    }
}
