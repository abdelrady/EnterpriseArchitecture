package edu.mum;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AmqpConsumerMain {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				new String[] { "/META-INF/spring/common.xml", "/META-INF/spring/amqp-item-app-context.xml",
						"/META-INF/spring/jms-queue-app-context.xml", "/META-INF/spring/item-app-context.xml" },
				AmqpConsumerMain.class);
		System.out.println("listening for messges..");
	}
}
