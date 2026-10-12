package com.powernode;

import com.powernode.spring6.biz.VipService;
import com.powernode.spring6.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    @Test
    public void testVip(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        VipService vipService = applicationContext.getBean("vipService", VipService.class);
        vipService.addVip();
        vipService.deleteVip();
        vipService.modifyVip();
        vipService.searchVip();
    }
    @Test
    public void testTransaction(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        accountService.transfer();
        accountService.withdraw();
    }
}
