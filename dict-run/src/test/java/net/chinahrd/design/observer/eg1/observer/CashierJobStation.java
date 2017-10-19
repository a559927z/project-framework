package net.chinahrd.design.observer.eg1.observer;

import net.chinahrd.design.observer.eg1.subject.CustomerSubject;

/**
 * @author jxzhang on 2017年08月18
 * @Verdion 1.0版本
 */
public class CashierJobStation extends AbstractJobStation {

    private CustomerSubject subject;
    private String cashierState;

    public CashierJobStation(CustomerSubject subject) {
        this.subject = subject;
    }

    @Override
    public void update() {
        if (subject.status == "已付款") {
            System.out.println("我是出纳，我给登记入账。");
            cashierState = "已入账";
        }
    }
}
