package com.powernode.spring6.test;

import com.powernode.spring6.bean.Order;
import com.powernode.spring6.bean.Student;
import com.powernode.spring6.bean.User;
import com.powernode.spring6.bean.Vip;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IoCAnnotationTest {
    @Test
    public void testChoose(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-choose.xml");

    }
    @Test
    public void testBeanComponent(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        User userBean = applicationContext.getBean("userBean", User.class);
        System.out.println(userBean);
        Vip vipBean =

                applicationContext.getBean("vipBean", Vip.class);
        System.out.println(vipBean);
        Student studentBean = applicationContext.getBean("student", Student.class);
        System.out.println(studentBean);
        Order orderBean = applicationContext.getBean("orderBean", Order.class);
        System.out.println(orderBean);

    }
}
