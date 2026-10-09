package org.powernode.service;

import org.powernode.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("orderService")
public class OrderService {
    @Autowired
    @Qualifier("orderDaoImplForOracle")
    private OrderDao orderDao;

    public void generate(){
        orderDao.insert();
    }


}
