package edu.mum.finco;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Injector {
	@SuppressWarnings("unchecked")
	public static <T> T createObject(String bean, Object... args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		return (T) context.getBean(bean, args);
	}
}