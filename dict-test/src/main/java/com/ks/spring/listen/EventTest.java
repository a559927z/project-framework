package com.ks.spring.listen;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:eg/test-listen.xml")
@ActiveProfiles("test")
public class EventTest implements ApplicationContextAware {

	public ApplicationContext context;

	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		this.context = arg0;

	}

	@Test
	public void myEventTest() {
		MyEvent event = new MyEvent("source", "param1", "param2");
		context.publishEvent(event);
	}

}
