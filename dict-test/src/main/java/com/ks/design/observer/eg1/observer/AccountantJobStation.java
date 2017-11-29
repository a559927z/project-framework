package com.ks.design.observer.eg1.observer;

import com.ks.design.observer.eg1.subject.CustomerSubject;

/**
 * @author jxzhang on 2017年08月18
 * @Verdion 1.0版本
 */
public class AccountantJobStation extends AbstractJobStation {

    private CustomerSubject subject;
    private String accountantState;

    public AccountantJobStation(CustomerSubject subject) {
        this.subject = subject;
    }

    @Override
    public void update() {
        if (subject.status == "已付款") {
            System.out.println("我是会计，我来开具发票。");
            accountantState = "已开具发票";
        }
    }
}
