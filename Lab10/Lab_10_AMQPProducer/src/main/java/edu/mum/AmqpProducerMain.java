package edu.mum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import edu.mum.amqp.ItemService;
import edu.mum.amqp.ItemServiceImpl;

public class AmqpProducerMain {
	
    public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("classpath:META-INF/spring/item-app-context.xml");
  
BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Press Enter To Send Message: ");
		try {
			in.readLine();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		RabbitTemplate directTemplate = context.getBean("directTemplate", RabbitTemplate.class);
		ItemService directService = new ItemServiceImpl();
		directService.publish(directTemplate);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
 
    }
}
