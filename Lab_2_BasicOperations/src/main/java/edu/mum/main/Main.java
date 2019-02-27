package edu.mum.main;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.mum.domain.User;
import edu.mum.service.UserService;
import edu.mum.service.impl.UserServiceImpl;

public class Main {
	
 	@Autowired
	UserService userService;
	
  public static void main(String[] args) {

      //ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:applicationContext.xml");//("classpath*:applicationContext.xml");
      ApplicationContext context = new ClassPathXmlApplicationContext(
    	        "classpath*:context/applicationContext.xml");

      for(int i=0;i<context.getBeanNamesForType(UserServiceImpl.class).length;i++) {
    	  System.out.println(context.getBeanNamesForType(UserServiceImpl.class)[i]);
      }
      
      System.out.println("Test");
	  //UserService userService = (UserService)context.getBean("userService");

      new Main().internal();
  }  
  
  public void internal() {

      
      
      User user = new User();
      user.setFirstName("Abdelrady");
      user.setLastName("Tantawy");
      user.setEmail("atantawy@mum.edu");
      
      userService.save(user);

      User user2 = userService.findByEmail("atantawy@mum.edu");
      System.out.println();
      System.out.println("        *********  User  **********");
     System.out.println("User Name: " + user2.getFirstName() + " " + user2.getLastName());

     
  }
  
 }