package com.ks.design.observer.eg1.observer;

import com.ks.design.observer.eg1.subject.CustomerSubject;

/**
 * @author jxzhang on 2017年08月18
 * @Verdion 1.0版本
 */
public class OrderJobStation extends AbstractJobStation {

    private CustomerSubject subject;
    private String orderStatus;

    public OrderJobStation(CustomerSubject subject) {
        this.subject = subject;
    }

    @Override
    public void update() {

        if (subject.status == "已付款") {
            System.out.println("====系统自动生成订单====");
            orderStatus = "已订单";
        }

    }
}
