package org.zwc.beancopiertest;

import net.sf.cglib.beans.BeanCopier;

/**
 * Created by zhangwenchao on 2017/10/27.
 */
public class MainTest {

    public static void main(String[] args) {
        Order entity = new Order();
        entity.setId(1);
        entity.setName("火车票订单");
        final BeanCopier copier = BeanCopier.create(Order.class, OrderDTO.class, false);
        OrderDTO dto = new OrderDTO();
        copier.copy(entity, dto, null);
        System.out.println(1==dto.getId());
        System.out.println("火车票订单".equals( dto.getName()));


    }
}
