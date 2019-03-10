package edu.mum.amqp;

import edu.mum.domain.Item;

public class ItemListener {

	public void listen(Item item) {
		System.out.println("---------- DIRECT consumer for Item: " + item.getName());
	}

}
