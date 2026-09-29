package com.powernode.spring6.test;

import com.powernode.spring6.jdbc.MyDataSource;
import com.powernode.spring6.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringDITest {
    @Test
    public void testSetDI(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = applicationContext.getBean("userServiceBean", UserService.class);
        userService.saveUser();
    }

    @Test
    public void testDataSource(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        MyDataSource dataSource = applicationContext.getBean("dataSource", MyDataSource.class);
        System.out.println(dataSource);
    }
}
