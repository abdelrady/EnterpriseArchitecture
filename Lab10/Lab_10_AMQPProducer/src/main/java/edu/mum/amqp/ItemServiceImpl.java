package edu.mum.amqp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

import edu.mum.domain.Item;

public class ItemServiceImpl implements ItemService {

	public void publish(RabbitTemplate rabbitTemplate) {

		rabbitTemplate.convertAndSend(new Item(1L, 1, "Kazoo", 10.0, "kazoo description"));

		rabbitTemplate.convertAndSend(new Item(2L, 1, "Hammer", 50.0, "Hammer description"));
	}
}
