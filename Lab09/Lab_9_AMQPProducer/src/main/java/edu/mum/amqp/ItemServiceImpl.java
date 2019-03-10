package edu.mum.amqp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

import edu.mum.domain.Item;

public class ItemServiceImpl implements ItemService {

	public void publish(RabbitTemplate rabbitTemplate) {

		rabbitTemplate.convertAndSend(new Item("Kazoo", "kazoo description"));

		rabbitTemplate.convertAndSend(new Item("Hammer", "Hammer description"));
	}
}
