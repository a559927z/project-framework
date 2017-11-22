package com.ks.eg.design.observer.eg1;

import com.ks.eg.design.observer.eg1.observer.AccountantJobStation;
import com.ks.eg.design.observer.eg1.observer.CashierJobStation;
import com.ks.eg.design.observer.eg1.observer.CourierJobStation;
import com.ks.eg.design.observer.eg1.observer.OrderJobStation;
import com.ks.eg.design.observer.eg1.subject.CustomerSubject;

/**
 * @author jxzhang on 2017年08月19
 * @Verdion 1.0版本
 */
public class TestObserver {
    public static void main(String[] args) {
        CustomerSubject subject = new CustomerSubject();

        subject.register(new AccountantJobStation(subject));
        subject.register(new CashierJobStation(subject));
        subject.register(new OrderJobStation(subject));
        subject.register(new CourierJobStation(subject));

        subject.status = "已付款";
        subject.notifys();

    }
}
