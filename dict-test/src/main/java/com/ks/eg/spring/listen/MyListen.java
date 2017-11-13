package com.ks.eg.spring.listen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * 观察者模式 （订阅）
 *
 * @author jxzhang on 2017年8月11日
 * @Verdion 1.0 版本
 */
public class MyListen implements ApplicationListener {

    public static final Logger log = LoggerFactory.getLogger(MyListen.class);

    public void onApplicationEvent(ApplicationEvent arg0) {
        if (arg0 instanceof MyEvent) {
            MyEvent event = (MyEvent) arg0;

            log.info("我是{}订阅者：", this.getClass().getName());
            log.info("收到广播信息：{},{},{}", event.getParam1(), event.getParam2(), event.getSource());

        }
    }

}
