package net.chinahrd.design.observer.eg1.observer;

import net.chinahrd.design.observer.eg1.subject.CustomerSubject;

/**
 * @author jxzhang on 2017年08月18
 * @Verdion 1.0版本
 */
public class CourierJobStation extends AbstractJobStation {

    private CustomerSubject subject;
    private String courierSataus;

    public CourierJobStation(CustomerSubject subject) {
        this.subject = subject;
    }

    @Override
    public void update() {
        if (subject.status == "已付款") {
            System.out.println("我是配送员，我来发货。");
            courierSataus = "已发货";
        }
    }
}
