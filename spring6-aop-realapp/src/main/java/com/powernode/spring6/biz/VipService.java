package com.powernode.spring6.biz;

import org.springframework.stereotype.Service;

@Service
public class VipService {
    public void addVip(){
        System.out.println("增加vip");
    }
    public void deleteVip(){
        System.out.println("删除vip");
    }
    public void modifyVip(){
        System.out.println("修改vip");
    }
    public void searchVip(){
        System.out.println("查找vip");
    }
}
