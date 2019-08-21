package org.taru.service.six.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taru.dao.six.OrdersSixDao;
import org.taru.service.six.OrderDeleteInterface;
@Service
public class OrderDeleteImpl implements OrderDeleteInterface {
@Autowired
OrdersSixDao d;

    /**
     * 订单删除
     * @param id
     * @return
     */
    @Override
    public int orderDeleteInterface(int id) {
        return d.orderdelete(id);
    }
}
