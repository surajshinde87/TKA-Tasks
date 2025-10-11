package com.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.config.ConfigClass;
import com.entity.User;

public class Main {

	public static void main(String[] args) {

		
   ApplicationContext context = new AnnotationConfigApplicationContext(ConfigClass.class);
   
    User u = context.getBean(User.class);
    
    System.out.println(u.getPhonePayment().makePayment());
    System.out.println(u.getUpiPayment().makePayment());

	}

}
