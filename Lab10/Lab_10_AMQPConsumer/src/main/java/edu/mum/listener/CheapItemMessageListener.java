package edu.mum.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import edu.mum.domain.Item;


public class CheapItemMessageListener implements MessageListener {

    public void onMessage(Message message) {
        ObjectMessage objectMessage = (ObjectMessage) message;
        Item receivedItem = null;
		try {
			receivedItem = (Item) objectMessage.getObject();
		} catch (JMSException e) {
			e.printStackTrace();
		}
		System.out.println("Low Price Item received: ");
		System.out.println("Name: " + receivedItem.getName() + ", Price:" + receivedItem.getPrice() + ", Auction ID:"
				+ receivedItem.getAuctionId());
    }
}
