package net.chinahrd.design.observer.eg1.subject;

import net.chinahrd.design.observer.eg1.observer.AbstractJobStation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jxzhang on 2017年08月18
 * @Verdion 1.0版本
 */
public class CustomerSubject implements Subject {

    public String status;

    private List<AbstractJobStation> observers = new ArrayList<AbstractJobStation>();

    @Override
    public void notifys() {
        for (AbstractJobStation observer : observers) {
            observer.update();
        }
    }

    public void register(AbstractJobStation observer) {
        this.observers.add(observer);
    }
}
