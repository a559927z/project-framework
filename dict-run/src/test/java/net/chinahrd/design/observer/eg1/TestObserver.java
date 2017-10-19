package net.chinahrd.design.observer.eg1;

import net.chinahrd.design.observer.eg1.observer.AccountantJobStation;
import net.chinahrd.design.observer.eg1.observer.CashierJobStation;
import net.chinahrd.design.observer.eg1.observer.CourierJobStation;
import net.chinahrd.design.observer.eg1.observer.OrderJobStation;
import net.chinahrd.design.observer.eg1.subject.CustomerSubject;
import net.chinahrd.design.observer.eg1.subject.Subject;

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
