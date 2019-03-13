 
package edu.mum.integration;

import org.springframework.integration.annotation.Transformer;
import org.springframework.stereotype.Component;

import edu.mum.domain.Item;

public class ItemsTransformerImpl implements ItemsTransformer {

	@Transformer(inputChannel="fromAmqpItem", outputChannel="processedItem")
	public Item transformItem(Item item) {
		item.setAuctionId(item.getName() + item.getVersion());
		return item;
	}
}
