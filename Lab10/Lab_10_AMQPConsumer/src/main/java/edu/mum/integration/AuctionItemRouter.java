 
package edu.mum.integration;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Router;
import edu.mum.domain.Item;

@MessageEndpoint
public class AuctionItemRouter {

	@Router(inputChannel="processedItem")
	public String processAuctionItem(Item item) {
	    String destination = null;
	    
  	    if(item != null && item.getPrice() > 20) {
  	    	destination = "highpricechannel";
  	    }else {
  	    	destination = "moderatepricechannel";
  	    }
	
		return destination;
	}

}
