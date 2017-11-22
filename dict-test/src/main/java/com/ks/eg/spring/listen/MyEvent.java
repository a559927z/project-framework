package com.ks.eg.spring.listen;

import org.springframework.context.ApplicationEvent;

/**
 * 观察者模式 （主题）
 *
 * @author jxzhang on 2017年8月11日
 * @Verdion 1.0 版本
 */
public class MyEvent extends ApplicationEvent {

    public String param1;

    public String param2;

    public MyEvent(Object source, String param1, String param2) {
        super(source);
        this.param1 = param1;
        this.param2 = param2;
    }

    @Override
    public Object getSource() {
        return super.getSource();
    }

    public String getParam1() {
        return param1;
    }

    public void setParam1(String param1) {
        this.param1 = param1;
    }

    public String getParam2() {
        return param2;
    }

    public void setParam2(String param2) {
        this.param2 = param2;
    }

}
