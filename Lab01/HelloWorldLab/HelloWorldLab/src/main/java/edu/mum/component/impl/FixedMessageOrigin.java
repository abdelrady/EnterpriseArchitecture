package edu.mum.component.impl;

import java.util.Locale;

import org.springframework.stereotype.Component;

import edu.mum.component.MessageOrigin;

@Component
public class FixedMessageOrigin /*implements MessageOrigin*/ {
	public String getMessage() {
 		
		  return "Hello Rady";
	}

}
