package com.powernode.spring6.test;

import cn.powernode.Spring6Config;
import cn.powernode.service.StudentService;
import com.powernode.spring6.bean.Order;
import com.powernode.spring6.bean.Student;
import com.powernode.spring6.bean.User;
import com.powernode.spring6.bean.Vip;
import org.junit.Test;
import org.powernode.service.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.annotation.Annotation;

public class IoCAnnotationTest {
    @Test
    public void testNoXML(){
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(Spring6Config.class);
        StudentService studentService = context.getBean("studentService", StudentService.class);
        studentService.deleteStudent();
    }
    @Test
    public void testResource(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-resource.xml");
        StudentService studentService = applicationContext.getBean("studentService", StudentService.class);
        studentService.deleteStudent();
    }
    @Test
    public void testAutwired(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-autowired.xml");
        org.powernode.service.OrderService orderService = applicationContext.getBean("orderService", org.powernode.service.OrderService.class);
        orderService.generate();
    }
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
