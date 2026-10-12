package com.powernode.spring6.service;

import org.springframework.stereotype.Service;

@Service
public class AccountService {
    public void transfer(){
        System.out.println("银行账户正在完成转账操作");
    }

    public void withdraw(){
        System.out.println("正在取款，请稍后");
    }
}
