package com.powernode.spring6.text;

import com.powernode.spring6.bean.User;
import org.junit.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FirstSpringTest {
    @Test
    public void testFirstSpringCode(){
        //获取spring容器对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        //根据bean的id从spring容器中获取这个对象
        Object userBean = applicationContext.getBean("userBean");
        System.out.println(userBean);
        User userBean1 = applicationContext.getBean("userBean", User.class);
        userBean1.Hello();
    }

    @Test
    public void testData(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");

        Object dataBean = applicationContext.getBean("dataBean");
        System.out.println(dataBean);
    }
    @Test
    public void testInitBean(){
        Logger logger = LoggerFactory.getLogger(FirstSpringTest.class);
        logger.info("1");
        logger.debug("2");
        logger.error("3");
    }
}
