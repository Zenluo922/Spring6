package org.powernode.dao.impl;

import org.powernode.dao.OrderDao;
import org.springframework.stereotype.Repository;

@Repository("orderDaoImplForOracle")
public class OrderDaoImplForOracle implements OrderDao {
    @Override
    public void insert() {
        System.out.println("Oracle数据库正在保存订单信息");
    }
}
