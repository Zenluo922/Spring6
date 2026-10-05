package com.powernode.spring6.text;

import com.powernode.spring6.bean.Gun;
import com.powernode.spring6.bean.Person;
import com.powernode.spring6.bean.SpringBean;
import com.powernode.spring6.bean.Star;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanInstantiationTest {
    @Test
    public void testPerson(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Person person = applicationContext.getBean("person", Person.class);
    }
    @Test
    public void testGun(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Gun gun = applicationContext.getBean("gun", Gun.class);
    }
    @Test
    public void testStar(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Star star = applicationContext.getBean("star", Star.class);
    }
    @Test
    public void testIstantiation(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        SpringBean sb = applicationContext.getBean("sb", SpringBean.class);

    }
}
