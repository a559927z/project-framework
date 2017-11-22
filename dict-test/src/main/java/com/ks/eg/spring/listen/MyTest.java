package com.ks.eg.spring.listen;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:eg/spring-bean.xml")
@ActiveProfiles("test")
public class MyTest implements ApplicationContextAware {

    public ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext arg0) throws BeansException {
        this.context = arg0;

    }

    @Test
    public void test2() {
        MyEvent event = new MyEvent("source", "param1", "param2");
        context.publishEvent(event);
    }

}
