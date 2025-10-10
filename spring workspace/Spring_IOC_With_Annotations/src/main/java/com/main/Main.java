package com.main;



import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.config.ConfigClass;
import com.entity.Car;


public class Main {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(ConfigClass.class);

		Car c = context.getBean(Car.class);
		System.out.println(c);
		
		Car c1 = context.getBean(Car.class);
		
		
		System.out.println(c1 == c);
		
		

	}

}
