package org.powernode.dao.impl;

import org.powernode.dao.OrderDao;
import org.springframework.stereotype.Repository;

@Repository("orderDaoImplForMySQL")
public class OrderDaoImpleForMysQl implements OrderDao {
    @Override
    public void insert() {
        System.out.println("MySQL数据库正在保存订单信息");
    }
}
